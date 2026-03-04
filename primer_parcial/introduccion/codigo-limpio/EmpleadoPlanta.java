public class EmpleadoPlanta extends Empleado{
    private double salarioBase;
    public EmpleadoPlanta(double salarioBase){
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalario(){
        double salario = salarioBase;
        return salario;
    }

}
