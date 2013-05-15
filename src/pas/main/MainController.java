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
        mainFrame.setSidebarEnabled(false);
        mainFrame.setProfilePanelEnabled(false);
        Main view = new Main(this);
        open(view);
    }

    
}
