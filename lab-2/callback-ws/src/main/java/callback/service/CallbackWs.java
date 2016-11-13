package callback.service;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class CallbackWs {

    @WebMethod
    public String sayHello(String name) {
        return "CallbackWs " + name;
    }

}
