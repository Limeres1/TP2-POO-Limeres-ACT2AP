package LogicLayer;

import javax.swing.JOptionPane;

public class Cliente extends Usuario {
    private Cuenta cuenta;
    
    public Cliente(String mail, String contr) {
        super(mail, contr, Rol.Cliente);
    }
    
    public Cuenta getCuenta() {
        return cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    @Override
    public void Menu() {
        boolean salir = false;
        
        while (!salir) {
            int opcion = JOptionPane.showOptionDialog(null, 
                "Bienvenido Cliente\nCuenta: " + cuenta.getNum_cuenta() + 
                "\nSaldo: $" + cuenta.getSaldo(), 
                "Menú Cliente", 
                0, 0, null, 
                this.getRol().getOpciones(), 
                this.getRol().getOpciones()[0]);
            
            switch (opcion) {
                case 0: // Transferir
                    transferir();
                    break;
                case 1: // Depositar
                    depositar();
                    break;
                case 2: // Retirar
                    retirar();
                    break;
                case 3: // Consultar saldo
                    consultarSaldo();
                    break;
                case 4: // Historial transacciones
                    verHistorial();
                    break;
                case 5: // Salir
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }
    
    private void transferir() {
        int cuentaDestino = Validaciones.IngresarInt("Ingrese número de cuenta destino:");
        int monto = Validaciones.IngresarInt("Ingrese monto a transferir:");
        
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "Monto debe ser mayor a 0");
            return;
        }
        
        if (cuenta.getSaldo() < monto) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return;
        }
        
        // Buscar cuenta destino (en un sistema real, buscaría en base de datos)
        Cuenta destino = buscarCuenta(cuentaDestino);
        if (destino == null) {
            JOptionPane.showMessageDialog(null, "Cuenta destino no encontrada");
            return;
        }
        
        // Realizar transferencia
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        destino.setSaldo(destino.getSaldo() + monto);
        
        // Registrar transacción
        Transaccion transaccion = new Transaccion(monto, "TRANSFERENCIA", "Electrónico", cuenta, destino);
        cuenta.getTransacciones().add(transaccion);
        destino.getTransacciones().add(transaccion);
        
        JOptionPane.showMessageDialog(null, "Transferencia exitosa!\nNuevo saldo: $" + cuenta.getSaldo());
    }
    
    private void depositar() {
        int monto = Validaciones.IngresarInt("Ingrese monto a depositar:");
        
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "Monto debe ser mayor a 0");
            return;
        }
        
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        
        Transaccion transaccion = new Transaccion(monto, "DEPÓSITO", "Efectivo", null, cuenta);
        cuenta.getTransacciones().add(transaccion);
        
        JOptionPane.showMessageDialog(null, "Depósito exitoso!\nNuevo saldo: $" + cuenta.getSaldo());
    }
    
    private void retirar() {
        int monto = Validaciones.IngresarInt("Ingrese monto a retirar:");
        
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "Monto debe ser mayor a 0");
            return;
        }
        
        if (cuenta.getSaldo() < monto) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return;
        }
        
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        
        Transaccion transaccion = new Transaccion(monto, "RETIRO", "Efectivo", cuenta, null);
        cuenta.getTransacciones().add(transaccion);
        
        JOptionPane.showMessageDialog(null, "Retiro exitoso!\nNuevo saldo: $" + cuenta.getSaldo());
    }
    
    private void consultarSaldo() {
        JOptionPane.showMessageDialog(null, 
            "Número de cuenta: " + cuenta.getNum_cuenta() + 
            "\nSaldo actual: $" + cuenta.getSaldo());
    }
    
    private void verHistorial() {
        if (cuenta.getTransacciones().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay transacciones registradas");
            return;
        }
        
        StringBuilder historial = new StringBuilder("Historial de transacciones:\n");
        for (Transaccion trans : cuenta.getTransacciones()) {
            historial.append(trans.getTipo()).append(": $").append(trans.getMonto())
                     .append(" - ").append(trans.getFecha_hora()).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, historial.toString());
    }
    
    private Cuenta buscarCuenta(int numeroCuenta) {
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getCuenta().getNum_cuenta() == numeroCuenta) {
                    return cliente.getCuenta();
                }
            }
        }
        return null;
    }
}