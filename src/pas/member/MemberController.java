package pas.member;

import mvc.controller.AbstractController;
import pas.layout.MainFrame;

/**
 *
 * @author Frank
 */
public class MemberController extends AbstractController {

    public MemberController() {
        MainFrame mainFrame = (MainFrame) getMainFrame();
        mainFrame.setSidebarEnabled(true);
    }

    public void manageMemberAction() {
        open(new ManageMember(this));
    }

    public void addMemeberAction() {
        open(new AddMember(this));
    }

    public void measurementResultsAction() {
        MeasurementResults view = new MeasurementResults(this);
        open(view);
    }

    public void measurementAction() {
        Measurement view = new Measurement(this);
        open(view);
    }
}
