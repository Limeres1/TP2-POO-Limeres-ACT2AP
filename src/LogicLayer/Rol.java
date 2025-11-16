package LogicLayer;

public enum Rol {
	
	Empleado(new String[] {"Dar de baja cuenta","Reponer dinero","Crear empleado","Ver cuentas", "Salir"}),
	Cliente(new String[] {"Transferir","Depositar","Retirar","Consultar saldo","Historial transacciones", "Pedir prestamo", "Consultar prestamo","Salir"});

	private String[] opciones;

	private Rol(String[] opciones) {
		this.opciones = opciones;
	}

	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}
	

}
