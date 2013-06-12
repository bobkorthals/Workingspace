/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.layout.table;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Ruben
 */
public class Table extends JTable {
    public void setMultiSelect(){
        this.setRowSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
}
