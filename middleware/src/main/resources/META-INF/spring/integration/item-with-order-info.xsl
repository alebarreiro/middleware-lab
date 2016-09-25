<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="UTF-8" indent="yes" method="xml" standalone="no" omit-xml-declaration="no"/>
    <xsl:template match="/">


        <order>
            <xsl:attribute name="id">
                <xsl:value-of select="string(/order/@id)" />
            </xsl:attribute>

            <fecha-creacion><xsl:value-of select="/order/fecha-creacion" /></fecha-creacion>
            <id-cliente><xsl:value-of select="/order/id-cliente/text()" /></id-cliente>
            <forma-pago><xsl:value-of select="/order/forma-pago/text()" /></forma-pago>

            <facturacion><xsl:copy-of select="/order/facturacion/node()" /></facturacion>

            <items>
                <xsl:for-each select="//items/item">
                    <item>
                        <xsl:attribute name="id">
                            <xsl:value-of select="string(./@id)" />
                        </xsl:attribute>

                        <xsl:copy-of select="./node()" />
                        <id-orden><xsl:value-of select="string(/order/@id)" /></id-orden>
                        <fecha-creacion><xsl:value-of select="/order/fecha-creacion/text()" /></fecha-creacion>
                        <id-cliente><xsl:value-of select="/order/id-cliente/text()" /></id-cliente>
                        <precio-total><xsl:value-of select="cantidad/text() * precio/text()" /></precio-total>
                    </item>
                </xsl:for-each>
            </items>
        </order>

    </xsl:template>
</xsl:stylesheet>
