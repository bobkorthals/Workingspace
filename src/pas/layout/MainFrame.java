/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.layout;

/**
 *
 * @author Frank
 */
public class MainFrame extends mvc.view.AbstractFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        MenuItemSluiten.setText("Sluiten");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem MenuItemSluiten;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
