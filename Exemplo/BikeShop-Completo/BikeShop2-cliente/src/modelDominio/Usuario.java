/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author herrmann
 */
public class Usuario implements Serializable{
    private static final long serialVersionUID = 123456789L;
    private int codUsuario;
    private String nomeUsuario;
    private String login;
    private String senha;
    private String email;

    public Usuario(int codUsuario, String nomeUsuario, String login, String senha, String email) {
        this.codUsuario = codUsuario;
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String nomeUsuario, String login, String senha, String email) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", nomeUsuario=" + nomeUsuario + ", login=" + login + ", senha=" + senha + ", email=" + email + '}';
    }


    
    
}
