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
public class Prueba05 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select * from cliente "
              + "where vch_cliepaterno like concat(?,'%') "
              + "and vch_cliematerno like concat(?,'%') ";
      // Creación del objeto Preparedstatement
      PreparedStatement pstm = cn.prepareStatement(sql);
      // Asignar valor a cada uno de los parámetros
      pstm.setString(1, "R");
      pstm.setString(2, "");
      // Ejecución
      ResultSet rs = pstm.executeQuery();
      // Procesar resultado
      while (rs.next()) {
        System.out.println(
                rs.getString("chr_cliecodigo") + " | "
                + rs.getString("vch_cliepaterno") + " | "
                + rs.getString("vch_cliematerno") + " | "
                + rs.getString("vch_clienombre"));
      }
      // ==========================
      // Fin
      // ==========================
      rs.close();
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
