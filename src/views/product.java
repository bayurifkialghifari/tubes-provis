/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import java.awt.event.KeyEvent;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.products;

/**
 *
 * @author mac
 */
public class product extends javax.swing.JInternalFrame {

    // Action state
    public String action;
    public String search, id, nama, harga, stok;
    
    // Import model
    public products prod = new products();
    public CachedRowSet crs;
    
    public product() {
        initComponents();
        
        this.setSize(855, 750);
        
        // Change table name
        this.prod.change_table();
        
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
            this.crs = this.prod.all();
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
            this.crs = this.prod.select_like("*", like);
        }
        
        // Create table instance
        DefaultTableModel newtable = (DefaultTableModel) table.getModel();
        // Clear the table
        newtable.setRowCount(0);
       
        // Print the data       
        while(this.crs.next()) {
            newtable.addRow(new Object[]{
                this.crs.getString("prod_id"), 
                this.crs.getString("prod_name"),  
                this.crs.getString("prod_price"),
                this.crs.getString("prod_qty"),
            });
        }
    }
    
    // Create data
    public void create() {
        this.nama = this.fnama.getText();
        this.harga = this.fharga.getText();
        this.stok = this.fstok.getText();
        
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
        this.id = this.fid.getText();
        this.nama = this.fnama.getText();
        this.harga = this.fharga.getText();
        this.stok = this.fstok.getText();
        
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
                
                if(j == 0) {
                    this.id = (String) table.getValueAt(selectedRow[i], j);
                    this.fid.setText(this.id);
                
                } else if (j == 1) {
                    this.nama = (String) table.getValueAt(selectedRow[i], j);
                    this.fnama.setText(this.nama);
                
                } else if (j == 2) {
                    this.harga = (String) table.getValueAt(selectedRow[i], j);
                    this.fharga.setText(this.harga);
                
                } else if (j == 3) {
                    this.stok = (String) table.getValueAt(selectedRow[i], j);
                    this.fstok.setText(this.stok);
                }
            }
        }
    }
    
    // Reset field
    public void clearField() {
        this.fsearch.setText("");
        this.fid.setText("");
        this.fnama.setText("");
        this.fharga.setText("");
        this.fstok.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search_group = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        fsearch = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        byall = new javax.swing.JRadioButton();
        byid = new javax.swing.JRadioButton();
        bynama = new javax.swing.JRadioButton();
        byharga = new javax.swing.JRadioButton();
        bystok = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        add_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        action_panel = new javax.swing.JPanel();
        lid = new javax.swing.JLabel();
        fid = new javax.swing.JTextField();
        lnama = new javax.swing.JLabel();
        fnama = new javax.swing.JTextField();
        lharga = new javax.swing.JLabel();
        fharga = new javax.swing.JTextField();
        lstok = new javax.swing.JLabel();
        fstok = new javax.swing.JTextField();
        save_btn = new javax.swing.JButton();
        reset_btn = new javax.swing.JButton();
        lsave = new javax.swing.JLabel();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama", "Harga", "Stok"
            }
        ));
        jScrollPane1.setViewportView(table);

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

        search_group.add(byall);
        byall.setText("Semua");

        search_group.add(byid);
        byid.setText("Id");

        search_group.add(bynama);
        bynama.setText("Nama");

        search_group.add(byharga);
        byharga.setText("Harga");

        search_group.add(bystok);
        bystok.setText("Stok");

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
                        .addComponent(byid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bynama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(byharga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bystok)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(byid)
                    .addComponent(bynama)
                    .addComponent(byharga)
                    .addComponent(bystok))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Produk");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        lid.setText("ID");

        fid.setEditable(false);

        lnama.setText("Nama");

        lharga.setText("Harga");

        fharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fhargaKeyTyped(evt);
            }
        });

        lstok.setText("Stok");

        fstok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fstokKeyTyped(evt);
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

        javax.swing.GroupLayout action_panelLayout = new javax.swing.GroupLayout(action_panel);
        action_panel.setLayout(action_panelLayout);
        action_panelLayout.setHorizontalGroup(
            action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(action_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(action_panelLayout.createSequentialGroup()
                        .addComponent(reset_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save_btn))
                    .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(action_panelLayout.createSequentialGroup()
                            .addComponent(lid)
                            .addGap(50, 50, 50)
                            .addComponent(fid, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(action_panelLayout.createSequentialGroup()
                            .addComponent(lnama)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fnama, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(action_panelLayout.createSequentialGroup()
                            .addComponent(lharga)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fharga, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(action_panelLayout.createSequentialGroup()
                            .addComponent(lstok)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fstok, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lsave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        action_panelLayout.setVerticalGroup(
            action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(action_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(action_panelLayout.createSequentialGroup()
                        .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lid)
                            .addComponent(fid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lharga)
                            .addComponent(fharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lstok)
                            .addComponent(fstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lsave, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(action_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn)
                    .addComponent(reset_btn))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(action_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(action_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        this.action = "create";
        this.lid.setVisible(false);
        this.fid.setVisible(false);
        this.lsave.setText("Buat produk baru");
        
        // Show action panel
        this.action_panel.setVisible(true);
    }//GEN-LAST:event_add_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // Get select row        
        int[] selectedRow = table.getSelectedRows();
        
        // If row selected
        if (selectedRow.length > 0) {
            this.action = "update";
            this.lid.setVisible(true);
            this.fid.setVisible(true);
            this.setSelectedData();
            this.lsave.setText("Update produk");
            
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

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        this.clearField();
    }//GEN-LAST:event_reset_btnActionPerformed

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

    private void fhargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fhargaKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_fhargaKeyTyped

    private void fstokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fstokKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_fstokKeyTyped

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        try {
            this.showData(null, null);
        } catch (Exception ex) {
            System.out.println("Show data ERROR");
        }
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        try {
            String field [] = new String[this.byall.isSelected() ? 4 : 1];
            
            // Search by id
            if (this.byid.isSelected()) {
                field[0] = "prod_id";
            // Search by name
            } else if (this.bynama.isSelected()) {
                field[0] = "prod_name";
            // Search by harga
            } else if (this.byharga.isSelected()) {
                field[0] = "prod_price";
            // Search by Stok
            } else if (this.bystok.isSelected()) {
                field[0] = "prod_qty";
            // Search all default
            } else {
                field[0] = "prod_id";
                field[1] = "prod_name";
                field[2] = "prod_price";
                field[3] = "prod_qty";
            }
            
            String where = this.fsearch.getText();
        
            this.showData(field, where);
        } catch (Exception ex) {
            System.out.println("Show data ERROR");
        }
    }//GEN-LAST:event_search_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel action_panel;
    private javax.swing.JButton add_btn;
    private javax.swing.JRadioButton byall;
    private javax.swing.JRadioButton byharga;
    private javax.swing.JRadioButton byid;
    private javax.swing.JRadioButton bynama;
    private javax.swing.JRadioButton bystok;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField fharga;
    private javax.swing.JTextField fid;
    private javax.swing.JTextField fnama;
    private javax.swing.JTextField fsearch;
    private javax.swing.JTextField fstok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lharga;
    private javax.swing.JLabel lid;
    private javax.swing.JLabel lnama;
    private javax.swing.JLabel lsave;
    private javax.swing.JLabel lstok;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JButton reset_btn;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton search_btn;
    private javax.swing.ButtonGroup search_group;
    private javax.swing.JTable table;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
