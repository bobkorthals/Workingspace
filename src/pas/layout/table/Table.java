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
    private boolean allSelected = false;
    
    public void setMultiSelect(){
        this.setRowSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    public void selectAllRows(){
        this.setRowSelectionInterval(0, this.getRowCount() - 1);
        this.allSelected = true;
    }
    
    public void deselectAllRows(){
        this.clearSelection();
        this.allSelected = false;
    }
    
    public void toggleRowSelect(){
        if(this.allSelected == true){
            this.deselectAllRows();
        } else {
             this.selectAllRows();
        }
    }
    
    public void setValue(Object val, int row, int col){
        this.dataModel.setValueAt(val, row, col);
    }
}
