package LogicLayer;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Empleado extends Usuario{
    
    private LocalDate fechaInicio;

    public Empleado(String mail, String contr, LocalDate fechaInicio) {
        super(mail, contr, Rol.Empleado);
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Empleado [fechaInicio=" + fechaInicio + ", toString()=" + super.toString() + "]";
    }

    @Override
    public void Menu() {
        boolean salir = false;
        
        while (!salir) {
            int opcion = JOptionPane.showOptionDialog(null, 
                "Bienvenido Empleado\nFecha inicio: " + fechaInicio, 
                "Menú Empleado", 
                0, 0, null, 
                this.getRol().getOpciones(),
                this.getRol().getOpciones()[0]);
            
            switch (opcion) {
                case 0: 
                    darDeBajaCuenta();
                    break;
                case 1: 
                    reponerDinero();
                    break;
                case 2: 
                    verCuentas();
                    break;
                case 3: 
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }
    
    private void darDeBajaCuenta() {
        int numeroCuenta = Validaciones.IngresarInt("Ingrese número de cuenta a dar de baja:");    
    		
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.esCliente()) {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getCuenta().getNum_cuenta() == numeroCuenta) {
                    Usuario.getUsuarios().remove(cliente);
                   JOptionPane.showMessageDialog(null, "Cuenta " + numeroCuenta + " dada de baja exitosamente");
                    return;
                }
            }
        }
       
        JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
   }
    
    
    private void reponerDinero() {
        int numeroCuenta = Validaciones.IngresarInt("Ingrese número de cuenta:");
        int monto = Validaciones.IngresarInt("Ingrese monto a reponer:");
        
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0");
            return;
        }
        
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.esCliente()) {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getCuenta().getNum_cuenta() == numeroCuenta) {
                    cliente.getCuenta().setSaldo(cliente.getCuenta().getSaldo() + monto);
                    
                    Transaccion transaccion = new Transaccion(monto, "REPOSICIÓN", "Empleado", null, cliente.getCuenta());
                    cliente.getCuenta().getTransacciones().add(transaccion);
                    
                    JOptionPane.showMessageDialog(null, "Dinero repuesto exitosamente\n" + "Nuevo saldo: $" + cliente.getCuenta().getSaldo());
                    return;
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
    }
    
    private void verCuentas() {
        if (Usuario.getUsuarios().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay cuentas registradas");
            return;
        }
        
       
        String info = "LISTA DE CUENTAS:\n\n";
        
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.esCliente()) {
                Cliente cliente = (Cliente) usuario;
                Cuenta cuenta = cliente.getCuenta();
                info = info + "Cuenta: " + cuenta.getNum_cuenta() + " - Cliente: " + cliente.getMail() + " - Saldo: $" + cuenta.getSaldo() + " - Estado: " + cuenta.getEstadoCuenta() + "\n";
            } else if (usuario.esEmpleado()) {
                Empleado empleado = (Empleado) usuario;
                info = info + "EMPLEADO: " + empleado.getMail() + " - Fecha inicio: " + empleado.fechaInicio + "\n";
            }
        }
        
        JOptionPane.showMessageDialog(null, info);
    }
}