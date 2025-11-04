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
		
		int opcion = JOptionPane.showOptionDialog(null, "Bienvenido empleado", "", 0, 0, null, this.getRol().getOpciones(),this.getRol().getOpciones()[0]);
	
	}
}
