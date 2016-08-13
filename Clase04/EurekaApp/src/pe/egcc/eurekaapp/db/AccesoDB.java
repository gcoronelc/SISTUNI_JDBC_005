package pe.egcc.eurekaapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public final class AccesoDB {

  private AccesoDB() {
  }
  
  private static final String DRIVER = "oracle.jdbc.OracleDriver";
  private static final String URL = "jdbc:oracle:thin:@172.17.3.201:1521:ORCL";
  private static final String USER = "eureka";
  private static final String PASS = "admin";
  
  public static Connection getConnection() throws SQLException{
    Connection cn = null;
    try {
      // Paso 1: Cargar el driver
      Class.forName(DRIVER).newInstance();
      // Paso 2: Obtener Conexión
      cn = DriverManager.getConnection(URL, USER, PASS);
    } catch (ClassNotFoundException e) {
      throw new SQLException("No se ha encontrado el driver");
    } catch(SQLException e){
      throw e;
    } catch(Exception e){
      throw new SQLException("No se tiene acceso al servidor de BD.");
    }
    return cn;
  }
  
  
  
}
