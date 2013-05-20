package pas.member;

import pas.member.*;
import mvc.controller.AbstractController;
import pas.layout.MainFrame;

/**
 *
 * @author Frank
 */
public class MemberController extends AbstractController {

    private MainFrame mainFrame;

    public MemberController() {
        mainFrame = (MainFrame) getMainFrame();

    }

    public void manageMemberAction() {
        ManageMember view = new ManageMember(this);
        mainFrame.setSidebarEnabled(true);
        mainFrame.setProfilePanelEnabled(true);
        open(view);
    }

    public void addMemeberAction() {
        open(new AddMember(this));
        mainFrame.setSidebarEnabled(false);
        mainFrame.setProfilePanelEnabled(true);
    }
}
