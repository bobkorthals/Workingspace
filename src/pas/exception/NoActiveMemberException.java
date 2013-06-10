package pas.exception;

/**
 * Pas exception thrown if entity manager was not specified
 * 
 * @author Frank
 */
public class NoActiveMemberException extends Exception {
    
    // Error code
    private int code;

    /**
     * Initialize parent class
     * 
     * @param message
     */
    public NoActiveMemberException(String message) {
        super(message);
    }

    /**
     * Initialize parent class
     * 
     * @param cause
     */
    public NoActiveMemberException(Throwable cause) {
        super(cause);
    }

    /**
     * Initialize parent class
     * 
     * @param message
     * @param cause
     */
    public NoActiveMemberException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Initialize parent class
     * 
     * @param message
     * @param code
     */
    public NoActiveMemberException(String message, int code) {
        super(message);
        this.code = code;
    }

    /**
     * Initialize parent class
     * 
     * @param message
     * @param code
     * @param cause
     */
    public NoActiveMemberException(String message, int code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * Get code
     * 
     * @return int code
     */
    public int getCode() {
        return this.code;
    }
}
