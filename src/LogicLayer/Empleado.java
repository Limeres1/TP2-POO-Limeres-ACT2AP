package LogicLayer;
import java.awt.Image;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import UserLayer.Main;

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
                "Bienvenido Empleado\n", 
                "Menú Empleado", 
                0, 0, iconoEscalado, 
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
                    crearEmpleado();
                    break;
                case 3: 
                    verCuentas();
                    break;
                case 4: 
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }
    //CREAR EMPELADO
    private static void crearEmpleado() {
        String mail = Validaciones.IngresarMail("Ingrese su email:");
        
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.getMail().equals(mail)) {
                JOptionPane.showMessageDialog(null, "El email ya está registrado");
                return;
            }
        }
        
        String contr = Validaciones.IngresarString("Ingrese su contraseña:");
        

        Usuario.getUsuarios().add(new Empleado(mail, contr, LocalDate.now()));
              
        JOptionPane.showMessageDialog(null, 
            "Empleado registrado exitosamente!\n" +
            "Email: " + mail);
    }
    //DAR DE BAJA CUENTA USUARIOs
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
    
    //REPONER DINERO
    private void reponerDinero() {
        int numeroCuenta = Validaciones.IngresarInt("Ingrese número de cuenta:");
        String moneda = Cliente.elegirMoneda("Elegir moneda a depositar: ");
    	if (moneda == null) {
    		return;
    	}
        int monto = Validaciones.IngresarInt("Ingrese monto a reponer:");
        
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0");
            return;
        }
        
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.esCliente()) {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getCuenta().getNum_cuenta() == numeroCuenta) {
                    cliente.getCuenta().setSaldoArg(cliente.getCuenta().getSaldoArg() + monto);
                    
                    switch(moneda) {
                    case "ARS":
                        cliente.getCuenta().setSaldoArg(cliente.getCuenta().getSaldoArg() + monto);
                        
                        Transaccion transaccionARS = new Transaccion(monto, "DEPÓSITO", "Efectivo", null, cliente.getCuenta());
                        cliente.getCuenta().getTransacciones().add(transaccionARS);
                        
                        JOptionPane.showMessageDialog(null, "Depósito exitoso!\nNuevo saldo Pesos: $" + cliente.getCuenta().getSaldoArg());
                    	break;
                    case "CNY":
                    	cliente.getCuenta().setSaldoYuan(cliente.getCuenta().getSaldoYuan() + monto);
                        
                        Transaccion transaccionYNS = new Transaccion(monto, "DEPÓSITO", "Efectivo", null, cliente.getCuenta());
                        cliente.getCuenta().getTransacciones().add(transaccionYNS);
                        
                        JOptionPane.showMessageDialog(null, "Depósito exitoso!\nNuevo saldo Yuanes: ¥" + cliente.getCuenta().getSaldoYuan());
                    	break;
                    case "USD":
                    	cliente.getCuenta().setSaldoDol(cliente.getCuenta().getSaldoDol() + monto);
                        
                        Transaccion transaccionUSD = new Transaccion(monto, "DEPÓSITO", "Efectivo", null, cliente.getCuenta());
                        cliente.getCuenta().getTransacciones().add(transaccionUSD);
                        
                        JOptionPane.showMessageDialog(null, "Depósito exitoso!\nNuevo saldo Dolares: $" + cliente.getCuenta().getSaldoDol());
                    	break;
                    }
                }
                else {
                	JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
                }
            }
        }
    }
    //VER CUENTAS
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
                info = info + "Cuenta: " + cuenta.getNum_cuenta() + " - Cliente: " + cliente.getMail() + " - Saldo: $" + cuenta.getSaldoArg() + " - Estado: " + cuenta.getEstadoCuenta() + "\n";
            } else if (usuario.esEmpleado()) {
                Empleado empleado = (Empleado) usuario;
                info = info + "EMPLEADO: " + empleado.getMail() + " - Fecha inicio: " + empleado.fechaInicio + "\n";
            }
        }
        
        JOptionPane.showMessageDialog(null, info);
    }
    ImageIcon icono = new ImageIcon(Main.class.getResource("imgs/bancoIcon.png"));
    Image imagenEscalada = icono.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
}