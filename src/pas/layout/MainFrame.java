/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.layout;

import mvc.view.AbstractFrame;
import pas.main.MainController;

/**
 *
 * @author Frank
 */
public class MainFrame extends AbstractFrame {
private MainController maincontroller;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        this.setExtendedState(AbstractFrame.MAXIMIZED_BOTH);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuItemSluiten = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new java.awt.FlowLayout());

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuFileMouseClicked
        System.out.println("Sluiten...");
    }//GEN-LAST:event_MenuFileMouseClicked

    private void MenuItemSluitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSluitenActionPerformed
        // TODO add your handling code here:
        new MainController().mainAction();
    }//GEN-LAST:event_MenuItemSluitenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem MenuItemSluiten;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
