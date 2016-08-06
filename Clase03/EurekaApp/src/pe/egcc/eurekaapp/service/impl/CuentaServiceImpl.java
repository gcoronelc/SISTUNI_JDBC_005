package pe.egcc.eurekaapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class CuentaServiceImpl implements CuentaServiceEspec {

  @Override
  public void doProcDeposito(String cuenta, double importe, String codEmp) {
    Connection cn = null;
    try {
      // Acceso al objeto Connection
      cn = AccesoDB.getConnection();
      // Inicia Tx
      cn.setAutoCommit(false);
      // Actualizar la tabla cuenta
      String sql = "update cuenta "
              + "set dec_cuensaldo = dec_cuensaldo + ?, "
              + "int_cuencontmov = int_cuencontmov + 1 "
              + "where chr_cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, importe);
      pstm.setString(2, cuenta);
      int filas = pstm.executeUpdate();
      pstm.close();
      if( filas != 1){
        throw new Exception("Cuenta no es correcta.");
      }
      // Leer el contador
      sql = "select int_cuencontmov cont from cuenta "
              + "where chr_cuencodigo = ?";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if( !rs.next() ){
        throw new Exception("Parece que algo anda mal.");
      }
      int contMov = rs.getInt("cont");
      // Insertar el movimiento
      sql = "insert into movimiento(chr_cuencodigo, "
              + "int_movinumero, dtt_movifecha,"
              + "chr_emplcodigo, chr_tipocodigo, "
              + "dec_moviimporte) values(?,?,SYSDATE,?,'003',?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, contMov);
      pstm.setString(3, codEmp);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      pstm.close();
      // Confirmar Tx
      cn.commit();
    } catch (Exception e) {
      try {
        // Cancela Tx
        cn.rollback();
      } catch (Exception e1) {
      }
      String mensaje = "Error en el Proceso, intentelo mas tarde.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        mensaje += " " + e.getMessage();
      }
      throw new RuntimeException(mensaje);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

}
