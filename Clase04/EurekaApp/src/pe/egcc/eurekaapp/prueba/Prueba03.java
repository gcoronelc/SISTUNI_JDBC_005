package pe.egcc.eurekaapp.prueba;

import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class Prueba03 {
  
  public static void main(String[] args) {
    try {
      CuentaServiceEspec service;
      service = new CuentaServiceImpl();
      service.doProcRetiro("00100001", 30066.0, "0006", "123456");
      System.out.println("Proceso ok.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
