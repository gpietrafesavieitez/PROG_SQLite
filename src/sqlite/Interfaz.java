package sqlite;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Interfaz extends javax.swing.JFrame {
    
    SQLite bd;
    ResultSet rs;
    
    public Interfaz(){
        bd = new SQLite();
        if(bd.conectar()){
            System.out.println("[ info ] Conexión satisfactoria.");
            rs = bd.mostrar();
            initComponents();
        }else{
            JOptionPane.showMessageDialog(null, "Error de conexión.", "SQLite", 0);
            System.out.println("[ error ] No se ha podido establecer una conexión con la base de datos.");
            System.exit(0);
        }
    }
    
    public void refrescarTabla(){
        try{
            jTable1.setModel(DbUtils.resultSetToTableModel(bd.mostrar()));
        }catch(Exception e){
            System.out.println("[ error ] " + e.getMessage());
        }    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SQLite");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        try{
            while(rs.next()){
                Object[] fila = new Object[3];
                for(int i = 0; i < 3; i ++){
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        }catch(Exception e){
            System.out.println("[ error ]" + e.getMessage());
        }
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 204));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            Object o = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            int op = JOptionPane.showConfirmDialog(null,"¿Está seguro/a?","SQLite",JOptionPane.YES_NO_OPTION);
            if(op == 0){
                int f = bd.eliminar(o);
                if(f > 0){
                    JOptionPane.showMessageDialog(null,"Entrada eliminada satisfactoriamente.","SQLite",1);
                    System.out.println("[ info ] " + f + " fila(s) afectada(s)");
                }else{
                    JOptionPane.showMessageDialog(null,"No se ha podido eliminar.","SQLite",0);
                    System.out.println("[ error ] No se ha podido borrar.");
                }
                refrescarTabla();
            }
        }catch(ArrayIndexOutOfBoundsException e1){
            JOptionPane.showMessageDialog(null,"Seleccione la entrada que desea eliminar.","SQLite",2);
            System.out.println("[ error ] " + e1.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            int f = bd.modificar(jTable1.getValueAt(jTable1.getSelectedRow(), 0), jTable1.getValueAt(jTable1.getSelectedRow(), 1), jTable1.getValueAt(jTable1.getSelectedRow(), 2));
            if(f > 0){
                JOptionPane.showMessageDialog(null,"Entrada modificada satisfactoriamente.","SQLite",1);
                System.out.println("[ info ] " + f + " fila(s) afectada(s)");
            }else{
                JOptionPane.showMessageDialog(null,"No se ha podido modificar.","SQLite",0);
                System.out.println("[ error ] No se ha podido modificar.");
            }
            refrescarTabla();
        }catch(ArrayIndexOutOfBoundsException e1){
            JOptionPane.showMessageDialog(null,"Seleccione la entrada que desea modificar.","SQLite",2);
            System.out.println("[ error ] " + e1.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el ID:","SQLite",3));
            String nombre = JOptionPane.showInputDialog(null,"Introduzca el nombre:","SQLite",3);
            String apellido = JOptionPane.showInputDialog(null,"Introduzca el apellido:");
            int f = bd.insertar(id,nombre,apellido);
            if(f > 0){
                JOptionPane.showMessageDialog(null,"Entrada insertada satisfactoriamente.","SQLite",1);
                System.out.println("[ info ] " + f + " fila(s) afectada(s)");
                refrescarTabla();
            }else{
                JOptionPane.showMessageDialog(null,"No se ha podido crear una entrada nueva.","SQLite",0);
                System.out.println("[ error ] No se ha podido insertar.");
            }
        }catch(NumberFormatException e1){
            JOptionPane.showMessageDialog(null,"Formato incorrecto.","SQLite",2);
            System.out.println("[ error ] " + e1.getMessage());
        }catch(Exception e){
            System.out.println("[ error ] " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(bd.desconectar()){
            System.out.println("[ info ] Desconexión satisfactoria.");
        }else{
            System.out.println("[ error ] Ha habido problemas en la desconexión.");
        }
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]){
        System.out.println("Debug console:");
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
