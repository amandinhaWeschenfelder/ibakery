package controller;

import com.example.bikeshopsocket.InformacoesApp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelDominio.Bike;
import modelDominio.Usuario;

public class ConexaoController {

    InformacoesApp infoApp;

    // Esse método é chamado somente 1 vez.
    public void Conectar(){
        try{
            // sobrescrevendo politicas de restrição
            //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            //StrictMode.setThreadPolicy(policy);
            System.out.println("Conectando no servidor...");
            infoApp.socket = new Socket("10.0.2.2", 12345);
            infoApp.out = new ObjectOutputStream(infoApp.socket.getOutputStream());
            infoApp.in = new ObjectInputStream(infoApp.socket.getInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ConexaoController(InformacoesApp infoApp) {
        this.infoApp = infoApp;
    }

    public ArrayList<Bike> bikeLista(){
        String msg;
        try{
            infoApp.out.writeObject("BikeLista");
            ArrayList<Bike> listabike = (ArrayList<Bike>) infoApp.in.readObject();
            return listabike;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean bikeAlterar(Bike bk){
        String msg = "";
        try{
            infoApp.out.writeObject("BikeAlterar");
            msg = (String) infoApp.in.readObject(); // lendo ok
            infoApp.out.writeObject(bk); // escrevendo a bike
            msg = (String) infoApp.in.readObject(); // lendo ok
            if (msg.equals("ok")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public Usuario efetuarLogin(Usuario usr){
        String msg;
        try{
            infoApp.out.writeObject("UsuarioEfetuarLogin");
            msg = (String) infoApp.in.readObject(); // lendo ok
            infoApp.out.writeObject(usr); // escrevendo o filtro
            Usuario usrselecionado = (Usuario) infoApp.in.readObject();
            return usrselecionado;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean usuarioAlterar(Usuario usr){
        String msg = "";
        try{
            infoApp.out.writeObject("UsuarioAlterar");
            msg = (String) infoApp.in.readObject(); // lendo ok
            infoApp.out.writeObject(usr); // escrevendo o usuário
            msg = (String) infoApp.in.readObject(); // lendo ok
            if (msg.equals("ok")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public void fim() {
        String msg;
        try {
            infoApp.out.writeObject("fim");
            infoApp.in.close();
            infoApp.out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
