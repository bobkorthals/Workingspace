package pas.layout;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JPanel;
import mvc.view.AbstractFrame;
import mvc.view.AbstractView;
import pas.layout.label.Button;
import pas.layout.panel.iterate.SidebarMemberSearchResult;
import pas.main.MainController;
import pas.models.db.Member;

/**
 *
 * @author Frank
 */
public class MainFrame extends AbstractFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setExtendedState(AbstractFrame.MAXIMIZED_BOTH);
        btnAllMembers.setStatus(Button.ACTIVE); 
        
//        EntityManager entityManager = Persistence.createEntityManagerFactory("PASPU").createEntityManager();
//        Query query = entityManager.createNamedQuery("Member.findAll");
//        List<Member> memberList = query.getResultList();
//        
//        pnlMemberSearchResults.setLayout(new GridLayout(memberList.size(), 0));
//        GridBagConstraints gbc = new GridBagConstraints();
//        
//        for (Member member: memberList) {
//            pnlMemberSearchResults.add(new SidebarMemberSearchResult(member), gbc);
//        }
    }

    /*
     * By overriding the setContentPane mehtod we make sure that 
     * not the entire contentPane but just the main JPanel receives the
     * view when the instanceController opens a view.
     * 
     * @param Container view
     * @return void
     */
    @Override
    public void setContentPane(Container contentPane) {
        if (contentPane instanceof AbstractView) {
            JPanel view = (JPanel) contentPane;
            this.pnlMain.removeAll();
            this.pnlMain.add(view);
        } else {
            super.setContentPane(contentPane);
        }
    }

    public void setSidebarEnabled(boolean flag) {
        this.pnlSidebar.setVisible(flag);
    }

    public void setProfilePanelEnabled(boolean flag) {
        this.profilePanel.setVisible(flag);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        javax.swing.JPanel pnlBackground = new pas.layout.panel.Background("/pas/resources/Pas_Background.jpg", pas.layout.panel.Background.REPEAT);
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlMain = new pas.layout.panel.Background("/pas/resources/background.jpg", pas.layout.panel.Background.REPEAT);
        pnlHeader = new javax.swing.JPanel();
        pnlBackgroundHead = new pas.layout.panel.Background(
            "/pas/resources/background_head.png", pas.layout.panel.Background.REPEAT_HORIZONTAL);
        imgLogo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        link2 = new pas.layout.label.Link();
        lblSepperator2 = new javax.swing.JLabel();
        linkLogout1 = new pas.layout.label.Link();
        profilePanel = new javax.swing.JPanel();
        link1 = new pas.layout.label.Link();
        lblSepperator1 = new javax.swing.JLabel();
        linkLogout = new pas.layout.label.Link();
        pnlSidebar = new javax.swing.JPanel();
        title2 = new pas.layout.label.Title();
        pnlMemberSearchControl = new javax.swing.JPanel();
        btnAllMembers = new pas.layout.label.Button();
        btnActiveMembers = new pas.layout.label.Button();
        textField1 = new pas.layout.textfield.TextField("Zoek op naam of lid nummer..");
        pnlMemberSearchResults = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 204, 102));
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        pnlBackground.setOpaque(false);
        pnlBackground.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnlBackgroundKeyPressed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        pnlMain.setOpaque(false);
        pnlMain.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(pnlMain);

        pnlHeader.setOpaque(false);
        pnlHeader.setPreferredSize(new java.awt.Dimension(461, 200));

        pnlBackgroundHead.setOpaque(false);

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pas/resources/logo.png"))); // NOI18N

        jPanel4.setOpaque(false);

        link2.setText("Wijzig profiel");
        jPanel4.add(link2);

        lblSepperator2.setText("-");
        lblSepperator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblSepperator2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(lblSepperator2);

        linkLogout1.setText("Uitloggen");
        jPanel4.add(linkLogout1);

        profilePanel.setOpaque(false);

        link1.setText("Wijzig profiel");

        lblSepperator1.setText("-");
        lblSepperator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblSepperator1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        linkLogout.setText("Uitloggen");

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(link1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblSepperator1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(link1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSepperator1))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBackgroundHeadLayout = new javax.swing.GroupLayout(pnlBackgroundHead);
        pnlBackgroundHead.setLayout(pnlBackgroundHeadLayout);
        pnlBackgroundHeadLayout.setHorizontalGroup(
            pnlBackgroundHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundHeadLayout.createSequentialGroup()
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBackgroundHeadLayout.setVerticalGroup(
            pnlBackgroundHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgLogo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundHead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(pnlBackgroundHead, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSidebar.setOpaque(false);
        pnlSidebar.setPreferredSize(new java.awt.Dimension(240, 403));

        title2.setText("Leden beheer");

        pnlMemberSearchControl.setPreferredSize(new java.awt.Dimension(240, 127));

        btnAllMembers.setText("Alle leden");
        btnAllMembers.setAlignmentY(0.0F);
        btnAllMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAllMembersMouseClicked(evt);
            }
        });

        btnActiveMembers.setText("Nu aanwezig");
        btnActiveMembers.setAlignmentY(0.0F);
        btnActiveMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActiveMembersMouseClicked(evt);
            }
        });

        textField1.setBorder(null);
        textField1.setAlignmentX(0.0F);
        textField1.setAlignmentY(0.0F);
        textField1.setMargin(new java.awt.Insets(5, 5, 5, 5));

        javax.swing.GroupLayout pnlMemberSearchControlLayout = new javax.swing.GroupLayout(pnlMemberSearchControl);
        pnlMemberSearchControl.setLayout(pnlMemberSearchControlLayout);
        pnlMemberSearchControlLayout.setHorizontalGroup(
            pnlMemberSearchControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMemberSearchControlLayout.createSequentialGroup()
                .addGroup(pnlMemberSearchControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMemberSearchControlLayout.createSequentialGroup()
                        .addComponent(btnActiveMembers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnAllMembers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMemberSearchControlLayout.setVerticalGroup(
            pnlMemberSearchControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMemberSearchControlLayout.createSequentialGroup()
                .addGroup(pnlMemberSearchControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAllMembers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActiveMembers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMemberSearchResults.setOpaque(false);
        pnlMemberSearchResults.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMemberSearchResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMemberSearchControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMemberSearchControl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMemberSearchResults, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu2.setText("Edit");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Naar Hoofdmenu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActiveMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActiveMembersMouseClicked
        btnAllMembers.toggleStatus();
    }//GEN-LAST:event_btnActiveMembersMouseClicked

    private void btnAllMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAllMembersMouseClicked
        btnActiveMembers.toggleStatus();
    }//GEN-LAST:event_btnAllMembersMouseClicked

    private void pnlBackgroundKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlBackgroundKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlBackgroundKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new MainController().mainAction();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pas.layout.label.Button btnActiveMembers;
    private pas.layout.label.Button btnAllMembers;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSepperator1;
    private javax.swing.JLabel lblSepperator2;
    private pas.layout.label.Link link1;
    private pas.layout.label.Link link2;
    private pas.layout.label.Link linkLogout;
    private pas.layout.label.Link linkLogout1;
    private javax.swing.JPanel pnlBackgroundHead;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMemberSearchControl;
    private javax.swing.JPanel pnlMemberSearchResults;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel profilePanel;
    private pas.layout.textfield.TextField textField1;
    private pas.layout.label.Title title2;
    // End of variables declaration//GEN-END:variables
}
