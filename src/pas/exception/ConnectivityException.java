/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.exception;

/**
 *
 * @author Ruben
 */
public class ConnectivityException extends Exception {
    private int code;
    
    protected ConnectivityException(){
        
    }
    
    public ConnectivityException(String message, int code){
        super(message);
        this.code = code;
    }
    
    public ConnectivityException(String message, int code, Throwable cause){
        super(message, cause);
        this.code = code;
    }
    
    public int getCode(){
        return this.code;
    }
}
