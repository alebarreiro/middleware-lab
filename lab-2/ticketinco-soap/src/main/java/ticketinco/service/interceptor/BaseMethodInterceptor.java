package ticketinco.service.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;

import java.util.Map;

public class BaseMethodInterceptor extends WSS4JInInterceptor {
    private Map<String, Object> properties;

    public BaseMethodInterceptor() {
        super();
    }

    public BaseMethodInterceptor(final Map<String, Object> properties)
    {
        super(properties);
        this.properties = properties;
    }

    @Override
    public void handleMessage(final SoapMessage message) throws Fault {
        String action = (String) message.get("SOAPAction");
        String methods = (String) properties.get("methods");

        if (methods != null) {
            String[] splitMethods = methods.split(" ");

            for (String method: splitMethods) {
                if (action.equals(method)) {
                    super.handleMessage(message);
                    return;
                }
            }
        }
    }
}
