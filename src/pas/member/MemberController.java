package pas.member;

import mvc.controller.AbstractController;

/**
 *
 * @author Frank
 */
public class MemberController extends AbstractController {
    
    public void addMemberAction() {
        open(new AddMember(this));
    }    
}
