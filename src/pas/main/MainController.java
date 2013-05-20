package pas.main;

import mvc.controller.AbstractController;
import pas.layout.MainFrame;

/**
 *
 * @author jkg
 */
public class MainController extends AbstractController {

    private MainFrame mainFrame;

    public MainController() {
        mainFrame = (MainFrame) getMainFrame();
    }

    public void mainAction() {
        mainFrame.setSidebarEnabled(true);
        mainFrame.setProfilePanelEnabled(true);
        Main view = new Main(this);
        open(view);
    }
}
