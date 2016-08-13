package pe.egcc.eurekaapp.controller;

import java.util.List;
import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.EmpleadoServiceEspec;
import pe.egcc.eurekaapp.service.impl.EmpleadoServiceImpl;
import pe.egcc.eurekaapp.util.Eureka;

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

  public void procesar(String accion, Empleado bean) {
    switch(accion){
      case Eureka.CRUD_NUEVO:
        service.insertar(bean);
        break;
      case Eureka.CRUD_EDITAR:
        service.actualizar(bean);
        break;
      case Eureka.CRUD_ELIMINAR:
        service.eliminar(bean.getCodigo());
        break;
      default:
        throw new RuntimeException("Acción incorrecta.");
    }
  
  }
  
  
  
}
