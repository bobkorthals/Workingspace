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
        Main view = new Main(this);
        mainFrame.setSidebarEnabled(false);
        open(view);
    }

    
}
