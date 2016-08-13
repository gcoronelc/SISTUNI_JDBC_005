package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.domain.Empleado;
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;
import pe.egcc.eurekaapp.util.Session;

public class CuentaController {

  public void doProcDeposito(String cuenta, double importe) {
    // Empleado
    Empleado bean = (Empleado) Session.get("usuario");
    // Proceso
    CuentaServiceEspec service = new CuentaServiceImpl();
    service.doProcDeposito(cuenta, importe, bean.getCodigo());
  }
  
}
