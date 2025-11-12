package UserLayer;

import javax.swing.JOptionPane;

import LogicLayer.Cliente;
import LogicLayer.Cuenta;
import LogicLayer.Empleado;
import LogicLayer.Usuario;
import LogicLayer.Validaciones;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Agregar datos de prueba
        inicializarDatosPrueba();
        
        boolean salir = false;
        
        while (!salir) {
            String[] opciones = {"Ingresar", "Registrarse", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, 
                "SISTEMA BANCARIO\nSeleccione una opción:", 
                "Bienvenido", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);
            
            switch (opcion) {
                case 0: // Ingresar
                    login();
                    break;
                case 1: // Registrarse
                    registrarCliente();
                    break;
                case 2: // Salir
                    salir = true;
                    JOptionPane.showMessageDialog(null, "¡Hasta pronto!");
                    break;
                default:
                    break;
            }
        }
    }
    
    private static void inicializarDatosPrueba() {
        // Empleado/Admin de prueba
        Usuario.getUsuarios().add(new Empleado("admin@banco", "admin123", LocalDate.now()));
        
        // Cliente de prueba
        Cliente clientePrueba = new Cliente("cliente@prueba", "cliente123");
        Cuenta cuentaPrueba = new Cuenta(5000);
        clientePrueba.setCuenta(cuentaPrueba);
        Usuario.getUsuarios().add(clientePrueba);
    }
    
    private static void login() {
        String mail = Validaciones.IngresarString("Ingrese su email:");
        String contr = Validaciones.IngresarString("Ingrese su contraseña:");
        
        Usuario usuario = Usuario.Login(mail, contr);
        if (usuario != null) {
            JOptionPane.showMessageDialog(null, "Login exitoso!");
            usuario.Menu();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
        }
    }
    
    private static void registrarCliente() {
        String mail = Validaciones.IngresarString("Ingrese su email:");
        
        // Verificar si el email ya existe
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.getMail().equals(mail)) {
                JOptionPane.showMessageDialog(null, "El email ya está registrado");
                return;
            }
        }
        
        String contr = Validaciones.IngresarString("Ingrese su contraseña:");
        
        // Crear nuevo cliente
        Cliente nuevoCliente = new Cliente(mail, contr);
        
        // Crear cuenta automáticamente para el cliente
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