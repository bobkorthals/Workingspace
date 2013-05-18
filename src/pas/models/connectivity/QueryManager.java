package pas.models.connectivity;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import pas.exception.*;

/**
 * @description
 * @author Ruben
 */
public class QueryManager {
    private static Connection conn;
    private ArrayList<ResultSet> resultset = new ArrayList<>();
    private ArrayList<PreparedStatement> pStatement = new ArrayList<>();
    private Statement statement = null;
    
    private static QueryManager instance = null;
    
    /**
     * Singelton QueryManager object
     */
    private QueryManager(){
               
    }
    
    // No cloning allowed
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    
    /**
     * @access public
     * @return QueryManager instance
     * @throws DbManagerException 
     */
    
    public static synchronized QueryManager getInstance(Connection conn) throws DbManagerException {
        // Overwrite connection with latest connection
        QueryManager.conn = conn;
        
        if(QueryManager.instance == null){
            QueryManager.instance = new QueryManager();
        }
        return QueryManager.instance;
    }
    
    /**
     * @access public
     * @return QueryManager instance
     * @throws DbManagerException 
     */
    
    public static synchronized QueryManager getInstance() throws DbManagerException, QueryManagerException {
        if(QueryManager.instance == null){
            throw new QueryManagerException("Not initialized", 201);
        }
        return QueryManager.instance;
    }
    
    
    /**
     * @description
     * @param query (String)
     * @return
     * @throws QueryManagerException 
     */
    public int prepare(String query) throws QueryManagerException {
        try{
            this.pStatement.add(QueryManager.conn.prepareStatement(query));
            return this.pStatement.size()-1;
        }
        catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1020);
        }
        catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1021);
        }
    }
    
    /**
     * @description Support for Transactions
     * @param autocommit (boolean)
     * @throws QueryManagerException 
     */
    public void setAutocommit(boolean autocommit) throws QueryManagerException {
        try {
            QueryManager.conn.setAutoCommit(autocommit);
        }
        catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1022);
        }
        catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1023);
        }
    }
    
    
    public Savepoint setSavepoint() throws QueryManagerException {
        try {
            return QueryManager.conn.setSavepoint();
        }
        catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1024);
        }
        catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1025);
        }
    }
    
    public void rollback() throws QueryManagerException {
        try {
            QueryManager.conn.rollback();
        } catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1026);
        }
        catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1027);
        }
    }
    
    public void rollback(Savepoint sp) throws QueryManagerException {
        try {
            QueryManager.conn.rollback();
        } catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1028);
        }
        catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1029);
        }
    }
    
    public void commit() throws QueryManagerException {
        try {
            QueryManager.conn.commit();
        } catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1030);
        }
        catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1031);
        }
    }
    
    /**
     * @descriptions    Executes a prepared statement stored at defined index without values
     *                  This prepared statement can only be an Select
     *                  It will return the number of affected rows
     *                  It will throw a QueryManagerException when it fails
     * @param index (int)
     * @return ResultSet
     * @throws QueryManagerException 
     */
    public ResultSet doPreparedStatement(int index) throws QueryManagerException {
        try {
            if(QueryManager.conn.isClosed()){
                throw new QueryManagerException("Connection closed", 1032);
            }
            ResultSet rs = this.pStatement.get(index).executeQuery();
            this.resultset.add(rs);
            return rs;            
        } catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1033);
        } catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1034);
        }
    }
    
    /**
     * @descriptions    Executes a prepared statement stored at defined index with values
     *                  This prepared statement can only be an Select
     *                  It will return a ResultSet with results
     *                  It will throw a QueryManagerException when it fails
     * @param index (int)
     * @param values (ArrayList)
     * @return ResultSet
     * @throws QueryManagerException 
     */
    public ResultSet doPreparedStatement(int index, ArrayList<?> values) throws QueryManagerException {
        try {
            if(QueryManager.conn.isClosed()){
                throw new QueryManagerException("Connection closed", 1035);
            }
            
            this.parseValues(index, values);
            ResultSet rs = this.pStatement.get(index).executeQuery();
            this.resultset.add(rs);
            return rs;            
        } catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1036);
        } catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1037);
        }
    }
    
    /**
     * @descriptions    Executes a prepared statement stored at defined index without values
     *                  This prepared statement can only be an Insert, Delete, Create or Drop statement
     *                  It will return the number of affected rows
     *                  It will throw a QueryManagerException when it fails
     * @param index
     * @return int
     * @throws QueryManagerException 
     */
    public int executePreparedStatement(int index) throws QueryManagerException {
        try {
            if(QueryManager.conn.isClosed()){
                throw new QueryManagerException("Connection closed", 1038);
            }
            return this.pStatement.get(index).executeUpdate();
        } catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1039);
        } catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1040);
        }
    }
    
    /**
     * @descriptions    Executes a prepared statement stored at defined index with values
     *                  This prepared statement can only be an Insert, Delete or Update statement
     *                  It will return the number of affected rows
     *                  It will throw a QueryManagerException when it fails
     * @param index
     * @return int
     * @throws QueryManagerException 
     */
    public int executePreparedStatement(int index, ArrayList<?> values) throws QueryManagerException {
        try {
            if(QueryManager.conn.isClosed()){
                throw new QueryManagerException("Connection closed", 1041);
            }
            
            this.parseValues(index, values);
            return this.pStatement.get(index).executeUpdate();
        } catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1042);
        } catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1043);
        }
    }
    
    public ResultSet doQuery(String query) throws QueryManagerException {
        try {
            if(QueryManager.conn.isClosed()){
                throw new QueryManagerException("Connection closed", 1044);
            }
            this.statement = QueryManager.conn.createStatement();
            ResultSet rs = this.statement.executeQuery(query);
            this.resultset.add(rs);
            return rs;
        } catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1045);
        } catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1046);
        }
    }
    
    public int executeQuery(String query) throws QueryManagerException {
        try {
            if(QueryManager.conn.isClosed()){
                throw new QueryManagerException("Connection closed", 1047);
            }
            this.statement = QueryManager.conn.createStatement();
            return this.statement.executeUpdate(query);
        } catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1048);
        } catch(Exception e){
            throw new QueryManagerException(e.getMessage(), 1049);
        }
    }
    
    public ResultSet getResultSet(int index) throws QueryManagerException {
        if(index > this.resultset.size()){
            throw new QueryManagerException("Requested ResultSet does not exist", 1050);
        }
        return this.resultset.get(index);
    }
    
    private void parseValues(int index, ArrayList<?> values) throws QueryManagerException, QueryManagerUnknownTypeException {
        try {
            PreparedStatement currStatement = this.pStatement.get(index);
            int currentIteration = 1;
            for(Object value : values ){
                
                switch(value.getClass().getName()){
                    case "java.math.BigDecimal": currStatement.setBigDecimal(currentIteration, (BigDecimal) value);
                        break;
                    case "java.io.InputStream": currStatement.setBinaryStream(currentIteration, (InputStream) value);
                        break;
                    case "java.sql.Blob": currStatement.setBlob(currentIteration, (Blob) value);
                        break;
                    case "java.lang.Boolean": currStatement.setBoolean(currentIteration, (Boolean) value);
                        break;
                    case "java.lang.Byte": currStatement.setByte(currentIteration, (Byte) value);
                        break;
                    case "java.util.Date": value = new java.sql.Date(new java.util.Date().getTime());
                    case "java.sql.Date": currStatement.setDate(currentIteration, (java.sql.Date) value);
                        break;
                    case "java.lang.Double": currStatement.setDouble(currentIteration, (Double) value);
                        break;
                    case "java.lang.Short": currStatement.setShort(currentIteration, (Short) value);
                        break;
                    case "java.sql.Time": currStatement.setTime(currentIteration, (Time) value);
                        break;
                    case "java.sql.Timestamp": currStatement.setTimestamp(currentIteration, (Timestamp) value);
                        break;
                    case "java.lang.String": currStatement.setString(currentIteration, (String) value);
                        break;
                    case "java.lang.Integer": currStatement.setInt(currentIteration, (Integer) value);
                        break;
                    case "java.lang.Long": currStatement.setLong(currentIteration, (Long) value);
                        break;
                    case "java.lang.Object": currStatement.setObject(currentIteration, value);
                        break;
                    default: throw new QueryManagerUnknownTypeException("No prepare type found for "+value, 1052);
                }                
                currentIteration++;
            }
        }
        catch(SQLException e){
            throw new QueryManagerException(e.getMessage(), 1051);
        }
    }
}
