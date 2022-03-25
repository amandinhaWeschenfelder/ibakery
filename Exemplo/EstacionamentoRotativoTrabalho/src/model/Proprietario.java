package model;

import controller.Controladora;

public class Proprietario {
    private String nome;
    private String tel;

    public Proprietario(String n, String t) {
        this.nome = n;
        this.tel = t;
    }

    @Override
    public String toString() {
        return  nome + ", " + Controladora.formatarTelefone(tel);  
    }
}
