package pe.egcc.eurekaapp.service.espec;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public interface RowMapper<T> {
  
  /**
   * Pasa la fila actual del ResultSet a un bean de tipo T.
   * 
   * @param rs
   * @return Retorna una instancia de T.
   * @throws SQLException 
   */
  T mapRow(ResultSet rs) throws SQLException;
  
}
