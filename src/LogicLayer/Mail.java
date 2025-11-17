package LogicLayer;

import javax.swing.JOptionPane;

public class Mail {
	
	public static void main(String[] args) {
		
			String mail= JOptionPane.showInputDialog("Ingrese mail");
			
		    if (mail.matches("[^@]+@[^@]+\\.[a-zA-Z]{2,}")) {
				JOptionPane.showMessageDialog(null, "Valido");
			} else {
				JOptionPane.showMessageDialog(null, "No valido");
			}
	}
}


