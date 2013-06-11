/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.course;

import java.awt.Container;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Ufuk Çelebi
 */
public class CourseMain extends mvc.view.AbstractView {

    private Container container;
    private CourseController coursecontroller;

    /**
     * Creates new form CourseMain
     */
    public CourseMain(CourseController coursecontroller) {
        this.coursecontroller = coursecontroller;
        initComponents();
    }

    @Override
    public CourseController getController() {
        return this.coursecontroller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent change) {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCourseMain = new javax.swing.JPanel();
        pnlButtons = new javax.swing.JPanel();
        btnChange = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNewCourse = new javax.swing.JButton();
        btnScheduleCourse = new javax.swing.JButton();
        pnlCourseOverview = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCourseOverview = new javax.swing.JTable();
        lblCourseIDOverview = new javax.swing.JLabel();
        lblCourseNameOverview = new javax.swing.JLabel();
        lblLocationIDOverview = new javax.swing.JLabel();
        lblCoursePriceOverview = new javax.swing.JLabel();
        txtCourseIDOverview = new java.awt.TextField();
        txtCourseNameOverview = new java.awt.TextField();
        txtLocationIDOverview = new java.awt.TextField();
        txtCoursePriceOverview = new java.awt.TextField();
        pnlCourseData = new javax.swing.JPanel();
        pnlCourseGeneral = new javax.swing.JPanel();
        lblCourseID = new javax.swing.JLabel();
        lblCourseName = new javax.swing.JLabel();
        lblCcoursePrice = new javax.swing.JLabel();
        txtCourseID = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();
        txtCoursePrice = new javax.swing.JTextField();
        lblCourseActivity = new javax.swing.JLabel();
        txtCourseActivity = new javax.swing.JTextField();
        lblCourseCapacity = new javax.swing.JLabel();
        txtCourseCapacity = new javax.swing.JTextField();
        lblCourseMinimum = new javax.swing.JLabel();
        txtCourseMinimum = new javax.swing.JTextField();
        lblCourseDuration = new javax.swing.JLabel();
        txtCourseDuration = new javax.swing.JTextField();
        lblCourseDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCourseDescription = new javax.swing.JTextArea();
        pnlLocationData = new javax.swing.JPanel();
        lblLocationID = new javax.swing.JLabel();
        txtLocationID = new javax.swing.JTextField();
        lblLocationName = new javax.swing.JLabel();
        txtLocationName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblLocationStreetName = new javax.swing.JLabel();
        txtLocationStreetName = new javax.swing.JTextField();
        lblLocationZipCode = new javax.swing.JLabel();
        txtLocationZipCode = new javax.swing.JTextField();
        lblLocationHouseNumber = new javax.swing.JLabel();
        txtLocationHouseNumber = new javax.swing.JTextField();
        lblLocationSuffix = new javax.swing.JLabel();
        txtLocationSuffix = new javax.swing.JTextField();
        lblLocationCity = new javax.swing.JLabel();
        txtLocationCity = new javax.swing.JTextField();
        lblLocationTelNumber = new javax.swing.JLabel();
        txtLocationTelNumber = new javax.swing.JTextField();
        lblLocationEmail = new javax.swing.JLabel();
        txtLocationEmail = new javax.swing.JTextField();
        lblCourseMain = new javax.swing.JLabel();

        setOpaque(false);

        pnlCourseMain.setOpaque(false);

        pnlButtons.setOpaque(false);

        btnChange.setBackground(new java.awt.Color(155, 9, 46));
        btnChange.setForeground(new java.awt.Color(255, 255, 255));
        btnChange.setText("Wijzigen");
        btnChange.setMaximumSize(new java.awt.Dimension(99, 23));
        btnChange.setMinimumSize(new java.awt.Dimension(99, 23));
        btnChange.setPreferredSize(new java.awt.Dimension(99, 23));

        btnSave.setBackground(new java.awt.Color(155, 9, 46));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Opslaan");

        btnDelete.setBackground(new java.awt.Color(155, 9, 46));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Verwijderen");

        btnNewCourse.setBackground(new java.awt.Color(155, 9, 46));
        btnNewCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnNewCourse.setText("Nieuw Cursus");
        btnNewCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCourseActionPerformed(evt);
            }
        });

        btnScheduleCourse.setBackground(new java.awt.Color(155, 9, 46));
        btnScheduleCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnScheduleCourse.setText("Planning beheer");
        btnScheduleCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewCourse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(btnScheduleCourse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnScheduleCourse)
                .addContainerGap())
        );

        pnlCourseOverview.setBorder(javax.swing.BorderFactory.createTitledBorder("Cursus overzicht"));
        pnlCourseOverview.setOpaque(false);

        tblCourseOverview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cursusnummer", "Naam", "Locatie", "Prijs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCourseOverview.setOpaque(false);
        jScrollPane1.setViewportView(tblCourseOverview);

        lblCourseIDOverview.setText("Cursusnummer");

        lblCourseNameOverview.setText("Naam");

        lblLocationIDOverview.setText("Locatienummer");

        lblCoursePriceOverview.setText("Prijs");

        javax.swing.GroupLayout pnlCourseOverviewLayout = new javax.swing.GroupLayout(pnlCourseOverview);
        pnlCourseOverview.setLayout(pnlCourseOverviewLayout);
        pnlCourseOverviewLayout.setHorizontalGroup(
            pnlCourseOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseOverviewLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlCourseOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlCourseOverviewLayout.createSequentialGroup()
                        .addComponent(lblCourseIDOverview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCourseIDOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCourseNameOverview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCourseNameOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLocationIDOverview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocationIDOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCoursePriceOverview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCoursePriceOverview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42)))
                .addContainerGap())
        );
        pnlCourseOverviewLayout.setVerticalGroup(
            pnlCourseOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCourseOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCourseIDOverview)
                    .addGroup(pnlCourseOverviewLayout.createSequentialGroup()
                        .addGroup(pnlCourseOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCourseIDOverview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCourseOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCourseOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCourseNameOverview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLocationIDOverview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCoursePriceOverview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCoursePriceOverview, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(lblCourseNameOverview)
                                .addComponent(lblLocationIDOverview)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pnlCourseData.setBorder(javax.swing.BorderFactory.createTitledBorder("Cursus gegevens"));
        pnlCourseData.setOpaque(false);

        pnlCourseGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder("Algemeen"));
        pnlCourseGeneral.setOpaque(false);

        lblCourseID.setText("Cursusnummer");

        lblCourseName.setText("Naam");

        lblCcoursePrice.setText("Prijs");

        lblCourseActivity.setText("Aciviteit");

        lblCourseCapacity.setText("Capaciteit");

        lblCourseMinimum.setText("Minimum");

        lblCourseDuration.setText("Duur");

        lblCourseDescription.setText("Omschrijving");

        txtCourseDescription.setColumns(20);
        txtCourseDescription.setRows(5);
        jScrollPane2.setViewportView(txtCourseDescription);

        javax.swing.GroupLayout pnlCourseGeneralLayout = new javax.swing.GroupLayout(pnlCourseGeneral);
        pnlCourseGeneral.setLayout(pnlCourseGeneralLayout);
        pnlCourseGeneralLayout.setHorizontalGroup(
            pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addGroup(pnlCourseGeneralLayout.createSequentialGroup()
                        .addComponent(lblCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCourseID))
                    .addGroup(pnlCourseGeneralLayout.createSequentialGroup()
                        .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCourseDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblCourseDuration, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCourseMinimum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCourseCapacity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCourseActivity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCourseName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCcoursePrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCourseName)
                            .addComponent(txtCoursePrice)
                            .addComponent(txtCourseActivity)
                            .addComponent(txtCourseCapacity)
                            .addComponent(txtCourseMinimum)
                            .addComponent(txtCourseDuration))))
                .addContainerGap())
        );
        pnlCourseGeneralLayout.setVerticalGroup(
            pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourseID)
                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourseName)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCcoursePrice)
                    .addComponent(txtCoursePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourseActivity)
                    .addComponent(txtCourseActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCourseCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCourseCapacity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourseMinimum)
                    .addComponent(txtCourseMinimum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourseDuration)
                    .addComponent(txtCourseDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCourseDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlLocationData.setBorder(javax.swing.BorderFactory.createTitledBorder("Locatie gegevens"));
        pnlLocationData.setOpaque(false);

        lblLocationID.setText("Locatie nummer");

        lblLocationName.setText("Naam");

        lblLocationStreetName.setText("Straatnaam");

        lblLocationZipCode.setText("Postcode");

        lblLocationHouseNumber.setText("Huisnummer");

        lblLocationSuffix.setText("Achtervoegsel");

        lblLocationCity.setText("Woonplaats");

        lblLocationTelNumber.setText("Telefoonnummer");

        lblLocationEmail.setText("Email");

        javax.swing.GroupLayout pnlLocationDataLayout = new javax.swing.GroupLayout(pnlLocationData);
        pnlLocationData.setLayout(pnlLocationDataLayout);
        pnlLocationDataLayout.setHorizontalGroup(
            pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocationDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblLocationSuffix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLocationHouseNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlLocationDataLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblLocationName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLocationID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLocationStreetName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLocationZipCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLocationCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLocationTelNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(lblLocationEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLocationStreetName)
                    .addComponent(txtLocationName)
                    .addComponent(txtLocationID)
                    .addComponent(txtLocationHouseNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(txtLocationSuffix)
                    .addComponent(txtLocationCity)
                    .addComponent(txtLocationTelNumber)
                    .addComponent(txtLocationEmail)
                    .addComponent(txtLocationZipCode))
                .addContainerGap())
        );
        pnlLocationDataLayout.setVerticalGroup(
            pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocationDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocationID)
                    .addComponent(txtLocationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocationName)
                    .addComponent(txtLocationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocationStreetName)
                    .addComponent(txtLocationStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocationHouseNumber)
                    .addComponent(txtLocationHouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocationSuffix)
                    .addComponent(txtLocationSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocationZipCode)
                    .addComponent(txtLocationZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocationCity)
                    .addComponent(txtLocationCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocationTelNumber)
                    .addComponent(txtLocationTelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocationDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocationEmail)
                    .addComponent(txtLocationEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11))
        );

        javax.swing.GroupLayout pnlCourseDataLayout = new javax.swing.GroupLayout(pnlCourseData);
        pnlCourseData.setLayout(pnlCourseDataLayout);
        pnlCourseDataLayout.setHorizontalGroup(
            pnlCourseDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCourseGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLocationData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCourseDataLayout.setVerticalGroup(
            pnlCourseDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCourseDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlLocationData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCourseGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblCourseMain.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblCourseMain.setText("Cursus Beheer");
        lblCourseMain.setMaximumSize(new java.awt.Dimension(129, 24));
        lblCourseMain.setMinimumSize(new java.awt.Dimension(129, 24));
        lblCourseMain.setPreferredSize(new java.awt.Dimension(129, 24));

        javax.swing.GroupLayout pnlCourseMainLayout = new javax.swing.GroupLayout(pnlCourseMain);
        pnlCourseMain.setLayout(pnlCourseMainLayout);
        pnlCourseMainLayout.setHorizontalGroup(
            pnlCourseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCourseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCourseMain, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCourseMainLayout.createSequentialGroup()
                        .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCourseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCourseOverview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlCourseData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlCourseMainLayout.setVerticalGroup(
            pnlCourseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCourseMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCourseMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCourseMainLayout.createSequentialGroup()
                        .addComponent(pnlCourseOverview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlCourseData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(pnlCourseMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnlCourseMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCourseActionPerformed
        coursecontroller.AddCourseAction();        // Deze button opent de view AddCourse
    }//GEN-LAST:event_btnNewCourseActionPerformed

    private void btnScheduleCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleCourseActionPerformed
        coursecontroller.ScheduleCourseAction();        // Deze button opent de view PlanningCourse
    }//GEN-LAST:event_btnScheduleCourseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewCourse;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnScheduleCourse;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCcoursePrice;
    private javax.swing.JLabel lblCourseActivity;
    private javax.swing.JLabel lblCourseCapacity;
    private javax.swing.JLabel lblCourseDescription;
    private javax.swing.JLabel lblCourseDuration;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblCourseIDOverview;
    private javax.swing.JLabel lblCourseMain;
    private javax.swing.JLabel lblCourseMinimum;
    private javax.swing.JLabel lblCourseName;
    private javax.swing.JLabel lblCourseNameOverview;
    private javax.swing.JLabel lblCoursePriceOverview;
    private javax.swing.JLabel lblLocationCity;
    private javax.swing.JLabel lblLocationEmail;
    private javax.swing.JLabel lblLocationHouseNumber;
    private javax.swing.JLabel lblLocationID;
    private javax.swing.JLabel lblLocationIDOverview;
    private javax.swing.JLabel lblLocationName;
    private javax.swing.JLabel lblLocationStreetName;
    private javax.swing.JLabel lblLocationSuffix;
    private javax.swing.JLabel lblLocationTelNumber;
    private javax.swing.JLabel lblLocationZipCode;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCourseData;
    private javax.swing.JPanel pnlCourseGeneral;
    private javax.swing.JPanel pnlCourseMain;
    private javax.swing.JPanel pnlCourseOverview;
    private javax.swing.JPanel pnlLocationData;
    private javax.swing.JTable tblCourseOverview;
    private javax.swing.JTextField txtCourseActivity;
    private javax.swing.JTextField txtCourseCapacity;
    private javax.swing.JTextArea txtCourseDescription;
    private javax.swing.JTextField txtCourseDuration;
    private javax.swing.JTextField txtCourseID;
    private java.awt.TextField txtCourseIDOverview;
    private javax.swing.JTextField txtCourseMinimum;
    private javax.swing.JTextField txtCourseName;
    private java.awt.TextField txtCourseNameOverview;
    private javax.swing.JTextField txtCoursePrice;
    private java.awt.TextField txtCoursePriceOverview;
    private javax.swing.JTextField txtLocationCity;
    private javax.swing.JTextField txtLocationEmail;
    private javax.swing.JTextField txtLocationHouseNumber;
    private javax.swing.JTextField txtLocationID;
    private java.awt.TextField txtLocationIDOverview;
    private javax.swing.JTextField txtLocationName;
    private javax.swing.JTextField txtLocationStreetName;
    private javax.swing.JTextField txtLocationSuffix;
    private javax.swing.JTextField txtLocationTelNumber;
    private javax.swing.JTextField txtLocationZipCode;
    // End of variables declaration//GEN-END:variables
}
