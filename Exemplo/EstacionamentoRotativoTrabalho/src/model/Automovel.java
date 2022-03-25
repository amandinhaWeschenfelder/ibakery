package model;

public class Automovel extends Veiculo{

    public Automovel(String t, String d, String p, int c, Proprietario prop, int perma, String data) {
        super.descricao = d;
        super.placa = p;
        super.custo = c;
        super.prop = prop;
        super.permanencia = perma;
        super.data = data;
        super.tipo = t;
    }
    
    public Automovel(String d, String p, int c, int perma, String data) {
        super.descricao = d;
        super.placa = p;
        super.custo = c;
        super.permanencia = perma;
        super.data = data;
    }
}
