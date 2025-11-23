package LogicLayer;
import java.time.LocalDate;
import java.util.LinkedList;

public class CuentaInversion {
	 private int numCuenta;
	    private double saldo;
	    private LocalDate fechaCreacion;
	    private LinkedList<RegistroInversion> historial;
	    
	    public CuentaInversion(int numCuenta, double saldoInicial) {
	        this.numCuenta = numCuenta;
	        this.saldo = saldoInicial;
	        this.setFechaCreacion(LocalDate.now());
	        this.historial = new LinkedList<>();
	        
	        historial.add(new RegistroInversion(LocalDate.now(), saldoInicial, 0, saldoInicial, "DEPÓSITO INICIAL"));
	    }

		public int getNumCuenta() {
			return numCuenta;
		}

		public void setNumCuenta(int numCuenta) {
			this.numCuenta = numCuenta;
		}

		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public LocalDate getFechaCreacion() {
			return fechaCreacion;
		}

		public void setFechaCreacion(LocalDate fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}

		public LinkedList<RegistroInversion> getHistorial() {
			return historial;
		}

		public void setHistorial(LinkedList<RegistroInversion> historial) {
			this.historial = historial;
		}
	    


}
