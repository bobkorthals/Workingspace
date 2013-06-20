package pas.layout.panel.iterate;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pas.member.MemberController;
import pas.models.db.Lid;

/**
 *
 * @author Frank
 */
public class SidebarMemberSearchResult extends JPanel implements MouseListener {

    // Member controller
    private static MemberController controller;
    private Lid member;
    
    // Active result list members
    private static ArrayList<SidebarMemberSearchResult> activeResultList = new ArrayList<>();
    // Statusses
    public static final int INACTIVE = 1;
    public static final int ACTIVE = 2;
    // Alternating background colors
    public static final Color COLOR_ODD = new Color(255, 255, 255);
    public static final Color COLOR_EVEN = new Color(222, 222, 222);
    /*
     * State
     */
    private int status = SidebarMemberSearchResult.INACTIVE;
    private Color color = new Color(0, 0, 0);
    private Color backgroundColor; // Alternating
    private int cursor = Cursor.HAND_CURSOR;
    /*
     * Hover style
     */
    private Color hoverColor = new Color(255, 255, 255);
    private Color hoverBackgroundColor = new Color(155, 9, 46);
    /*
     * Active style
     */
    private Color activeColor = new Color(255, 255, 255);
    private Color activeBackgroundColor = new Color(155, 9, 46);

    /*
     * Creates new form SidebarMemberSearchResult
     * 
     * @param Lid member
     */
    public SidebarMemberSearchResult(Lid member) {
        initComponents();

        this.member = member;
           
        lblMemberName.setText(member.getVoornaam()+ " " + member.getAchternaam());
        lblMemberName.setForeground(color);

        lblMemberId.setText(member.getId().toString());
        lblMemberId.setForeground(color);

        setBorder(new EmptyBorder(0, 10, 0, 0));
        setCursor(new Cursor(this.cursor));

        if (SidebarMemberSearchResult.activeResultList.size() % 2 == 0) {
            setBackground(SidebarMemberSearchResult.COLOR_ODD);
            this.backgroundColor = SidebarMemberSearchResult.COLOR_ODD;
        } else {
            setBackground(SidebarMemberSearchResult.COLOR_EVEN);
            this.backgroundColor = SidebarMemberSearchResult.COLOR_EVEN;
        }

        SidebarMemberSearchResult.activeResultList.add(this);
        addMouseListener(this);
    }
    
    /*
     * Return member id
     * 
     * @param int memberId
     */
    public int getMemberId() {
        return this.member.getId();
    }
    
    /*
     * Set membername
     * 
     * @param String name
     * @return void
     */
    public void setMemberName(String name) {
        lblMemberName.setText(name);
    }
    
    /*
     * Returns an instance of the controller
     * 
     * @return MemberController controller
     */
    public MemberController getController() {
        if (null == SidebarMemberSearchResult.controller) {
            SidebarMemberSearchResult.controller = new MemberController();
        }
        
        return SidebarMemberSearchResult.controller;
    }

    /*
     * Reset the alternate counter
     * 
     * @return void
     */
    public static void resetCounter() {
        SidebarMemberSearchResult.activeResultList.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMemberName = new javax.swing.JLabel();
        lblMemberId = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(246, 20));
        setMinimumSize(new java.awt.Dimension(246, 20));
        setPreferredSize(new java.awt.Dimension(246, 20));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblMemberName.setText("Member name");

        lblMemberId.setText("Member id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblMemberId)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMemberId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        getController().manageMemberAction(
                Integer.parseInt(lblMemberId.getText()));
    }//GEN-LAST:event_formMouseClicked

    /*
     * Toggle status
     * 
     * @return void
     */
    public void toggleStatus() {
        switch (this.status) {
            case 1:
                this.setStatus(SidebarMemberSearchResult.ACTIVE);
                break;
            case 2:
                this.setStatus(SidebarMemberSearchResult.INACTIVE);
                break;
        }
    }

    /*
     * Activate or deactivate the button
     * 
     * @param int status
     * @return void
     */
    public void setStatus(int status) {
        switch (status) {
            case 1:
                this.setInactive();
                break;
            case 2:
                this.setActive();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        switch (status) {
            case 1:
                setStatus(SidebarMemberSearchResult.ACTIVE);
                break;
            case 2:
                setStatus(SidebarMemberSearchResult.INACTIVE);
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        if (null != hoverColor && !color.equals(hoverColor)) {
            lblMemberId.setForeground(hoverColor);
            lblMemberName.setForeground(hoverColor);
        }

        if (null != hoverBackgroundColor && !color.equals(hoverBackgroundColor)) {
            setBackground(hoverBackgroundColor);
        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        if (status == SidebarMemberSearchResult.INACTIVE) {
            setInactive();
        } else {
            if (null != activeColor && !color.equals(activeColor)) {
                lblMemberId.setForeground(activeColor);
                lblMemberName.setForeground(activeColor);
            } else {
                lblMemberId.setForeground(color);
                lblMemberName.setForeground(color);
            }

            if (null != activeBackgroundColor && !backgroundColor.equals(activeBackgroundColor)) {
                setBackground(activeBackgroundColor);
            } else {
                setBackground(backgroundColor);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /*
     * Activate button
     * 
     * @return void
     */
    private void setActive() {
        // Disable all buttons
        for (SidebarMemberSearchResult searchResult: SidebarMemberSearchResult.activeResultList) {
            searchResult.setInactive();
        }
        
        this.status = SidebarMemberSearchResult.ACTIVE;
        if (null != activeColor && !color.equals(activeColor)) {
            lblMemberId.setForeground(activeColor);
            lblMemberName.setForeground(activeColor);
        }

        if (null != activeBackgroundColor && !backgroundColor.equals(activeBackgroundColor)) {
            setBackground(activeBackgroundColor);
        }
    }

    /*
     * Deactivate button (back to default state)
     * 
     * @return void
     */
    private void setInactive() {
        this.status = SidebarMemberSearchResult.INACTIVE;
        lblMemberId.setForeground(color);
        lblMemberName.setForeground(color);
        setBackground(backgroundColor);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMemberId;
    private javax.swing.JLabel lblMemberName;
    // End of variables declaration//GEN-END:variables

}
