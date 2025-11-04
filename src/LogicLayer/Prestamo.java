package LogicLayer;

import java.time.LocalDate;

public class Prestamo {
	private double montoTotal;
	private double montoPendiente;
	private double tasaInteres;
	private int plazoMeses;
	private LocalDate fechaAprobacion;
	private LocalDate fechaVencimiento;
	private String estado;
	private Cliente solicitante;
	private Cuota[] cuotas;
}
