package pe.egcc.eurekaapp.prueba;

import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.LoginServiceEspec;
import pe.egcc.eurekaapp.service.impl.LoginServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class Prueba01 {

  public static void main(String[] args) {
    try {
      LoginServiceEspec service;
      service = new LoginServiceImpl();
      Empleado bean = service.validar("cromero", "chicho");
      System.out.println("Código: " + bean.getCodigo());
      System.out.println("Paterno: " + bean.getPaterno());
      System.out.println("Materno: " + bean.getMaterno());
      System.out.println("Nombre: " + bean.getNombre());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
