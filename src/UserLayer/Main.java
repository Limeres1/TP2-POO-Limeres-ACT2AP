package UserLayer;

import LogicLayer.Cliente;
import LogicLayer.Cuenta;
import LogicLayer.Empleado;
import LogicLayer.Usuario;
import LogicLayer.Validaciones;

import java.awt.Image;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ImageIcon icono = new ImageIcon(Main.class.getResource("imgs/bancoIcon.png"));
        Image imagenEscalada = icono.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
    	adminPrueba();
        boolean salir = false;
        
        
        
        while (!salir) {
            String[] opciones = {"Ingresar", "Registrarse", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, 
                "Elige alguna opción", 
                "Sistema bancario", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                iconoEscalado, opciones, opciones[0]);
            
            switch (opcion) {
                case 0: // Ingresar
                    login();
                    break;
                case 1: // Registrarse cliente
                    registrarCliente();
                    break;
                case 2: // Salir
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    break;
            }
        }
    }
    
    private static void adminPrueba() { 
    	//EMPLEADO
    	Usuario.getUsuarios().add(new Empleado("admin@banco.com", "admin123", LocalDate.now()));
    	
    	//CLIENTE
    	Cliente nuevoCliente = new Cliente("cliente@gmail.com", "123");
    	
        Cuenta nuevaCuenta = new Cuenta(0);
        nuevoCliente.setCuenta(nuevaCuenta);
        Usuario.getUsuarios().add(nuevoCliente);
    }
    
    
    private static void login() {
        String mail = Validaciones.IngresarMail("Ingrese su email:");
        if(mail == null) {
        	return;
        }
        String contr = Validaciones.IngresarString("Ingrese su contraseña:");
        if(contr == null) {
        	return;
        }
        Usuario usuario = Usuario.Login(mail, contr);
        if (usuario != null) {
            JOptionPane.showMessageDialog(null, "Login exitoso!");
            usuario.Menu();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
        }
    }
    
    private static void registrarCliente() {
        String mail = Validaciones.IngresarMail("Ingrese su email:");
        if(mail == null) {
        	return;
        }
        
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.getMail().equals(mail)) {
                JOptionPane.showMessageDialog(null, "El email ya está registrado");
                return;
            }
        }
        
        String contr = Validaciones.IngresarString("Ingrese su contraseña:");
        if(contr == null) {
        	return;
        }
        
        Cliente nuevoCliente = new Cliente(mail, contr);
        
        
        Cuenta nuevaCuenta = new Cuenta(0);
        nuevoCliente.setCuenta(nuevaCuenta);
        Usuario.getUsuarios().add(nuevoCliente);
        
        JOptionPane.showMessageDialog(null, 
            "Cliente registrado exitosamente!\n" +
            "Número de cuenta: " + nuevaCuenta.getNum_cuenta() + "\n" +
            "Email: " + mail + "\n" +
            "Saldo inicial: $0");
    }
}