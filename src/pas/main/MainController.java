package pas.main;

import mvc.controller.AbstractController;
import pas.layout.MainFrame;

/**
 *
 * @author jkg
 */
public class MainController extends AbstractController {

    public MainController() {
        MainFrame mainFrame;
        mainFrame = (MainFrame) this.getMainFrame();
        mainFrame.setSidebarEnabled(false);
    }
    
    public void mainAction() {
        Main view = new Main(this);
        open(view);
    }

   
}
