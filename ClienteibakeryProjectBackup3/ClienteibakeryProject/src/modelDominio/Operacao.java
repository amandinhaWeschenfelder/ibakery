/**
NOME: Luana Kuntz e Amanda Weschenfelder
TURMA: INF4AT
DATA: 16/02/2022
 */
package modelDominio;

import java.io.Serializable;

public class Operacao implements Serializable {
    private int idOperacao;
    private String dataRetirada;
    private String horaRetirada;
    private float valorTotal;
    private Usuario idUsuario;
    private int tipoOperacao;

    public Operacao(int idOperacao, float valorTotal, Usuario idUsuario, int tipoOperacao) {
        this.idOperacao = idOperacao;
        this.valorTotal = valorTotal;
        this.idUsuario = idUsuario;
        this.tipoOperacao = tipoOperacao;
    }

    public Operacao(int idOperacao, String dataRetirada, String horaRetirada, float valorTotal, Usuario idUsuario, int tipoOperacao) {
        this.idOperacao = idOperacao;
        this.dataRetirada = dataRetirada;
        this.horaRetirada = horaRetirada;
        this.valorTotal = valorTotal;
        this.idUsuario = idUsuario;
        this.tipoOperacao = tipoOperacao;
    }
    
    public int getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(int idOperacao) {
        this.idOperacao = idOperacao;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(String horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(int tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }
    
    
}
