public class EmpleadoHora extends Empleado {
    private double tarifaPorHora;
    private double horasTrabajadas;

    public EmpleadoHora(double tarifaPorHora, double horasTrabajadas){
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario(){
        double salario = tarifaPorHora*horasTrabajadas;
        return salario;
    }
}
