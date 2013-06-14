package pas.financial;

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
    
    /**
     * 
     */
    public FinancialController() {
        this.mainFrame = (MainFrame) getMainFrame();
        this.locked = false;
        this.lockMessage = "";
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
    private FinancialData getSubscriptionRevenues(int time_from, int time_to){
        String location = "";
        return this.getSubscriptionRevenues(time_from, time_to, location);
    }
    
    private FinancialData getSubscriptionRevenues(String location){
        int time_from = 0;
        int time_to = 9999999;
        return this.getSubscriptionRevenues(time_from, time_to, location);
    }
    
    private FinancialData getSubscriptionRevenues(int time_from, int time_to, String location){
        Query query = getEntityManager().createNamedQuery("Finance.returnRevenues");
        query.setParameter("time_from", time_from);
        query.setParameter("time_to", time_to);
        query.setParameter("location", location);
        
        return new FinancialData((Finance) query.getSingleResult());
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
}
