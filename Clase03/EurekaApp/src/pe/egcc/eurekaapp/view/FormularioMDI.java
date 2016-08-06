package pe.egcc.eurekaapp.view;

import javax.swing.JInternalFrame;
import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.impl.MantEmpleadosView;
import pe.egcc.eurekaapp.util.Session;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class FormularioMDI extends javax.swing.JFrame {

  public FormularioMDI() {
    initComponents();
    establecerTitulo();
    this.setExtendedState(MAXIMIZED_BOTH);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    desktopPane = new javax.swing.JDesktopPane();
    menuBar = new javax.swing.JMenuBar();
    menuArchivo = new javax.swing.JMenu();
    menuArchivoSalir = new javax.swing.JMenuItem();
    menuProceso = new javax.swing.JMenu();
    menuProcesoDeposito = new javax.swing.JMenuItem();
    menuProcesoRetiro = new javax.swing.JMenuItem();
    jMenuItem3 = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    menuProcesoAperturaCuenta = new javax.swing.JMenuItem();
    menuProcesoCierreCuenta = new javax.swing.JMenuItem();
    menuTabla = new javax.swing.JMenu();
    menuTablaEmpleado = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuItem4 = new javax.swing.JMenuItem();
    menuConsulta = new javax.swing.JMenu();
    menuReporte = new javax.swing.JMenu();
    menuUtil = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    menuArchivo.setText("Archivo");

    menuArchivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
    menuArchivoSalir.setText("Salir");
    menuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuArchivoSalirActionPerformed(evt);
      }
    });
    menuArchivo.add(menuArchivoSalir);

    menuBar.add(menuArchivo);

    menuProceso.setText("Proceso");

    menuProcesoDeposito.setText("Depósito");
    menuProcesoDeposito.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuProcesoDepositoActionPerformed(evt);
      }
    });
    menuProceso.add(menuProcesoDeposito);

    menuProcesoRetiro.setText("Retiro");
    menuProceso.add(menuProcesoRetiro);

    jMenuItem3.setText("Transferencia");
    menuProceso.add(jMenuItem3);
    menuProceso.add(jSeparator1);

    menuProcesoAperturaCuenta.setText("Apertura de cuenta");
    menuProceso.add(menuProcesoAperturaCuenta);

    menuProcesoCierreCuenta.setText("Cierre de cuena");
    menuProceso.add(menuProcesoCierreCuenta);

    menuBar.add(menuProceso);

    menuTabla.setText("Tabla");

    menuTablaEmpleado.setText("Empleado");
    menuTablaEmpleado.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuTablaEmpleadoActionPerformed(evt);
      }
    });
    menuTabla.add(menuTablaEmpleado);

    jMenuItem2.setText("jMenuItem2");
    menuTabla.add(jMenuItem2);

    jMenuItem4.setText("jMenuItem4");
    menuTabla.add(jMenuItem4);

    menuBar.add(menuTabla);

    menuConsulta.setText("Consulta");
    menuBar.add(menuConsulta);

    menuReporte.setText("Reporte");
    menuBar.add(menuReporte);

    menuUtil.setText("Util");
    menuBar.add(menuUtil);

    setJMenuBar(menuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void menuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoSalirActionPerformed
    System.exit(0);
  }//GEN-LAST:event_menuArchivoSalirActionPerformed

  private void menuProcesoDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProcesoDepositoActionPerformed
    cargarFormInterno(ProcDepositoView.class);
  }//GEN-LAST:event_menuProcesoDepositoActionPerformed

  private void menuTablaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTablaEmpleadoActionPerformed
    cargarFormInterno(MantEmpleadosView.class);
  }//GEN-LAST:event_menuTablaEmpleadoActionPerformed

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
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new FormularioMDI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JDesktopPane desktopPane;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JMenu menuArchivo;
  private javax.swing.JMenuItem menuArchivoSalir;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenu menuConsulta;
  private javax.swing.JMenu menuProceso;
  private javax.swing.JMenuItem menuProcesoAperturaCuenta;
  private javax.swing.JMenuItem menuProcesoCierreCuenta;
  private javax.swing.JMenuItem menuProcesoDeposito;
  private javax.swing.JMenuItem menuProcesoRetiro;
  private javax.swing.JMenu menuReporte;
  private javax.swing.JMenu menuTabla;
  private javax.swing.JMenuItem menuTablaEmpleado;
  private javax.swing.JMenu menuUtil;
  // End of variables declaration//GEN-END:variables

  private void establecerTitulo() {
    String titulo = "EUREKA APP";
    Empleado bean = (Empleado) Session.get("usuario");
    titulo += " [Usuario:" + bean.getUsuario() + "]";
    this.setTitle(titulo);
  }
  
  private void cargarFormInterno(Class<?> aClass) {
    try {
      // Variable de control
      JInternalFrame view = null;
      // Buscar objeto en desktopPane
      for(JInternalFrame form: desktopPane.getAllFrames()){
        if(aClass.isInstance(form)){
          view = form;
          break;
        }
      }
      // Crear instancia
      if(view == null){
        view = (JInternalFrame) Class.forName(aClass.getName()).newInstance();
        desktopPane.add(view);
        view.setVisible(true);
      }
      // Activar formulario
      view.setSelected(true);
    } catch (Exception e) {
    }
  }

}
