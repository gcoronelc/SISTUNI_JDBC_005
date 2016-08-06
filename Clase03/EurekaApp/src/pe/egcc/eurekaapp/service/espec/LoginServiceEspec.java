package pe.egcc.eurekaapp.service.espec;

import pe.egcc.eurekaapp.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public interface LoginServiceEspec {
  
  /**
   * Este metodo permite validar el usuario y clave.
   * Si no son correctos genera una excepción de tipo RuntimeException.
   * 
   * @param usuario
   * @param clave
   * @return Retorna on objeto de tipo Empleado 
   *         con los datos correspondientes.
   */
  Empleado validar(String usuario, String clave);
  
}
