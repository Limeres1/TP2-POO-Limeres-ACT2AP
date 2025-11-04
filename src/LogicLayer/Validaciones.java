package LogicLayer;

import javax.swing.JOptionPane;

public abstract class Validaciones {

	public static String IngresarString(String mensaje) {
		String dato;
		do {
			dato = JOptionPane.showInputDialog(mensaje);
			if (dato.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error");
			}
		} while (dato.isEmpty());
		return dato;
	}
	public static int IngresarInt(String mensaje) {
		boolean flag;
		String dato ="Gamaliel";
		
		do {
			flag = true;
			dato = JOptionPane.showInputDialog(mensaje);
			if (dato.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error");
				flag = false;
			}else {
				for (int i = 0; i < dato.length(); i++) {
					//recorro cada caracter dato.charAt(i) i varia
					if (!Character.isDigit(dato.charAt(i)) && dato.charAt(0) !='-' ) {
						//Si el caracter, no es un digito
						flag = false;
						JOptionPane.showMessageDialog(null, "El dato no puede ser letras");
						break;
					}
				}
			}
		} while (flag==false);
		return Integer.parseInt(dato) ;
	}

}