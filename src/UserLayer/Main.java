package UserLayer;

import javax.swing.JOptionPane;

import LogicLayer.Cliente;
import LogicLayer.Cuenta;
import LogicLayer.Usuario;
import LogicLayer.Validaciones;


public class Main {
    public static void main(String[] args) {
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
                case 0: 
                    login();
                    break;
                case 1: 
                    registrarCliente();
                    break;
                case 2:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "¡Hasta pronto!");
                    break;
                default:
                    break;
            }
        }
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
        String contr = Validaciones.IngresarString("Ingrese su contraseña:");
        
        // Verificar si el email ya existe
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.getMail().equals(mail)) {
                JOptionPane.showMessageDialog(null, "El email ya está registrado");
                return;
            }
        }
        
        // Crear nuevo cliente
        Cliente nuevoCliente = new Cliente(mail, contr);
        Usuario.getUsuarios().add(nuevoCliente);
        
        // Crear cuenta automáticamente para el cliente
        Cuenta nuevaCuenta = new Cuenta(0);
        nuevoCliente.setCuenta(nuevaCuenta);
        
        JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente!\nNúmero de cuenta: " + nuevaCuenta.getNum_cuenta());
    }
}