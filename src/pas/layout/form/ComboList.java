package pas.layout.form;

/**
 *
 * @author Frank
 */
public class ComboList extends javax.swing.JComboBox {

    public void addItem(ComboListItem item) {
        super.addItem(item);
    }

    @Override
    public ComboListItem getItemAt(int index) {
        return (ComboListItem) super.getItemAt(index);
    }
}
