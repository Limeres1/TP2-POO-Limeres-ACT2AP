package LogicLayer;

public enum Rol {
	
	Empleado(new String[] {"Dar de baja cajero","Reponer dinero","Salir"}),
	Cliente(new String[] {"Transferir","Depositar","Retirar","Consultar saldo","Historial transacciones","Salir"});
	
	
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
