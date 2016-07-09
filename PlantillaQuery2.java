Connection cn = null;
try {
  cn = AccesoDB.getConnection();

} catch (SQLException e) {
  throw new RuntimeException(e.getMessage());
} catch (Exception e) {
  String mensaje = "Se ha producido un error, intentelo mas tarde.";
  if(e.getMessage() != null && !e.getMessage().isEmpty()){
	mensaje += (" " + e.getMessage());
  }
  throw new RuntimeException(mensaje);
} finally {
  try {
  cn.close();
  } catch (Exception e) {
  }
}