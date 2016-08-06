package pe.egcc.eurekaapp.service.espec;

import java.util.List;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public interface CrudServiceEspec<T> {
  
  void insertar(T bean);
  
  void actualizar(T bean);
  
  void eliminar(String codigo);

  T leer(String codigo);
  
  List<T> leer(T bean);
  
}
