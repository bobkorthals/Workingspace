/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.exception;

/**
 *
 * @author Ruben
 */
public class DbManagerException extends ConnectivityException { 
    public DbManagerException(String message, int code){
        super(message, code);
    }
    
    public DbManagerException(String message, int code, Throwable cause){
        super(message, code, cause);
    }
}
