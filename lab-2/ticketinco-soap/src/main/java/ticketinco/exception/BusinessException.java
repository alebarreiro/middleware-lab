package ticketinco.exception;

/**
 * Created by alejandrobarreiro on 26/10/16.
 */
public class BusinessException extends Exception {

    int causeCode;
    String causeMessage;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, int code, String cause) {
        super(message);
        causeCode = code;
        causeMessage = cause;
    }

    @Override
    public String getLocalizedMessage() {
        StringBuffer sb = new StringBuffer(super.getLocalizedMessage());
        sb.append(". Code: " + causeCode + " Cause Message: " + causeMessage);
        return sb.toString();
    }

}
