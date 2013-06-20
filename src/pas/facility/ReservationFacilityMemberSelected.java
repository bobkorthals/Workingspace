/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.facility;

import java.beans.PropertyChangeEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import pas.layout.form.ComboListItem;
import pas.member.MemberController;
import pas.models.ActiveMember;
import pas.models.db.Faciliteit;
import pas.models.db.Reservering;
import pas.models.db.Vestiging;
import pas.models.role.Member;

/**
 *
 * @author Bob
 */
public class ReservationFacilityMemberSelected extends mvc.view.AbstractView {

    private FacilityController facilitycontroller;
    private List<Faciliteit> facilities = new ArrayList();
    private List<Vestiging> vestigingen;

    /**
     * Creates new form ReservationFacilityMemberSelected
     *
     * @param FacilityController controller
     * @param Member active member
     * @param List<Faciliteit>
     */
    public ReservationFacilityMemberSelected(FacilityController facilitycontroller, Member member, List<Vestiging> vestigingen) {
        initComponents();
        this.facilitycontroller = facilitycontroller;
        this.vestigingen = vestigingen;

        this.setVestigingen();
        this.setMember(member);

        ddlFacilities.setEnabled(false);
    }

    @Override
    public FacilityController getController() {
        return this.facilitycontroller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case ActiveMember.MEMBER:
                this.setMember((Member) evt.getNewValue());
                break;
        }
    }

    /*
     * Class helper to set member data
     * 
     * @param Member member
     * @return void
     */
    private void setMember(Member member) {
        txtFirstName.setText(member.getFirstName());
        txtLastName.setText(member.getLastName());
        txtSuffix.setText(member.getSuffix());
        txtDateOfBirth.setText(member.getDateOfBrith().toString());
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
    
    /*
     * Clear the facility form fields
     * 
     * @return void
     */
    private void clearFacilityForm() {
        txtCapaciteit.setText("");
        txtNaam.setText("");
        txtKosten.setText("");
        txtLocation.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        pnlLeftButtons = new javax.swing.JPanel();
        btnReserverenBetalen = new javax.swing.JButton();
        btnTerug = new javax.swing.JButton();
        pnlMiddleUpTable = new javax.swing.JPanel();
        ddlFacilities = new pas.layout.form.ComboList();
        lblTitle1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtSoort = new javax.swing.JTextField();
        txtFaciliteitNaam = new javax.swing.JTextField();
        btnKosten = new javax.swing.JTextField();
        btnLocatie = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtSuffix = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtGeslacht = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtLidKrediet = new javax.swing.JTextField();
        txtLidBetalingsAchterstand = new javax.swing.JTextField();
        lblTitle2 = new javax.swing.JLabel();
        txtDateOfBirth = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txtCapaciteit = new javax.swing.JTextField();
        ddlTijd = new java.awt.Choice();
        ddlLocatie = new pas.layout.form.ComboList();
        pnlMiddleDown = new javax.swing.JPanel();
        lblTitle4 = new javax.swing.JLabel();
        h11 = new pas.layout.label.H1();

        setOpaque(false);

        jPanel2.setOpaque(false);

        jPanel14.setOpaque(false);

        pnlLeftButtons.setOpaque(false);

        btnReserverenBetalen.setBackground(new java.awt.Color(155, 9, 46));
        btnReserverenBetalen.setForeground(new java.awt.Color(255, 255, 255));
        btnReserverenBetalen.setText("Reserveren/Betalen");
        btnReserverenBetalen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserverenBetalenActionPerformed(evt);
            }
        });

        btnTerug.setBackground(new java.awt.Color(155, 9, 46));
        btnTerug.setForeground(new java.awt.Color(255, 255, 255));
        btnTerug.setText("Terug");
        btnTerug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerugActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLeftButtonsLayout = new javax.swing.GroupLayout(pnlLeftButtons);
        pnlLeftButtons.setLayout(pnlLeftButtonsLayout);
        pnlLeftButtonsLayout.setHorizontalGroup(
            pnlLeftButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReserverenBetalen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
            .addComponent(btnTerug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlLeftButtonsLayout.setVerticalGroup(
            pnlLeftButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReserverenBetalen)
                .addGap(18, 18, 18)
                .addComponent(btnTerug)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMiddleUpTable.setOpaque(false);

        ddlFacilities.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ddlFacilitiesItemStateChanged(evt);
            }
        });
        ddlFacilities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlFacilitiesActionPerformed(evt);
            }
        });

        lblTitle1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(98, 98, 152));
        lblTitle1.setText("Faciliteit gegevens");

        jPanel5.setOpaque(false);

        jLabel58.setText("Naam");

        jLabel59.setText("Soort");

        jLabel44.setText("Kosten");

        jLabel60.setText("Locatie");

        jLabel54.setText("Tussenvoegsel");

        jLabel53.setText("Achternaam");

        jLabel52.setText("Voornaam");

        jLabel55.setText("Geboortedatum");

        jLabel57.setText("Geslacht");

        txtSuffix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuffixActionPerformed(evt);
            }
        });

        txtGeslacht.setText("jTextField1");

        jLabel27.setText("Krediet");

        jLabel28.setText("Betalingsachterstand");

        txtLidKrediet.setText("jTextField3");
        txtLidKrediet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLidKredietActionPerformed(evt);
            }
        });

        txtLidBetalingsAchterstand.setText("jTextField3");
        txtLidBetalingsAchterstand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLidBetalingsAchterstandActionPerformed(evt);
            }
        });

        lblTitle2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(98, 98, 152));
        lblTitle2.setText("Lid gegevens");

        jLabel62.setText("Tijd");

        jLabel4.setText("Datum");

        jLabel61.setText("Capaciteit");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel44)
                            .addComponent(jLabel60)
                            .addComponent(jLabel58)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel58)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel57))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLocatie)
                            .addComponent(btnKosten)
                            .addComponent(txtSoort)
                            .addComponent(txtFaciliteitNaam)
                            .addComponent(txtFirstName)
                            .addComponent(txtLastName)
                            .addComponent(txtSuffix)
                            .addComponent(txtDateOfBirth)
                            .addComponent(txtGeslacht))
                        .addGap(67, 67, 67)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel4)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCapaciteit)
                    .addComponent(ddtTijd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLidKrediet, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLidBetalingsAchterstand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(txtKosten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel60))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLocatie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(lblTitle2))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtFaciliteitNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtLidKrediet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtLidBetalingsAchterstand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28)))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel52)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel53))))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(ddtTijd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCapaciteit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel62)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtGeslacht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        ddlLocatie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ddlLocatieItemStateChanged(evt);
            }
        });
        ddlLocatie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlLocatieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMiddleUpTableLayout = new javax.swing.GroupLayout(pnlMiddleUpTable);
        pnlMiddleUpTable.setLayout(pnlMiddleUpTableLayout);
        pnlMiddleUpTableLayout.setHorizontalGroup(
            pnlMiddleUpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMiddleUpTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMiddleUpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMiddleUpTableLayout.createSequentialGroup()
                        .addComponent(lblTitle1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMiddleUpTableLayout.createSequentialGroup()
                        .addGroup(pnlMiddleUpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ddlLocatie, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(ddlFacilities, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnlMiddleUpTableLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMiddleUpTableLayout.setVerticalGroup(
            pnlMiddleUpTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMiddleUpTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ddlLocatie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ddlFacilities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(lblTitle1)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMiddleDown.setOpaque(false);

        javax.swing.GroupLayout pnlMiddleDownLayout = new javax.swing.GroupLayout(pnlMiddleDown);
        pnlMiddleDown.setLayout(pnlMiddleDownLayout);
        pnlMiddleDownLayout.setHorizontalGroup(
            pnlMiddleDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMiddleDownLayout.setVerticalGroup(
            pnlMiddleDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        lblTitle4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTitle4.setForeground(new java.awt.Color(98, 98, 152));

        h11.setText("Reservering");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(pnlLeftButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlMiddleDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlMiddleUpTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(h11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle4)
                    .addComponent(h11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlLeftButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(pnlMiddleUpTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304)
                        .addComponent(pnlMiddleDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReserverenBetalenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserverenBetalenActionPerformed
        new FacilityController().paymentAction();        // TODO add your handling code here:
    }//GEN-LAST:event_btnReserverenBetalenActionPerformed

    private void btnTerugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerugActionPerformed
        new MemberController().manageMemberAction(WIDTH);        // TODO add your handling code here:
    }//GEN-LAST:event_btnTerugActionPerformed

    private void txtLidKredietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLidKredietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLidKredietActionPerformed

    private void txtLidBetalingsAchterstandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLidBetalingsAchterstandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLidBetalingsAchterstandActionPerformed

    private void txtSuffixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuffixActionPerformed
    }//GEN-LAST:event_txtSuffixActionPerformed

    private void ddlFacilitiesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ddlFacilitiesItemStateChanged
        if (ddlFacilities.isFocusOwner()) {
            ComboListItem item = ddlFacilities.getSelectedItem();

            if (item.hasValue()) {
                // Populate form
                Faciliteit facility = (Faciliteit) item.getValue();
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                txtCapaciteit.setText(new Integer(facility.getCapaciteit()).toString());
                txtNaam.setText(facility.getOmschrijving());
                txtKosten.setText(formatter.format(facility.getKosten()));
                txtLocation.setText(ddlLocatie.getSelectedItem().getValue().toString());
            } else {
                // Clear form
                this.clearFacilityForm();
            }
        }
    }//GEN-LAST:event_ddlFacilitiesItemStateChanged

    private void ddlFacilitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlFacilitiesActionPerformed
    }//GEN-LAST:event_ddlFacilitiesActionPerformed

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

    private void ddlLocatieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ddlLocatieItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ddlLocatieItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReserverenBetalen;
    private javax.swing.JButton btnTerug;
    private pas.layout.form.ComboList ddlFacilities;
    private pas.layout.form.ComboList ddlLocatie;
    private java.awt.Choice ddlTijd;
    private pas.layout.label.H1 h11;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JPanel pnlLeftButtons;
    private javax.swing.JPanel pnlMiddleDown;
    private javax.swing.JPanel pnlMiddleUpTable;
    private javax.swing.JTextField txtCapaciteit;
    private javax.swing.JTextField txtDateOfBirth;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGeslacht;
    private javax.swing.JTextField txtKosten;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLidBetalingsAchterstand;
    private javax.swing.JTextField txtLidKrediet;
    private javax.swing.JTextField txtSoort;
    private javax.swing.JTextField txtSuffix;
    // End of variables declaration//GEN-END:variables
}
