package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class Prueba03 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "insert into parametro(chr_paracodigo,"
              + "vch_paradescripcion, vch_paravalor,"
              + "vch_paraestado) values(?,?,?,?)";
      // Creación del objeto Preparedstatement
      PreparedStatement pstm = cn.prepareStatement(sql);
      // ============================
      // Primera ejecución
      // ============================
      // Asignar valor a cada uno de los parámetros
      pstm.setString(1, "111");
      pstm.setString(2, "abc");
      pstm.setString(3, "abc");
      pstm.setString(4, "ACTIVO");
      // Ejecutar la sentencia
      pstm.executeUpdate();
      System.out.println("Primera ok.");
      // ============================
      // Primera ejecución
      // ============================
      // Asignar valor a cada uno de los parámetros
      pstm.setString(1, "aaa");
      pstm.setString(2, "aaa");
      pstm.setString(3, "aaa");
      pstm.setString(4, "ACTIVO");
      // Ejecutar la sentencia
      pstm.executeUpdate();
      System.out.println("Segunda ok.");
      // ==========================
      // Fin
      // ==========================
      pstm.close();
      System.out.println("Ok.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

}
