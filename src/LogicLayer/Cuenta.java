package LogicLayer;
import java.util.LinkedList;

public class Cuenta {
    
    private int num_cuenta;
    private double saldoArg;
    private double saldoYuan;
    private double saldoDol;
    private static int num = 0;
    private LinkedList<Transaccion> transacciones;
    private LinkedList<Prestamo> prestamos;
    private String estadoCuenta;

    public Cuenta(int saldo) {
        num++;
        this.num_cuenta = num;
        this.saldoArg = saldo;
        this.transacciones = new LinkedList<Transaccion>();
        this.prestamos = new LinkedList<Prestamo>();
        this.estadoCuenta = "ACTIVA";
    }

    public int getNum_cuenta() {
        return num_cuenta;
    }
    
    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
    }


//SALDOS
    public double getSaldoArg() {
		return saldoArg;
	}

	public void setSaldoArg(double saldoArg) {
		this.saldoArg = saldoArg;
	}

	public double getSaldoYuan() {
		return saldoYuan;
	}

	public void setSaldoYuan(double saldoYuan) {
		this.saldoYuan = saldoYuan;
	}

	public double getSaldoDol() {
		return saldoDol;
	}

	public void setSaldoDol(double saldoDol) {
		this.saldoDol = saldoDol;
	}
//
	public LinkedList<Transaccion> getTransacciones() {
        return transacciones;
    }
    
    public void setTransacciones(LinkedList<Transaccion> transacciones) {
        this.transacciones = transacciones;
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
}