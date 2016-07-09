try {
  // Acceso al objeto Connection
  cn = AccesoDB.getConnection();
  // Inicia Tx
  cn.setAutoCommit(false);
  
  
  // Confirmar Tx
  cn.commit();
} catch (Exception e) {
  try {
    // Cancela Tx
    cn.rollback();
  } catch (Exception e1) {
  }
  e.printStackTrace();
} finally {
  try {
	cn.close();
  } catch (Exception e) {
  }
}