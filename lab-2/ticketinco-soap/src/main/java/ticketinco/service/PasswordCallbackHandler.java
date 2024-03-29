package ticketinco.service;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PasswordCallbackHandler implements CallbackHandler {
    private Map<String, String> passwords =
            new HashMap<String, String>();

    public PasswordCallbackHandler() {
        passwords.put("middleware-lab2-wsse", "changeit");
        passwords.put("client-middleware-lab2-wsse", "changeit");
    }

    public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {

        for (Callback callback: callbacks) {
            WSPasswordCallback pc = (WSPasswordCallback) callback;
            String pass = passwords.get(pc.getIdentifier());

            if (pass != null) {
                pc.setPassword(pass);
                return;
            }
        }
    }
}
