/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.facility;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mvc.Application;
import mvc.controller.AbstractController;
import pas.exception.NoEntityManagerException;
import pas.layout.MainFrame;
import pas.member.MemberController;
import pas.models.ActiveMember;
import pas.models.SessionManager;
import pas.models.db.Faciliteit;
import pas.models.db.Vestiging;
import session.NoSessionManagerException;

/**
 *
 * @author jkg
 */
public class FacilityController extends AbstractController {

    private MainFrame mainFrame;

    public FacilityController() {
        mainFrame = (MainFrame) getMainFrame();
        mainFrame.setProfilePanelEnabled(true);
        mainFrame.setSidebarEnabled(true);
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
    
    /*
     * Returns the active member
     * 
     * @return ActiveMember
     */
    private ActiveMember getActiveMember() {
        try {
            return getSessionManager().getActiveMember();
        } catch (NoEntityManagerException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
     * Get facilities from the database
     * 
     * @return List<Faciliteit>
     */
    public List<Faciliteit> getFacilitiesByLocatieId(Vestiging vestigingId) {
        Query query = getEntityManager().createNamedQuery("Faciliteit.findbyIdLocatie");
        query.setParameter("vestigingid", vestigingId);
        return query.getResultList();
    }
    
    /*
     * Get facilities from the database
     * 
     * @return List<Faciliteit>
     */
    private List<Vestiging> getVestigingen() {
        Query query = getEntityManager().createNamedQuery("Vestiging.findAll");
        return query.getResultList();
    }

    public void facilityAction() {
        Facility view = new Facility(this);
        open(view);
    }

    public void reservationChange() {
        ReservationChange view = new ReservationChange(this);
        open(view);
    }

    public void paymentAction() {
        open(new ReservationPayment(this,
                getActiveMember().getMember()));
    }

    public void addFacilityAction() {
        AddFacility view = new AddFacility(this);
        open(view);
    }

    public void actionReservationMemberSelected() {
        open(new ReservationFacilityMemberSelected(
                this, 
                getActiveMember().getMember(), 
                getVestigingen()));
    }
}
