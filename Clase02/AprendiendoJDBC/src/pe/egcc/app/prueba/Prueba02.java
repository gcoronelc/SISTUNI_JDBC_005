package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.Statement;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class Prueba02 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      System.out.println("Conxión ok.");

      String sql = "insert into parametro(CHR_PARACODIGO,"
              + "VCH_PARADESCRIPCION,VCH_PARAVALOR,"
              + "VCH_PARAESTADO) values('776','PROFESOR',"
              + "'GUSTAVO CORONEL','ACTIVO')";
      Statement stm = cn.createStatement();
      stm.executeUpdate(sql);
      System.out.println("Parámetro registrado.");
      
      
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      
    } finally{
      try {
        cn.close();
        System.out.println("Conexión cerrada.");
      } catch (Exception e) {
      }
    }
  }

}
