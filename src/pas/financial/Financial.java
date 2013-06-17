/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.financial;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pas.layout.form.ComboListItem;
import pas.layout.label.Button;
import pas.layout.table.Table;

/**
 *
 * @author Ruben
 */
public class Financial extends mvc.view.AbstractView {
    private FinancialController controller;
    private CardLayout cardLayout;
    private Button currentActiveButton;
    private TableModel barTableModel;
    private String activePanel;
    
    private ArrayList<JTable> tables = new ArrayList<>();
    private HashMap<Integer, String[]> columns = new HashMap<>();
    
    /**
     * Creates new form Revenue
     */
    public Financial(FinancialController controller) {
        this.controller = controller;
        this.initComponents();
        this.assembleElements();
        this.updateTable(tablePaymentMembers, new ArrayList()); // <<=== Hier werkelijke data invoeren
        //this.controller.getResults(activePanel, 0, 0, 9999);
    }
    
    @Override
    public FinancialController getController(){
        return this.controller;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent change) {
        
    }
    
    public void updateSelection(String location, String from, String to, String status){
        
    }
    
    public void changeCard(String card){
        this.cardLayout.show(this.viewFrame, card);
        this.activePanel = card;
        
        if(card == "statusCard"){
            this.labelStatus.setVisible(true);
            this.selectStatus.setVisible(true);
        }
        else {
            this.labelStatus.setVisible(false);
            this.selectStatus.setVisible(false);
        }
        
        if(card == "settingsCard"){
            this.labelLocation.setVisible(false);
            this.selectLocation.setVisible(false);
            this.labelPeriod.setVisible(false);
            this.selectPeriodMonth.setVisible(false);
            this.selectPeriodYear.setVisible(false);
        }
        else {
            this.labelLocation.setVisible(true);
            this.selectLocation.setVisible(true);
            this.labelPeriod.setVisible(true);
            this.selectPeriodMonth.setVisible(true);
            this.selectPeriodYear.setVisible(true);
        }
    }
    
    public void activateButton(Button button){
        if(this.currentActiveButton == null){
            this.currentActiveButton = button;
        }
        this.currentActiveButton.setStatus(Button.INACTIVE);
        this.currentActiveButton = button;
        button.setStatus(Button.ACTIVE);
    }
    
    public void deActivateButton(Button button){
        this.deActivateButton(button, 100);
    }
    
    public void deActivateButton(Button button, int timeout){
        button.setStatus(Button.INACTIVE);
    }
    
    private void assembleElements(){        
        this.cardLayout = (CardLayout) this.viewFrame.getLayout();        
        this.changeCard("revenuesCard");
        this.activateButton(this.buttonRevenues);
        this.tableColumns();
        
        /** Table Setup **/
        this.setupTable(this.tableBar, barTableListener);
        this.setupTable(this.tableCourse, courseTableListener);
        this.setupTable(this.tableFacility, facilityTableListener);
        this.setupTable(this.tablePaymentMembers, membersTableListener);
        this.setupTable(this.tableCollectionMembers, members1TableListener);
        this.setupTable(this.tableSubscription, subscriptionTableListener);
        
        /** Combobox setup **/
        this.selectLocation.addItem(new ComboListItem("Alle", 0));
        this.selectLocation.addItem(new ComboListItem("Haarlem", 1));
        this.selectLocation.addItem(new ComboListItem("Purmerend", 2));
        this.selectLocation.addItem(new ComboListItem("Amsterdam", 3));
        
        this.selectPeriodMonth.addItem(new ComboListItem("Geheel", 0));
        this.selectPeriodMonth.addItem(new ComboListItem("Januari", 1));
        this.selectPeriodMonth.addItem(new ComboListItem("Februari", 2));
        this.selectPeriodMonth.addItem(new ComboListItem("Maart", 3));
        this.selectPeriodMonth.addItem(new ComboListItem("April", 4));
        this.selectPeriodMonth.addItem(new ComboListItem("Mei", 5));
        this.selectPeriodMonth.addItem(new ComboListItem("Juni", 6));
        this.selectPeriodMonth.addItem(new ComboListItem("Juli", 7));
        this.selectPeriodMonth.addItem(new ComboListItem("Augustus", 8));
        this.selectPeriodMonth.addItem(new ComboListItem("September", 9));
        this.selectPeriodMonth.addItem(new ComboListItem("Oktober", 10));
        this.selectPeriodMonth.addItem(new ComboListItem("November", 11));
        this.selectPeriodMonth.addItem(new ComboListItem("December", 12));
        
        this.selectPeriodYear.addItem(new ComboListItem("2010", 2010));
        this.selectPeriodYear.addItem(new ComboListItem("2011", 2011));
        this.selectPeriodYear.addItem(new ComboListItem("2012", 2012));
        this.selectPeriodYear.addItem(new ComboListItem("2013", 2013));
        
        this.selectStatus.addItem(new ComboListItem("Alle", 0));
        this.selectStatus.addItem(new ComboListItem("Voldaan", 1));
        this.selectStatus.addItem(new ComboListItem("Deels Voldaan", 2));
        this.selectStatus.addItem(new ComboListItem("Mislukt", 3));
        this.selectStatus.addItem(new ComboListItem("Gestorneerd", 4));
        
        this.selectPaymentUpdateAction.addItem(new ComboListItem("Status voldaan", "Voldaan"));
        this.selectPaymentUpdateAction.addItem(new ComboListItem("Status deels voldaan", "Deels voldaan"));
        this.selectPaymentUpdateAction.addItem(new ComboListItem("Status mislukt", "Mislukt"));
        this.selectPaymentUpdateAction.addItem(new ComboListItem("Status gestorneerd", "Gestorneerd"));
        
        this.selectCollectionUpdateAction.addItem(new ComboListItem("Verwijderen", 0));
        this.selectCollectionUpdateAction.addItem(new ComboListItem("Wijzigen", 1));
    }
    
    private void setupTable(Table table, TableModelListener listener){
        table.setMultiSelect();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addTableModelListener(listener);
        
        int tableIndex = this.tables.indexOf(table);
        String[] tableColumns = this.columns.get(tableIndex);
        
        for(String column : tableColumns){
            model.addColumn(column);
        }
    }
    
    private void updateTable(JTable table, ArrayList data){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        /******** Mock Data. Dit moet nog uit de database komen *********/
        data = new ArrayList<ArrayList>();
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add(1);
        row1.add("Ruben Kruiver");
        row1.add(1);
        row1.add("28 januari 2013");
        row1.add(35.00);
        row1.add(0.00);
        row1.add("Voldaan");
        row1.add("1 februari 2013");
        data.add(row1);
        
        ArrayList<Object> row2 = new ArrayList<>();
        row2.add(2);
        row2.add("Chantal Scharbaai");
        row2.add(1);
        row2.add("28 januari 2013");
        row2.add(35.00);
        row2.add(20.00);
        row2.add("Deels voldaan");
        row2.add("1 februari 2013");
        data.add(row2);
        
        ArrayList<Object> row3 = new ArrayList<>();
        row3.add(3);
        row3.add("Ruben Kruiver");
        row3.add(1);
        row3.add("28 januari 2013");
        row3.add(35.00);
        row3.add(0.00);
        row3.add("Voldaan");
        row3.add("1 februari 2013");
        data.add(row3);
        
        ArrayList<Object> row5 = new ArrayList<>();
        row5.add(4);
        row5.add("Ashley Kruiver");
        row5.add(1);
        row5.add("28 januari 2013");
        row5.add(35.00);
        row5.add(0.00);
        row5.add("Voldaan");
        row5.add("1 februari 2013");
        data.add(row5);
        
        ArrayList<Object> row6 = new ArrayList<>();
        row6.add(5);
        row6.add("Bob de Bouwer");
        row6.add(1);
        row6.add("28 januari 2013");
        row6.add(35.00);
        row6.add(35.00);
        row6.add("Achterstand");
        row6.add("1 februari 2013");
        data.add(row6);
        
        /****************************************************************/
        Object[] rowContent;
        int rowcounter = 0;
        for(Object element : data){
            ArrayList cols = (ArrayList) element;
             rowContent = new Object[cols.size()];
            
            int pointer = 0;
            for(Object col : cols){
                if(rowcounter == 0){
                    System.out.println(col.getClass());
                    if(col instanceof Integer ||
                        col instanceof Double ||
                        col instanceof BigDecimal){
                            table.getColumnModel().getColumn(pointer).setPreferredWidth(50);
                    }  
                }
                rowContent[pointer] = col;
                pointer++;
            }
            model.addRow(rowContent);
            rowcounter++;
        }
    }
    
    private TableModelListener barTableListener = new TableModelListener(){
        @Override
        public void tableChanged(TableModelEvent e){
            
        }
    };
    
    private TableModelListener courseTableListener = new TableModelListener(){
        @Override
        public void tableChanged(TableModelEvent e){
            
        }
    };
    
    private TableModelListener facilityTableListener = new TableModelListener(){
        @Override
        public void tableChanged(TableModelEvent e){
            
        }
    };
    
    private TableModelListener membersTableListener = new TableModelListener(){
        @Override
        public void tableChanged(TableModelEvent e){
            
        }
    };
    
    private TableModelListener members1TableListener = new TableModelListener(){
        @Override
        public void tableChanged(TableModelEvent e){
            
        }
    };
    
    private TableModelListener subscriptionTableListener = new TableModelListener(){
        @Override
        public void tableChanged(TableModelEvent e){
            
        }
    };
    
    private void tableColumns(){
        this.tables.add(tableBar);
        String[] barColumns = {"Product", "Groep", "Vestiging", "Aantal", "Omzet"};
        this.columns.put(0, barColumns);
        
        this.tables.add(tableCollectionMembers);
        String[] collectionColumns = {"Lidnummer", "Naam", "Abonnement", "Bar", "Faciliteiten", "Cursussen", "Totaal", "Datum"};
        this.columns.put(1, collectionColumns);
        
        this.tables.add(tableCourse);
        String[] courseColumns = {"Naam", "Vestiging", "Aantal", "Omzet"};
        this.columns.put(2, courseColumns);
        
        this.tables.add(tablePaymentMembers);
        String[] paymentColumns = {"Lidnummer", "Naam", "Factuurnr", "Factuurdatum", "Totaal", "Resterend", "Status", "Datum"};
        this.columns.put(3, paymentColumns);
        
        this.tables.add(tableFacility);
        String[] facilityColumns = {"Naam", "Vestiging", "Aantal", "Omzet"};
        this.columns.put(4, facilityColumns);
        
        this.tables.add(tableSubscription);
        String[] subscriptionColumns = {"Abonnement", "Vestiging", "Aantal", "Omzet"};
        this.columns.put(5, subscriptionColumns);
    }
    
    private void getSelection(ComboListItem location, ComboListItem month, ComboListItem year, ComboListItem status){
        JOptionPane.showMessageDialog(this, "Selectie: Vestiging "+location.getText()+" in de periode van "+month.getText()+" "+year.getText()+" met status "+status.getText()+" en toepassen in "+this.activePanel);
        // Queries ophalen aan de hand van de active panel
        // Tabellen updaten behorend aan de active panel
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainFrame = new javax.swing.JPanel();
        buttonRevenues = new pas.layout.label.Button();
        buttonCollection = new pas.layout.label.Button();
        labelLocation = new javax.swing.JLabel();
        labelPeriod = new javax.swing.JLabel();
        buttonSelect = new pas.layout.label.Button();
        buttonPaymentStatus = new pas.layout.label.Button();
        viewFrame = new javax.swing.JPanel();
        collectionPanel = new javax.swing.JPanel();
        paneMembersCollection = new javax.swing.JPanel();
        collectionScrollPane = new javax.swing.JScrollPane();
        tableCollectionMembers = new pas.layout.table.Table();
        buttonSellectAllCollection = new pas.layout.label.Button();
        buttonGenerateCollection = new pas.layout.label.Button();
        labelCollectionUpdateAction = new javax.swing.JLabel();
        buttonUpdateCollection = new pas.layout.label.Button();
        selectCollectionUpdateAction = new pas.layout.form.ComboList();
        revenuesPanel = new javax.swing.JPanel();
        paneBar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBar = new pas.layout.table.Table();
        paneSubscription = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSubscription = new pas.layout.table.Table();
        paneCourse1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCourse = new pas.layout.table.Table();
        paneBar4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableFacility = new pas.layout.table.Table();
        paymentStatusPanel = new javax.swing.JPanel();
        paneMembersPayment = new javax.swing.JPanel();
        paymentScrollPane = new javax.swing.JScrollPane();
        tablePaymentMembers = new pas.layout.table.Table();
        buttonSelectAllPayment = new pas.layout.label.Button();
        labelPaymentUpdateAction = new javax.swing.JLabel();
        buttonUpdatePayment = new pas.layout.label.Button();
        selectPaymentUpdateAction = new pas.layout.form.ComboList();
        settingsPanel = new javax.swing.JPanel();
        paneMembersCollection1 = new javax.swing.JPanel();
        buttonSaveSettings = new pas.layout.label.Button();
        labelStatus = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        selectLocation = new pas.layout.form.ComboList();
        selectPeriodMonth = new pas.layout.form.ComboList();
        selectPeriodYear = new pas.layout.form.ComboList();
        selectStatus = new pas.layout.form.ComboList();
        buttonSettings = new pas.layout.label.Button();

        setOpaque(false);

        mainFrame.setOpaque(false);
        mainFrame.setPreferredSize(new java.awt.Dimension(915, 617));

        buttonRevenues.setText("Omzetten");
        buttonRevenues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRevenuesMouseClicked(evt);
            }
        });

        buttonCollection.setText("Incasso");
        buttonCollection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCollectionMouseClicked(evt);
            }
        });

        labelLocation.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelLocation.setForeground(new java.awt.Color(98, 98, 152));
        labelLocation.setText("Vestiging");

        labelPeriod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPeriod.setForeground(new java.awt.Color(98, 98, 152));
        labelPeriod.setText("Periode");

        buttonSelect.setText("Selecteren");
        buttonSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSelectMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonSelectMouseReleased(evt);
            }
        });
        buttonSelect.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                buttonSelectPropertyChange(evt);
            }
        });

        buttonPaymentStatus.setText("Betalingsstatus");
        buttonPaymentStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPaymentStatusMouseClicked(evt);
            }
        });

        viewFrame.setOpaque(false);
        viewFrame.setLayout(new java.awt.CardLayout());

        collectionPanel.setOpaque(false);

        paneMembersCollection.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leden", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneMembersCollection.setOpaque(false);

        tableCollectionMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        collectionScrollPane.setViewportView(tableCollectionMembers);

        buttonSellectAllCollection.setText("Selecteer/Deselecteer alles");
        buttonSellectAllCollection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSellectAllCollectionMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonSellectAllCollectionMouseReleased(evt);
            }
        });
        buttonSellectAllCollection.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                buttonSellectAllCollectionPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout paneMembersCollectionLayout = new javax.swing.GroupLayout(paneMembersCollection);
        paneMembersCollection.setLayout(paneMembersCollectionLayout);
        paneMembersCollectionLayout.setHorizontalGroup(
            paneMembersCollectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMembersCollectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMembersCollectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(collectionScrollPane)
                    .addGroup(paneMembersCollectionLayout.createSequentialGroup()
                        .addComponent(buttonSellectAllCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneMembersCollectionLayout.setVerticalGroup(
            paneMembersCollectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMembersCollectionLayout.createSequentialGroup()
                .addComponent(collectionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSellectAllCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonGenerateCollection.setText("Genereer Incassobestand");
        buttonGenerateCollection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonGenerateCollectionMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonGenerateCollectionMouseReleased(evt);
            }
        });

        labelCollectionUpdateAction.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCollectionUpdateAction.setForeground(new java.awt.Color(98, 98, 152));
        labelCollectionUpdateAction.setText("Met geselecteerd");

        buttonUpdateCollection.setText("Uitvoeren");
        buttonUpdateCollection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateCollectionMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonUpdateCollectionMouseReleased(evt);
            }
        });
        buttonUpdateCollection.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                buttonUpdateCollectionPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout collectionPanelLayout = new javax.swing.GroupLayout(collectionPanel);
        collectionPanel.setLayout(collectionPanelLayout);
        collectionPanelLayout.setHorizontalGroup(
            collectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(collectionPanelLayout.createSequentialGroup()
                .addGroup(collectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(collectionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneMembersCollection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(collectionPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(buttonGenerateCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                        .addComponent(labelCollectionUpdateAction)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectCollectionUpdateAction, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdateCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        collectionPanelLayout.setVerticalGroup(
            collectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(collectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneMembersCollection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(collectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGenerateCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCollectionUpdateAction)
                    .addComponent(buttonUpdateCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectCollectionUpdateAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        viewFrame.add(collectionPanel, "collectionCard");

        revenuesPanel.setOpaque(false);

        paneBar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneBar.setOpaque(false);

        tableBar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableBar);

        javax.swing.GroupLayout paneBarLayout = new javax.swing.GroupLayout(paneBar);
        paneBar.setLayout(paneBarLayout);
        paneBarLayout.setHorizontalGroup(
            paneBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneBarLayout.setVerticalGroup(
            paneBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        paneSubscription.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Abonnementen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneSubscription.setOpaque(false);

        tableSubscription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableSubscription);

        javax.swing.GroupLayout paneSubscriptionLayout = new javax.swing.GroupLayout(paneSubscription);
        paneSubscription.setLayout(paneSubscriptionLayout);
        paneSubscriptionLayout.setHorizontalGroup(
            paneSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSubscriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        paneSubscriptionLayout.setVerticalGroup(
            paneSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
        );

        paneCourse1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursussen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneCourse1.setOpaque(false);

        tableCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tableCourse);

        javax.swing.GroupLayout paneCourse1Layout = new javax.swing.GroupLayout(paneCourse1);
        paneCourse1.setLayout(paneCourse1Layout);
        paneCourse1Layout.setHorizontalGroup(
            paneCourse1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCourse1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        paneCourse1Layout.setVerticalGroup(
            paneCourse1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        paneBar4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Faciliteiten", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneBar4.setOpaque(false);

        tableFacility.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tableFacility);

        javax.swing.GroupLayout paneBar4Layout = new javax.swing.GroupLayout(paneBar4);
        paneBar4.setLayout(paneBar4Layout);
        paneBar4Layout.setHorizontalGroup(
            paneBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBar4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        paneBar4Layout.setVerticalGroup(
            paneBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout revenuesPanelLayout = new javax.swing.GroupLayout(revenuesPanel);
        revenuesPanel.setLayout(revenuesPanelLayout);
        revenuesPanelLayout.setHorizontalGroup(
            revenuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(revenuesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(revenuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneSubscription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneCourse1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        revenuesPanelLayout.setVerticalGroup(
            revenuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(revenuesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneSubscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneCourse1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        viewFrame.add(revenuesPanel, "revenuesCard");

        paymentStatusPanel.setOpaque(false);

        paneMembersPayment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leden", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneMembersPayment.setOpaque(false);

        tablePaymentMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        paymentScrollPane.setViewportView(tablePaymentMembers);

        buttonSelectAllPayment.setText("Selecteer/Deselecteer alles");
        buttonSelectAllPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSelectAllPaymentMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonSelectAllPaymentMouseReleased(evt);
            }
        });
        buttonSelectAllPayment.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                buttonSelectAllPaymentPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout paneMembersPaymentLayout = new javax.swing.GroupLayout(paneMembersPayment);
        paneMembersPayment.setLayout(paneMembersPaymentLayout);
        paneMembersPaymentLayout.setHorizontalGroup(
            paneMembersPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMembersPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneMembersPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paymentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addGroup(paneMembersPaymentLayout.createSequentialGroup()
                        .addComponent(buttonSelectAllPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneMembersPaymentLayout.setVerticalGroup(
            paneMembersPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneMembersPaymentLayout.createSequentialGroup()
                .addComponent(paymentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSelectAllPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelPaymentUpdateAction.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPaymentUpdateAction.setForeground(new java.awt.Color(98, 98, 152));
        labelPaymentUpdateAction.setText("Met geselecteerd");

        buttonUpdatePayment.setText("Uitvoeren");
        buttonUpdatePayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdatePaymentMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonUpdatePaymentMouseReleased(evt);
            }
        });
        buttonUpdatePayment.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                buttonUpdatePaymentPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout paymentStatusPanelLayout = new javax.swing.GroupLayout(paymentStatusPanel);
        paymentStatusPanel.setLayout(paymentStatusPanelLayout);
        paymentStatusPanelLayout.setHorizontalGroup(
            paymentStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentStatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneMembersPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paymentStatusPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelPaymentUpdateAction, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectPaymentUpdateAction, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdatePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paymentStatusPanelLayout.setVerticalGroup(
            paymentStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentStatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneMembersPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paymentStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpdatePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPaymentUpdateAction)
                    .addComponent(selectPaymentUpdateAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        viewFrame.add(paymentStatusPanel, "statusCard");

        settingsPanel.setOpaque(false);

        paneMembersCollection1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instellingen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneMembersCollection1.setOpaque(false);

        javax.swing.GroupLayout paneMembersCollection1Layout = new javax.swing.GroupLayout(paneMembersCollection1);
        paneMembersCollection1.setLayout(paneMembersCollection1Layout);
        paneMembersCollection1Layout.setHorizontalGroup(
            paneMembersCollection1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
        );
        paneMembersCollection1Layout.setVerticalGroup(
            paneMembersCollection1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        buttonSaveSettings.setText("Opslaan");
        buttonSaveSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSaveSettingsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonSaveSettingsMouseReleased(evt);
            }
        });
        buttonSaveSettings.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                buttonSaveSettingsPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneMembersCollection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSaveSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneMembersCollection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSaveSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        viewFrame.add(settingsPanel, "settingsCard");

        labelStatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(98, 98, 152));
        labelStatus.setText("Status");

        labelTitle.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(98, 98, 152));
        labelTitle.setText("Financieel");

        buttonSettings.setText("Instellingen");
        buttonSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSettingsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainFrameLayout = new javax.swing.GroupLayout(mainFrame);
        mainFrame.setLayout(mainFrameLayout);
        mainFrameLayout.setHorizontalGroup(
            mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainFrameLayout.createSequentialGroup()
                        .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonPaymentStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(buttonRevenues, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonCollection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(viewFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(mainFrameLayout.createSequentialGroup()
                        .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectPeriodMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectPeriodYear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        mainFrameLayout.setVerticalGroup(
            mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFrameLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStatus)
                    .addComponent(labelPeriod)
                    .addComponent(labelLocation)
                    .addComponent(labelTitle)
                    .addComponent(selectLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectPeriodMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectPeriodYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainFrameLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(buttonRevenues, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainFrameLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(viewFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRevenuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRevenuesMouseClicked
        try {
            this.controller.requestCardSwitch();
            this.changeCard("revenuesCard");
            this.activateButton((Button) evt.getComponent());
        } catch(Exception e){
            // Switch not allowed
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonRevenuesMouseClicked

    private void buttonCollectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCollectionMouseClicked
        try {
            this.controller.requestCardSwitch();
            this.changeCard("collectionCard");
            this.activateButton((Button) evt.getComponent());
        } catch(Exception e){
            // Switch not allowed
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonCollectionMouseClicked

    private void buttonSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSelectMouseClicked
        ComboListItem location = (ComboListItem) selectLocation.getSelectedItem();
        ComboListItem month = (ComboListItem) selectPeriodMonth.getSelectedItem();
        ComboListItem year = (ComboListItem) selectPeriodYear.getSelectedItem();
        ComboListItem status = (ComboListItem) selectStatus.getSelectedItem();
        this.getSelection(location, month, year, status);
    }//GEN-LAST:event_buttonSelectMouseClicked

    private void buttonSelectPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_buttonSelectPropertyChange

    }//GEN-LAST:event_buttonSelectPropertyChange

    private void buttonPaymentStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPaymentStatusMouseClicked
        try {
            this.controller.requestCardSwitch();
            this.changeCard("statusCard");
            this.activateButton((Button) evt.getComponent());
        } catch(Exception e){
            // Switch not allowed
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonPaymentStatusMouseClicked

    private void buttonGenerateCollectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGenerateCollectionMouseClicked
        JOptionPane.showMessageDialog(this, "Genereren van Clieop03 bestand op basis van huidige selectie");
    }//GEN-LAST:event_buttonGenerateCollectionMouseClicked

    private void buttonUpdatePaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdatePaymentMouseClicked
        // ophalen huidige selectie
        
        ComboListItem updateAction = (ComboListItem) this.selectPaymentUpdateAction.getSelectedItem();
        int dialogButton = JOptionPane.OK_CANCEL_OPTION;
        int response = JOptionPane.showConfirmDialog(this, "Weet u zeker dat u betalingsstatus van de huidige selectie wilt wijzigen in "+updateAction.getText(), "Bevestigen", dialogButton);
        
        // Controleren op aantal geselecteerde rijen en bij 1 of meer
        if(response == JOptionPane.OK_OPTION){
            int[] rows = tablePaymentMembers.getSelectedRows();
            
            for(int row : rows){
                DefaultTableModel model = (DefaultTableModel) tablePaymentMembers.getModel();
                
                model.setValueAt(updateAction.getStringValue(), row, 6);
                
                Integer lidnummer = (Integer) tablePaymentMembers.getModel().getValueAt(row, 0);
                
                // Wijziging toepassen op database en bij selectie van aanmaning versturen een email zenden
            }
        }
        else {
            
        }
    }//GEN-LAST:event_buttonUpdatePaymentMouseClicked

    private void buttonUpdatePaymentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_buttonUpdatePaymentPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdatePaymentPropertyChange

    private void buttonSelectAllPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSelectAllPaymentMouseClicked
        this.tablePaymentMembers.toggleRowSelect();
    }//GEN-LAST:event_buttonSelectAllPaymentMouseClicked

    private void buttonSelectAllPaymentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_buttonSelectAllPaymentPropertyChange
       
    }//GEN-LAST:event_buttonSelectAllPaymentPropertyChange

    private void buttonUpdateCollectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCollectionMouseClicked
        // ophalen huidige selectie
        
        ComboListItem updateAction = (ComboListItem) this.selectCollectionUpdateAction.getSelectedItem();
        int dialogButton = JOptionPane.OK_CANCEL_OPTION;
        int response = JOptionPane.showConfirmDialog(this, "Weet u zeker dat u deze rij(en) wilt "+updateAction.getText(), "Bevestigen", dialogButton);
        
        // Controleren op aantal geselecteerde rijen en bij 1 of meer
        if(response == JOptionPane.OK_OPTION){
            int[] rows = tableCollectionMembers.getSelectedRows();
            
            int action = updateAction.getIntegerValue();
            
            for(int row : rows){
                DefaultTableModel model = (DefaultTableModel) tableCollectionMembers.getModel();
                Integer lidnummer = (Integer) tableCollectionMembers.getModel().getValueAt(row, 0);
                
                if(action == 0){
                    // status verwijderd in database en niet tonen in lijst
                    tableCollectionMembers.removeRowSelectionInterval(row, row);
                }
                else {
                    // wijzigen in database
                    // model.setValueAt(updateAction.getStringValue(), row, 6);
                }
            }
        }
        else {
            
        }
    }//GEN-LAST:event_buttonUpdateCollectionMouseClicked

    private void buttonUpdateCollectionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_buttonUpdateCollectionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateCollectionPropertyChange

    private void buttonSellectAllCollectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSellectAllCollectionMouseClicked
        this.tableCollectionMembers.toggleRowSelect();
        
        Button button = (Button) evt.getComponent();
        button.setStatus(Button.INACTIVE);
    }//GEN-LAST:event_buttonSellectAllCollectionMouseClicked

    private void buttonSellectAllCollectionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_buttonSellectAllCollectionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSellectAllCollectionPropertyChange

    private void buttonSelectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSelectMouseReleased
        Button button = (Button) evt.getComponent();
        button.setStatus(Button.INACTIVE);
    }//GEN-LAST:event_buttonSelectMouseReleased

    private void buttonSellectAllCollectionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSellectAllCollectionMouseReleased
        Button button = (Button) evt.getComponent();
        button.setStatus(Button.INACTIVE);
    }//GEN-LAST:event_buttonSellectAllCollectionMouseReleased

    private void buttonGenerateCollectionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGenerateCollectionMouseReleased
        Button button = (Button) evt.getComponent();
        button.setStatus(Button.INACTIVE);
    }//GEN-LAST:event_buttonGenerateCollectionMouseReleased

    private void buttonUpdateCollectionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCollectionMouseReleased
       Button button = (Button) evt.getComponent();
        button.setStatus(Button.INACTIVE);
    }//GEN-LAST:event_buttonUpdateCollectionMouseReleased

    private void buttonSelectAllPaymentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSelectAllPaymentMouseReleased
        Button button = (Button) evt.getComponent();
        button.setStatus(Button.INACTIVE);
    }//GEN-LAST:event_buttonSelectAllPaymentMouseReleased

    private void buttonUpdatePaymentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdatePaymentMouseReleased
       Button button = (Button) evt.getComponent();
        button.setStatus(Button.INACTIVE);
    }//GEN-LAST:event_buttonUpdatePaymentMouseReleased

    private void buttonSaveSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSaveSettingsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSaveSettingsMouseClicked

    private void buttonSaveSettingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSaveSettingsMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSaveSettingsMouseReleased

    private void buttonSaveSettingsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_buttonSaveSettingsPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSaveSettingsPropertyChange

    private void buttonSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSettingsMouseClicked
        try {
            this.controller.requestCardSwitch();
            this.changeCard("settingsCard");
            this.activateButton((Button) evt.getComponent());
        } catch(Exception e){
            // Switch not allowed
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonSettingsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pas.layout.label.Button buttonCollection;
    private pas.layout.label.Button buttonGenerateCollection;
    private pas.layout.label.Button buttonPaymentStatus;
    private pas.layout.label.Button buttonRevenues;
    private pas.layout.label.Button buttonSaveSettings;
    private pas.layout.label.Button buttonSelect;
    private pas.layout.label.Button buttonSelectAllPayment;
    private pas.layout.label.Button buttonSellectAllCollection;
    private pas.layout.label.Button buttonSettings;
    private pas.layout.label.Button buttonUpdateCollection;
    private pas.layout.label.Button buttonUpdatePayment;
    private javax.swing.JPanel collectionPanel;
    private javax.swing.JScrollPane collectionScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelCollectionUpdateAction;
    private javax.swing.JLabel labelLocation;
    private javax.swing.JLabel labelPaymentUpdateAction;
    private javax.swing.JLabel labelPeriod;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel mainFrame;
    private javax.swing.JPanel paneBar;
    private javax.swing.JPanel paneBar4;
    private javax.swing.JPanel paneCourse1;
    private javax.swing.JPanel paneMembersCollection;
    private javax.swing.JPanel paneMembersCollection1;
    private javax.swing.JPanel paneMembersPayment;
    private javax.swing.JPanel paneSubscription;
    private javax.swing.JScrollPane paymentScrollPane;
    private javax.swing.JPanel paymentStatusPanel;
    private javax.swing.JPanel revenuesPanel;
    private pas.layout.form.ComboList selectCollectionUpdateAction;
    private pas.layout.form.ComboList selectLocation;
    private pas.layout.form.ComboList selectPaymentUpdateAction;
    private pas.layout.form.ComboList selectPeriodMonth;
    private pas.layout.form.ComboList selectPeriodYear;
    private pas.layout.form.ComboList selectStatus;
    private javax.swing.JPanel settingsPanel;
    private pas.layout.table.Table tableBar;
    private pas.layout.table.Table tableCollectionMembers;
    private pas.layout.table.Table tableCourse;
    private pas.layout.table.Table tableFacility;
    private pas.layout.table.Table tablePaymentMembers;
    private pas.layout.table.Table tableSubscription;
    private javax.swing.JPanel viewFrame;
    // End of variables declaration//GEN-END:variables
}