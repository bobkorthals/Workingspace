package pas.models.connectivity;

import java.sql.*;
import java.util.Properties;
import pas.exception.*;


/**
 * @todo Support for multiple synchronous database connections
 * @author Ruben
 */
public final class DbManager {
    public enum Drivers {
        POSTGRESQL ("org.postgresql.Driver", "jdbc:postgresql://"),
        MYSQL("com.mysql.jdbc.Driver", "jdbc:mysql://"),
        ODBC("sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:emp://"),
        MSSQL("com.mysql.jdbc.Driver", "jdbc:mysql://");
        
        
        private String driver;
        private String connStr;
        
        private Drivers(String driver, String connStr){
            this.driver = driver;
            this.connStr = connStr;
        }
        
        public String getDriver(){
            return this.driver;
        }
        
        public String getConnStr(){
            return this.connStr;
        }
    }
    
    private static Connection conn = null;
    private static Properties connProperties = null;
    private static DbManager.Drivers selectedDriver = null;
    
    /**
     * Static DbManager class for use of one concurrent database connection
     */
    
    // Private constructor. No instances allowed 
    private DbManager(){
        //
    }
    
    // No cloning allowed either
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    
    /**
     * This static method returns a Connection object with saved settings
     * @access public static
     * @return Connection
     * @throws DbManagerException 
     */
    
    // Give the current static Connection object
    public static synchronized Connection getConnection() throws DbManagerException {
        if(DbManager.selectedDriver == null){
            throw new DbManagerException("No database driver selected!", 150);
        }
        else if(DbManager.connProperties == null){
            throw new DbManagerException("No database settings available", 151);
        }
        
        return DbManager.connect(DbManager.selectedDriver);
    }
    
    /**
     * This static method returns a Connection object with given settings
     * @access public static
     * @param driver
     * @param connProperties
     * @return Connection
     * @throws DbManagerException 
     */
    
    public static Connection getConnection(DbManager.Drivers driver, Properties connProperties) throws DbManagerException {
        DbManager.selectedDriver = driver;
        
        if(connProperties.getProperty("host") == null || 
           connProperties.getProperty("port") == null || 
           connProperties.getProperty("user") == null || 
           connProperties.getProperty("password") == null || 
           connProperties.getProperty("database") == null){
            throw new DbManagerException("Connection properties list incomplete", 1000);
        }
        
        if(connProperties.getProperty("ssl") != null && "false".equals(connProperties.getProperty("ssl"))){
            connProperties.remove("ssl");
        }
        
        DbManager.connProperties = connProperties;
        
        return DbManager.connect(driver);
    }
    
    /**
     * This private method opens a database connection
     * @access private
     * @param driver
     * @return Connection
     * @throws DbManagerException 
     */
    
    private static Connection connect(DbManager.Drivers driver) throws DbManagerException {
        try {
            Class.forName(driver.getDriver()).newInstance();
            String connStr = driver.getConnStr()+DbManager.connProperties.getProperty("host")+":"+DbManager.connProperties.getProperty("port")+"/"
                                                                   +DbManager.connProperties.getProperty("database")
                                                                   +"?user="+DbManager.connProperties.getProperty("user")
                                                                   +"&password="+DbManager.connProperties.getProperty("password");
            
            if("true".equals(DbManager.connProperties.getProperty("ssl"))){
                connStr += "&ssl=true";
            }
            
            // First close any existing database connection
            if(DbManager.conn != null){
                DbManager.close();
            }
            DbManager.conn = DriverManager.getConnection(connStr);
        }
        catch(SQLException e){ 
            throw new DbManagerException("SQL: "+e.getMessage(), 1010);
        }
        catch(ClassNotFoundException e){
            throw new DbManagerException("Class Not Found: "+e.getMessage(), 1011);
        }
        catch(InstantiationException e){
            throw new DbManagerException(e.getMessage(), 1013);
        }
        catch(Exception e){
            throw new DbManagerException(e.getMessage(), 1015);
        }
        return DbManager.conn;
    }
    
    
    /**
     * This method closes the connection
     * @access public
     * @throws DbManagerException 
     */
    public static void close() throws DbManagerException {
        try{
            DbManager.conn.close();
        }
        catch(SQLException e){
            throw new DbManagerException("Could not close connection.\n"+e.getMessage(), 1090);
        }
    }
}
