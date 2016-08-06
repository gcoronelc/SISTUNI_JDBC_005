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
public class Prueba04 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select * from cliente where chr_cliecodigo=?";
      // Creación del objeto Preparedstatement
      PreparedStatement pstm = cn.prepareStatement(sql);
      // Asignar valor a cada uno de los parámetros
      pstm.setString(1, "00010");
      // Ejecución
      ResultSet rs = pstm.executeQuery();
      // Procesar resultado
      if(rs.next()){
        System.out.println("Código: " + rs.getString("chr_cliecodigo"));
        System.out.println("Paterno: " + rs.getString("vch_cliepaterno"));
        System.out.println("Materno: " + rs.getString("vch_cliematerno"));
        System.out.println("Nombre: " + rs.getString("vch_clienombre"));
      } else {
        System.err.println("Código no existe.");
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
