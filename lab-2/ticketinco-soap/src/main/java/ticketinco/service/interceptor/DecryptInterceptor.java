package ticketinco.service.interceptor;

import java.util.Map;

public class DecryptInterceptor extends BaseMethodInterceptor {
    public DecryptInterceptor() {
        super();
    }

    public DecryptInterceptor(final Map<String, Object> properties)
    {
        super(properties);
    }
}
