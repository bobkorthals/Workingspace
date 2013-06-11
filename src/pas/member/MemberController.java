package pas.member;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mvc.Application;
import mvc.controller.AbstractController;
import mvc.view.AbstractView;
import pas.exception.NoEntityManagerException;
import pas.layout.MainFrame;
import pas.models.ActiveMember;
import pas.models.SessionManager;
import pas.models.db.Lid;
import pas.models.role.Member;
import session.NoSessionManagerException;

/**
 *
 * @author Frank
 */
public class MemberController extends AbstractController {

    // ManageMember view
    private ManageMember manageMember;
    
    // Openend view
    private AbstractView open;
    
    /*
     * Enable sidebar and profile section in the mainframe
     */
    public MemberController() {
        MainFrame mainFrame = (MainFrame) getMainFrame();
        mainFrame.setSidebarEnabled(true);
        mainFrame.setProfilePanelEnabled(true);
     
        addModel(getActiveMember());
    }
    
    /*
     * Get the manageMember view
     * 
     * @return ManageMember view
     */
    private ManageMember getManageMember() {
        if (null == this.manageMember) {
            this.manageMember = new ManageMember(this);
            addView(this.manageMember);
        }
        
        return this.manageMember;
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
     * Return a new member from the database
     * 
     * @param int memberId
     * @return Member member
     */
    private Member getMember(int memberId) {
        Query query = getEntityManager().createNamedQuery("Lid.findById");
        query.setParameter("id", memberId);
        return new Member((Lid) query.getSingleResult());
    }
    
    /*
     * Open the index view
     * 
     * @return void
     */
    public void indexAction() {
        open(new MemberIndex(this));
    }

    /*
     * Change the active member and open the manage member view
     * 
     * @param int member to manage
     * @return void
     */
    public void manageMemberAction(int memberId) {
        getActiveMember().setMember(getMember(memberId));
        
        if (null == this.open || !this.open.equals(this.getManageMember())) {
            open(this.getManageMember());
            this.open = this.getManageMember();
        }
    }

    /*
     * Open the addMember view
     * 
     * @return void
     */
    public void addMemeberAction() {
        open(new AddMember(this));
    }
}
