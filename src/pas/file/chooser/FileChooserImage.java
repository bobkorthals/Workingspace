package pas.file.chooser;

/**
 *
 * @author Frank
 */
public class FileChooserImage extends FileChooserAbstract {

    public FileChooserImage(FileChooserInterface caller) {
        super(caller);
        
        getFileChooser().setMultiSelectionEnabled(false);
    }
    
    
}
