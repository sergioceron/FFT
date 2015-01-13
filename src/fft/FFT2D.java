/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FFT2D.java
 *
 * Created on Nov 11, 2009, 4:39:15 PM
 */

package fft;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.DefaultListModel;

/**
 *
 * @author sxceron
 */
public class FFT2D extends javax.swing.JFrame {

    /** Creates new form FFT2D */
    public FFT2D() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        valores = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sol = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inverse = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(fft.FFTApp.class).getContext().getResourceMap(FFT2D.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        valores.setText(resourceMap.getString("valores.text")); // NOI18N
        valores.setName("valores"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        sol.setName("sol"); // NOI18N
        jScrollPane1.setViewportView(sol);

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        inverse.setText(resourceMap.getString("inverse.text")); // NOI18N
        inverse.setName("inverse"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valores, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inverse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(475, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(valores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(inverse))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(1, 1, 1))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String vals[] = valores.getText().split(",");
        int len = vals.length;
        //int log = 1;
        for( int k = 0; k < 15; k++ ){
            if( (int)Math.pow(2, k) == len )
                break;
            if( (int)Math.pow(2, k) > len ){
                len  = (int)Math.pow(2, k);
                break;
            }
        }
        Complex co[] = new Complex[len];
        Complex c[] = new Complex[len];

        for( int i = 0; i < len; i++ ){
            if( i >= vals.length ){
                c[i] = new Complex(0.0);
                co[i] = new Complex(0.0);
            }else{
                c[i] = new Complex(vals[i]);
                co[i] = new Complex(vals[i]);
            }
        }

        int log = (int)(Math.log(len) / Math.log(2));
        System.out.println(log);
        FFT w = new FFT(log);
        w.hacerFFT(c, inverse.isSelected() ? false : true);
        DefaultListModel model = new DefaultListModel();
        int count = 0;
        for( Complex x : c )
            model.addElement((count ++) + " -> " + x );
        sol.setModel(model);

        Graphics graf = getContentPane().getGraphics();
        graf.setColor(Color.GREEN);
        graf.clearRect(0, 0, 921+100, 466+15);
        int OFFSET = 25;
        int SEPX = 921/log;
        int SEPY = 466 / (int)Math.pow(2, log);

        int fases = log;

        for( int x = 0; x < fases + 1; x++ )
            for( int y = 0; y < Math.pow(2, fases); y++ ){
                int a = x * SEPX;
                int b = y * SEPY;
                graf.fillOval(OFFSET + a, OFFSET + b, 3, 3);

                graf.setColor(Color.WHITE);
                if( x == 0 ){
                    graf.drawString(co[w.getBitInverso()[y]].toString(), OFFSET + a, OFFSET + b);
                }else if( x == fases ){
                    graf.drawString(c[y].toString(), OFFSET + a, OFFSET + b);
                }else{
                    graf.drawString(w.getFases()[x-1][w.getBitInverso()[y]].toString(), OFFSET + a, OFFSET + b);
                }
                graf.setColor(Color.GREEN);

                if( x < fases ){
                    if( y % (Math.pow(2, x) + Math.pow(2, x)) == 0){
                        for( int $y = y; $y < y + Math.pow(2, x); $y++  )
                            graf.drawLine(OFFSET + a, OFFSET + $y * SEPY, OFFSET + (x+1) * SEPX,(int) (OFFSET + ($y + Math.pow(2, x)) * SEPY));
                        for( int $y = y + (int)Math.pow(2, x); $y < y + 2*Math.pow(2, x); $y++  )
                            graf.drawLine(OFFSET + a, OFFSET + $y * SEPY, OFFSET + (x+1) * SEPX,(int) (OFFSET + ($y - Math.pow(2, x)) * SEPY));
                    }
                    graf.drawLine(OFFSET + a, OFFSET + b, OFFSET + (x+1) * SEPX, OFFSET + b);
                }
            }


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FFT2D().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox inverse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList sol;
    private javax.swing.JTextField valores;
    // End of variables declaration//GEN-END:variables

}
