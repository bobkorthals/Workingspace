package pas.financial;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mvc.Application;
import mvc.controller.AbstractController;
import pas.exception.NoEntityManagerException;
import pas.layout.MainFrame;
import pas.models.FinancialData;
import pas.models.SessionManager;
import pas.models.db.Finance;
import session.NoSessionManagerException;

/**
 *
 * @author Ruben
 */
public class FinancialController extends AbstractController {

    private MainFrame mainFrame;
    private Financial view;
    private String lockMessage;
    private boolean locked;
    
    private HashMap<String, Integer> cardQueries;
    private String[][] queries;
    
    /**
     * 
     */
    public FinancialController() {
        this.mainFrame = (MainFrame) getMainFrame();
        this.locked = false;
        this.lockMessage = "";
        this.matchCardQueries();
    }
    
    public boolean requestCardSwitch() throws Exception {
        if(this.locked){
            throw new Exception(this.lockMessage);
        }        
        return true;
    }
    
    public void lockCard(String message){
        this.lockMessage = message;
        this.locked = true;
    }
    
    public void unlockCard(){
        this.lockMessage = "";
        this.locked = false;
    }
    
    /**
     * 
     */
    public void defaultAction() {
        mainFrame.setSidebarEnabled(true);
        mainFrame.setProfilePanelEnabled(true);
        this.view = new Financial(this);
        this.open(this.view);
    }
    
    /**
     * 
     * @return 
     */
    public FinancialData getResultsByLocation(String card, int sqlIndex, int time_from, int time_to, String location){
        int current = this.cardQueries.get(card);
        
        String sql = this.queries[this.cardQueries.get(card)][sqlIndex];
        Query query = getEntityManager().createNamedQuery(sql);
        if(!location.equals("")) {
            query.setParameter("location", location);
        }
        query.setParameter("time_from", time_from);
        query.setParameter("time_to", time_to);
        
        return new FinancialData((Finance) query.getResultList());
    }
    
    public FinancialData getResults(String card, int sqlIndex, int time_from, int time_to){
        return this.getResultsByLocation(card, sqlIndex, time_from, time_to, "");
    }    
    
    /*
     * Returns the Sessionmanager
     * 
     * @return SessionManager
     */
    private SessionManager getSessionManager() {
        try {
            return (SessionManager) Application.getInstance().getSessionManager();
        } catch (NoSessionManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
     * Returns the database entity manager
     * 
     * @return EntityManager
     */
    private EntityManager getEntityManager() {
        try {
            return this.getSessionManager().getEntityManager();
        } catch (NoEntityManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void matchCardQueries(){
        this.cardQueries = new HashMap<>();
        this.cardQueries.put("revenuesCard", 0);
        this.cardQueries.put("collectionCard", 1);
        this.cardQueries.put("statusCard", 2);
        this.cardQueries.put("configCard", 4);
        
        this.queries = new String[4][20];
        
        this.queries[0][0] = "Finance.getRevenuesByLocation";
        this.queries[0][1] = "Finance.getRevenues";
        this.queries[0][2] = "Finance.getFacilityRevenuesByLocation";
        this.queries[0][3] = "Finance.getFacilityRevenues";
        this.queries[0][4] = "Finance.getCourseRevenuesByLocation";
        this.queries[0][5] = "Finance.getCourseRevenues";
        this.queries[0][6] = "Finance.getSubscriptionRevenuesByLocation";
        this.queries[0][7] = "Finance.getSubscriptionRevenues";        
    }
}
