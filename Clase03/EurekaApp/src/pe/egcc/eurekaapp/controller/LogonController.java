package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.LoginServiceEspec;
import pe.egcc.eurekaapp.service.impl.LoginServiceImpl;
import pe.egcc.eurekaapp.util.Session;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class LogonController {
  
  public void validar(String usuario, String clave){
    LoginServiceEspec service;
    service = new LoginServiceImpl();
    Empleado bean = service.validar(usuario, clave);
    Session.put("usuario", bean);
  }
}
