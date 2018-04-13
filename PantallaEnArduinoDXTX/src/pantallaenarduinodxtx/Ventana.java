package pantallaenarduinodxtx;
/**
 *
 * @author Orlando Mozqueda
 */
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventanaç
     */
    String puerta = "COM1";
    public Ventana() {
        initComponents();          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable()) {
                    temp.setText(ino.printMessage()+"º C");
                    hum.setText("0%");
                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        temp = new javax.swing.JTextField();
        hum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        texto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Enviar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        puerto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comunicacion = new javax.swing.JButton();
        com = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));

        temp.setBackground(new java.awt.Color(0, 255, 255));
        temp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        hum.setBackground(new java.awt.Color(0, 255, 255));
        hum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Temperatura:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Humedad:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Texto de comunicacion:");

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Comunicacion con Arduino");

        puerto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "COM18" }));

        jLabel5.setText("Puerto:");

        comunicacion.setText("Comunicar");
        comunicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comunicacionActionPerformed(evt);
            }
        });

        com.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        com.setForeground(new java.awt.Color(255, 0, 0));
        com.setText("Desconectado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(texto)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(temp)
                                        .addComponent(hum, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comunicacion))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addComponent(com)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)))
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(Enviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(comunicacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(com)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Enviar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        try {
            //Aqui se envia por el serial lo que va recibir el arduino
            ino.sendData(texto.getText()+"");    
            texto.setText("");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EnviarActionPerformed

    private void comunicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comunicacionActionPerformed
       //En estas decisiones se va traer el valor del puerto que fue seleccionado      
        if(puerto.getSelectedItem()=="COM1"){
            puerta = "COM1";
        }
        if(puerto.getSelectedItem()=="COM2"){
            puerta = "COM2";
        }
        if(puerto.getSelectedItem()=="COM3"){
            puerta = "COM3";
        }
        if(puerto.getSelectedItem()=="COM4"){
            puerta = "COM4";
        }
        if(puerto.getSelectedItem()=="COM5"){
            puerta = "COM5";
        }
        if(puerto.getSelectedItem()=="COM6"){
            puerta = "COM6";
        }
        if(puerto.getSelectedItem()=="COM7"){
            puerta = "COM7";
        }
        if(puerto.getSelectedItem()=="COM8"){
            puerta = "COM8";
        }
        if(puerto.getSelectedItem()=="COM9"){
            puerta = "COM9";
        }
        if(puerto.getSelectedItem()=="COM18"){
            puerta = "COM18";
        }
        try {
            //Aqui se hace la conexion hacia el arduino
            //Seleccionamos el puerto
            //La velocidad de comunicacion del serial
            //El metodo utilizado para hacer los envios y tambien recibirlos
            ino.arduinoRXTX(puerta, 9600, listener);
            com.setText("Conectado");
            com.setForeground(new java.awt.Color(0, 204, 0));
        } catch (ArduinoException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            com.setText("Desconectado");
            com.setForeground(new java.awt.Color(255, 0, 0));
        }
    }//GEN-LAST:event_comunicacionActionPerformed

    private void humActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enviar;
    private javax.swing.JLabel com;
    private javax.swing.JButton comunicacion;
    private javax.swing.JTextField hum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> puerto;
    private javax.swing.JTextField temp;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables
}