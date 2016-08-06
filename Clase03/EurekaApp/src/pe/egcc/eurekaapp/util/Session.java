package pe.egcc.eurekaapp.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog wwww.desarrollasoftware.com
 */
public final class Session {

  private Session() {
  }
  
  private static final Map<String,Object> datos;
  
  static{
    datos = new HashMap<>();
  }
  
  public static void put(String key, Object value){
    datos.put(key, value);
  }
  
  public static Object get(String key){
    return datos.get(key);
  }
  
}
