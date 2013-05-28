/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.financial;

/**
 *
 * @author Ruben
 */
public class Payment extends javax.swing.JPanel {

    /**
     * Creates new form Revenue
     */
    public Payment() {
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

        title = new pas.layout.label.Title();
        buttonRevenues = new pas.layout.label.Button();
        buttonPayments = new pas.layout.label.Button();
        buttonCosts = new pas.layout.label.Button();
        buttonCollection = new pas.layout.label.Button();
        paneBar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBar = new javax.swing.JTable();
        paneSubscription = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSubscription = new javax.swing.JTable();
        paneCourse = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCourse = new javax.swing.JTable();
        paneBar3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableFacility = new javax.swing.JTable();
        labelLocation = new javax.swing.JLabel();
        selectPeriodMonth = new javax.swing.JComboBox();
        labelPeriod = new javax.swing.JLabel();
        selectLocation1 = new javax.swing.JComboBox();
        selectPeriodYear = new javax.swing.JComboBox();
        button1 = new pas.layout.label.Button();

        setName("Form"); // NOI18N

        title.setForeground(new java.awt.Color(98, 98, 152));
        title.setText("Financieel - Betalingen");
        title.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        title.setName("title"); // NOI18N

        buttonRevenues.setText("Omzetten");
        buttonRevenues.setName("buttonRevenues"); // NOI18N

        buttonPayments.setText("Betalingen");
        buttonPayments.setName("buttonPayments"); // NOI18N

        buttonCosts.setText("Kosten");
        buttonCosts.setName("buttonCosts"); // NOI18N

        buttonCollection.setText("Incasso");
        buttonCollection.setName("buttonCollection"); // NOI18N

        paneBar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneBar.setName("paneBar"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tableBar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Sandwiches",  new Float(3487.5)},
                {"Dranken",  new Float(6214.0)},
                {null, null},
                {null, null}
            },
            new String [] {
                "Groep", "Omzet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableBar.setName("tableBar"); // NOI18N
        jScrollPane1.setViewportView(tableBar);

        javax.swing.GroupLayout paneBarLayout = new javax.swing.GroupLayout(paneBar);
        paneBar.setLayout(paneBarLayout);
        paneBarLayout.setHorizontalGroup(
            paneBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        paneBarLayout.setVerticalGroup(
            paneBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBarLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        paneSubscription.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Abonnementen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneSubscription.setName("paneSubscription"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tableSubscription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Regulier",  new Float(12185.0)},
                {"Junior",  new Float(2300.0)},
                {"Senior",  new Float(3780.0)}
            },
            new String [] {
                "Soort", "Omzet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSubscription.setName("tableSubscription"); // NOI18N
        jScrollPane2.setViewportView(tableSubscription);

        javax.swing.GroupLayout paneSubscriptionLayout = new javax.swing.GroupLayout(paneSubscription);
        paneSubscription.setLayout(paneSubscriptionLayout);
        paneSubscriptionLayout.setHorizontalGroup(
            paneSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSubscriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        paneSubscriptionLayout.setVerticalGroup(
            paneSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSubscriptionLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        paneCourse.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursussen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneCourse.setName("paneCourse"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        tableCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tai-boxing",  new Integer(150),  new Float(4500.0)},
                {"Joga",  new Integer(75),  new Float(1500.0)},
                {"Karate",  new Integer(113),  new Float(2260.0)}
            },
            new String [] {
                "Naam", "Deelnames", "Omzet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableCourse.setName("tableCourse"); // NOI18N
        jScrollPane3.setViewportView(tableCourse);

        javax.swing.GroupLayout paneCourseLayout = new javax.swing.GroupLayout(paneCourse);
        paneCourse.setLayout(paneCourseLayout);
        paneCourseLayout.setHorizontalGroup(
            paneCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        paneCourseLayout.setVerticalGroup(
            paneCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCourseLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        paneBar3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Faciliteiten", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(102, 0, 255))); // NOI18N
        paneBar3.setName("paneBar3"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        tableFacility.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Sauna",  new Integer(833),  new Float(4165.0)},
                {"Squash",  new Integer(186),  new Float(930.0)},
                {"Zonnebank",  new Integer(368), null}
            },
            new String [] {
                "Naam", "Deelnames", "Omzet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableFacility.setName("tableFacility"); // NOI18N
        jScrollPane4.setViewportView(tableFacility);

        javax.swing.GroupLayout paneBar3Layout = new javax.swing.GroupLayout(paneBar3);
        paneBar3.setLayout(paneBar3Layout);
        paneBar3Layout.setHorizontalGroup(
            paneBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBar3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        paneBar3Layout.setVerticalGroup(
            paneBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneBar3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        labelLocation.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelLocation.setForeground(new java.awt.Color(98, 98, 152));
        labelLocation.setText("Vestiging");
        labelLocation.setName("labelLocation"); // NOI18N

        selectPeriodMonth.setBackground(new java.awt.Color(242, 109, 142));
        selectPeriodMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December" }));
        selectPeriodMonth.setToolTipText("");
        selectPeriodMonth.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(154, 13, 48), null));
        selectPeriodMonth.setName("selectPeriodMonth"); // NOI18N
        selectPeriodMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPeriodMonthActionPerformed(evt);
            }
        });

        labelPeriod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPeriod.setForeground(new java.awt.Color(98, 98, 152));
        labelPeriod.setText("Periode");
        labelPeriod.setName("labelPeriod"); // NOI18N

        selectLocation1.setBackground(new java.awt.Color(242, 109, 142));
        selectLocation1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Haarlem", "Amsterdam", "Purmerend" }));
        selectLocation1.setToolTipText("");
        selectLocation1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(154, 13, 48), null));
        selectLocation1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        selectLocation1.setName("selectLocation1"); // NOI18N
        selectLocation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLocation1ActionPerformed(evt);
            }
        });

        selectPeriodYear.setBackground(new java.awt.Color(242, 109, 142));
        selectPeriodYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013" }));
        selectPeriodYear.setSelectedIndex(3);
        selectPeriodYear.setToolTipText("");
        selectPeriodYear.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(154, 13, 48), null));
        selectPeriodYear.setName("selectPeriodYear"); // NOI18N
        selectPeriodYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPeriodYearActionPerformed(evt);
            }
        });

        button1.setText("Selecteren");
        button1.setName("button1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonCosts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonPayments, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonRevenues, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonCollection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectLocation1, 0, 142, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectPeriodMonth, 0, 104, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectPeriodYear, 0, 61, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(paneBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paneSubscription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paneCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paneBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLocation)
                    .addComponent(selectLocation1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPeriod)
                    .addComponent(selectPeriodMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectPeriodYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRevenues, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCosts, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCollection, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneSubscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectPeriodMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPeriodMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPeriodMonthActionPerformed

    private void selectLocation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLocation1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectLocation1ActionPerformed

    private void selectPeriodYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPeriodYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPeriodYearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pas.layout.label.Button button1;
    private pas.layout.label.Button buttonCollection;
    private pas.layout.label.Button buttonCosts;
    private pas.layout.label.Button buttonPayments;
    private pas.layout.label.Button buttonRevenues;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelLocation;
    private javax.swing.JLabel labelPeriod;
    private javax.swing.JPanel paneBar;
    private javax.swing.JPanel paneBar3;
    private javax.swing.JPanel paneCourse;
    private javax.swing.JPanel paneSubscription;
    private javax.swing.JComboBox selectLocation1;
    private javax.swing.JComboBox selectPeriodMonth;
    private javax.swing.JComboBox selectPeriodYear;
    private javax.swing.JTable tableBar;
    private javax.swing.JTable tableCourse;
    private javax.swing.JTable tableFacility;
    private javax.swing.JTable tableSubscription;
    private pas.layout.label.Title title;
    // End of variables declaration//GEN-END:variables
}
