package model;

public class Motocicleta extends Veiculo {

    public Motocicleta(String t, String d, String p, int c, Proprietario prop, int perma, String data) {
        super.descricao = d;
        super.placa = p;
        super.custo = c;
        super.prop = prop;
        super.permanencia = perma;
        super.data = data;
        super.tipo = t;
    }

    public Motocicleta(String d, String p, int c, int perma, String data) {
        super.descricao = d;
        super.placa = p;
        super.custo = c;
        super.permanencia = perma;
        super.data = data;
    }
}
