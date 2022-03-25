/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDominio;

import java.io.Serializable;

/**
 * Classe de domínio para as Marcas.
 *
 * @author herrmann
 */
public class Marca implements Serializable{
    private static final long serialVersionUID = 123456789L;
    private int codmarca;
    private String nomemarca;

    public Marca(int codmarca) {
        this.codmarca = codmarca;
    }

    public Marca(int codmarca, String nomemarca) {
        this.codmarca = codmarca;
        this.nomemarca = nomemarca;
    }

    public int getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(int codmarca) {
        this.codmarca = codmarca;
    }

    public String getNomemarca() {
        return nomemarca;
    }

    public void setNomemarca(String nomemarca) {
        this.nomemarca = nomemarca;
    }

    public Marca(String nomemarca) {
        this.nomemarca = nomemarca;
    }

    @Override
    public String toString() {
        return "Marca{" + "codmarca=" + codmarca + ", nomemarca=" + nomemarca + '}';
    }

    
    
}
