package LogicLayer;

import javax.swing.JOptionPane;

public abstract class Validaciones {

	
	
//	public static String IngresarMail(String mensaje) {
//	    String mail;
//	    do {
//	        mail = JOptionPane.showInputDialog(mensaje);
//	        if (mail == null) {
//	            ;
//	        }
//	        if (mail.trim().isEmpty()) {
//	            JOptionPane.showMessageDialog(null, "Error: No puede estar vacío");
//	        } else if (!mail.matches("[^@]+@[^@]+\\.[a-zA-Z]{2,}")) {
//	            JOptionPane.showMessageDialog(null, "Error: Debe seguir el ejemplo: nombre@dominio.com/.ar");
//	        } else {
//	            break;
//	        }
//	    } while (true);
//	    return mail.trim();
//	}
	public static String IngresarMail(String mensaje) {
	    String mail;
	    do {
	        mail = JOptionPane.showInputDialog(mensaje);
	        if (mail == null) {
	            int confirmacion = JOptionPane.showConfirmDialog(
	                null, 
	                "¿Está seguro que desea cancelar?", 
	                "Confirmar", 
	                JOptionPane.YES_NO_OPTION
	            );
	            if (confirmacion == JOptionPane.YES_OPTION) {
	                return null;
	            } else {
	                continue;
	            }
	        }
	        if (mail.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Error: No puede estar vacío");
	        } else if (!mail.matches("[^@]+@[^@]+\\.[a-zA-Z]{2,}")) {
	            JOptionPane.showMessageDialog(null, "Error: Debe seguir el ejemplo: nombre@dominio.com/.ar");
	        } else {
	            break;
	        }
	    } while (true);
	    return mail.trim();
	}
	
    public static String IngresarString(String mensaje) {
        String dato;
        do {
            dato = JOptionPane.showInputDialog(mensaje);
            if (dato == null) {
                return null;
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
                return -1;
            }
            if (dato.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: No puede estar vacío");
                flag = false;
            } else {
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
}