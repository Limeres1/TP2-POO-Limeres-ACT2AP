package LogicLayer;

import javax.swing.JOptionPane;

public abstract class Validaciones {

    public static String IngresarString(String mensaje) {
        String dato;
        do {
            dato = JOptionPane.showInputDialog(mensaje);
            if (dato == null) {
                return null; // Usuario canceló
            }
            if (dato.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: No puede estar vacío");
            }
        } while (dato.trim().isEmpty());
        return dato.trim();
    }
    
    public static int IngresarInt(String mensaje) {
        boolean flag;
        String dato;
        
        do {
            flag = true;
            dato = JOptionPane.showInputDialog(mensaje);
            if (dato == null) {
                return -1; // Usuario canceló
            }
            if (dato.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: No puede estar vacío");
                flag = false;
            } else {
                // Verificar que sea número válido
                try {
                    Integer.parseInt(dato);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido");
                    flag = false;
                }
            }
        } while (!flag);
        return Integer.parseInt(dato);
    }
    
    public static double IngresarDouble(String mensaje) {
        boolean flag;
        String dato;
        
        do {
            flag = true;
            dato = JOptionPane.showInputDialog(mensaje);
            if (dato == null) {
                return -1;
            }
            if (dato.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: No puede estar vacío");
                flag = false;
            } else {
                try {
                    Double.parseDouble(dato);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido");
                    flag = false;
                }
            }
        } while (!flag);
        return Double.parseDouble(dato);
    }
    
    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }
}