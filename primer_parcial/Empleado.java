
public class Empleado
{
    private String tipo;
    private double salarioBase;
    private double tarifaPorHora;
    private double horasTrabajadas;
    private int cantidadVentas;
    private double porcentajeComision;
    
    public Empleado(String tipo){
        this.tipo = tipo;
    }
    
    public double calcularSalario(){
        double salario;
        if(tipo.equals("PLANTA")){
            salario = salarioBase;
        }else if(tipo.equals("HORA")){
            salario = horasTrabajadas*tarifaPorHora;
        }else if(tipo.equals("COMISION")){
            salario = cantidadVentas*porcentajeComision;
        }else{
            salario = 0.0;
        }
        return salario;
    }
}
