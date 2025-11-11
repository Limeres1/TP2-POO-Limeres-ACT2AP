package LogicLayer;

import java.time.LocalDate;

public class Transaccion {
	
	private String numero_transaccion;
	private LocalDate fecha_hora;
	private double monto;
	private String tipo;
	private String metodo;
	private Cuenta cuentaOrigen;
	private Cuenta cuentaDestino;
	
	
	public Transaccion(double monto, String tipo, String metodo,
            Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        super();
        this.numero_transaccion = generarNumeroTransaccion();
        this.fecha_hora = LocalDate.now();
        this.monto = monto;
        this.tipo = tipo;
        this.metodo = metodo;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }
    
    private String generarNumeroTransaccion() {
        return "TXN" + System.currentTimeMillis();
    }

	public String getNumero_transaccion() {
		return numero_transaccion;
	}
	public void setNumero_transaccion(String numero_transaccion) {
		this.numero_transaccion = numero_transaccion;
	}


	public LocalDate getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(LocalDate fecha_hora) {
		this.fecha_hora = fecha_hora;
	}	


	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	
	
	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	
	
	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
	@Override
	public String toString() {
		return "Transaccion [numero_transaccion=" + numero_transaccion + ", fecha_hora=" + fecha_hora + ", monto="
				+ monto + ", tipo=" + tipo + ", metodo=" + metodo + ", cuentaOrigen=" + cuentaOrigen
				+ ", cuentaDestino=" + cuentaDestino + "]";
	}

}
