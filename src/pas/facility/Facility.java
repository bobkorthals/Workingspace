/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.facility;

import java.beans.PropertyChangeEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import mvc.Application;
import pas.exception.NoEntityManagerException;
import pas.layout.MainFrame;
import pas.layout.form.ComboListItem;
import pas.main.MainController;
import pas.models.SessionManager;
import pas.models.db.Faciliteit;
import pas.models.db.Vestiging;
import session.NoSessionManagerException;

/**
 *
 * @author Bob
 */
public class Facility extends mvc.view.AbstractView {

    private FacilityController facilitycontroller;
    private List<Faciliteit> facilities = new ArrayList();
    private List<Vestiging> vestigingen;
    private boolean wijzigen = false;

    /**
     * Creates new form Facility
     */
    public Facility(FacilityController facilitycontroller, List<Vestiging> vestigingen) {
        this.facilitycontroller = facilitycontroller;
        initComponents();

        this.vestigingen = vestigingen;

        this.Wijzigen(wijzigen);
        this.setVestigingen();
        ddlFacilities.setEditable(false);

//        refreshTable();

    }

    @Override
    public FacilityController getController() {
        return this.facilitycontroller;
    }

    private SessionManager getSessionManager() {
        try {
            return (SessionManager) Application.getInstance().getSessionManager();
        } catch (NoSessionManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
     * Returns the database entity manager
     * 
     * @return EntityManager
     */
    private EntityManager getEntityManager() {
        try {
            return this.getSessionManager().getEntityManager();
        } catch (NoEntityManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    /*
     * Fill the facilitie table and dropdown
     * 
     * @return void
     */
    private void setFacilities() {
        ddlFacilities.removeAllItems();
        ddlFacilities.addItem(new ComboListItem("Selecteer faciliteit"));

        if (!this.facilities.isEmpty()) {
            for (Faciliteit facility : facilities) {
                ddlFacilities.addItem(
                        new ComboListItem(
                        facility.getOmschrijving(),
                        facility));
            }

            ddlFacilities.setEnabled(true);
        } else {
            ddlFacilities.setEnabled(false);
        }

        ddlFacilities.repaint();
    }

    private void Wijzigen(Boolean wijzigen) {
        txtFaciliteitNaam.setEditable(wijzigen);
        txtFaciliteitSoort.setEditable(wijzigen);
        txtFaciliteitKosten.setEditable(wijzigen);
        txtFaciliteitTijd.setEditable(wijzigen);
        txtFaciliteitLocatie.setEditable(wijzigen);
        txtFaciliteitCapaciteit.setEditable(wijzigen);
        txtBeschrijving.setEditable(wijzigen);

    }

    /*
     * Fill the location table and dropdown
     * 
     * @return void
     */
    private void setVestigingen() {
        ddlLocatie.addItem(new ComboListItem("Selecteer vestiging"));
        for (Vestiging vestinging : this.vestigingen) {
            ddlLocatie.addItem(
                    new ComboListItem(
                    vestinging.getNaam(),
                    vestinging));
        }
    }

    
    private void clearFacilityForm() {
        txtFaciliteitCapaciteit.setText("");
        txtFaciliteitNaam.setText("");
        txtFaciliteitKosten.setText("");
        txtFaciliteitLocatie.setText("");
        txtFaciliteitSoort.setText("");
    }

//    public void setFacilityList(List<Faciliteit> facilityList) {
//        System.out.println("TEST");
//        pnlFacilitySearchResults.removeAll();
//        FacilityListSearchResults.resetCounter();
//        if (facilityList.size() > 0) {
//            pnlFacilitySearchResults.setLayout(new GridLayout(facilityList.size(), 0));
//            pnlFacilitySearchResults.repaint();
//            GridBagConstraints gbc = new GridBagConstraints();
//            for (Faciliteit facility : facilityList) {
//                pnlFacilitySearchResults.add(
//                        new FacilityListSearchResults(facility, this), gbc);
//            }
//        }
//
//        pnlFacilitySearchResults.revalidate();
//        pnlFacilitySearchResults.repaint();
//    }
//    public void refreshTable() {
//        Query query = getEntityManager().createNamedQuery("Faciliteit.findAll");
//        this.setFacilityList(query.getResultList());
//    }
//    public void updateFaciliteit() {
//        String sql = "UPDATE Faciliteit SET name='" + this.txtFaciliteitNaam.getText() + "', "
//                + "WHERE id='" + Integer.parseInt(this.txtFaciliteitSoort.getText()) + "' ";
//
//        try {
//            if (!getEntityManager().getTransaction().isActive()) {
//                getEntityManager().getTransaction().begin();
//            }
//            if (getEntityManager().getTransaction().isActive()) {
//                System.out.println("Verbinding is actief");
//            } else {
//                System.out.println("Verbinding is niet actief");
//            }
//
//            Query query = getEntityManager().createQuery(sql);
//            query.executeUpdate();
//            getEntityManager().getTransaction().commit();
//            this.refreshTable();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnFacilityWijzigen = new javax.swing.JButton();
        btnFacilityOpslaan = new javax.swing.JButton();
        btnOverzichtReservering = new javax.swing.JButton();
        btnNieuweFaciliteit = new javax.swing.JButton();
        btnFacilityHoofdscherm = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBeschrijving = new javax.swing.JTextArea();
        jLabel50 = new javax.swing.JLabel();
        txtFaciliteitNaam = new javax.swing.JTextField();
        txtFaciliteitSoort = new javax.swing.JTextField();
        txtFaciliteitKosten = new javax.swing.JTextField();
        txtFaciliteitLocatie = new javax.swing.JTextField();
        txtFaciliteitCapaciteit = new javax.swing.JTextField();
        txtFaciliteitTijd = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        ddlLocatie = new pas.layout.form.ComboList();
        ddlFacilities = new pas.layout.form.ComboList();
        jLabel3 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setOpaque(false);

        jPanel2.setOpaque(false);

        jPanel7.setOpaque(false);

        btnFacilityWijzigen.setBackground(new java.awt.Color(155, 9, 46));
        btnFacilityWijzigen.setForeground(new java.awt.Color(255, 255, 255));
        btnFacilityWijzigen.setText("Wijzigen");
        btnFacilityWijzigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacilityWijzigenActionPerformed(evt);
            }
        });

        btnFacilityOpslaan.setBackground(new java.awt.Color(155, 9, 46));
        btnFacilityOpslaan.setForeground(new java.awt.Color(255, 255, 255));
        btnFacilityOpslaan.setText("Opslaan");
        btnFacilityOpslaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacilityOpslaanActionPerformed(evt);
            }
        });

        btnOverzichtReservering.setBackground(new java.awt.Color(155, 9, 46));
        btnOverzichtReservering.setForeground(new java.awt.Color(255, 255, 255));
        btnOverzichtReservering.setText("Overzicht Reserveringen");
        btnOverzichtReservering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOverzichtReserveringActionPerformed(evt);
            }
        });

        btnNieuweFaciliteit.setBackground(new java.awt.Color(155, 9, 46));
        btnNieuweFaciliteit.setForeground(new java.awt.Color(255, 255, 255));
        btnNieuweFaciliteit.setText("Nieuwe Faciliteit");
        btnNieuweFaciliteit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNieuweFaciliteitActionPerformed(evt);
            }
        });

        btnFacilityHoofdscherm.setBackground(new java.awt.Color(155, 9, 46));
        btnFacilityHoofdscherm.setForeground(new java.awt.Color(255, 255, 255));
        btnFacilityHoofdscherm.setText("Naar Hoofdmenu");
        btnFacilityHoofdscherm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacilityHoofdschermActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFacilityWijzigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFacilityOpslaan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOverzichtReservering, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(btnNieuweFaciliteit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFacilityHoofdscherm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFacilityHoofdscherm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNieuweFaciliteit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOverzichtReservering)
                .addGap(13, 13, 13)
                .addComponent(btnFacilityWijzigen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFacilityOpslaan)
                .addGap(52, 52, 52))
        );

        jPanel1.setOpaque(false);

        lblTitle1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(98, 98, 152));
        lblTitle1.setText("Faciliteit gegevens");

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Algemeen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), java.awt.Color.darkGray)); // NOI18N
        jPanel23.setOpaque(false);

        jLabel45.setText("Kosten");

        jLabel46.setText("Naam");

        jLabel47.setText("Soort");

        jLabel48.setText("Locatie");

        jLabel49.setText("Beschrijving");

        txtBeschrijving.setColumns(20);
        txtBeschrijving.setRows(5);
        jScrollPane4.setViewportView(txtBeschrijving);

        jLabel50.setText("Capaciteit");

        txtFaciliteitNaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFaciliteitNaamActionPerformed(evt);
            }
        });

        jLabel51.setText("Tijd");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel46))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFaciliteitNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFaciliteitSoort, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFaciliteitCapaciteit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFaciliteitTijd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel45))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFaciliteitKosten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFaciliteitLocatie, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel49))
                        .addGap(235, 235, 235)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel46)
                                    .addComponent(txtFaciliteitNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel47)
                                    .addComponent(txtFaciliteitSoort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFaciliteitTijd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel51))
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txtFaciliteitKosten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txtFaciliteitLocatie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtFaciliteitCapaciteit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ddlLocatie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlLocatieActionPerformed(evt);
            }
        });

        ddlFacilities.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ddlFacilitiesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle1)
                            .addComponent(ddlLocatie, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ddlFacilities, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ddlLocatie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ddlFacilities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(98, 98, 152));
        jLabel3.setText("Faciliteiten Beheren");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    //Wijzigen button
    private void btnFacilityWijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacilityWijzigenActionPerformed
        if (ddlFacilities.getSelectedItem().hasValue()) {
            if (!wijzigen == true) {
                JOptionPane.showMessageDialog(ddlLocatie, "U kunt nu een Faciliteit wijzigen");
                wijzigen = true;
                this.Wijzigen(wijzigen);
                btnFacilityWijzigen.setText("Stop Wijzigen");
            } else {
                wijzigen = false;
                this.Wijzigen(wijzigen);
                btnFacilityWijzigen.setText("Wijzigen");
            }
                
        }
    }//GEN-LAST:event_btnFacilityWijzigenActionPerformed

    private void btnFacilityOpslaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacilityOpslaanActionPerformed
        Faciliteit facility = new Faciliteit();
        facility.setOmschrijving(txtFaciliteitNaam.getText());
        facility.setSoort(txtFaciliteitSoort.getText());
        facility.save();
        
        this.getController().facilityAction();
    }//GEN-LAST:event_btnFacilityOpslaanActionPerformed

    private void btnOverzichtReserveringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOverzichtReserveringActionPerformed
        new FacilityController().reservationChange();        // Open reservationChange view
    }//GEN-LAST:event_btnOverzichtReserveringActionPerformed

    private void btnNieuweFaciliteitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNieuweFaciliteitActionPerformed
        new FacilityController().addFacilityAction();        // TODO add your handling code here:
    }//GEN-LAST:event_btnNieuweFaciliteitActionPerformed

    private void btnFacilityHoofdschermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacilityHoofdschermActionPerformed
        new MainController().mainAction();                  // TODO add your handling code here:
    }//GEN-LAST:event_btnFacilityHoofdschermActionPerformed

    private void txtNaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNaamActionPerformed

    private void txtFaciliteitNaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFaciliteitNaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFaciliteitNaamActionPerformed

    private void ddlLocatieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlLocatieActionPerformed
        ComboListItem item = ddlLocatie.getSelectedItem();
        this.clearFacilityForm();

        if (item.hasValue()) {
            Vestiging vestiging = (Vestiging) item.getValue();
            this.facilities = this.getController()
                    .getFacilitiesByLocatieId(vestiging);

            this.setFacilities();
        } else {
            this.facilities.clear();
            this.setFacilities();
        }
    }//GEN-LAST:event_ddlLocatieActionPerformed

    private void ddlFacilitiesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ddlFacilitiesItemStateChanged
        if (ddlFacilities.isFocusOwner()) {
            ComboListItem item = ddlFacilities.getSelectedItem();

            if (item.hasValue()) {
                // Populate form
                Faciliteit facility = (Faciliteit) item.getValue();
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                txtFaciliteitCapaciteit.setText(new Integer(facility.getCapaciteit()).toString());
                txtFaciliteitNaam.setText(facility.getOmschrijving());
                txtFaciliteitKosten.setText(formatter.format(facility.getKosten()));
                txtFaciliteitLocatie.setText(facility.getVestigingid().getNaam());
                txtFaciliteitSoort.setText(facility.getSoort());
//                txtFaciliteitTijd.setText(Integer.toString());
            } else {
                // Clear form
                this.clearFacilityForm();
            }
        }
    }//GEN-LAST:event_ddlFacilitiesItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFacilityHoofdscherm;
    private javax.swing.JButton btnFacilityOpslaan;
    private javax.swing.JButton btnFacilityWijzigen;
    private javax.swing.JButton btnNieuweFaciliteit;
    private javax.swing.JButton btnOverzichtReservering;
    private pas.layout.form.ComboList ddlFacilities;
    private pas.layout.form.ComboList ddlLocatie;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JTextArea txtBeschrijving;
    private javax.swing.JTextField txtFaciliteitCapaciteit;
    private javax.swing.JTextField txtFaciliteitKosten;
    private javax.swing.JTextField txtFaciliteitLocatie;
    private javax.swing.JTextField txtFaciliteitNaam;
    private javax.swing.JTextField txtFaciliteitSoort;
    private javax.swing.JTextField txtFaciliteitTijd;
    // End of variables declaration//GEN-END:variables
}
