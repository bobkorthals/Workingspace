/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.exception;

/**
 *
 * @author Ruben
 */
public class QueryManagerException extends ConnectivityException {
    public QueryManagerException(String message, int code){
        super(message, code);
    }
    
    public QueryManagerException(String message, int code, Throwable cause){
        super(message, code, cause);
    }
}
