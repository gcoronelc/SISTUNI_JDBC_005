package pe.egcc.eurekaapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.LoginServiceEspec;

public class LoginServiceImpl implements LoginServiceEspec {

  @Override
  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_emplcodigo,vch_emplpaterno,"
              + "vch_emplmaterno,vch_emplnombre,vch_emplciudad,"
              + "vch_empldireccion,vch_emplusuario "
              + "from empleado "
              + "where vch_emplusuario=? "
              + "and vch_emplclave=? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new SQLException("Datos son incorrectos.");
      }
      bean = new Empleado();
      bean.setCodigo(rs.getString("chr_emplcodigo"));
      bean.setPaterno(rs.getString("vch_emplpaterno"));
      bean.setMaterno(rs.getString("vch_emplmaterno"));
      bean.setNombre(rs.getString("vch_emplnombre"));
      bean.setCiudad(rs.getString("vch_emplciudad"));
      bean.setDireccion(rs.getString("vch_empldireccion"));
      bean.setUsuario(rs.getString("vch_emplusuario")); 
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      String mensaje = "Se ha producido un error, intentelo mas tarde.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        mensaje += (" " + e.getMessage());
      }
      throw new RuntimeException(mensaje);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

}
