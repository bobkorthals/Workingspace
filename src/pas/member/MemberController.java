package pas.member;

import mvc.controller.AbstractController;
import pas.layout.FileChooser;
/**
 *
 * @author Frank
 */
public class MemberController extends AbstractController {
    
    public void manageMemberAction() {
        open(new manageMember(this));
    }    

    public void addMemeberAction(){
    open (new AddMember(this));
    }

    public void fileChooserAction(){
    open(new FileChooser(this));
    }

    public void measurementResultsAction(){
    open(new MeasurementResults(this));
    }
}
