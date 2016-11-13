package ticketinco.service.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.log4j.Logger;
import java.util.Map;

public class DecryptInterceptor extends BaseMethodInterceptor {
    final static Logger logger = Logger.getLogger(DecryptInterceptor.class);

    public DecryptInterceptor() {
        super();
    }

    public DecryptInterceptor(final Map<String, Object> properties) {
        super(properties);
    }

    @Override
    public void handleMessage(final SoapMessage message) {
        logger.info("handleMessage: running interceptor");

        super.handleMessage(message);
    }
}
