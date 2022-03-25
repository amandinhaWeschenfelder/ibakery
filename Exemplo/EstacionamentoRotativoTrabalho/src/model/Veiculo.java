package model;

import controller.Controladora;

public class Veiculo{
    protected String tipo;
    protected String descricao;
    protected String placa;
    protected Proprietario prop;
    protected int permanencia;
    protected String data;
    protected int custo;
    
    public float calcularCusto(){
        return custo*permanencia;
    }
    
    @Override
    public String toString() {
        return tipo + " " + descricao + " (" + Controladora.formatarPlaca(this.placa) + ")"
               + "\n - " + prop.toString() 
               + "\n - Entrada: " + data.toString()
               + "\n - Saída: " + Controladora.dataSaida(permanencia)
               + "\n - Custo: R$" + calcularCusto();
    }
}
