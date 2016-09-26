package com.middleware.integracion;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by acabrera on 9/24/16.
 */
public class AggregatorStrawberry {
    final static int PACKAGE_SIZE_REQUIRED = 1000;

    public String aggregate(List<String> items) throws IOException, SAXException, ParserConfigurationException, TransformerException, ParseException {
        Document resultDoc = createDoc();
        Element rootElement = resultDoc.createElement("mid:NotificarCompra");
        rootElement.setAttribute("xmlns:mid", "http://middleware/");

        resultDoc.appendChild(rootElement);

        buildItemsTag(items, rootElement, resultDoc);

        return fromDomToString(resultDoc);
    }

    public boolean shouldRelease(List<String> items) {
        return items.size() == PACKAGE_SIZE_REQUIRED;
    }

    private void addFechaHoraTag(Element root, Document targetDoc) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);

        Element fechaHora = targetDoc.createElement("fecha_hora");
        fechaHora.appendChild(targetDoc.createTextNode(reportDate));
        root.appendChild(fechaHora);
    }

    // Los metodos no pueden tener mas de dos parametros, pero el clean code es proporcional al tiempo disponible
    private void buildItemsTag(List<String> items, Element root, Document resultDoc) throws SAXException, ParserConfigurationException, ParseException, IOException {
        for (String itemStr: items) {
            Element item = buildItemXml(itemStr, resultDoc);

            root.appendChild(item);
        }
    }

    private Document createDoc() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        return docBuilder.newDocument();
    }

    private Element buildItemXml(String itemStr, Document targetDom) throws IOException, SAXException, ParserConfigurationException, ParseException {
        Document sourceItemDoc = fromStringToDom(itemStr);
        NodeList nList = sourceItemDoc.getElementsByTagName("item");
        Element item = targetDom.createElement("items");

        for (int index = 0; index < nList.getLength(); index++) {
            Node nNode = nList.item(index);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                String idItem = eElement.getAttribute("id");

                buildTag("id-producto", "id_Producto", eElement, item, targetDom);
                buildTag("cantidad", "cantidad", eElement, item, targetDom);

                String idOrden = eElement.getElementsByTagName("id-orden").item(0).getTextContent();

                String idTransaccion = idOrden + ':' + idItem;
                Element elemIdTrans = targetDom.createElement("id_Transaccion");
                elemIdTrans.appendChild(targetDom.createTextNode(idTransaccion));
                item.appendChild(elemIdTrans);
            }
        }

        addFechaHoraTag(item, targetDom);

        return item;
    }

    private void buildTag(String sourceTagName, String targetTagName, Element eElement, Element item, Document targetDom) {
        String tagValue = eElement.getElementsByTagName(sourceTagName).item(0).getTextContent();

        Element idProducto = targetDom.createElement(targetTagName);
        idProducto.appendChild(targetDom.createTextNode(tagValue));
        item.appendChild(idProducto);
    }

    private Document fromStringToDom(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));

        return db.parse(is);
    }

    private String fromDomToString(Document doc) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));

        return writer.getBuffer().toString().replaceAll("\n|\r", "");
    }
}
