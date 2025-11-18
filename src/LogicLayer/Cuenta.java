package LogicLayer;
import java.util.LinkedList;

public class Cuenta {
    
    private int num_cuenta;
    private double saldo;
    private static int num = 0;
    private LinkedList<Transaccion> transacciones;
    private LinkedList<Prestamo> prestamos;
    private String estadoCuenta;

    public Cuenta(int saldo) {
        num++;
        this.num_cuenta = num;
        this.saldo = saldo;
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

    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

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