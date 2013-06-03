package pas.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.Application;
import mvc.controller.AbstractController;
import mvc.controller.InstanceController;
import mvc.exception.NoInstanceControllerException;
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
        mainFrame.setProfilePanelEnabled(true);
        Main view = new Main(this);
        open(view);
    }
    
    public void referer() {
        InstanceController instanceController = null;
        try {
            instanceController = Application.getInstance()
                                            .getInstanceController();
            
        } catch (NoInstanceControllerException ex) {
            Logger.getLogger(AbstractController.class.getName())
                  .log(Level.SEVERE, null, ex);
        }
        
        open(instanceController.getReferer());
    }
}
