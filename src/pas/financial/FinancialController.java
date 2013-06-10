package pas.financial;

import mvc.controller.AbstractController;
import pas.layout.MainFrame;

/**
 *
 * @author Ruben
 */
public class FinancialController extends AbstractController {

    private MainFrame mainFrame;
    private Financial view;
    private String lockMessage;
    private boolean locked;

    public FinancialController() {
        mainFrame = (MainFrame) getMainFrame();
        this.locked = false;
        this.lockMessage = "";
    }

    public void defaultAction() {
        mainFrame.setSidebarEnabled(false);
        mainFrame.setProfilePanelEnabled(true);
        this.view = new Financial(this);
        
        this.open(this.view);
    }
    
    public boolean requestCardSwitch() throws Exception {
        if(this.locked){
            throw new Exception(this.lockMessage);
        }        
        return true;
    }
    
    public void lockCard(String message){
        this.lockMessage = message;
        this.locked = true;
    }
    
    public void unlockCard(){
        this.lockMessage = "";
        this.locked = false;
    }
}
