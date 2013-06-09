package pas.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import mvc.model.PropertyChangeSupportInterface;
import pas.models.role.Member;

/**
 *
 * @author Frank
 */
public class ActiveMember implements PropertyChangeSupportInterface {

    // Propery name
    public static final String MEMBER = "member";
    // Active member
    private Member member;
    // Listeners
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /*
     * Is there an active member?
     * 
     * @return boolean
     */
    public boolean hasMember() {
        return null != this.member;
    }

    /*
     * Return the active member
     * 
     * @return Member active member
     */
    public Member getMember() {
        return member;
    }

    /*
     * Update active member
     */
    public void setMember(Member member) {
        if (this.propertyChangeSupport.hasListeners(null)) {
            this.propertyChangeSupport.firePropertyChange(
                    ActiveMember.MEMBER, this.member, member);
        }

        this.member = member;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
