package pe.egcc.eurekaapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.EmpleadoServiceEspec;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class EmpleadoServiceImpl implements EmpleadoServiceEspec {

  private String SQL_SELECT = "select chr_emplcodigo,vch_emplpaterno,"
          + "vch_emplmaterno,vch_emplnombre,"
          + "vch_emplciudad,vch_empldireccion,"
          + "vch_emplusuario from empleado ";

  private String SQL_UPDATE = "update empleado "
          + "set vch_emplpaterno=?,vch_emplmaterno=?,"
          + "vch_emplnombre=?,vch_emplciudad=?,"
          + "vch_empldireccion=?,vch_emplusuario=? "
          + "where chr_emplcodigo=? ";

  @Override
  public void insertar(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void actualizar(Empleado bean) {
    Connection cn = null;
    try {
      // Acceso al objeto Connection
      cn = AccesoDB.getConnection();
      // Inicia Tx
      cn.setAutoCommit(false);
      // Proceso
      PreparedStatement pstm = cn.prepareStatement(SQL_UPDATE);
      pstm.setString(1, bean.getPaterno());
      pstm.setString(2, bean.getMaterno());
      pstm.setString(3, bean.getNombre());
      pstm.setString(4, bean.getCiudad());
      pstm.setString(5, bean.getDireccion());
      pstm.setString(6, bean.getUsuario());
      pstm.setString(7, bean.getCodigo());
      int filas = pstm.executeUpdate();
      System.err.println("Filas: " + filas);
      pstm.close();
      if(filas != 1){
        throw new Exception("Datos no son correctos.");
      }
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

  @Override
  public void eliminar(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Empleado leer(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Empleado> leer(Empleado bean) {
    List<Empleado> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = SQL_SELECT + " where "
              + "chr_emplcodigo like concat(?,'%') "
              + "and vch_emplpaterno like concat(?,'%') "
              + "and vch_emplmaterno like concat(?,'%') "
              + "and vch_emplnombre like concat(?,'%')  ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getCodigo());
      pstm.setString(2, bean.getPaterno());
      pstm.setString(3, bean.getMaterno());
      pstm.setString(4, bean.getNombre());
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        lista.add(mapRow(rs));
      }
      rs.close();
      pstm.close();
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
    return lista;
  }

  @Override
  public Empleado mapRow(ResultSet rs) throws SQLException {
    Empleado bean = new Empleado();
    bean.setCodigo(rs.getString("chr_emplcodigo"));
    bean.setPaterno(rs.getString("vch_emplpaterno"));
    bean.setMaterno(rs.getString("vch_emplmaterno"));
    bean.setNombre(rs.getString("vch_emplnombre"));
    bean.setCiudad(rs.getString("vch_emplciudad"));
    bean.setDireccion(rs.getString("vch_empldireccion"));
    bean.setUsuario(rs.getString("vch_emplusuario"));
    bean.setClave("********");
    return bean;
  }

}
