/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Components.beforeTodayVetoPolicy;
import Controller.RouterController;
import javax.swing.JOptionPane;
import models.AppModel;
import models.DealershipDAO;
import models.PurchaseModel;
import models.VehicleModel;
import Controller.UpdateInterface;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Date;
import java.time.temporal.ChronoUnit;

import main.Utils;
import models.RentModel;

/**
 *
 * @author twene
 */
public class CarInfoView extends javax.swing.JPanel implements UpdateInterface, DateChangeListener {

        DatePickerSettings dateSettings1, dateSettings2;
        TimePickerSettings timeSettings1, timeSettings2;
        RouterController controller;
        AppModel appState;
        public DealershipDAO dealershipDao;
        Runnable update = () -> this.updatePage();
        Utils utilityClass = new Utils();

        /**
         * Creates new form CarInfo
         */
        public CarInfoView(AppModel appState, RouterController controller, DealershipDAO dealershipDao) {
                this.controller = controller;
                this.appState = appState;
                this.dealershipDao = dealershipDao;
                this.controller.attachUpdateFunc(update);
                dateSettings1 = new DatePickerSettings();

                dateSettings2 = new DatePickerSettings();
                ;

                initComponents();
                dateSettings1.setVetoPolicy(new beforeTodayVetoPolicy());

                dateSettings2.setVetoPolicy(new beforeTodayVetoPolicy());

                pickupPicker.addDateChangeListener(this);
                returnPicker.addDateChangeListener(this);

        }

        public long calcTotalPrice(long days, int price) {
                return days * price;
        }

        @Override
        public void dateChanged(DateChangeEvent event) {
                // get the number of days

                LocalDate stDate = pickupPicker.getDate();

                LocalDate endDate = returnPicker.getDate();

                if (stDate == null || endDate == null) {
                        // set the number of days to 0

                        item.setText(String.format("%s Day(s) @ $%s", 0, 0));
                        dailyRateTotal.setText("€" + 0);
                        price.setText("€" + 0);

                } else {
                        long days = ChronoUnit.DAYS.between(stDate, endDate);
                        int baseprice = appState.getSelectedVehicle().getVehiclePrice();

                        long total = calcTotalPrice(days, baseprice);
                        dailyRateTotal.setText("€" + total);
                        item.setText(String.format("%s Day(s) @ $%s", days, baseprice));
                        price.setText("€" + total);

                }

        }

        @Override
        public void updatePage() {
                VehicleModel selected = appState.getSelectedVehicle();
                price.setText("€" + selected.getVehiclePrice());
                name.setText(String.format("%s - %s", selected.getVehicleMake(), selected.getVehicleModel()));
                carRarity.setText(selected.getVehicleRarity());
                carRarity.setForeground(Color.decode(selected.getRarityColor()));
                imageContainer.setImage(selected.getVehicleImage());
                color.setText(selected.getVehicleColor());
                type.setText(selected.getVehicleType());
                year.setText(Integer.toString(selected.getVehicleYear()));
                passengers.setText(Integer.toString(selected.getVehiclePassengers()));

                if (appState.getSelectedVehicle().isForRent()) {
                        pickupPicker.setDate(appState.pickupDate);
                        returnPicker.setDate(appState.returnDate);
                        pickupLabel.setVisible(true);
                        returnLabel.setVisible(true);
                        pickupPicker.setVisible(true);
                        returnPicker.setVisible(true);
                        summary.setText("Order Details - Rent");
                        jButton1.setText("Rent Now");
                        saleItem.setVisible(false);
                        salePrice.setVisible(false);

                        item.setText(String.format("%s Day(s) @ $%s",
                                        ChronoUnit.DAYS.between(pickupPicker.getDate(), returnPicker.getDate()),
                                        selected.getVehiclePrice()));

                } else {
                        pickupLabel.setVisible(false);
                        returnLabel.setVisible(false);
                        pickupPicker.setVisible(false);
                        returnPicker.setVisible(false);
                        jButton1.setText("Buy Now");
                        item.setVisible(false);
                        dailyRate.setVisible(false);
                        dailyRateTotal.setVisible(false);
                        summary.setText("Order Details - Sale");
                        saleItem.setVisible(true);
                        salePrice.setVisible(true);
                        saleItem.setText(String.format("%s - %s(%s)", selected.getVehicleMake(),
                                        selected.getVehicleModel(),
                                        selected.getVehicleYear()));
                        salePrice.setText("€" + selected.getVehiclePrice());
                }

        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel2 = new javax.swing.JPanel();
                jButton2 = new javax.swing.JButton();
                imageContainer = new third_party.PictureBox();
                jLabel4 = new javax.swing.JLabel();
                carRarity = new javax.swing.JLabel();
                name = new javax.swing.JLabel();
                color = new javax.swing.JLabel();
                passengers = new javax.swing.JLabel();
                type = new javax.swing.JLabel();
                year = new javax.swing.JLabel();
                jSeparator2 = new javax.swing.JSeparator();
                color1 = new javax.swing.JLabel();
                type1 = new javax.swing.JLabel();
                passengers1 = new javax.swing.JLabel();
                year1 = new javax.swing.JLabel();
                jPanel3 = new javax.swing.JPanel();
                pickupLabel = new javax.swing.JLabel();
                returnLabel = new javax.swing.JLabel();
                pickupPicker = new com.github.lgooddatepicker.components.DatePicker(dateSettings1);
                returnPicker = new com.github.lgooddatepicker.components.DatePicker(dateSettings2);
                dailyRate = new javax.swing.JLabel();
                item = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                price = new javax.swing.JLabel();
                jSeparator1 = new javax.swing.JSeparator();
                jLabel5 = new javax.swing.JLabel();
                summary = new javax.swing.JLabel();
                dailyRateTotal = new javax.swing.JLabel();
                saleItem = new javax.swing.JLabel();
                salePrice = new javax.swing.JLabel();

                jPanel2.setBackground(new java.awt.Color(255, 255, 255));

                jButton2.setText("< Back");
                jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                imageContainer.setImage(new javax.swing.ImageIcon(getClass().getResource("/images/car.png"))); // NOI18N

                jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                jLabel4.setText("Specs");

                carRarity.setText("Ultra");
                carRarity.setBackground(new java.awt.Color(255, 128, 0));
                carRarity.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
                carRarity.setForeground(new java.awt.Color(255, 128, 0));

                name.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
                name.setText("Land Rover - Discovery");

                color.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                color.setText("Colour");

                passengers.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                passengers.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                passengers.setText("Passengers");

                type.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                type.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                type.setText("Type");

                year.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                year.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                year.setText("Year");

                color1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                color1.setText("Colour");

                type1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                type1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                type1.setText("Type");

                passengers1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                passengers1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                passengers1.setText("Passengers");

                year1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                year1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                year1.setText("Year");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel2Layout.createSequentialGroup()
                                                                                                                .addContainerGap()
                                                                                                                .addComponent(jSeparator2))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addContainerGap(
                                                                                                                                                22,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(imageContainer,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                851,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jButton2,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                112,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(name)
                                                                                                                                                .addComponent(carRarity)
                                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addGap(3, 3, 3)
                                                                                                                                                                .addComponent(jLabel4))))
                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(73, 73, 73)
                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(color1)
                                                                                                                                                .addComponent(type1)
                                                                                                                                                .addComponent(passengers1))
                                                                                                                                .addGap(39, 39, 39)
                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(type)
                                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                                                628,
                                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                .addComponent(color)
                                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                .addComponent(year1)
                                                                                                                                                                                .addGap(48, 48, 48)
                                                                                                                                                                                .addComponent(year)
                                                                                                                                                                                .addGap(229, 229,
                                                                                                                                                                                                229)))
                                                                                                                                                .addComponent(passengers))))
                                                                                                .addGap(0, 24, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(jButton2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(imageContainer,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                402,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(name)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(carRarity)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(jSeparator2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                53,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(color)
                                                                                .addComponent(year)
                                                                                .addComponent(color1)
                                                                                .addComponent(year1))
                                                                .addGap(37, 37, 37)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(type)
                                                                                .addComponent(type1))
                                                                .addGap(43, 43, 43)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(passengers)
                                                                                .addComponent(passengers1))
                                                                .addGap(60, 60, 60)));

                jPanel3.setBackground(new java.awt.Color(255, 255, 255));

                pickupLabel.setText("Pickup Date");
                pickupLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

                returnLabel.setText("Return Date");
                returnLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

                pickupPicker.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

                returnPicker.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

                dailyRate.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
                dailyRate.setText("Daily Rate");

                item.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
                item.setText("3 Days @ 33");

                jButton1.setText("Rent");
                jButton1.setBackground(new java.awt.Color(153, 51, 255));
                jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                price.setText("€120");
                price.setFont(new java.awt.Font("Segoe UI Semilight", 1, 36)); // NOI18N

                jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
                jLabel5.setText("Total");

                summary.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                summary.setText("Order Details");

                dailyRateTotal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
                dailyRateTotal.setText("$22");

                saleItem.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
                saleItem.setText("Land Rover Discovery Sport");

                salePrice.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
                salePrice.setText("$140000");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(34, 34, 34)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jButton1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                337,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 38, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel3Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(saleItem)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(salePrice))
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addComponent(dailyRate)
                                                                                                                                                                .addComponent(item))
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(dailyRateTotal))
                                                                                                                                .addComponent(returnPicker,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(pickupPicker,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(jSeparator1)
                                                                                                                                .addGroup(jPanel3Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(jLabel5)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(price)))
                                                                                                                .addGap(48, 48, 48))
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(pickupLabel)
                                                                                                                .addComponent(returnLabel))
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(120, 120, 120)
                                                                .addComponent(summary)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addComponent(summary)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                55,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(pickupLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(pickupPicker,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                32,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(2, 2, 2)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(saleItem)
                                                                                .addComponent(salePrice))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(returnLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(returnPicker,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                32,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(33, 33, 33)
                                                                .addComponent(dailyRate)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(item)
                                                                                .addComponent(dailyRateTotal))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jSeparator1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(price))
                                                                .addGap(41, 41, 41)
                                                                .addComponent(jButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                51,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(68, Short.MAX_VALUE)
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jPanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(68, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jPanel2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(14, Short.MAX_VALUE)));
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:

                // check if the user is logged in if the user isnt logged in then open the login
                // prompet
                if (appState.currentUser == null) {
                        JOptionPane.showMessageDialog(null, "you need to login");
                } else if (this.appState.getSelectedVehicle().isForRent()) {

                        LocalDate pickupDate = pickupPicker.getDate();
                        LocalDate returnDate = returnPicker.getDate();
                        // construct a new rental object
                        System.out.println(" this car is avaliable for rent");

                        if (pickupDate == null || returnDate == null) {
                                JOptionPane.showMessageDialog(null, "Please enter the pickup and return date");

                        } else {
                                System.out.println(" converting and adding to db");
                                Date pickupDateConverted = utilityClass.convertToDateViaSqlDate(pickupPicker.getDate());
                                Date returnDateConverted = utilityClass.convertToDateViaSqlDate(returnPicker.getDate());

                                long daysBetween = ChronoUnit.DAYS.between(pickupDate, returnDate);

                                System.out.println(" The number of days between dates: " + daysBetween);
                                // get the amount of days between the two dates

                                // convert the days to java Date the call the db command.... for testing
                                RentModel newModel = new RentModel(0, pickupDateConverted, returnDateConverted,
                                                (int) daysBetween,
                                                this.appState.getSelectedVehicle().getVehicleId(),
                                                appState.getCurrentUser().getUserId());

                                dealershipDao.addRental(newModel);
                        }

                } else {
                        // create a purchase object
                        JOptionPane.showMessageDialog(null,
                                        String.format("You have bought a %s %s",
                                                        this.appState.getSelectedVehicle().getVehicleMake(),
                                                        this.appState.getSelectedVehicle().getVehicleModel()));

                        dealershipDao.addPurchase(new PurchaseModel(null, appState.getCurrentUser().getUserId(),
                                        this.appState.getSelectedVehicle().getVehicleId(),
                                        this.appState.getSelectedVehicle().getVehiclePrice()));
                        controller.goHome();
                }
        }

        // GEN-LAST:event_jButton1ActionPerformed
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                // TODO add your handling code here:

                controller.goRentals();
        }// GEN-LAST:event_jButton2ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel carRarity;
        private javax.swing.JLabel color;
        private javax.swing.JLabel color1;
        private javax.swing.JLabel dailyRate;
        private javax.swing.JLabel dailyRateTotal;
        private third_party.PictureBox imageContainer;
        private javax.swing.JLabel item;
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JLabel name;
        private javax.swing.JLabel passengers;
        private javax.swing.JLabel passengers1;
        private javax.swing.JLabel pickupLabel;
        private com.github.lgooddatepicker.components.DatePicker pickupPicker;
        private javax.swing.JLabel price;
        private javax.swing.JLabel returnLabel;
        private com.github.lgooddatepicker.components.DatePicker returnPicker;
        private javax.swing.JLabel saleItem;
        private javax.swing.JLabel salePrice;
        private javax.swing.JLabel summary;
        private javax.swing.JLabel type;
        private javax.swing.JLabel type1;
        private javax.swing.JLabel year;
        private javax.swing.JLabel year1;
        // End of variables declaration//GEN-END:variables
}
