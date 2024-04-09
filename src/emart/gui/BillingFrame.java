package emart.gui;

import emart.dao.OrderDAO;  // Correct import statement
import emart.dao.ProductDAO;
import emart.pojo.ProductsPojo;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//package emart.gui;
//
//import emart.dao.ProductDAO;
//import emart.pojo.ProductsPojo;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
public class BillingFrame extends javax.swing.JFrame {

    ArrayList<ProductsPojo> al = new ArrayList<ProductsPojo>();
    DefaultTableModel tm;
    double total = 0.0;

    public BillingFrame() {
        initComponents();
        //setResizable(false);
        setLocationRelativeTo(this);
        tm = (DefaultTableModel) billtable.getModel();
        txtproudctId.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtproudctId = new javax.swing.JTextField();
        btnback = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        billtable = new javax.swing.JTable();
        btnBillGenerate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Billing Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Id");

        txtproudctId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtproudctId.setText(" ");
        txtproudctId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproudctIdActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(255, 102, 0));
        btnback.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(255, 102, 0));
        Logout.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");

        billtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Name", "Product Price", "Our Price", "Product Company", "Quantity", "Tax", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(billtable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtproudctId, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtproudctId)
                    .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnBillGenerate.setBackground(new java.awt.Color(255, 102, 0));
        btnBillGenerate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBillGenerate.setForeground(new java.awt.Color(255, 255, 255));
        btnBillGenerate.setText("Generatr Bill");
        btnBillGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(600, Short.MAX_VALUE)
                .addComponent(btnBillGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(590, 590, 590))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBillGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBillGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillGenerateActionPerformed

       try {
    String orderid = OrderDAO.getNextOrderId();
    if (OrderDAO.addOrder(al, orderid) && ProductDAO.updateStocks(al)) {
        // Calculate total bill amount
        double totalBillAmount = 0.0;
        for (ProductsPojo product : al) {
            totalBillAmount += product.getTotal();
        }

        // Display bill details
        StringBuilder billDetails = new StringBuilder();
        billDetails.append("PRODUCT ID\t\tPRODUCT NAME\tQUANTITY\tPRICE\tTOTAL\n");
        for (ProductsPojo product : al) {
            billDetails.append(product.getProductId()).append("\t")
                    .append(product.getProductName()).append("\t")
                    .append(product.getQuantity()).append("\t")
                    .append(product.getOurPrice()).append("\t")
                    .append(product.getTotal()).append("\n");
        }
        billDetails.append("\nTotal Bill Amount: ").append(totalBillAmount);

        JOptionPane.showMessageDialog(null, billDetails.toString(), "Bill Details", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Order of Rs " + totalBillAmount + "/- created successfully");
        ViewOrdersFrame vs = new ViewOrdersFrame();
        vs.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Order not created");
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Database Error");
    e.printStackTrace();
}


//        //1st find orderid
//        try {
//            String orderid = OrderDAO.getNextOrderId();
//            if (OrderDAO.addOrder(al, orderid) && ProductDAO.updateStocks(al)) {
//                JOptionPane.showMessageDialog(null, "Order of Rs " + total + "/- created successfullt");
//                ViewOrdersFrame vs = new ViewOrdersFrame();
//                vs.setVisible(true);
//                this.dispose();
//            } else {
//                JOptionPane.showMessageDialog(null, "Order not created");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Database Error");
//            e.printStackTrace();
//        }
//////new comment
//    if (al.isEmpty()) {
//        JOptionPane.showMessageDialog(null, "No products added to the bill", "Error", JOptionPane.ERROR_MESSAGE);
//        return;
//    }
//    
//    // 2. Calculate the total bill amount
//    double totalBillAmount = 0.0;
//    for (ProductsPojo product : al) {
//        totalBillAmount += product.getTotal();
//    }
//
//    // 3. Display the bill in a new frame or dialog
//    StringBuilder billDetails = new StringBuilder();
//    billDetails.append("PRODUCT ID\t\tPRODUCT NAME\tQUANTITY\tPRICE\tTOTAL\n");
//    for (ProductsPojo product : al) {
//        billDetails.append(product.getProductId()).append("\t")
//                   .append(product.getProductName()).append("\t")
//                   .append(product.getQuantity()).append("\t")
//                   .append(product.getOurPrice()).append("\t")
//                   .append(product.getTotal()).append("\n");
//    }
//    billDetails.append("\nTotal Bill Amount: ").append(totalBillAmount);
//    
//    JOptionPane.showMessageDialog(null, billDetails.toString(), "Bill Details", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnBillGenerateActionPerformed

    private void txtproudctIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproudctIdActionPerformed

        if (txtproudctId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "please enter product id", "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadItemList(txtproudctId.getText().trim());

    }//GEN-LAST:event_txtproudctIdActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed

        ReceptionistOptionPanel rpp = new ReceptionistOptionPanel();
        rpp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JTable billtable;
    private javax.swing.JButton btnBillGenerate;
    private javax.swing.JButton btnback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtproudctId;
    // End of variables declaration//GEN-END:variables

    private void loadItemList(String productId) {
        try {
            ProductsPojo product = ProductDAO.getProductDetails(productId);

            if (product.getProductId() == null) {
                JOptionPane.showMessageDialog(null, "Please enter a valid product id", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if product not found
            }

            int index = getRowIndex(product.getProductId());

            if (index == -1) {
                // Product not found in the table, add a new row
                Object[] rowData = new Object[8];
                int quan = 1;
                double amt = quan * product.getOurPrice();
                product.setQuantity(quan);
                product.setTotal(amt + (amt * product.getTax() / 100));

                rowData[0] = product.getProductId(); // Set product ID
                rowData[1] = product.getProductName();
                rowData[2] = product.getProductPrice();
                rowData[3] = product.getOurPrice();
                rowData[4] = product.getProductCompany();
                rowData[5] = product.getQuantity(); // Default quantity for a new product
                rowData[6] = product.getTax(); // Set the tax
                rowData[7] = product.getTotal(); // Set the total amount including tax

                tm.addRow(rowData); // Add new row to the table model
                al.add(product);
                total += product.getTotal();
            } else {
                // Product found in the table, update quantity and total price
                int oldQuantity = (int) tm.getValueAt(index, 5);
                double amt = product.getOurPrice(); // Price without tax
                int tax = product.getTax(); // Tax percentage
                amt = amt + (amt * tax / 100); // Total amount including tax
                double existingTotal = (double) tm.getValueAt(index, 7);

                tm.setValueAt(++oldQuantity, index, 5);
                tm.setValueAt(existingTotal + amt, index, 7);
                total += amt;
                ProductsPojo existingProduct = al.get(index);
                existingProduct.setQuantity(oldQuantity);
                existingProduct.setTotal(existingTotal + amt);
                al.set(index, existingProduct);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while loading product details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getRowIndex(String productId) {
        for (int i = 0; i < tm.getRowCount(); i++) {
            if (tm.getValueAt(i, 0).equals(productId)) {
                return i; // Product found at this index
            }
        }
        return -1; // Product not found
    }

}
