package pas.file.chooser;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Image chooser
 * 
 * @author Frank
 */
public class FileChooserImage extends FileChooserAbstract {

    public FileChooserImage(FileChooserInterface caller) {
        super(caller);
        
        JFileChooser chooser = getFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(
                new FileNameExtensionFilter("Image files", "jpg", "png"));
    }
}
