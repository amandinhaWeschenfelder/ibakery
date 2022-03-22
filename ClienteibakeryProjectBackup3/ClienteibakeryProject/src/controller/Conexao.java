/**
 * NOME: Luana Kuntz e Amanda Weschenfelder
 * TURMA: INF4AT
 * DATA: 13/02/2022
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import modelDominio.Produto;
import modelDominio.Usuario;
import modelDominio.Operacao;
import java.io.Serializable;
import java.util.ArrayList;

public class Conexao implements Serializable {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Conexao(ObjectInputStream in, ObjectOutputStream out) {
        this.out = out;
        this.in = in;
    }

    // INSERIR GERENTE //
    public int inserirGerente(String nome, String sobrenome, String telefone, String email, String senha, String cnpj, String cpf, int tipoUsuario) {
        String msg;
        try {
            out.writeObject("InserirGerente");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                Usuario gerente = new Usuario(nome, sobrenome, telefone, email, senha, cnpj, cpf, tipoUsuario);
                out.writeObject(gerente);
                return (Integer) in.readObject();
            }
            return 0;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao inserir gerente: "
                    + ex.getMessage() + ".");
            return 0;
        }
    }

    // INSERIR FUNCIONÁRIO OU CLIENTE //
    public int inserirUsuario(String nome, String sobrenome, String telefone, String email, String senha, String cnpj, String cpf, int tipoUsuario) {
        String msg;
        try {
            out.writeObject("InserirUsuario");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                Usuario usuario = new Usuario(nome, sobrenome, telefone, email, senha, cnpj, cpf, tipoUsuario);
                out.writeObject(usuario);
                return (Integer) in.readObject();
            }
            return 0;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao inserir usuário: "
                    + ex.getMessage() + ".");
            return 0;
        }
    }
    
    // LOGIN //
    public Usuario validaUsuario(String email, String senha) {
        String msg;
        try {
            out.writeObject("ValidaUsuario");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                Usuario usuario = new Usuario(email, senha);
                out.writeObject(usuario);
                return (Usuario) in.readObject();
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao buscar usuário: "
                    + ex.getMessage() + ".");
            return null;
        }
    }

    // INSERIR PRODUTO //
    public int inserirProduto(String nome, float precoCusto, float valorVenda, int estoque, int tipoProduto) {        
        String msg;
        try {
            out.writeObject("InserirProduto");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                Produto produto = new Produto(nome, precoCusto, valorVenda, estoque, tipoProduto);
                out.writeObject(produto);
                return (Integer) in.readObject();
            }
            return 0;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao inserir produto: "
                    + ex.getMessage() + ".");
            return 0;
        }
    }
    
    public ArrayList<Usuario> usuariosGetListaUsuarios() {
        String msg;
        try {
            out.writeObject("UsuariosGetListaUsuarios");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return (ArrayList<Usuario>) in.readObject();
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os usuarios: "
                    + ex.getMessage() + ".");
            return null;
        }
    }
    
    public ArrayList<Usuario> usuariosGetListaUsuariosNome(String nome) {
        String msg;
        try {
            out.writeObject("UsuariosGetListaUsuariosNome");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                out.writeObject(nome);
                return (ArrayList<Usuario>) in.readObject();
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os usuários por nome: "
                    + ex.getMessage() + ".");
            return null;
        }
    }
    
    public ArrayList<Usuario> usuariosGetListaUsuariosId(int id) {
        String msg;
        try {
            out.writeObject("UsuariosGetListaUsuariosId");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                out.writeObject(id);
                return (ArrayList<Usuario>) in.readObject();
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os usuários por ID: "
                    + ex.getMessage() + ".");
            return null;
        }
    }  
    
    // ATUALIZAR PRODUTO //
    public int atualizarProduto(int id, float precoCusto, float valorVenda, int estoque) {        
        String msg;
        try {
            out.writeObject("AtualizarProduto");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                Produto produto = new Produto(id, precoCusto, valorVenda, estoque);
                out.writeObject(produto);
                return (Integer) in.readObject();
            }
            return 0;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao inserir produto: "
                    + ex.getMessage() + ".");
            return 0;
        }
    }
    
    public ArrayList<Produto> produtosGetListaProdutos() {
        String msg;
        try {
            out.writeObject("ProdutosGetListaProdutos");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return (ArrayList<Produto>) in.readObject();
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os produtos: "
                    + ex.getMessage() + ".");
            return null;
        }
    }
    
    public ArrayList<Produto> produtosGetListaProdutosNome(String nome) {
        String msg;
        try {
            out.writeObject("ProdutosGetListaProdutosNome");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                out.writeObject(nome);
                return (ArrayList<Produto>) in.readObject();
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os produtos por nome: "
                    + ex.getMessage() + ".");
            return null;
        }
    }
    
    public ArrayList<Produto> produtosGetListaProdutosId(int id) {
        String msg;
        try {
            out.writeObject("ProdutosGetListaProdutosId");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                out.writeObject(id);
                return (ArrayList<Produto>) in.readObject();
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os produtos por ID: "
                    + ex.getMessage() + ".");
            return null;
        }
    }      

    // INSERIR VENDA //
    public int inserirVenda(int idOperacao, float valorTotal, Usuario idUsuario, int tipoOperacao) {
        String msg;
        try {
            out.writeObject("InserirVenda");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                Operacao venda = new Operacao(idOperacao, valorTotal, idUsuario, tipoOperacao);
                out.writeObject(venda);
                return (Integer) in.readObject();
            }
            return 0;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao inserir venda: "
                    + ex.getMessage() + ".");
            return 0;
        }
    }

    // INSERIR ENCOMENDA //
    public int inserirEncomenda(int idOperacao, String dataRetirada, String horaRetirada, float valorTotal, Usuario idUsuario, int tipoOperacao) {
        String msg;
        try {
            out.writeObject("InserirEncomenda");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                Operacao encomenda = new Operacao(idOperacao, dataRetirada, horaRetirada, valorTotal, idUsuario, tipoOperacao);
                out.writeObject(encomenda);
                return (Integer) in.readObject();
            }
            return 0;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao inserir encomenda: "
                    + ex.getMessage() + ".");
            return 0;
        }
    }

    // CADASTRAR PRODUÇÃO //
    // LISTAR NO COMBOBOX //
    public ArrayList<Produto> produtosGetComboBoxProdutos() {
        String msg;
        try {
            out.writeObject("ProdutosGetComboBoxProdutos");
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return (ArrayList<Produto>) in.readObject();
            }
            return null;

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao buscar os produtos: "
                    + ex.getMessage() + ".");
            return null;
        }
    }
    // AUTENTICAR USUÁRIO //    
    // VALIDAR E-MAIL //
    // VALIDAR NOVA SENHA //    
}
