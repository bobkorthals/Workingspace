/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.exception;

/**
 *
 * @author Ruben
 */
public class QueryManagerUnknownTypeException extends ConnectivityException {
    public QueryManagerUnknownTypeException(String message, int code){
        super(message, code);
    }
    
    public QueryManagerUnknownTypeException(String message, int code, Throwable cause){
        super(message, code, cause);
    }
}
