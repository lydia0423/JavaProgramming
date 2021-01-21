package hotelmanagementsystem;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class BookingManagement extends javax.swing.JFrame {
    public BookingManagement() throws FileNotFoundException {
        initComponents();
        
        txtCustomerName.setEditable(false);
        
        //set up label background color
        jLabel1.setOpaque(true);
        Color purpleColor = new Color(36, 0, 46);
        jLabel1.setBackground(purpleColor);
        
        String filePath = "Text File//Booking.txt";
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));
        DefaultTableModel model = (DefaultTableModel)tblBooking.getModel();
        Object[] tableLines = br.lines().toArray();

        for(int i = 0; i < tableLines.length; i++){
            String line = tableLines[i].toString().trim();
            String[] dataRow = line.split("\t");
            model.addRow(dataRow); 
        }
        
        scaleImage();
    }
    
    private void scaleImage(){
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
    
    public void sendEmail(String recepient) throws MessagingException{
        System.out.println("Preparing to send enmail!");
        Properties properties = new Properties();
        
        //always require username and password to authenticate the account
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "leeyi08248@gmail.com";
        String password = "l-842808";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
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
            message.setSubject("Booking Update Confirmation");
            message.setText(
                    "Hi " + txtCustomerName.getText() + "\n\n\n" +
                    "Thank you for choosing to stay with Java Holiday Hotel!" +
                    "\n\n" +
                    "Please take a look at the information below and let us know if you "
                    + "have any questions or would like to make any changes to your booking."
                    + " You can call us at 03-6653458 or simply email javaholidayhotel@gmail.com." +
                    "\n\nSee you soon at Java Holiday Hotel!" +
                    "\n\n\n\n" +
                    "Booking Date: " + lblCurrentDate.getText() +
                    "\nCustomer Name: " + txtCustomerName.getText() +
                    "IC/Passport Number: " + txtICNumber.getText() +
                    "\nContact Number: " + txtContactNumber.getText() +
                    "\nEmail: " + txtEmail.getText() +
                    "\nCheck In Date: " + dtpCheckIn.getDate().toString() +
                    "\nCheck Out Date: " + dtpCheckOut.getDate().toString() + 
                    "\nRoom ID: " + cmbRoomID.getSelectedItem() +
                    "\nTotal Charges: " + "RM " + txtTotal.getText() + 
                    "\nPayment Status: " + cmbPaymentStatus.getSelectedItem());
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(AddNewBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooking = new javax.swing.JTable();
        lblCheckOut = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        txtICNumber = new javax.swing.JTextField();
        cmbRoomID = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblCurrentDate = new javax.swing.JLabel();
        lblBookingDate = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblICNumber = new javax.swing.JLabel();
        lblContactNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCheckIn = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        lblTotalPayment = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dtpCheckIn = new com.github.lgooddatepicker.components.DatePicker();
        dtpCheckOut = new com.github.lgooddatepicker.components.DatePicker();
        lblPaymentStatus = new javax.swing.JLabel();
        cmbPaymentStatus = new javax.swing.JComboBox<>();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblMailBox = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        lblPrint = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booking Management");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotelmanagementsystem/cartoon-background-hotel-reception-flyer-ad-poster-banner-with-arab-family_33099-900.jpg"))); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 102));

        tblBooking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking Date", "Customer Name", "IC/Passport Number", "Contact Number", "Email", "Check In", "Check Out", "Room ID", "Status", "Total", "Payment Status"
            }
        ));
        tblBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBooking);

        lblCheckOut.setText("Check Out:");

        cmbRoomID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Room---", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210" }));
        cmbRoomID.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbRoomIDPopupMenuWillBecomeVisible(evt);
            }
        });

        lblID.setText("Room ID:");

        lblCurrentDate.setText("Booking");

        lblBookingDate.setText("Booking Date:");

        lblCustomerName.setText("Customer Name: ");

        lblICNumber.setText("IC/ Passport Number: ");

        lblContactNumber.setText("Contact Number: ");

        lblEmail.setText("Email: ");

        lblCheckIn.setText("Check In:");

        lblStatus.setText("Status: ");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Status---", "Booked", "Completed" }));

        lblTotalPayment.setText("Total:");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setText("RM");

        lblPaymentStatus.setText("Payment Status:");

        cmbPaymentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Payment Status--", "Paid", "Unpaid" }));

        lblSearch.setText("Search: ");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblMailBox.setText("Mail Box");
        lblMailBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMailBoxMouseClicked(evt);
            }
        });

        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        lblPrint.setText("Print");
        lblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintMouseClicked(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(lblContactNumber)
                            .addComponent(lblICNumber)
                            .addComponent(lblCustomerName)
                            .addComponent(lblBookingDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtICNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(lblCurrentDate)))
                            .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPaymentStatus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 31, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnBack)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMailBox, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCheckOut)
                                        .addGap(13, 13, 13)
                                        .addComponent(dtpCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblID)
                                            .addComponent(lblStatus))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTotalPayment)
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCalculate))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCheckIn)
                                        .addGap(26, 26, 26)
                                        .addComponent(dtpCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(lblSearch)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dtpCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCheckIn))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dtpCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCheckOut))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtICNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblContactNumber))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail)
                                    .addComponent(lblTotalPayment)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalculate)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblID)
                                    .addComponent(cmbRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblStatus)
                                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPaymentStatus)
                                    .addComponent(cmbPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(53, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 22, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnDelete)
                                    .addComponent(lblMailBox, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBack)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurrentDate)
                            .addComponent(lblBookingDate))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomerName)
                            .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(lblICNumber)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblBooking.getModel();
        
        int selectedRowIndex = tblBooking.getSelectedRow();
        model.removeRow(selectedRowIndex);
        
        String filePath = "Text File//Booking.txt";
        String customerNameInput = txtCustomerName.getText();
        String roomIDInput = String.valueOf(cmbRoomID.getSelectedItem());
        String tempFile = "Text File//temp.txt";
        
        String currentDate = ""; String customerName = ""; String ICNumber = "";
        String contactNumber = ""; String email = ""; String checkIn = "";
        String checkOut = ""; String roomID = ""; String status = "";
        String total = ""; String paymentStatus = "";
        
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        
        try{
            FileWriter fw = new FileWriter("Text File//temp.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner inputFile = new Scanner(new File(filePath));
            inputFile.useDelimiter("[\t\n]");
            
            if(inputFile.hasNext()){
                currentDate = inputFile.next();
                customerName = inputFile.next();
                ICNumber = inputFile.next();
                contactNumber = inputFile.next();
                email = inputFile.next();
                checkIn = inputFile.next();
                checkOut = inputFile.next();
                roomID = inputFile.next();
                status = inputFile.next();
                total = inputFile.next();
                
                if(!(customerName.equals(customerNameInput) && roomID.equals(roomIDInput) && status.equals("Booked"))){
                    pw.println(currentDate + "\t" + customerName + "\t" + ICNumber + "\t" + contactNumber + "\t" + email 
                            + "\t" + checkIn + "\t" + checkOut + "\t" + roomID + "\t" + status + "\t" + total + "\t" + paymentStatus);
                }JOptionPane.showMessageDialog(null,"Delete Booking Successfully", "Success",JOptionPane.INFORMATION_MESSAGE); 
            }
            
            inputFile.close();
            pw.flush();
            pw.close();
            
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
            
        }catch(FileNotFoundException e){
            System.out.println("Error");
        }catch (IOException ex) {
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblBookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookingMouseClicked
        int i = tblBooking.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)tblBooking.getModel();
        lblCurrentDate.setText(model.getValueAt(i, 0).toString());
        txtCustomerName.setText(model.getValueAt(i, 1).toString());
        txtICNumber.setText(model.getValueAt(i, 2).toString());
        txtContactNumber.setText(model.getValueAt(i, 3).toString());
        txtEmail.setText(model.getValueAt(i, 4).toString());
        dtpCheckIn.setDate(LocalDate.parse((String)model.getValueAt(i, 5)));
        dtpCheckOut.setDate(LocalDate.parse((String)model.getValueAt(i, 6)));
        cmbRoomID.setSelectedItem(model.getValueAt(i, 7).toString());
        cmbStatus.setSelectedItem(model.getValueAt(i, 8).toString());
        txtTotal.setText(model.getValueAt(i, 9).toString());
        cmbPaymentStatus.setSelectedItem(model.getValueAt(i, 10).toString());

    }//GEN-LAST:event_tblBookingMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String filePath = "Text File//Booking.txt";
        String currentDateInput = lblCurrentDate.getText();
        String customerNameInput = txtCustomerName.getText();
        String newICNumberInput = txtICNumber.getText();
        String newContactNumberInput = txtContactNumber.getText();
        String newEmailInput = txtEmail.getText();
        String newCheckInInput =  String.valueOf(dtpCheckIn.getDate());
        String newCheckOutInput =  String.valueOf(dtpCheckOut.getDate());
        String newRoomIDInput = cmbRoomID.getSelectedItem().toString();
        String newStatusInput = cmbStatus.getSelectedItem().toString();
        String newTotalInput = txtTotal.getText();
        String newPaymentStatusInput = cmbPaymentStatus.getSelectedItem().toString();
        String tempFile = "Text File//temp.txt";
        
        String currentDate = ""; String customerName = ""; String ICNumber = "";
        String contactNumber = ""; String email = ""; String checkIn = "";
        String checkOut = ""; String roomID = ""; String status = "";
        String total = ""; String paymentStatus = "";
        
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        
        try{
            FileWriter fw = new FileWriter("Text File//temp.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner inputFile = new Scanner(new File(filePath));
            inputFile.useDelimiter("[\t\n]");
            
            if(inputFile.hasNext()){
                currentDate = inputFile.next();
                customerName = inputFile.next();
                ICNumber = inputFile.next();
                contactNumber = inputFile.next();
                email = inputFile.next();
                checkIn = inputFile.next();
                checkOut = inputFile.next();
                roomID = inputFile.next();
                status = inputFile.next();
                total = inputFile.next();
                paymentStatus = inputFile.next();
                
                if(currentDate.equals(currentDateInput) && customerName.equals(customerNameInput)){
                    pw.println(currentDate + "\t" + customerName + "\t" + newICNumberInput + "\t" + newContactNumberInput + "\t" + newEmailInput 
                            + "\t" + newCheckInInput + "\t" + newCheckOutInput + "\t" + newRoomIDInput + "\t" + newStatusInput 
                            + "\t" + newTotalInput + "\t" + newPaymentStatusInput );
                    JOptionPane.showMessageDialog(null,"Update Booking Successfully", "Success",JOptionPane.INFORMATION_MESSAGE); 
                }else{
                    pw.println(currentDate + "\t" + customerName + "\t" + ICNumber + "\t" + contactNumber + "\t" + email 
                            + "\t" + checkIn + "\t" + checkOut + "\t" + roomID + "\t" + status + "\t" + total + "\t" + paymentStatus);
                }
            }
            
            inputFile.close();
            pw.flush();
            pw.close();
            
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
            
        }catch(FileNotFoundException e){
            System.out.println("Error");
        }catch (IOException ex) {
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel)tblBooking.getModel();
        String search = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tblBooking.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        LocalDate checkIn = dtpCheckIn.getDate();
        LocalDate checkOut = dtpCheckOut.getDate();
        
        double roomFees = 350;
        int tourismTax = 10;
        double serviceTax = 0.1;
        
        long daysBetween = ChronoUnit.DAYS.between(checkIn,checkOut);
        
        double sum = (daysBetween * roomFees) + (daysBetween * roomFees * serviceTax) + (daysBetween * tourismTax);
        
        txtTotal.setText(String.valueOf(sum));
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void lblMailBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMailBoxMouseClicked
        try {
            sendEmail(txtEmail.getText());
            JOptionPane.showMessageDialog(null, "Booking Update Confirmation Have Been Sent Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
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
                "Hi " + txtCustomerName.getText() + ","+ "\n\n\n" +
                "Thank you for choosing to stay with Java Holiday Hotel!" +
                "\n\n" +
                "Please take a look at the information below and let us know if you "
                + "have any questions or would like to make any changes to your booking."
                + " You can call us at 03-6653458 or simply email javaholidayhotel@gmail.com." +
                "\n\nSee you soon at Java Holiday Hotel!"));
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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainMenu a = new MainMenu();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed
    
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
        
        if (clashingBookings.isEmpty()){
            availableRooms = roomList;
        }else{
            ArrayList<String> bookingCheckOut = new ArrayList<>();
                ArrayList<String> bookingRoom = new ArrayList<>();
                //split the booking values
                
                    //remove all the bookings records that check in date is before all the check in and check out date in the records
                    for(String detail : clashingBookings){
                         String[] booking = detail.split("\t");
                         bookingCheckOut.add(booking[6]);
                         clashingBookings.removeIf(a->(checkIn.isBefore(LocalDate.parse(booking[5])) && checkOut.isBefore(LocalDate.parse(booking[5]))));
                    }
                    
                    //remove all the bookings records that check in date is after all the check in and check out date in the records
                    for(String date:bookingCheckOut){
                         clashingBookings.removeIf(a -> (checkIn.isAfter(LocalDate.parse(date)) && checkOut.isAfter(LocalDate.parse(date))));
                    }
                    
                    //add all the relevant room num in the array list
                    for(String detail:clashingBookings){
                        String[] room = detail.split("\t");
                        bookingRoom.add(room[7]);
                    }           
                    
                    //remove all the booking room num that clashing to each other
                    for(String c : bookingRoom){
                        roomList.removeIf(a->(c.equals(a)));
                    }
            availableRooms = roomList;
        }

        DefaultComboBoxModel<String> roomSelector = new DefaultComboBoxModel(availableRooms.toArray());
        cmbRoomID.setModel(roomSelector);

    }//GEN-LAST:event_cmbRoomIDPopupMenuWillBecomeVisible

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BookingManagement().setVisible(true);
                } catch (FileNotFoundException ex) {
                    java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbPaymentStatus;
    private javax.swing.JComboBox<String> cmbRoomID;
    private javax.swing.JComboBox<String> cmbStatus;
    private com.github.lgooddatepicker.components.DatePicker dtpCheckIn;
    private com.github.lgooddatepicker.components.DatePicker dtpCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTotalPayment;
    private javax.swing.JTable tblBooking;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtICNumber;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
