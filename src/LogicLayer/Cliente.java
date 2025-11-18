package LogicLayer;

import java.time.LocalDate;
import java.util.LinkedList;

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
                case 0: transferir(); break;
                case 1: depositar(); break;
                case 2: retirar(); break;
                case 3: consultarSaldo(); break;
                case 4: verHistorial(); break;
                case 5: pedirPrestamo(); break;
                case 6: consultarPrestamo(); break;
                case 7: salir = true; break;
                default: break;
            }
        }
    }
    
    private void transferir() {
        if (!cuenta.getEstadoCuenta().equals("ACTIVA")) {
            JOptionPane.showMessageDialog(null, "Cuenta inactiva. No puede realizar transferencias");
            return;
        }
        
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
        
        Cuenta destino = buscarCuenta(cuentaDestino);
        if (cuentaDestino == this.cuenta.getNum_cuenta()) {
            JOptionPane.showMessageDialog(null, "No puede transferir a su propia cuenta");
            return;
        }
        if (destino == null) {
            JOptionPane.showMessageDialog(null, "Cuenta destino no encontrada");
            return;
        }
        
        if (!destino.getEstadoCuenta().equals("ACTIVA")) {
            JOptionPane.showMessageDialog(null, "Cuenta destino está inactiva");
            return;
        }
        
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        destino.setSaldo(destino.getSaldo() + monto);
        
        Transaccion transaccion = new Transaccion(monto, "TRANSFERENCIA", "Electrónico", cuenta, destino);
        cuenta.getTransacciones().add(transaccion);
        destino.getTransacciones().add(transaccion);
        
        JOptionPane.showMessageDialog(null, "Transferencia exitosa!\nNuevo saldo: $" + cuenta.getSaldo());
    }
    
    private void depositar() {
        if (!cuenta.getEstadoCuenta().equals("ACTIVA")) {
            JOptionPane.showMessageDialog(null, "Cuenta inactiva. No puede realizar depósitos");
            return;
        }
        
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
        if (!cuenta.getEstadoCuenta().equals("ACTIVA")) {
            JOptionPane.showMessageDialog(null, "Cuenta inactiva. No puede realizar retiros");
            return;
        }
        
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
            "\nSaldo actual: $" + cuenta.getSaldo() +
            "\nEstado: " + cuenta.getEstadoCuenta());
    }
    
    private void verHistorial() {
        if (cuenta.getTransacciones().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay transacciones registradas");
            return;
        }
        
    
        String historial = "Historial de transacciones:\n\n";
        for (Transaccion trans : cuenta.getTransacciones()) {
            historial = historial + trans.getTipo() + ": $" + trans.getMonto() + 
                       " - " + trans.getFecha_hora() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, historial);
    }
    
    private void pedirPrestamo() {
    	
        double monto = Validaciones.IngresarDouble("Ingrese monto del préstamo:");
        
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0");
            return;
        }
        
        if (monto > 50000) {
            JOptionPane.showMessageDialog(null, "El monto máximo por préstamo es $50,000");
            return;
        }
        
        int meses = Validaciones.IngresarInt("Ingrese a cuántos meses (6, 12, 24, 36):");
        if (meses != 6 && meses != 12 && meses != 24 && meses != 36) {
            JOptionPane.showMessageDialog(null, "Plazo no válido. Use: 6, 12, 24 o 36 meses");
            return;
        }
        
        //prestamo
        double tasa = calcularTasaInteres(meses);
        double interesTotal = monto * tasa;
        double montoTotal = monto + interesTotal;
        double cuotaMensual = montoTotal / meses;
        
        LocalDate fechaVencimiento = LocalDate.now().plusMonths(meses);
        
        
        String resumen = String.format(
            "RESUMEN DEL PRÉSTAMO:\n\n" +
            "Monto solicitado: $%.2f\n" +
            "Plazo: %d meses\n" +
            "Tasa de interés: %.1f%%\n" +
            "Interés total: $%.2f\n" +
            "Monto total a pagar: $%.2f\n" +
            "Cuota mensual: $%.2f\n" +
            "Fecha de vencimiento: %s\n\n" +
            "¿Aceptar el préstamo?",
            monto, meses, tasa * 100, interesTotal, montoTotal, cuotaMensual, fechaVencimiento
        );
        
        int confirmacion = JOptionPane.showConfirmDialog(null, resumen, "Confirmar Préstamo", JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            
            Prestamo prestamo = new Prestamo(monto, tasa, meses, fechaVencimiento, this.cuenta);
            prestamo.setMontoTotal(montoTotal);
            prestamo.setMontoPendiente(montoTotal);
            prestamo.setEstado("APROBADO");
            prestamo.setFechaAprobacion(LocalDate.now());
            
          
            generarCuotas(prestamo, cuotaMensual);
            
          
            this.cuenta.getPrestamos().add(prestamo);
            
            
            this.cuenta.setSaldo(this.cuenta.getSaldo() + (int)monto);
            
            
            Transaccion transaccion = new Transaccion(monto, "PRÉSTAMO", "Desembolso", null, this.cuenta);
            this.cuenta.getTransacciones().add(transaccion);
            
            JOptionPane.showMessageDialog(null, 
                "¡Préstamo aprobado!\n" +
                "El monto de $" + monto + " ha sido depositado.\n" +
                "Nuevo saldo: $" + this.cuenta.getSaldo());
        }
    }
    
    private void consultarPrestamo() {
        if (cuenta.getPrestamos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tiene préstamos activos");
            return;
        }
        
        LinkedList<Prestamo> prestamosAprobados = new LinkedList<>();
        for (Prestamo prestamo : cuenta.getPrestamos()) {
            if ("APROBADO".equals(prestamo.getEstado())) {
                prestamosAprobados.add(prestamo);
            }
        }
        
        if (prestamosAprobados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tiene préstamos aprobados");
            return;
        }
        
        String[] opciones = new String[prestamosAprobados.size()];
        for (int i = 0; i < prestamosAprobados.size(); i++) {
            Prestamo p = prestamosAprobados.get(i);
            opciones[i] = "Préstamo: $" + String.format("%.2f", p.getMontoTotal());
        }
        
        String seleccion = (String) JOptionPane.showInputDialog(
            null, "Seleccione un préstamo:", "Consultar Préstamos",
            JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]
        );
        
        if (seleccion != null) {
            for (int i = 0; i < opciones.length; i++) {
                if (opciones[i].equals(seleccion)) {
                    Prestamo prestamo = prestamosAprobados.get(i);
                    
                    int cuotasPagadas = 0;
                    int cuotasPendientes = 0;
                    for (Cuota cuota : prestamo.getCuotas()) {
                        if ("PAGADA".equals(cuota.getEstado())) {
                            cuotasPagadas++;
                        } else {
                            cuotasPendientes++;
                        }
                    }
                    
                    String info = "INFORMACIÓN DEL PRÉSTAMO:\n\n" +
                                 "Monto inicial: $" + String.format("%.2f", prestamo.getMontoTotal() / (1 + prestamo.getTasaInteres())) + "\n" +
                                 "Monto total: $" + String.format("%.2f", prestamo.getMontoTotal()) + "\n" +
                                 "Monto pendiente: $" + String.format("%.2f", prestamo.getMontoPendiente()) + "\n" +
                                 "Cuotas totales: " + prestamo.getPlazoMeses() + "\n" +
                                 "Cuotas pagadas: " + cuotasPagadas + "\n" +
                                 "Cuotas pendientes: " + cuotasPendientes + "\n" +
                                 "Cuota mensual: $" + String.format("%.2f", prestamo.getCuotas().get(0).getMontoCuota()) + "\n" +
                                 "Fecha vencimiento: " + prestamo.getFechaVencimiento();
                    
                    JOptionPane.showMessageDialog(null, info);
                    break;
                }
            }
        }
    }
    
    private double calcularTasaInteres(int meses) {
        switch (meses) {
            case 6: return 0.05;  // 5%
            case 12: return 0.08; // 8%
            case 24: return 0.12; // 12%
            case 36: return 0.15; // 15%
            default: return 0.10; // 10%
        }
    }
    
    private void generarCuotas(Prestamo prestamo, double cuotaMensual) {
        prestamo.setCuotas(new java.util.LinkedList<Cuota>());
        
        for (int i = 1; i <= prestamo.getPlazoMeses(); i++) {
            LocalDate fechaVencimiento = LocalDate.now().plusMonths(i);
            Cuota cuota = new Cuota(cuotaMensual, fechaVencimiento, "PENDIENTE", 0);
            prestamo.getCuotas().add(cuota);
        }
    }
    
    private Cuenta buscarCuenta(int numeroCuenta) {
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.esCliente()) {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getCuenta().getNum_cuenta() == numeroCuenta) {
                    return cliente.getCuenta();
                }
            }
        }
        return null;
    }
}