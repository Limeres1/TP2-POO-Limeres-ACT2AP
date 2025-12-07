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
	    
		public static double generarTasaInteresDiaria() {
			//POSIBILIDAD DE GANANCIA 70%
		    if (Math.random() < 0.7) {
		        return Math.random() * 0.05; //Alcista
		    } else {
		        return Math.random() * -0.03; //Bajista
		    }
		}
		    
		    // SIMULACION
		    public static void simularDiasInversion(CuentaInversion cuenta, int dias) {
		        double saldoActual = cuenta.getSaldo();
		        LocalDate fechaActual = LocalDate.now();
		        
		        for (int i = 1; i <= dias; i++) {
		            double tasa = generarTasaInteresDiaria();
		            double rendimiento = saldoActual * tasa;
		            double nuevoSaldo = saldoActual + rendimiento;
		            
		            //HISTORIAL
		            cuenta.getHistorial().add(new RegistroInversion(
		                fechaActual.plusDays(i),
		                saldoActual,
		                tasa,
		                nuevoSaldo,
		                "RENDIMIENTO DIARIO"
		            ));
		            
		            saldoActual = nuevoSaldo;
		        }
		        cuenta.setSaldo(saldoActual);
		    }
}
