package LogicLayer;

import java.time.LocalDate;

public class RegistroInversion {
    private LocalDate fecha;
    private double saldoInicial;
    private double tasaInteres;
    private double saldoFinal;
    private String tipoMovimiento;
    
    public RegistroInversion(LocalDate fecha, double saldoInicial, double tasaInteres, 
                           double saldoFinal, String tipoMovimiento) {
        this.fecha = fecha;
        this.saldoInicial = saldoInicial;
        this.tasaInteres = tasaInteres;
        this.saldoFinal = saldoFinal;
        this.tipoMovimiento = tipoMovimiento;
    }
    
    // Getters
    public LocalDate getFecha() { return fecha; }
    public double getSaldoInicial() { return saldoInicial; }
    public double getTasaInteres() { return tasaInteres; }
    public double getSaldoFinal() { return saldoFinal; }
    public String getTipoMovimiento() { return tipoMovimiento; }
}