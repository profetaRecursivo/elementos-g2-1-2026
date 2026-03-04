public class EmpleadoComision  extends Empleado{
    private int cantidadVentas;
    private double porcentajeComision;
    public EmpleadoComision(int cantidadVentas, double porcentajeComision){
        this.cantidadVentas = cantidadVentas;
        this.porcentajeComision = porcentajeComision;
    }
    @Override
    public double calcularSalario(){
        double salario = cantidadVentas*porcentajeComision;
        return salario;
    }
}
