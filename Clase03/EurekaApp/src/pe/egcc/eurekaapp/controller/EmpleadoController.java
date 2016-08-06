package pe.egcc.eurekaapp.controller;

import java.util.List;
import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.EmpleadoServiceEspec;
import pe.egcc.eurekaapp.service.impl.EmpleadoServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public class EmpleadoController {
  
  private EmpleadoServiceEspec service;

  public EmpleadoController() {
    service = new EmpleadoServiceImpl();
  }

  public List<Empleado> leer(Empleado bean) {
  return service.leer(bean);
  }
  
  
  
}
