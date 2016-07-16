package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class Prueba06 {

  public static void main(String[] args) {
    // Dato
    String cuenta = "00100001";
    double importe = 50.0;
    String codEmp = "0002";
    // Variables auxiliares
    double saldo = 0;
    int contMov = 0, filasProc = 0;
    boolean existe = false;
    String sql;
    PreparedStatement pstm;
    Connection cn = null;
    ResultSet rs = null;
    try {
      cn = AccesoDB.getConnection();
      // Iniciar Tx
      cn.setAutoCommit(false);
      // Leer datos de la cuenta
      sql = "select dec_cuensaldo, int_cuencontmov "
              + "from cuenta "
              + "where chr_cuencodigo = ?";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      rs = pstm.executeQuery();
      if (rs.next()) {
        saldo = rs.getDouble("dec_cuensaldo");
        contMov = rs.getInt("int_cuencontmov");
        existe = true;
      }
      rs.close();
      pstm.close();
      if (!existe) {
        throw new Exception("Cuenta no existe.");
      }
      // Actualizar datos de la cuenta
      Thread.currentThread().sleep(1000);
      saldo += importe;
      contMov++;
      sql = "update cuenta set dec_cuensaldo = ?, "
              + "int_cuencontmov = ? "
              + "where chr_cuencodigo = ?";
      pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, saldo);
      pstm.setInt(2, contMov);
      pstm.setString(3, cuenta);
      filasProc = pstm.executeUpdate();
      pstm.close();
      if (filasProc != 1) {
        throw new Exception("No se ha podido actualizar la cuenta correctamente.");
      }
      // Registrar el movimiento
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
      // Confirmar Tx Tx
      cn.commit();
      System.out.println("Ok.");
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      System.err.println(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

}
