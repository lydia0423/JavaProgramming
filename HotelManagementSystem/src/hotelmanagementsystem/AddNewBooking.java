package hotelmanagementsystem;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static hotelmanagementsystem.InputValidation.isWord;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class Booking {

    private String bookingDate;
    private String customerName;
    private String ICNumber;
    private String contactNumber;
    private String email;
    private String checkIn;
    private String checkOut;
    private String roomID;
    private String status;
    private String total;
    private String paymentStatus;

    public void setBookingDate(String currentDate) {
        bookingDate = currentDate;
    }

    public void setCustomerName(String n) {
        customerName = n;
    }

    public void setICNumber(String i) {
        ICNumber = i;
    }

    public void setContactNumber(String c) {
        contactNumber = c;
    }

    public void setEmail(String e) {
        email = e;
    }

    public void setCheckIn(String startDate) {
        checkIn = startDate;
    }

    public void setCheckOut(String endDate) {
        checkOut = endDate;
    }

    public void setRoomID(String ID) {
        roomID = ID;
    }

    public void setStatus(String s) {
        status = s;
    }

    public void setTotal(String t) {
        total = t;
    }

    public void setPaymentStatus(String p) {
        paymentStatus = p;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getICNumber() {
        return ICNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getStatus() {
        return status;
    }

    public String getTotal() {
        return total;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    //display customer details
    public void display(String n, String i, String c, String e) {
        System.out.println("Name: " + customerName
                + "\nIC/Passport Number: " + ICNumber
                + "\nContactNumber: " + contactNumber
                + "Email Address: " + email);
    }

    //display booking details
    public void display(String currentDate, String n, String i, String c, String e, String startDate, String endDate, String ID, String s, String t, String p) {
        System.out.println("Booking Date: " + bookingDate + "\nName: " + customerName
                + "\nIC/Passport Number: " + ICNumber
                + "\nContactNumber: " + contactNumber
                + "\nEmail Address: " + email
                + "\nCheck In: " + checkIn
                + "\nCheck Out: " + checkOut
                + "\nRoom ID: " + roomID
                + "\nBooking Status: " + status
                + "\nTotal charges: " + total
                + "\nPayment Status: " + paymentStatus);
    }
}

public class AddNewBooking extends javax.swing.JFrame {

    public AddNewBooking() {
        initComponents();
        //user unable to edit the contents
        txtTotal.setEditable(false);

        //set up label background color
        jLabel1.setOpaque(true);
        Color purpleColor = new Color(36, 0, 46);
        jLabel1.setBackground(purpleColor);

        //show the current booking date
        Date bookingDate = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        String date = DATE_FORMAT.format(bookingDate);
        lblCurrentDate.setText(date);

        scaleImage();

    }

    private void scaleImage() {
        ImageIcon mailIcon = new ImageIcon("Images:Icon//mailbox_icon_60078_74274.png");
        //scale the image to fit the label
        Image imgMailBox = mailIcon.getImage();
        Image imgScale1 = imgMailBox.getScaledInstance(lblMailBox.getWidth(), lblMailBox.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledMailIcon = new ImageIcon(imgScale1);
        lblMailBox.setIcon(scaledMailIcon);

        ImageIcon printIcon = new ImageIcon("Images:Icon//Very-Basic-Print-icon.png");
        //scale the image to fit the label
        Image imgPrint = printIcon.getImage();
        Image imgScale2 = imgPrint.getScaledInstance(lblPrint.getWidth(), lblPrint.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledPrintIcon = new ImageIcon(imgScale2);
        lblPrint.setIcon(scaledPrintIcon);

    }

    public void sendEmail(String recepient) throws MessagingException {
        System.out.println("Preparing to send enmail!");
        Properties properties = new Properties();

        //always require username and password to authenticate the account
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "slleeyifoo@gmail.com";
        String password = "f3WB7BCTQsYN";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient);

        Transport.send(message);
        System.out.println("Message send successfully!");
    }

    public Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Booking Confirmation");
            message.setText(
                    "Hi " + txtCustomerName.getText() + "\n\n\n"
                    + "Thank you for choosing to stay with Java Holiday Hotel!"
                    + "\n\n"
                    + "Please take a look at the information below and let us know if you "
                    + "have any questions or would like to make any changes to your booking."
                    + " You can call us at 03-6653458 or simply email javaholidayhotel@gmail.com."
                    + "\n\nSee you soon at Java Holiday Hotel!"
                    + "\n\n\n\n"
                    + "Booking Date: " + lblCurrentDate.getText()
                    + "\nCustomer Name: " + txtCustomerName.getText()
                    + "IC/Passport Number: " + txtICNumber.getText()
                    + "\nContact Number: " + txtContactNumber.getText()
                    + "\nEmail: " + txtEmail.getText()
                    + "\nCheck In Date: " + dtpCheckIn.getDate().toString()
                    + "\nCheck Out Date: " + dtpCheckOut.getDate().toString()
                    + "\nRoom ID: " + cmbRoomID.getSelectedItem()
                    + "\nTotal Charges: " + "RM " + txtTotal.getText()
                    + "\nPayment Status: " + cmbPaymentStatus.getSelectedItem());
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(AddNewBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RoomTypes = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblCurrentDate = new javax.swing.JLabel();
        lblBookingDate = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblICNumber = new javax.swing.JLabel();
        lblContactNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCheckIn = new javax.swing.JLabel();
        lblCheckOut = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        txtICNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        btnResetAll = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        lblTotalPayment = new javax.swing.JLabel();
        lblRM = new javax.swing.JLabel();
        cmbRoomID = new javax.swing.JComboBox<>();
        txtTotal = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        DatePickerSettings checkOutDateSettings = new DatePickerSettings();
        dtpCheckOut = new DatePicker(checkOutDateSettings);
        checkOutDateSettings.setDateRangeLimits(LocalDate.now(), LocalDate.now().plusMonths(12));
        DatePickerSettings checkInDateSettings = new DatePickerSettings();
        dtpCheckIn = new DatePicker(checkInDateSettings);
        checkInDateSettings.setDateRangeLimits(LocalDate.now(), LocalDate.now().plusMonths(12));
        lblPaymentStatus = new javax.swing.JLabel();
        cmbPaymentStatus = new javax.swing.JComboBox<>();
        lblMailBox = new javax.swing.JLabel();
        lblPrint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add New Booking");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelmanagementsystem/cartoon-background-hotel-reception-flyer-ad-poster-banner-with-arab-family_33099-900.jpg"))); // NOI18N

        lblCurrentDate.setText("Booking");

        lblBookingDate.setText("Booking Date:");

        lblCustomerName.setText("Customer Name: ");

        lblICNumber.setText("IC/ Passport Number: ");

        lblContactNumber.setText("Contact Number: ");

        lblEmail.setText("Email: ");

        lblCheckIn.setText("Check In:");

        lblCheckOut.setText("Check Out:");

        jLabel10.setText("Room ID:");

        lblID.setText("Room ID:");

        btnResetAll.setText("Reset All");
        btnResetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAllActionPerformed(evt);
            }
        });

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblStatus.setText("Status: ");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Status---", "Booked", "Completed" }));

        lblTotalPayment.setText("Total:");

        lblRM.setText("RM");

        cmbRoomID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Room---" }));
        cmbRoomID.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbRoomIDPopupMenuWillBecomeVisible(evt);
            }
        });

        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        lblPaymentStatus.setText("Payment Status:");

        cmbPaymentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Payment Status--", "Paid", "Unpaid" }));

        lblMailBox.setText("Mail Box");
        lblMailBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMailBoxMouseClicked(evt);
            }
        });

        lblPrint.setText("Print");
        lblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(lblContactNumber)
                    .addComponent(lblICNumber)
                    .addComponent(lblCustomerName)
                    .addComponent(lblBookingDate))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtContactNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblCurrentDate))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtICNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCheckIn)
                                    .addComponent(lblTotalPayment)
                                    .addComponent(lblStatus)
                                    .addComponent(lblID)
                                    .addComponent(lblCheckOut))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblRM)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCalculate)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dtpCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dtpCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMailBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPaymentStatus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(lblPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnResetAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurrentDate)
                            .addComponent(lblBookingDate))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lblICNumber))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCheckOut, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCustomerName)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(txtICNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblContactNumber))
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblEmail)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblID)
                                        .addGap(57, 57, 57))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dtpCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCheckIn))
                        .addGap(17, 17, 17)
                        .addComponent(dtpCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(cmbRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRM)
                            .addComponent(btnCalculate)
                            .addComponent(lblTotalPayment))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaymentStatus)
                    .addComponent(cmbPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetAll)
                    .addComponent(btnConfirm)
                    .addComponent(btnBack)
                    .addComponent(lblMailBox, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainMenu a = new MainMenu();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnResetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetAllActionPerformed
        txtCustomerName.setText("");
        txtICNumber.setText("");
        txtContactNumber.setText("");
        txtEmail.setText("");
        cmbRoomID.setSelectedItem(false);
        cmbStatus.setSelectedItem(false);
        txtTotal.setText("");
        cmbPaymentStatus.setSelectedItem(false);

    }//GEN-LAST:event_btnResetAllActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        Booking obj1 = new Booking();

        obj1.setBookingDate(lblCurrentDate.getText());

        if (isWord(txtCustomerName.getText())) {
            obj1.setCustomerName(txtCustomerName.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Name only can consist of character", "Invalid", JOptionPane.ERROR_MESSAGE);
        }

        obj1.setICNumber(txtICNumber.getText());
        obj1.setContactNumber(txtContactNumber.getText());
        obj1.setEmail(txtEmail.getText());

        LocalDate checkIn = dtpCheckIn.getDate();
        LocalDate checkOut = dtpCheckOut.getDate();

        //verify the check in and check out date
        if (checkIn.isAfter(checkOut) || checkOut.isBefore(checkIn)) {
            JOptionPane.showMessageDialog(null, "Please make sure you select the right dates", "Invalid", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            obj1.setCheckIn(String.valueOf(checkIn));
            obj1.setCheckOut(String.valueOf(checkOut));
        }

        obj1.setRoomID(String.valueOf(cmbRoomID.getSelectedItem()));
        obj1.setStatus(String.valueOf(cmbStatus.getSelectedItem()));
        obj1.setTotal(txtTotal.getText());
        obj1.setPaymentStatus(String.valueOf(cmbPaymentStatus.getSelectedItem()));

        try {
            FileWriter fw = new FileWriter("Text File//Customer.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(obj1.getCustomerName());
            bw.write("\t");
            bw.write(obj1.getICNumber());
            bw.write("\t");
            bw.write(obj1.getContactNumber());
            bw.write("\t");
            bw.write(obj1.getEmail());
            bw.newLine();
            bw.close();

            System.out.println("Data written to the file.");
        } catch (IOException ex) {
            System.out.println("Unable to create file due to + " + ex);
        }

        //store booking details
        try {
            FileWriter fw = new FileWriter("Text File//Booking.txt", true);
            try ( BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(obj1.getBookingDate());
                bw.write("\t");
                bw.write(obj1.getCustomerName());
                bw.write("\t");
                bw.write(obj1.getICNumber());
                bw.write("\t");
                bw.write(obj1.getContactNumber());
                bw.write("\t");
                bw.write(obj1.getEmail());
                bw.write("\t");
                bw.write(obj1.getCheckIn());
                bw.write("\t");
                bw.write(obj1.getCheckOut());
                bw.write("\t");
                bw.write(String.valueOf(obj1.getRoomID()));
                bw.write("\t");
                bw.write(String.valueOf(obj1.getStatus()));
                bw.write("\t");
                bw.write(String.valueOf(obj1.getTotal()));
                bw.write("\t");
                bw.write((String.valueOf(obj1.getPaymentStatus())));
                bw.newLine();
                bw.close();
            }

            JOptionPane.showMessageDialog(null, "Add New Booking Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Data written to the file.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Fail to Add New Booking", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Unable to create file due to + " + ex);
        }

    }//GEN-LAST:event_btnConfirmActionPerformed

    @SuppressWarnings("unchecked")
    private void cmbRoomIDPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbRoomIDPopupMenuWillBecomeVisible
        LocalDate checkIn = dtpCheckIn.getDate();
        LocalDate checkOut = dtpCheckOut.getDate();

        ArrayList<String> roomList = new ArrayList<>(), availableRooms;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Text File//Rooms.txt"));
            String roomNum = br.readLine();
            while (roomNum != null) {
                roomList.add(roomNum);
                roomNum = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

        ArrayList<String> clashingBookings = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Text File//Booking.txt"));
            String clash = br.readLine();
            String[] sArray = clash.split("\t");
            while (clash != null) {
                if (!sArray[9].equals("Completed")) {
                    clashingBookings.add(clash);
                    clash = br.readLine();
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error");
        }

        if (clashingBookings.isEmpty()) {
            availableRooms = roomList;
        } else {
            ArrayList<String> bookingDate = new ArrayList<>();
            ArrayList<String> bookingCheckOut = new ArrayList<>();
            ArrayList<String> bookingCheckIn = new ArrayList<>();
            ArrayList<String> bookingRoom = new ArrayList<>();
            //split the booking values

            
            for (int i = 0; i < clashingBookings.size(); i++) {
                String[] booking = clashingBookings.get(i).split("\t");
                bookingCheckIn.add(booking[5]);
                bookingCheckOut.add(booking[6]);
                bookingDate.add(booking[0]);
            }
            
            //remove all the bookings records that check in date is before all the check in and check out date in the records
            for (String made : bookingDate) {
                for (String date : bookingCheckIn) {
                    boolean beforeIn = checkIn.isBefore(LocalDate.parse(date));
                    boolean beforeOut = checkOut.isBefore(LocalDate.parse(date));
                    if (beforeIn && beforeOut) {
                        clashingBookings.removeIf(a -> (a.contains(date) && a.contains(made)));
                    }
                }
            }
            
            //remove all the bookings records that check in date is after all the check in and check out date in the records
            for (String made : bookingDate) {
                for (String date : bookingCheckOut) {
                    boolean afterIn = checkIn.isAfter(LocalDate.parse(date));
                    boolean afterOut = checkOut.isAfter(LocalDate.parse(date));
                    if (afterIn && afterOut) {
                        clashingBookings.removeIf(a -> (a.contains(date) && a.contains(made)));
                    }
                }
            }

            //add all the relevant room num in the array list
            for (String detail : clashingBookings) {
                String[] room = detail.split("\t");
                bookingRoom.add(room[7]);
            }

            //remove all the booking room num that clashing to each other
            for (String c : bookingRoom) {
                roomList.removeIf(a -> (c.equals(a)));
            }
            availableRooms = roomList;
        }

        DefaultComboBoxModel<String> roomSelector = new DefaultComboBoxModel(availableRooms.toArray());
        cmbRoomID.setModel(roomSelector);


    }//GEN-LAST:event_cmbRoomIDPopupMenuWillBecomeVisible

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        LocalDate checkIn = dtpCheckIn.getDate();
        LocalDate checkOut = dtpCheckOut.getDate();

        double roomFees = 350;
        int tourismTax = 10;
        double serviceTax = 0.1;

        long daysBetween = ChronoUnit.DAYS.between(checkIn, checkOut);

        double sum = (daysBetween * roomFees) + (daysBetween * roomFees * serviceTax) + (daysBetween * tourismTax);

        txtTotal.setText(String.valueOf(sum));


    }//GEN-LAST:event_btnCalculateActionPerformed

    private void lblMailBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMailBoxMouseClicked
        try {
            sendEmail(txtEmail.getText());
            JOptionPane.showMessageDialog(null, "Booking Confirmation Have Been Sent Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException ex) {
            Logger.getLogger(AddNewBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblMailBoxMouseClicked

    private void lblPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintMouseClicked
        //will create a new pdf for printing purpose and it doesn't been saved in the file
        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Booking Receipt//Receipt.pdf"));
            document.open();
            document.add(new Paragraph("Java Holiday Hotel Booking Confirmation \n\n"));
            document.add(new Paragraph(
                    "Hi " + txtCustomerName.getText() + "," + "\n\n\n"
                    + "Thank you for choosing to stay with Java Holiday Hotel!"
                    + "\n\n"
                    + "Please take a look at the information below and let us know if you "
                    + "have any questions or would like to make any changes to your booking."
                    + " You can call us at 03-6653458 or simply email javaholidayhotel@gmail.com."
                    + "\n\nSee you soon at Java Holiday Hotel!"));
            document.add(new Paragraph("\n\nConfirmtaion Details\n"));

            //create table
            PdfPTable table = new PdfPTable(2);

            //table setup
            table.setWidthPercentage(105);
            table.setSpacingBefore(4f);
            table.setSpacingAfter(4f);
            float[] colWidth = {2f, 2f};
            table.setWidths(colWidth);

            //create cell
            PdfPCell c1 = new PdfPCell(new Paragraph("Booking Details"));
            PdfPCell c2 = new PdfPCell(new Paragraph("Description"));

            //add cell into table
            table.addCell(c1);
            table.addCell(c2);

            c1 = new PdfPCell(new Paragraph("Booking Date"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph(lblCurrentDate.getText()));
            table.addCell(c2);
            c1 = new PdfPCell(new Paragraph("Customer Name"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph(txtCustomerName.getText()));
            table.addCell(c2);
            c1 = new PdfPCell(new Paragraph("IC/Passport Number"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph(txtICNumber.getText()));
            table.addCell(c2);
            c1 = new PdfPCell(new Paragraph("Contact Number"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph(txtContactNumber.getText()));
            table.addCell(c2);
            c1 = new PdfPCell(new Paragraph("Email"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph(txtEmail.getText()));
            table.addCell(c2);
            c1 = new PdfPCell(new Paragraph("Check In Date"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph(dtpCheckIn.getDate().toString()));
            table.addCell(c2);
            c1 = new PdfPCell(new Paragraph("Check Out Date"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph(dtpCheckOut.getDate().toString()));
            table.addCell(c2);
            c1 = new PdfPCell(new Paragraph("Room ID"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph(cmbRoomID.getSelectedItem().toString()));
            table.addCell(c2);
            c1 = new PdfPCell(new Paragraph("Total Charges"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph("RM " + txtTotal.getText()));
            table.addCell(c2);
            c1 = new PdfPCell(new Paragraph("Payment Status"));
            table.addCell(c1);
            c2 = new PdfPCell(new Paragraph(cmbPaymentStatus.getSelectedItem().toString()));
            table.addCell(c2);

            document.add(table);
            document.close();
            writer.close();
            JOptionPane.showMessageDialog(null, "Booking Receipt Have Been Generated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException ex) {
            Logger.getLogger(AddNewBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddNewBooking.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblPrintMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewBooking().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RoomTypes;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnResetAll;
    private javax.swing.JComboBox<String> cmbPaymentStatus;
    private javax.swing.JComboBox<String> cmbRoomID;
    private javax.swing.JComboBox<String> cmbStatus;
    private com.github.lgooddatepicker.components.DatePicker dtpCheckIn;
    private com.github.lgooddatepicker.components.DatePicker dtpCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel lblBookingDate;
    private javax.swing.JLabel lblCheckIn;
    private javax.swing.JLabel lblCheckOut;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblCurrentDate;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblICNumber;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMailBox;
    private javax.swing.JLabel lblPaymentStatus;
    private javax.swing.JLabel lblPrint;
    private javax.swing.JLabel lblRM;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTotalPayment;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtICNumber;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
