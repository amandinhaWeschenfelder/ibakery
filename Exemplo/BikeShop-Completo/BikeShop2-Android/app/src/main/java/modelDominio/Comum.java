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
public class Comum extends Usuario implements Serializable {
    
        private static final long serialVersionUID = 123456789L;

    public Comum(int codUsuario, String nomeUsuario, String login, String senha, String email) {
        super(codUsuario, nomeUsuario, login, senha, email);
    }

    public Comum(String nomeUsuario, String login, String senha, String email) {
        super(nomeUsuario, login, senha, email);
    }
                
    @Override
    public String toString() {
        return super.toString()+"Comum{" + '}';
    }
    
}
