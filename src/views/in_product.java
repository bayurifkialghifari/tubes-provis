/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.products;
import model.purchases;

/**
 *
 * @author mac
 */
public class in_product extends javax.swing.JInternalFrame {

    // Action state
    public String action;
    public String search, id, nama, harga, stok;
    
    // Import model
    public products prod = new products();
    public purchases purch = new purchases();
    public CachedRowSet crs;
    
    public in_product() {
        initComponents();
        initComponents();
        
        this.setSize(855, 750);
        
        // Change table name
        this.prod.change_table();
        this.purch.change_table();
        
        // Show all data
        try {
            this.showData(null, null);
        } catch (Exception ex) {
            System.out.println("Show data ERROR");
        }
        
        // Search all default
        this.byall.setSelected(true);
        
        // Hide action panel
        this.action_panel.setVisible(false);
    }
    
    
    // Show all data
    public void showData(String[] where_field, String where) throws Exception {
        if(where_field == null) {
            // Get all data from database
            this.crs = this.purch.select_join_all("*", "left join product on product.prod_id = purchase.pruch_prod_id");
        } else {
            // Where like
            String like = " ";
            
            // Set field name           
            for(int i = 0; i < where_field.length;i++)
            {
                if(i == 0)
                    like += where_field[i] + " like '%"+ where +"%' ";
                else
                    like += " or "+ where_field[i] + " like '%"+ where +"%' ";
            }
            
            // Get data with condition from database
            this.crs = this.purch.select_join_like("*", "left join product on product.prod_id = purchase.pruch_prod_id", like);
        }
        
        // Create table instance
        DefaultTableModel newtable = (DefaultTableModel) table.getModel();
        // Clear the table
        newtable.setRowCount(0);
       
        // Print the data       
        while(this.crs.next()) {
            newtable.addRow(new Object[]{
                this.crs.getString("pruch_code"), 
                this.crs.getString("prod_name"),  
                this.crs.getString("pruch_qty"),
                this.crs.getString("purch_total"),
                this.crs.getString("purch_date"),
            });
        }
    }
    
    // Create data
    public void create() {
        this.harga = this.fprice.getText();
        this.stok = this.ftotal.getText();
        
        // Insert data to database
        String [] field = {"prod_name", "prod_price", "prod_qty"};
        String [] data = {this.nama, this.harga, this.stok};
        
        this.prod.insert(field, data);
        
        try {
            this.showData(null, null);
            this.clearField();
            
            JOptionPane.showMessageDialog(this, "Data berhasil dibuat !");
            
            // Hide action panel
            this.action_panel.setVisible(false);
        } catch (Exception ex) {
            System.out.println("Show data ERROR");
        }
    }
    
    // Update data
    public void update() {
        this.id = this.fcode.getText();
        this.harga = this.fprice.getText();
        this.stok = this.ftotal.getText();
        
        // Insert data to database
        String [] field = {"prod_name", "prod_price", "prod_qty"};
        String [] data = {this.nama, this.harga, this.stok};
        
        this.prod.update(field, data, "prod_id", this.id);
        
        try {
            this.showData(null, null);
            this.clearField();
            
            JOptionPane.showMessageDialog(this, "Data berhasil diubah !");
            
            // Hide action panel
            this.action_panel.setVisible(false);
        } catch (Exception ex) {
            System.out.println("Show data ERROR");
        }
    }
    
    // Delete data
    public void delete() {
        this.prod.delete("prod_id", this.id);
        
        try {
            this.showData(null, null);
            this.clearField();
            
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus !");
            
            // Hide action panel
            this.action_panel.setVisible(false);
        } catch (Exception ex) {
            System.out.println("Show data ERROR");
        }
    }
    
    // Set selected data from table to field
    public void setSelectedData() {
        // Get data
        int[] selectedRow = table.getSelectedRows();
        int selectedColumns = 4;
        
        for (int i = 0; i < selectedRow.length; i++) {
            for (int j = 0; j < selectedColumns; j++) {
                
            }
        }
    }
    
    // Reset field
    public void clearField() {
        this.fsearch.setText("");
        this.fcode.setText("");
        this.fprice.setText("");
        this.ftotal.setText("");
        this.fqty.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fsearch = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        byall = new javax.swing.JRadioButton();
        bycode = new javax.swing.JRadioButton();
        byprod = new javax.swing.JRadioButton();
        byqty = new javax.swing.JRadioButton();
        bydate = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        add_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        action_panel = new javax.swing.JPanel();
        lkode = new javax.swing.JLabel();
        fcode = new javax.swing.JTextField();
        lnama = new javax.swing.JLabel();
        lharga = new javax.swing.JLabel();
        fprice = new javax.swing.JTextField();
        lqty = new javax.swing.JLabel();
        ftotal = new javax.swing.JTextField();
        save_btn = new javax.swing.JButton();
        reset_btn = new javax.swing.JButton();
        lsave = new javax.swing.JLabel();
        ltotal = new javax.swing.JLabel();
        fqty = new javax.swing.JTextField();
        fprod = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Pembelian");

        search_btn.setText("Cari");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });

        jLabel2.setText("Pencarian Berdasarkan");

        byall.setText("Semua");

        bycode.setText("Kode");

        byprod.setText("Product");

        byqty.setText("Qty");

        bydate.setText("Tanggal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refresh_btn))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(byall)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bycode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(byprod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(byqty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bydate)))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refresh_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(byall)
                    .addComponent(bycode)
                    .addComponent(byprod)
                    .addComponent(byqty)
                    .addComponent(bydate))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Produk", "Qty", "Total", "Tanggal"
            }
        ));
        jScrollPane1.setViewportView(table);

        add_btn.setText("Tambah");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        update_btn.setText("Ubah");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setText("Hapus");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn)
                    .addComponent(update_btn)
                    .addComponent(delete_btn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lkode.setText("Kode");

        fcode.setEditable(false);

        lnama.setText("Product");

        lharga.setText("Harga");

        fprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fpriceKeyTyped(evt);
            }
        });

        lqty.setText("Qty");

        ftotal.setEditable(false);
        ftotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftotalKeyTyped(evt);
            }
        });

        save_btn.setText("Simpan");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        reset_btn.setText("Reset");
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });

        lsave.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lsave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lsave.setText("jLabel2");

        ltotal.setText("Total");

        fqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fqtyKeyTyped(evt);
            }
        });

        fprod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout action_panelLayout = new javax.swing.GroupLayout(action_panel);
        action_panel.setLayout(action_panelLayout);
        action_panelLayout.setHorizontalGroup(
            action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(action_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(action_panelLayout.createSequentialGroup()
                        .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(action_panelLayout.createSequentialGroup()
                                .addComponent(lkode)
                                .addGap(50, 50, 50)
                                .addComponent(fcode, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, action_panelLayout.createSequentialGroup()
                                .addComponent(lqty)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, action_panelLayout.createSequentialGroup()
                                        .addComponent(reset_btn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(save_btn))
                                    .addComponent(ftotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fqty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, action_panelLayout.createSequentialGroup()
                                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lharga)
                                    .addComponent(lnama))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fprice, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(fprod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lsave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ltotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        action_panelLayout.setVerticalGroup(
            action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(action_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(action_panelLayout.createSequentialGroup()
                        .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lkode)
                            .addComponent(fcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lnama)
                            .addComponent(fprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lharga)
                            .addComponent(fprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lqty)
                            .addComponent(fqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addComponent(lsave, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ltotal)
                    .addComponent(ftotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_btn)
                    .addComponent(save_btn))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addComponent(action_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(action_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        try {
            String field [] = new String[this.byall.isSelected() ? 4 : 1];

            // Search by code
            if (this.bycode.isSelected()) {
                field[0] = "pruch_code";
                // Search by product
            } else if (this.byprod.isSelected()) {
                field[0] = "prod_name";
                // Search by qty
            } else if (this.byqty.isSelected()) {
                field[0] = "pruch_qty";
                // Search by date
            } else if (this.bydate.isSelected()) {
                field[0] = "purch_date";
                // Search all default
            } else {
                field[0] = "pruch_code";
                field[1] = "prod_name";
                field[2] = "pruch_qty";
                field[3] = "purch_date";
            }

            String where = this.fsearch.getText();

            this.showData(field, where);
        } catch (Exception ex) {
            System.out.println("Show data ERROR");
        }
    }//GEN-LAST:event_search_btnActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        try {
            this.showData(null, null);
        } catch (Exception ex) {
            System.out.println("Show data ERROR");
        }
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        this.action = "create";
        this.lsave.setText("Buat pembelian baru");

        // Show action panel
        this.action_panel.setVisible(true);
    }//GEN-LAST:event_add_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // Get select row
        int[] selectedRow = table.getSelectedRows();

        // If row selected
        if (selectedRow.length > 0) {
            this.action = "update";
            this.setSelectedData();
            this.lsave.setText("Update pembelian");

            // Show action panel
            this.action_panel.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah terlebih dahulu !");
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // Get select row
        int[] selectedRow = table.getSelectedRows();

        // If row selected
        if (selectedRow.length > 0) {
            int confirmBtn = JOptionPane.YES_NO_OPTION;
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus data ini?", "Peringatan", confirmBtn);

            if(confirm == 0) {
                this.setSelectedData();
                this.delete();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus terlebih dahulu !");
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void fpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fpriceKeyTyped
        char c = evt.getKeyChar();

        if(!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_fpriceKeyTyped

    private void ftotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftotalKeyTyped
        char c = evt.getKeyChar();

        if(!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_ftotalKeyTyped

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        switch(this.action) {
            case "create" :
            this.create();
            break;
            case "update" :
            this.update();
            break;
        }
    }//GEN-LAST:event_save_btnActionPerformed

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        this.clearField();
    }//GEN-LAST:event_reset_btnActionPerformed

    private void fqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fqtyKeyTyped
        char c = evt.getKeyChar();

        if(!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_fqtyKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel action_panel;
    private javax.swing.JButton add_btn;
    private javax.swing.JRadioButton byall;
    private javax.swing.JRadioButton bycode;
    private javax.swing.JRadioButton bydate;
    private javax.swing.JRadioButton byprod;
    private javax.swing.JRadioButton byqty;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField fcode;
    private javax.swing.JTextField fprice;
    private javax.swing.JComboBox<String> fprod;
    private javax.swing.JTextField fqty;
    private javax.swing.JTextField fsearch;
    private javax.swing.JTextField ftotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lharga;
    private javax.swing.JLabel lkode;
    private javax.swing.JLabel lnama;
    private javax.swing.JLabel lqty;
    private javax.swing.JLabel lsave;
    private javax.swing.JLabel ltotal;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JButton reset_btn;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton search_btn;
    private javax.swing.JTable table;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
