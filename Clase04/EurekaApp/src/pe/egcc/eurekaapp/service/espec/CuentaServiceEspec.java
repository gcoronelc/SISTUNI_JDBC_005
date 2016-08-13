package pe.egcc.eurekaapp.service.espec;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public interface CuentaServiceEspec {

  void doProcDeposito(String cuenta, double importe, String codEmp);
  
  void doProcRetiro(String cuenta, double importe, String codEmp, String clave);

}
