package LogicLayer;

import java.time.LocalDate;

public class Transaccion {
	private String numero_transaccion;
	private LocalDate fecha_hora;
	private double monto;
	private String tipo;
	private String metodo;
	private Cliente cuentaOrigen;
	private Cliente cuentaDestino;
}
