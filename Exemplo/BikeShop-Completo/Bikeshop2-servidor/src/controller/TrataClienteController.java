/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import modelDominio.Bike;
import model.BikeDao;
import modelDominio.Marca;
import model.MarcaDao;
import model.UsuarioDao;
import modelDominio.Usuario;
/**
 *
 * @author herrmann
 */
public class TrataClienteController extends Thread {

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket s;
    private int idUnico;

    // Constructor 
    public TrataClienteController(Socket s, ObjectInputStream in, ObjectOutputStream out, int idUnico) {
        this.s = s;
        this.in = in;
        this.out = out;
        this.idUnico = idUnico;
        this.start();
    }

    @Override
    public void run() {
        String comando;
        System.out.println("Esperando comandos do cliente");
        try {
            comando = (String) in.readObject();
            //enquanto comando não for "fim" permanece no looping
            while (!comando.equalsIgnoreCase("fim")) {
                System.out.println("Cliente "+idUnico+" enviou comando: "+comando);
                // Qual é o comando????
                if (comando.equalsIgnoreCase("BikeInserir")){
                    out.writeObject("ok"); 
                    // esperando o objeto bike vir do cliente
                    Bike bike = (Bike) in.readObject();
                    // criando um Dao para armazenar no Banco
                    BikeDao bkdao = new BikeDao();
                    if (bkdao.inserir(bike) == -1){
                        out.writeObject("ok");
                    }else{
                        out.writeObject("nok");
                    }
                }else if (comando.equalsIgnoreCase("BikeAlterar")){
                    out.writeObject("ok"); 
                    // esperando o objeto bike vir do cliente
                    Bike bike = (Bike) in.readObject();
                    // criando um Dao para armazenar no Banco
                    BikeDao bkdao = new BikeDao();
                    if (bkdao.alterar(bike) == -1){
                        out.writeObject("ok");
                    }else{
                        out.writeObject("nok");
                    }
                }else if (comando.equalsIgnoreCase("BikeExcluir")){
                    out.writeObject("ok"); 
                    // esperando o objeto bike vir do cliente
                    Bike bike = (Bike) in.readObject();
                    // criando um Dao para armazenar no Banco
                    BikeDao bkdao = new BikeDao();
                    if (bkdao.excluir(bike) == -1){
                        out.writeObject("ok");
                    }else{
                        out.writeObject("nok");
                    }
                }else if (comando.equalsIgnoreCase("BikeLista")){
                    BikeDao bkdao = new BikeDao();
                    ArrayList<Bike> listaBike = bkdao.getListaBikes();
                    out.writeObject(listaBike);
                }else if (comando.equalsIgnoreCase("MarcaInserir")){
                    out.writeObject("ok"); 
                    // esperando o objeto Marca vir do cliente
                    Marca mc = (Marca) in.readObject();
                    // criando um Dao para armazenar no Banco
                    MarcaDao mcdao = new MarcaDao();
                    mcdao.inserir(mc);
                    out.writeObject("ok");                    
                }else if (comando.equalsIgnoreCase("MarcaAlterar")){
                    out.writeObject("ok"); 
                    // esperando o objeto Marca vir do cliente
                    Marca mc = (Marca) in.readObject();
                    // criando um Dao para armazenar no Banco
                    MarcaDao mcdao = new MarcaDao();
                    mcdao.alterar(mc);
                    out.writeObject("ok");                    
                }else if (comando.equalsIgnoreCase("MarcaExcluir")){
                    out.writeObject("ok"); 
                    // esperando o objeto Marca vir do cliente
                    Marca mc = (Marca) in.readObject();
                    // criando um Dao para armazenar no Banco
                    MarcaDao mcdao = new MarcaDao();
                    mcdao.excluir(mc);
                    out.writeObject("ok");                    
                }else if (comando.equalsIgnoreCase("MarcaLista")){
                    out.writeObject("ok"); 
                    // no pedido da lista não precisa mais nenhum parâmetro
                    // criando um Dao para armazenar no Banco
                    MarcaDao mcdao = new MarcaDao();
                    ArrayList<Marca> listamarca = mcdao.getListaMarcas();
                    out.writeObject(listamarca);                    
                }else if (comando.equalsIgnoreCase("MarcaListaNome")){
                    out.writeObject("ok"); 
                    // Nessa consulta eu preciso esperar o nome para realizar um filtro
                    String nome = (String) in.readObject();
                    MarcaDao mcdao = new MarcaDao();
                    ArrayList<Marca> listamarca = mcdao.getListaMarcasNome(nome);
                    out.writeObject(listamarca);// escrevendo a saída
                }else if (comando.equalsIgnoreCase("UsuarioEfetuarLogin")){
                    out.writeObject("ok"); 
                    Usuario usr = (Usuario) in.readObject(); // pegando o login do usuário
                    UsuarioDao usrdao = new UsuarioDao(); 
                    Usuario usrselecionado = usrdao.efetuarLogin(usr); // existe no banco
                    out.writeObject(usrselecionado);// escrevendo a saída
                }else if (comando.equalsIgnoreCase("UsuarioAlterar")){
                    out.writeObject("ok"); 
                    // esperando o objeto usuáriolistamarca vir do cliente
                    Usuario usr = (Usuario) in.readObject();
                    System.out.println(usr);
                    // criando um Dao para armazenar no Banco
                    UsuarioDao usrdao = new UsuarioDao();
                    usrdao.alterar(usr);
                    out.writeObject("ok");                    
                }else if (comando.equalsIgnoreCase("UsuarioInserir")){
                    out.writeObject("ok"); 
                    // esperando o objeto usuário vir do cliente
                    Usuario usr = (Usuario) in.readObject();
                    // criando um Dao para armazenar no Banco
                    UsuarioDao usrdao = new UsuarioDao();
                    usrdao.inserir(usr);
                    out.writeObject("ok");                    
                }else if (comando.equalsIgnoreCase("UsuarioExcluir")){
                    out.writeObject("ok"); 
                    // esperando o objeto usuário vir do cliente
                    Usuario usr = (Usuario) in.readObject();
                    // criando um Dao para armazenar no Banco
                    UsuarioDao usrdao = new UsuarioDao();
                    usrdao.excluir(usr);
                    out.writeObject("ok");                    
                }else if (comando.equalsIgnoreCase("UsuarioLista")){
                    out.writeObject("ok"); 
                    // no pedido da lista não precisa mais nenhum parâmetro
                    // criando um Dao para armazenar no Banco
                    UsuarioDao usrdao = new UsuarioDao();
                    ArrayList<Usuario> listausr = usrdao.getListaUsuarios();
                    out.writeObject(listausr);
                }else{
                    // comando inválido e não reconhecido
                    out.writeObject("nok"); 
                }
                comando = (String)in.readObject();
            }        
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        try {
            // fechando recursos ocupados pelo cliente.
            System.out.println("Cliente "+idUnico+" finalizou a conexão");
            this.in.close();
            this.out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
