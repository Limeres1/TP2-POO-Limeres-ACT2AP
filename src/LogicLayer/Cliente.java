package LogicLayer;
import java.time.LocalDate;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Cliente extends Usuario{
	
	private String titular;
	private String num_cuenta;
	private int saldo;
	private LocalDate fechaApertura;
	private Transaccion[] transacciones;
	private Tarjeta[] tarjetas;
	private Prestamo[] prestamos;
	private String estadoCuenta;
	
	
	
	public Cliente(String mail, String contr, int saldo) {
		super(mail, contr,Rol.Cliente);
		this.saldo = saldo;
	}

	public String getTitular() {return titular;}
	public void setTitular(String titular) {this.titular = titular;}

	
	public String getNum_cuenta() {return num_cuenta;}
	public void setNum_cuenta(String num_cuenta) {this.num_cuenta = num_cuenta;}

	
	public int getSaldo() {return saldo;}
	public void setSaldo(int saldo) {this.saldo = saldo;}

	
	public LocalDate getFechaApertura() {return fechaApertura;}
	public void setFechaApertura(LocalDate fechaApertura) {this.fechaApertura = fechaApertura;}


	public Transaccion[] getTransacciones() {return transacciones;}
	public void setTransacciones(Transaccion[] transacciones) {this.transacciones = transacciones;}


	public Tarjeta[] getTarjetas() {return tarjetas;}
	public void setTarjetas(Tarjeta[] tarjetas) {this.tarjetas = tarjetas;}


	public Prestamo[] getPrestamos() {return prestamos;}
	public void setPrestamos(Prestamo[] prestamos) {this.prestamos = prestamos;}


	public String getEstadoCuenta() {return estadoCuenta;}
	public void setEstadoCuenta(String estadoCuenta) {this.estadoCuenta = estadoCuenta;}


	@Override
	public String toString() {
		return "Cliente [titular=" + titular + ", num_cuenta=" + num_cuenta + ", saldo=" + saldo + ", fechaApertura="
				+ fechaApertura + ", transacciones=" + Arrays.toString(transacciones) + ", tarjetas="
				+ Arrays.toString(tarjetas) + ", prestamos=" + Arrays.toString(prestamos) + ", estadoCuenta="
				+ estadoCuenta + "]";
	}
	@Override
	public void Menu() {

		int opcion = JOptionPane.showOptionDialog(null, "Bienvenido cliente", "", 0, 0, null, this.getRol().getOpciones(),this.getRol().getOpciones()[0]);
	}
}
