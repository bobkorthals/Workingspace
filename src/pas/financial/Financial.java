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
        
        /** Table Bar Setup **/
        this.setupTable((Table) this.tableBar, barTableListener);
        this.setupTable((Table) this.tableCourse, courseTableListener);
        this.setupTable((Table) this.tableFacility, facilityTableListener);
        this.setupTable((Table) this.tablePaymentMembers, membersTableListener);
        this.setupTable((Table) this.tableCollectionMembers, members1TableListener);
        this.setupTable((Table) this.tableSubscription, subscriptionTableListener);
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
        selectPeriodMonth = new javax.swing.JComboBox();
        labelPeriod = new javax.swing.JLabel();
        selectLocation = new javax.swing.JComboBox();
        selectPeriodYear = new javax.swing.JComboBox();
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
        selectCollectionUpdateAction = new javax.swing.JComboBox();
        buttonUpdateCollection = new pas.layout.label.Button();
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
        selectPaymentUpdateAction = new javax.swing.JComboBox();
        buttonUpdatePayment = new pas.layout.label.Button();
        selectStatus = new javax.swing.JComboBox();
        labelStatus = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();

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

        selectPeriodMonth.setBackground(new java.awt.Color(242, 109, 142));
        selectPeriodMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geheel", "Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December" }));
        selectPeriodMonth.setToolTipText("");
        selectPeriodMonth.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(154, 13, 48), null));
        selectPeriodMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPeriodMonthActionPerformed(evt);
            }
        });

        labelPeriod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPeriod.setForeground(new java.awt.Color(98, 98, 152));
        labelPeriod.setText("Periode");

        selectLocation.setBackground(new java.awt.Color(242, 109, 142));
        selectLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alle", "Haarlem", "Amsterdam", "Purmerend" }));
        selectLocation.setToolTipText("");
        selectLocation.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(154, 13, 48), null));
        selectLocation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        selectLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLocationActionPerformed(evt);
            }
        });

        selectPeriodYear.setBackground(new java.awt.Color(242, 109, 142));
        selectPeriodYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013" }));
        selectPeriodYear.setSelectedIndex(3);
        selectPeriodYear.setToolTipText("");
        selectPeriodYear.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(154, 13, 48), null));
        selectPeriodYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPeriodYearActionPerformed(evt);
            }
        });

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

        selectCollectionUpdateAction.setBackground(new java.awt.Color(242, 109, 142));
        selectCollectionUpdateAction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Verwijderen", "Wijzigen" }));
        selectCollectionUpdateAction.setToolTipText("");
        selectCollectionUpdateAction.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(154, 13, 48), null));
        selectCollectionUpdateAction.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        selectCollectionUpdateAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCollectionUpdateActionActionPerformed(evt);
            }
        });

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
                    .addComponent(selectCollectionUpdateAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        selectPaymentUpdateAction.setBackground(new java.awt.Color(242, 109, 142));
        selectPaymentUpdateAction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Status betaald", "Status stornering", "Status mislukt", "Verstuur aanmaning" }));
        selectPaymentUpdateAction.setToolTipText("");
        selectPaymentUpdateAction.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(154, 13, 48), null));
        selectPaymentUpdateAction.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        selectPaymentUpdateAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPaymentUpdateActionActionPerformed(evt);
            }
        });

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
                    .addComponent(selectPaymentUpdateAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPaymentUpdateAction))
                .addContainerGap())
        );

        viewFrame.add(paymentStatusPanel, "statusCard");

        selectStatus.setBackground(new java.awt.Color(242, 109, 142));
        selectStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alle", "Achterstand", "Betaald", "Geweigerd", "Gestorneerd" }));
        selectStatus.setToolTipText("");
        selectStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(154, 13, 48), null));
        selectStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectStatusActionPerformed(evt);
            }
        });

        labelStatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(98, 98, 152));
        labelStatus.setText("Status");

        labelTitle.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(98, 98, 152));
        labelTitle.setText("Financieel");

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
                            .addComponent(buttonCollection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(viewFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(mainFrameLayout.createSequentialGroup()
                        .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(labelPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectPeriodMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectPeriodYear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(57, Short.MAX_VALUE))))
        );
        mainFrameLayout.setVerticalGroup(
            mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFrameLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStatus)
                    .addComponent(selectPeriodYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectPeriodMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPeriod)
                    .addComponent(selectLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLocation)
                    .addComponent(labelTitle))
                .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainFrameLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(buttonRevenues, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void selectPeriodMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPeriodMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPeriodMonthActionPerformed

    private void selectLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectLocationActionPerformed

    private void selectPeriodYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPeriodYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPeriodYearActionPerformed

    private void buttonSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSelectMouseClicked
        String location = (String) selectLocation.getSelectedItem();
        String month = (String) selectPeriodMonth.getSelectedItem();
        String year = (String) selectPeriodYear.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Selectie: Vestiging "+location+" in de periode van "+month+" "+year);
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

    private void selectStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectStatusActionPerformed

    private void selectPaymentUpdateActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPaymentUpdateActionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPaymentUpdateActionActionPerformed

    private void buttonUpdatePaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdatePaymentMouseClicked

    }//GEN-LAST:event_buttonUpdatePaymentMouseClicked

    private void buttonUpdatePaymentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_buttonUpdatePaymentPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdatePaymentPropertyChange

    private void buttonSelectAllPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSelectAllPaymentMouseClicked

        this.tablePaymentMembers.toggleRowSelect();
    }//GEN-LAST:event_buttonSelectAllPaymentMouseClicked

    private void buttonSelectAllPaymentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_buttonSelectAllPaymentPropertyChange
       
    }//GEN-LAST:event_buttonSelectAllPaymentPropertyChange

    private void selectCollectionUpdateActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCollectionUpdateActionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectCollectionUpdateActionActionPerformed

    private void buttonUpdateCollectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCollectionMouseClicked

    }//GEN-LAST:event_buttonUpdateCollectionMouseClicked

    private void buttonUpdateCollectionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_buttonUpdateCollectionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateCollectionPropertyChange

    private void buttonSellectAllCollectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSellectAllCollectionMouseClicked
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pas.layout.label.Button buttonCollection;
    private pas.layout.label.Button buttonGenerateCollection;
    private pas.layout.label.Button buttonPaymentStatus;
    private pas.layout.label.Button buttonRevenues;
    private pas.layout.label.Button buttonSelect;
    private pas.layout.label.Button buttonSelectAllPayment;
    private pas.layout.label.Button buttonSellectAllCollection;
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
    private javax.swing.JPanel paneMembersPayment;
    private javax.swing.JPanel paneSubscription;
    private javax.swing.JScrollPane paymentScrollPane;
    private javax.swing.JPanel paymentStatusPanel;
    private javax.swing.JPanel revenuesPanel;
    private javax.swing.JComboBox selectCollectionUpdateAction;
    private javax.swing.JComboBox selectLocation;
    private javax.swing.JComboBox selectPaymentUpdateAction;
    private javax.swing.JComboBox selectPeriodMonth;
    private javax.swing.JComboBox selectPeriodYear;
    private javax.swing.JComboBox selectStatus;
    private pas.layout.table.Table tableBar;
    private pas.layout.table.Table tableCollectionMembers;
    private pas.layout.table.Table tableCourse;
    private pas.layout.table.Table tableFacility;
    private pas.layout.table.Table tablePaymentMembers;
    private pas.layout.table.Table tableSubscription;
    private javax.swing.JPanel viewFrame;
    // End of variables declaration//GEN-END:variables
}