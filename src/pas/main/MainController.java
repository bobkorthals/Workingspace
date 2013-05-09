package pas.main;

import mvc.controller.AbstractController;
import pas.layout.MainFrame;

/**
 *
 * @author jkg
 */
public class MainController extends AbstractController {

    public MainController() {
        MainFrame mainFrame = (MainFrame) getMainFrame();
        mainFrame.setSidebarEnabled(false);
    }
    
    public void mainAction(String functie) {
        Main view = new Main(this, functie);
        open(view);
    }

    public void actorLoginAction() {
        ActorLogin view = new ActorLogin(this);
        open(view);
    }
}
