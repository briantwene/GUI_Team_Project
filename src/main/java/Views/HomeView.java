/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Components.beforeThisTimePolicy;
import Components.beforeTodayVetoPolicy;
import Controller.RouterController;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import models.AppModel;

/**
 *
 * @author twene
 */
public class HomeView extends javax.swing.JPanel {

    DatePickerSettings dateSettings1, dateSettings2;
    TimePickerSettings timeSettings1, timeSettings2;
    AppModel appState;
    RouterController controller;

    /**
     * Creates new form HomeView
     */
    public HomeView(AppModel appState, RouterController controller) {
        this.appState = appState;
        this.controller = controller;
        dateSettings1 = new DatePickerSettings();
        timeSettings1 = new TimePickerSettings();
        dateSettings2 = new DatePickerSettings();
        timeSettings2 = new TimePickerSettings();

        initComponents();
        dateSettings1.setVetoPolicy(new beforeTodayVetoPolicy());
        timeSettings1.setVetoPolicy(new beforeThisTimePolicy());
        dateSettings2.setVetoPolicy(new beforeTodayVetoPolicy());
        timeSettings2.setVetoPolicy(new beforeThisTimePolicy());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureBox1 = new third_party.PictureBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        searchContainer = new javax.swing.JPanel();
        goButton = new javax.swing.JButton();
        pickupLabel = new javax.swing.JLabel();
        returnLabel = new javax.swing.JLabel();
        pickupPicker = new com.github.lgooddatepicker.components.DateTimePicker(dateSettings1, timeSettings1);
        returnPicker = new com.github.lgooddatepicker.components.DateTimePicker(dateSettings2, timeSettings2);
        locationLabel = new javax.swing.JLabel();
        locationbox = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/images/chr.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 255));
        jLabel1.setText("Car Rental ");
        jLabel1.setMaximumSize(new java.awt.Dimension(400, 64));
        jLabel1.setMinimumSize(new java.awt.Dimension(400, 64));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("Purchase");
        jLabel2.setMaximumSize(new java.awt.Dimension(400, 64));
        jLabel2.setMinimumSize(new java.awt.Dimension(400, 64));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setText("Awesome price.");
        jLabel3.setMaximumSize(new java.awt.Dimension(400, 64));
        jLabel3.setMinimumSize(new java.awt.Dimension(400, 64));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setText("&");

        searchContainer.setBackground(new java.awt.Color(240, 240, 240));

        goButton.setBackground(new java.awt.Color(204, 0, 255));
        goButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        goButton.setForeground(new java.awt.Color(255, 255, 255));
        goButton.setText("GO");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        pickupLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        pickupLabel.setText("Pickup Date ");

        returnLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        returnLabel.setText("Return Date");

        pickupPicker.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        locationLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        locationLabel.setText("Location");

        locationbox.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        locationbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        locationbox.setText("J&B Dealership, Dublin");
        locationbox.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout searchContainerLayout = new javax.swing.GroupLayout(searchContainer);
        searchContainer.setLayout(searchContainerLayout);
        searchContainerLayout.setHorizontalGroup(
            searchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchContainerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(searchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(locationLabel)
                    .addComponent(locationbox, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(searchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pickupLabel)
                    .addComponent(pickupPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(searchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchContainerLayout.createSequentialGroup()
                        .addComponent(returnPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(goButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(returnLabel))
                .addGap(49, 49, 49))
        );
        searchContainerLayout.setVerticalGroup(
            searchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchContainerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(searchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pickupLabel)
                    .addComponent(locationLabel)
                    .addComponent(returnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(goButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(locationbox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(returnPicker, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                    .addComponent(pickupPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addComponent(searchContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        // TODO add your handling code here:

        // get pickup date and return date and add them to the appstate
        LocalDateTime pickupDate = pickupPicker.getDateTimeStrict();
        LocalDateTime returnDate = returnPicker.getDateTimeStrict();
        
        if(pickupDate == null || returnDate == null ){
            JOptionPane.showMessageDialog(null, "Please enter the pickup and return date");
        }else {
        appState.setPickupDate(pickupDate);
        appState.setReturnDate(returnDate);
        controller.goRentals();
        }

        //then move to the next page...
    }//GEN-LAST:event_goButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel locationbox;
    private javax.swing.JLabel pickupLabel;
    private com.github.lgooddatepicker.components.DateTimePicker pickupPicker;
    private third_party.PictureBox pictureBox1;
    private javax.swing.JLabel returnLabel;
    private com.github.lgooddatepicker.components.DateTimePicker returnPicker;
    private javax.swing.JPanel searchContainer;
    // End of variables declaration//GEN-END:variables
}
