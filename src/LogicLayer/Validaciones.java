package LogicLayer;

import javax.swing.JOptionPane;

public abstract class Validaciones {

	
	
    public static String IngresarMail(String mensaje) {
        String mail;
        do {
        	mail = JOptionPane.showInputDialog(mensaje);
            if (mail == null) {
            	JOptionPane.showMessageDialog(null, "Error: No debe estar vacio.");
                return null;
            }
            if (!mail.matches("[^@]+@[^@]+\\.[a-zA-Z]{2,}")) {
                JOptionPane.showMessageDialog(null, "Error: Debe seguir el ejemplo: nombre@dominio.com/.ar");
                return null;
            }
        } while (mail.trim().isEmpty());
        return mail;
    }
	
	
	public static String validarEmailCompleto(String mensaje) {
	    String dato;
	    
	    do {
	        dato = JOptionPane.showInputDialog(mensaje);
	        if (dato == null) {
	            return null;
	        }
	        
	        if (dato.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Error: No puede estar vacío");
	            continue;
	        }
	        
	        
	        if (!dato.contains("@")) {
	            JOptionPane.showMessageDialog(null, "Error: Debe contener @");
	            continue;
	        }
	        
	        String[] partes = dato.split("@");
	        
	        if (partes.length != 2) {
	            JOptionPane.showMessageDialog(null, "Error: Formato de email incorrecto");
	            continue;
	        }
	        
	        String usuario = partes[0];    
	        String dominio = partes[1];    
	        
	        if (usuario.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Error: Falta el nombre de usuario antes del @\n" +
	                    "Formato correcto: usuario@dominio.com\n");
	            continue; 
	        }
	        
	        if (dominio.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Error: Falta el dominio después del @");
	            continue;
	        }
	        String[] partes2 = dominio.split("\\.");
	        
	        if (partes2.length != 2) {
	            JOptionPane.showMessageDialog(null, "Error: Formato de email incorrecto");
	            continue;
	        }
	        
	        String dominio2 = partes2[0];
	        String com = partes2[1];
	        
	        if (dominio2.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Error: Falta el nombre del dominio @\n" +
	                    "Formato correcto: usuario@dominio.com\n");
	            continue; 
	        }
	        
	        if (com.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Error: Falta la extension de dominio (.com)");
	            continue;
	        }
	        
	        return dato;
	        
	    } while (true);
	} // PREGUNTAR COMO SE PUEDE ARREGLAR
	
	
	
	
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