package pas.file.chooser;

/**
 *
 * @author Frank
 */
public interface FileChooserInterface {
    /**
     * Called to push events from the file chooser
     * to the calling view
     * 
     * @param evt
     * @return void
     */
    public void fileChooserActionPerformed(java.awt.event.ActionEvent evt);
}
