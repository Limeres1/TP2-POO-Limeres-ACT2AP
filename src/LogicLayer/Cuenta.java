package LogicLayer;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cuenta extends Usuario{
	
	private int num_cuenta;
	private int saldo;
	private static int num = 0;
	private LinkedList<Transaccion> transacciones;
	private LinkedList<Tarjeta> tarjetas;
	private LinkedList<Prestamo> prestamos;
	private String estadoCuenta;

	 public Cuenta(int saldo) {
	        super("", "", Rol.Cliente); // Llamada al constructor de Usuario
	        num++;
	        this.num_cuenta = num;
	        this.saldo = saldo;
	        this.transacciones = new LinkedList<Transaccion>();
	        this.tarjetas = new LinkedList<Tarjeta>();
	        this.prestamos = new LinkedList<Prestamo>();
	        this.estadoCuenta = "ACTIVA";
	    }

	public int getNum_cuenta() {
		return num_cuenta;
	}
	public void setNum_cuenta(int num_cuenta) {
		this.num_cuenta = num_cuenta;
	}


	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public LinkedList<Transaccion> getTransacciones() {
		return transacciones;
	}
	public void setTransacciones(LinkedList<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}


	public LinkedList<Tarjeta> getTarjetas() {
		return tarjetas;
	}
	public void setTarjetas(LinkedList<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}


	public LinkedList<Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(LinkedList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}


	public String getEstadoCuenta() {
		return estadoCuenta;
	}
	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}


	@Override
	public void Menu() {

		int opcion = JOptionPane.showOptionDialog(null, "Bienvenido cliente", "", 0, 0, null, this.getRol().getOpciones(),this.getRol().getOpciones()[0]);
	}
}
