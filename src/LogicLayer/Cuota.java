package LogicLayer;

import java.time.LocalDate;

public class Cuota {
	private double montoCuota;
	private LocalDate fechaPago;
	private String estado;
	private double intereses;
	public Cuota(double montoCuota, LocalDate fechaPago, String estado, double intereses) {
		super();
		this.montoCuota = montoCuota;
		this.fechaPago = fechaPago;
		this.estado = estado;
		this.intereses = intereses;
	}
	public double getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(double montoCuota) {
		this.montoCuota = montoCuota;
	}
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getIntereses() {
		return intereses;
	}
	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}
	@Override
	public String toString() {
		return "Cuota [montoCuota=" + montoCuota + ", fechaPago=" + fechaPago + ", estado=" + estado + ", intereses="
				+ intereses + "]";
	}
	
	
}
