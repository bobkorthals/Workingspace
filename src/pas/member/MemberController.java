package pas.member;

import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.Application;
import mvc.controller.AbstractController;
import pas.layout.MainFrame;
import pas.models.SessionManager;
import pas.models.role.Member;
import session.NoSessionManagerException;

/**
 *
 * @author Frank
 */
public class MemberController extends AbstractController {

    public MemberController() {
        MainFrame mainFrame = (MainFrame) getMainFrame();
        mainFrame.setSidebarEnabled(true);
        mainFrame.setProfilePanelEnabled(true);
    }
    
    /*
     * Returns the Sessionmanager
     * 
     * @return SessionManager
     */
    protected SessionManager getSessionManager() {
        try {
            return (SessionManager) Application.getInstance().getSessionManager();
        } catch (NoSessionManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Member getMember(int memberId) {
        return new Member(memberId);
    }

    /*
     * DEZE METHOD MOET VERDWIJNEN! ER IS GEEN MEMBER ?!
     */
    public void manageMemberAction() {
        open(new ManageMember(this));
    }

    public void manageMemberAction(int memberId) {
        open(new ManageMember(this, this.getMember(memberId)));
    }

    public void addMemeberAction() {
        open(new AddMember(this));
    }
}
