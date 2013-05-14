package pas.layout;

import java.awt.Container;
import javax.swing.JPanel;
import mvc.view.AbstractFrame;
import mvc.view.AbstractView;

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
        pnlUser = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        link1 = new pas.layout.label.Link();
        lblSepperator1 = new javax.swing.JLabel();
        linkLogout = new pas.layout.label.Link();
        imgLogo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        link2 = new pas.layout.label.Link();
        lblSepperator2 = new javax.swing.JLabel();
        linkLogout1 = new pas.layout.label.Link();
        pnlSidebar = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuItemSluiten = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 204, 102));
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        pnlBackground.setOpaque(false);

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        pnlMain.setOpaque(false);
        pnlMain.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(pnlMain);

        pnlHeader.setOpaque(false);
        pnlHeader.setPreferredSize(new java.awt.Dimension(461, 200));

        pnlBackgroundHead.setOpaque(false);

        pnlUser.setOpaque(false);

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setOpaque(false);

        link1.setText("Wijzig profiel");

        lblSepperator1.setText("-");
        lblSepperator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblSepperator1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        linkLogout.setText("Uitloggen");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(link1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblSepperator1, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(linkLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(link1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSepperator1))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlUserLayout = new javax.swing.GroupLayout(pnlUser);
        pnlUser.setLayout(pnlUserLayout);
        pnlUserLayout.setHorizontalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        pnlUserLayout.setVerticalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout pnlBackgroundHeadLayout = new javax.swing.GroupLayout(pnlBackgroundHead);
        pnlBackgroundHead.setLayout(pnlBackgroundHeadLayout);
        pnlBackgroundHeadLayout.setHorizontalGroup(
            pnlBackgroundHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(pnlUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        pnlBackgroundHeadLayout.setVerticalGroup(
            pnlBackgroundHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundHeadLayout.createSequentialGroup()
                .addGroup(pnlBackgroundHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundHeadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgLogo))
                    .addGroup(pnlBackgroundHeadLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(pnlUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(pnlBackgroundHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSidebar.setOpaque(false);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        MenuFile.setText("File");
        MenuFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuFileMouseClicked(evt);
            }
        });

        MenuItemSluiten.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        MenuItemSluiten.setText("Naar Hoofdmenu");
        MenuItemSluiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSluitenActionPerformed(evt);
            }
        });
        MenuFile.add(MenuItemSluiten);

        jMenuBar1.add(MenuFile);

        jMenu2.setText("Edit");
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

    private void MenuFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuFileMouseClicked
        System.out.println("Sluiten...");
    }//GEN-LAST:event_MenuFileMouseClicked

    private void MenuItemSluitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSluitenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuItemSluitenActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem MenuItemSluiten;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlUser;
    // End of variables declaration//GEN-END:variables
}
