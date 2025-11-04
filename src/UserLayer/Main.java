package UserLayer;

import java.time.LocalDate;
import LogicLayer.Cliente;
import LogicLayer.Empleado;
import LogicLayer.Usuario;

public class Main {
public static void main(String[] args) {
		
		
		Usuario.getUsuarios().add(new Cliente("Joaquin","1234",5000));
		
		Usuario.getUsuarios().add(new Empleado("Angel","1234",LocalDate.now()));
		
		Usuario logueado =  Usuario.Login("Joaquin", "1234");
		
		logueado.Menu();
	}
}
