package ticketinco.service.interceptor;

import java.util.Map;

public class SignVerifInterceptor extends BaseMethodInterceptor {
    public SignVerifInterceptor() {
        super();
    }

    public SignVerifInterceptor(final Map<String, Object> properties)
    {
        super(properties);
    }
}
