/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import Models.Clothing;
import Models.DBHandler;
import Models.Footwear;
import Models.Product;
import Models.Staff;
import javax.swing.ButtonGroup;

/**
 *
 * @author Daniel Russell  22/1/2019
 */
public class FrmStaffEditProduct extends javax.swing.JFrame {

    //global attributes
    private Staff LoggedUser;
    private Product product;
    private ButtonGroup BG = new ButtonGroup();
    
    /** Creates new form FrmEditProduct */
    
    //initalises private attributes and GUI components, fills out fileds with product details
    public FrmStaffEditProduct(Staff St, Product Pro) {
        
        Clothing clothing;
        Footwear footwear;
        
        initComponents();
        
        BG.add(this.rndClothing);
        BG.add(this.rndFootwear);
        
        txtExtra.setVisible(false);
        
        LoggedUser = St;
        product = Pro;
        
        if(product.getClass().getName().equals("Models.Clothing"))
        {
         clothing = (Clothing) product;
         
        this.txtName.setText(clothing.getProductName());
        this.txtPrice.setText(Double.toString(clothing.getPrice()));
        this.txtStock.setText(Integer.toString(clothing.getStockLevel()));
        this.txtExtra.setText(clothing.getMeasurement());
        this.txtExtra.setVisible(true);
        lblExtra.setVisible(true);
        rndClothing.setSelected(true);
        rndClothing.setEnabled(false);
        rndFootwear.setEnabled(false);
        lblExtra.setText("Measurement");
        }
        else
        {
         footwear = (Footwear) product;
                
        this.txtName.setText(footwear.getProductName());
        this.txtPrice.setText(Double.toString(footwear.getPrice()));
        this.txtStock.setText(Integer.toString(footwear.getStockLevel()));
        this.txtExtra.setText(Integer.toString(footwear.getSize()));
        this.txtExtra.setVisible(true);
        lblExtra.setVisible(true);
        rndFootwear.setSelected(true);
        rndClothing.setEnabled(false);
        rndFootwear.setEnabled(false);
        lblExtra.setText("Size");
        }
            
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPrice = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnEditProduct = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        rndClothing = new javax.swing.JRadioButton();
        lblExtra = new javax.swing.JLabel();
        rndFootwear = new javax.swing.JRadioButton();
        txtExtra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEditProduct.setText("Edit Product");
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel1.setText("Type of product");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        rndClothing.setText("Clothing");
        rndClothing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rndClothingActionPerformed(evt);
            }
        });

        rndFootwear.setText("Footwear");
        rndFootwear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rndFootwearActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel3.setText("Price");

        jLabel4.setText("Stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rndClothing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rndFootwear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnEditProduct)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnClear))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                        .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtExtra, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtName)))
                                .addGap(0, 75, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rndClothing)
                    .addComponent(rndFootwear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditProduct)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //updates instance of product in database from input data
    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed

        try{

            if(this.txtName.getText().equals("") || this.txtStock.getText().equals("") || this.txtPrice.getText().equals("") || this.txtExtra.getText().equals(""))
            {

                lblError.setText("Please fill all fields");

            }
            else
            {
         
            if(this.rndClothing.isSelected() == true){
               String name = this.txtName.getText();
                double price = Double.parseDouble(this.txtPrice.getText());
                int stock = Integer.parseInt(this.txtStock.getText());
                String measurement = this.txtExtra.getText();

                DBHandler DBH = new DBHandler();
                Clothing clothing = new Clothing(measurement,product.getProductID(), name, price, stock);

                if(DBH.editProduct(clothing) == true)
                {
                    lblError.setText("Product updated");
                }
                else{
                    lblError.setText("failed to update request");
                }
         }
         else if(this.rndFootwear.isSelected() == true){
                String name = this.txtName.getText();
                double price = Double.parseDouble(this.txtPrice.getText());
                int stock = Integer.parseInt(this.txtStock.getText());
                int size = Integer.parseInt(this.txtExtra.getText());

                DBHandler DBH = new DBHandler();
                Footwear footwear = new Footwear(size,product.getProductID(), name, price, stock);

                if(DBH.editProduct(footwear) == true)
                {
                    lblError.setText("Product updated");
                }
                else{
                    lblError.setText("failed to update request");
                }
             }

            }
        }
        catch(Exception e)
        {
            lblError.setText("Error: " + e);
        }

    }//GEN-LAST:event_btnEditProductActionPerformed

    //clears all GUI components
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.txtName.setText("");
        this.txtPrice.setText("");
        this.txtStock.setText("");
        this.txtExtra.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    //navigates back to staff view product
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        FrmStaffModifyProduct newFrm = new FrmStaffModifyProduct(LoggedUser);
        this.dispose();
        newFrm.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    //radio button clothing, changes extra to measurment
    private void rndClothingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rndClothingActionPerformed
        lblExtra.setText("Measurment");
        lblExtra.setVisible(true);
        txtExtra.setVisible(true);
    }//GEN-LAST:event_rndClothingActionPerformed

    //radio button footwear, changes extra to size
    private void rndFootwearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rndFootwearActionPerformed
        lblExtra.setText("Size");
        lblExtra.setVisible(true);
        txtExtra.setVisible(true);
    }//GEN-LAST:event_rndFootwearActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmStaffEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmStaffEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmStaffEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmStaffEditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FrmStaffEditProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblExtra;
    private javax.swing.JRadioButton rndClothing;
    private javax.swing.JRadioButton rndFootwear;
    private javax.swing.JTextField txtExtra;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

}
