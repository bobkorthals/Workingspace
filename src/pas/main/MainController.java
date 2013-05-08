/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.main;

import mvc.controller.AbstractController;

/**
 *
 * @author jkg
 */
public class MainController extends AbstractController {
    
    public void mainAction(String functie){
    Main view=new Main(this, functie);
    open(view);
    }
    
    public void actorLoginAction(){
    ActorLogin view=new ActorLogin(this);
    open(view);
    }
    
}
