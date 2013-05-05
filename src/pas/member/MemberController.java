package pas.member;

import mvc.controller.AbstractController;

/**
 *
 * @author Frank
 */
public class MemberController extends AbstractController {

    public void manageMemberAction() {
        open(new manageMember(this));
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
