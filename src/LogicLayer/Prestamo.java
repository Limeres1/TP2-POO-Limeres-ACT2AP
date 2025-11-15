package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

public class Prestamo {
	private double montoTotal;
	private double montoPendiente;
	private double tasaInteres;
	private int plazoMeses;
	private LocalDate fechaAprobacion;
	private LocalDate fechaVencimiento;
	private String estado;
	private Cuenta solicitante;
	private LinkedList<Cuota> cuotas;
	
	public Prestamo(double montoTotal, double tasaInteres, int plazoMeses, LocalDate fechaVencimiento, Cuenta solicitante) {
	       super();
	       this.montoTotal = montoTotal;
	       this.tasaInteres = tasaInteres;
	       this.plazoMeses = plazoMeses;
	       this.fechaVencimiento = fechaVencimiento;
	       this.solicitante = solicitante;
	       this.cuotas = new LinkedList<Cuota>();
	}

	public double getMontoTotal() {
		return montoTotal;
	}


	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}


	public double getMontoPendiente() {
		return montoPendiente;
	}


	public void setMontoPendiente(double montoPendiente) {
		this.montoPendiente = montoPendiente;
	}


	public double getTasaInteres() {
		return tasaInteres;
	}


	public void setTasaInteres(double tasaInteres) {
		this.tasaInteres = tasaInteres;
	}


	public int getPlazoMeses() {
		return plazoMeses;
	}


	public void setPlazoMeses(int plazoMeses) {
		this.plazoMeses = plazoMeses;
	}


	public LocalDate getFechaAprobacion() {
		return fechaAprobacion;
	}


	public void setFechaAprobacion(LocalDate fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}


	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Cuenta getSolicitante() {
		return solicitante;
	}


	public void setSolicitante(Cuenta solicitante) {
		this.solicitante = solicitante;
	}


	public LinkedList<Cuota> getCuotas() {
		return cuotas;
	}


	public void setCuotas(LinkedList<Cuota> cuotas) {
		this.cuotas = cuotas;
	}


	@Override
	public String toString() {
		return "Prestamo [montoTotal=" + montoTotal + ", montoPendiente=" + montoPendiente + ", tasaInteres="
				+ tasaInteres + ", plazoMeses=" + plazoMeses + ", fechaAprobacion=" + fechaAprobacion
				+ ", fechaVencimiento=" + fechaVencimiento + ", estado=" + estado + ", solicitante=" + solicitante
				+ ", cuotas=" + cuotas + "]";
	}
	
}
