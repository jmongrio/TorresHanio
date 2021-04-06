package juego.torrehanoi;

import javax.swing.*;
import javax.swing.table.*;

public class VentanaPrincipal extends javax.swing.JFrame {

    int contadorNumeroMoviemiento = 0;
    Pila pilaTorreA;
    Pila pilaTorreB;
    Pila pilaTorreC;

    DefaultTableModel modeloTorreA, modeloTorreB, modeloTorreC;

    int Objetivo = 0;

    double numeroMinimoMovimientos = 0;

    boolean detener = false;

    public VentanaPrincipal() {
        initComponents();

        //Define el nuevo modelo de tabla.
        modeloTorreA = (DefaultTableModel) tblTorreA.getModel();
        modeloTorreA.setRowCount(10);

        modeloTorreB = (DefaultTableModel) tblTorreB.getModel();
        modeloTorreB.setRowCount(10);

        modeloTorreC = (DefaultTableModel) tblTorreC.getModel();
        modeloTorreC.setRowCount(10);

        //Centra el contenido de la tabla
        DefaultTableCellRenderer renderA = new DefaultTableCellRenderer();
        renderA.setHorizontalAlignment(SwingConstants.CENTER);
        tblTorreA.getColumnModel().getColumn(0).setCellRenderer(renderA);

        DefaultTableCellRenderer renderB = new DefaultTableCellRenderer();
        renderB.setHorizontalAlignment(SwingConstants.CENTER);
        tblTorreB.getColumnModel().getColumn(0).setCellRenderer(renderB);

        DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
        renderC.setHorizontalAlignment(SwingConstants.CENTER);
        tblTorreC.getColumnModel().getColumn(0).setCellRenderer(renderC);
    }

    //Reinicia los contadores.
    private void Limpiar(){
        contadorNumeroMoviemiento = 0;
        numeroMinimoMovimientos = 0;

        spnnumeroDiscos.setSelectedItem(String.valueOf(Objetivo));
        ((DefaultTableModel) tblTorreB.getModel()).setRowCount(0);
        ((DefaultTableModel) tblTorreC.getModel()).setRowCount(0);
        modeloTorreB.setRowCount(10);
        modeloTorreC.setRowCount(10);

    }
    
    //Incrementa la cantidad de movimientos realizados hasta lograr el objetivo.
    private void MostrarCantidadMovimientos(){
        contadorNumeroMoviemiento++;
        lblNumeroRealizados.setText(String.valueOf(contadorNumeroMoviemiento));
    }
    
    private void Reiniciar(){
        try{
            
            if(!lblNumeroMinimoMovimientos.getText().equals("")){
                
                Limpiar();
                Iniciar();
            }
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Coloca la cantidad designada de discos por el usuario en la 'tabla A'.
    private void Iniciar(){
        
        try {
            pilaTorreA = new Pila();
            pilaTorreB = new Pila();
            pilaTorreC = new Pila();

            Objetivo = Integer.parseInt(spnnumeroDiscos.getSelectedItem().toString());

            numeroMinimoMovimientos = Math.pow(2, Objetivo) - 1;

            lblNumeroRealizados.setText(String.valueOf(contadorNumeroMoviemiento));
            lblNumeroMinimoMovimientos.setText(String.valueOf(String.format("%.0f", numeroMinimoMovimientos)));

            for (int x = Objetivo; x >= 1; x--) {

                Nodo Plataforma = new Nodo();

                String Disco = "";

                for (int y = x; y > 0; y--) {
                    Disco += "#";
                }

                Plataforma.setDato(Disco);

                pilaTorreA.Push(Plataforma);
                
            }
            
            MostrarTorreA();
            MostrarTorreB();
            MostrarTorreC();
        } catch (Exception err) {
            JOptionPane.showConfirmDialog(this, err.getMessage());
        }
    }
    
    //Dibuja la torre A.
    private void MostrarTorreA(){        
        try{            
            //Reinicia los valores de las tablas.
            ((DefaultTableModel) tblTorreA.getModel()).setRowCount(0);
            modeloTorreA.setRowCount(10);
            
            Nodo k;
            
            int rowDisco = (10 - pilaTorreA.getContadorNodo());

            // Evalua si la pila posee algún dato.
            if (pilaTorreA.getContadorNodo() < 11) {

                for (k = pilaTorreA.getCabeza(); k.getAbajo() != null; k = k.getAbajo()) {
                    String[] vectorNormal = {k.getDato()};
                    
                    modeloTorreA.insertRow(rowDisco, vectorNormal);
                    rowDisco++;
                }

                if (k.getAbajo() == null) {
                    String[] vectorNormal = {k.getDato()};
                    modeloTorreA.insertRow(rowDisco, vectorNormal);
                }
            }
            tblTorreA.setModel(modeloTorreA);
            modeloTorreA.setRowCount(10);
            
        }catch(Exception err){
            System.out.println("Error Presentar TorreA= "+err.toString());
        }
    }
    
    //Dibuja la torre B.
    private void MostrarTorreB(){
       try{
            //Reinicia los valores de las tablas.
            ((DefaultTableModel) tblTorreB.getModel()).setRowCount(0);
            modeloTorreB.setRowCount(10);
            
            Nodo k;
            
            int rowDisco = (10 - pilaTorreB.getContadorNodo());
            
            // Evalua si la pila posee algún dato.
            if (pilaTorreB.getContadorNodo() < 11) { 
                for (k = pilaTorreB.getCabeza(); k.getAbajo() != null; k = k.getAbajo()) {                    
                    String[] vectorNormal = {k.getDato()};

                    modeloTorreB.insertRow(rowDisco, vectorNormal);
                    rowDisco++;
                }

                if (k.getAbajo() == null) {
                    String[] vectorNormal = {k.getDato()};
                    modeloTorreB.insertRow(rowDisco, vectorNormal);
                }
            }

            tblTorreB.setModel(modeloTorreB);
            modeloTorreB.setRowCount(10);
        }catch(Exception err){
            System.out.println("Error Presentar TorreB= "+err.toString());
        }
    }
    
    //Dibuja la torre C.
    private void MostrarTorreC(){
        try{
            //Reinicia los valores de las tablas.
            ((DefaultTableModel) tblTorreC.getModel()).setRowCount(0);
            modeloTorreC.setRowCount(10);

            Nodo k;

            int rowDisco = (10 - pilaTorreC.getContadorNodo());  
            
            // Evalua si la pila posee algún dato.
            if (pilaTorreC.getContadorNodo() < 11) {
                for (k = pilaTorreC.getCabeza(); k.getAbajo() != null; k = k.getAbajo()) {
                    String[] vectorNormal = {k.getDato()};
                    modeloTorreC.insertRow(rowDisco, vectorNormal);
                    rowDisco++;
                }

                if (k.getAbajo() == null) {
                    String[] vectorNormal = {k.getDato()};
                    modeloTorreC.insertRow(rowDisco, vectorNormal);
                }
            }

            tblTorreC.setModel(modeloTorreC);
            modeloTorreC.setRowCount(10);
        }catch(Exception err){
            System.out.println("Error Presentar TorreC= "+err.toString());
        }
    }
    
    //Realiza la animación de mover los discos.
    private void MoverPlataforma(Pila origen,Pila destino){
        try{
            if (detener == false) {
                Nodo plataforma = new Nodo();

                //Realiza el cambio de discos de una tabla a otra.
                plataforma.setDato(origen.Peek());

                origen.Pop();

                destino.Push(plataforma);
                
                MostrarTorreA();
                MostrarTorreB();
                MostrarTorreC();
                MostrarCantidadMovimientos();
                
                //Muestra los pasos para resolver el problema.
                JOptionPane pane = new JOptionPane("Paso # " + lblNumeroRealizados.getText() + "\n\n ¿Desea continuar?", 
                JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);

                JDialog dialog = pane.createDialog("Número de pasos");

                dialog.setLocation(600,400);
                dialog.setVisible(true);

                int opt = (int) pane.getValue();

                if(opt == JOptionPane.NO_OPTION){
                    detener = true;
                }
            }
        }catch(Exception err){
            System.out.println("Error: " + err.getMessage());
        }
    }
  
    //Método recursivo para resolver el ejercicio.
    private void ResolverHanoiRecursivo(int n,Pila origen,Pila auxiliar,Pila destino){
        
        try {
            if (n == 1) {
                
                MoverPlataforma(origen, destino);
             
            } else {
               
                ResolverHanoiRecursivo(n - 1, origen, destino, auxiliar);

                MoverPlataforma(origen, destino);

                ResolverHanoiRecursivo(n - 1, auxiliar, origen, destino);

            }
        } catch (Exception err) {

        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTorreB = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTorreC = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTorreA = new javax.swing.JTable();
        spnnumeroDiscos = new javax.swing.JComboBox<>();
        lblNumeroRealizados = new javax.swing.JLabel();
        lblNumeroMinimoMovimientos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bt_iniciar = new javax.swing.JButton();
        bt_reiniciar = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTorreB.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblTorreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Torre B"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tblTorreB.setFocusable(false);
        tblTorreB.setRowSelectionAllowed(false);
        tblTorreB.setShowHorizontalLines(false);
        tblTorreB.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblTorreB);
        if (tblTorreB.getColumnModel().getColumnCount() > 0)
        {
            tblTorreB.getColumnModel().getColumn(0).setResizable(false);
        }

        tblTorreC.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblTorreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Torre C"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tblTorreC.setFocusable(false);
        tblTorreC.setRowSelectionAllowed(false);
        tblTorreC.setShowHorizontalLines(false);
        tblTorreC.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tblTorreC);
        if (tblTorreC.getColumnModel().getColumnCount() > 0)
        {
            tblTorreC.getColumnModel().getColumn(0).setResizable(false);
        }

        tblTorreA.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblTorreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Torre A"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tblTorreA.setAutoscrolls(false);
        tblTorreA.setFocusable(false);
        tblTorreA.setRowSelectionAllowed(false);
        tblTorreA.setShowHorizontalLines(false);
        tblTorreA.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tblTorreA);
        if (tblTorreA.getColumnModel().getColumnCount() > 0)
        {
            tblTorreA.getColumnModel().getColumn(0).setResizable(false);
        }

        spnnumeroDiscos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        spnnumeroDiscos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));

        lblNumeroRealizados.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumeroRealizados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumeroRealizados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNumeroMinimoMovimientos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumeroMinimoMovimientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumeroMinimoMovimientos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Número de discos:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Número mìnimo de movimientos");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Movimientos realizados");

        bt_iniciar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bt_iniciar.setText("Iniciar");
        bt_iniciar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_iniciarActionPerformed(evt);
            }
        });

        bt_reiniciar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bt_reiniciar.setText("Reiniciar");
        bt_reiniciar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_reiniciarActionPerformed(evt);
            }
        });

        btnResolver.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnResolver.setText("Resolver");
        btnResolver.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnResolverActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNumeroRealizados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spnnumeroDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblNumeroMinimoMovimientos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(bt_iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(bt_reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnnumeroDiscos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumeroMinimoMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumeroRealizados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addGap(9, 9, 9))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_iniciarActionPerformed
        Iniciar();
    }//GEN-LAST:event_bt_iniciarActionPerformed

    private void bt_reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_reiniciarActionPerformed
        Reiniciar();
    }//GEN-LAST:event_bt_reiniciarActionPerformed

    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        if(!lblNumeroMinimoMovimientos.getText().equals("") && pilaTorreC.getContadorNodo()!=Objetivo){
            
            Reiniciar();
            detener = false;
            
            ResolverHanoiRecursivo(Objetivo,pilaTorreA,pilaTorreB,pilaTorreC);
            
        }
    }//GEN-LAST:event_btnResolverActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSalirActionPerformed
    {//GEN-HEADEREND:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_iniciar;
    private javax.swing.JButton bt_reiniciar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNumeroMinimoMovimientos;
    private javax.swing.JLabel lblNumeroRealizados;
    private javax.swing.JComboBox<String> spnnumeroDiscos;
    private javax.swing.JTable tblTorreA;
    private javax.swing.JTable tblTorreB;
    private javax.swing.JTable tblTorreC;
    // End of variables declaration//GEN-END:variables
}
