/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Bike;
import modelDominio.Marca;
import modelDominio.Usuario;

/**
 *
 * @author herrmann
 */
public class ConexaoController {
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private int idUnico;
    // Esse atributo vai armazenar o usuário logado no sistema
    public Usuario usuario;
    
    public ConexaoController(ObjectInputStream in,ObjectOutputStream out,int idUnico) {
        this.in=in;
        this.out=out;
        this.idUnico=idUnico;
    }    

    public Boolean bikeInserir(Bike bk){
        String msg = "";
        try{
            out.writeObject("BikeInserir");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(bk); // escrevendo a bike
            msg = (String) in.readObject(); // lendo ok
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

    public Boolean bikeAlterar(Bike bk){
        String msg = "";
        try{
            out.writeObject("BikeAlterar");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(bk); // escrevendo a bike
            msg = (String) in.readObject(); // lendo ok
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
    
    public Boolean bikeExcluir(Bike bk){
        String msg = "";
        try{
            out.writeObject("BikeExcluir");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(bk); // escrevendo a bike
            msg = (String) in.readObject(); // lendo ok
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
    
    public ArrayList<Bike> bikeLista(){
        String msg;
        try{
            out.writeObject("BikeLista");
            ArrayList<Bike> listabike = (ArrayList<Bike>) in.readObject(); 
            return listabike;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
   
    // MARCA ------------------------------------------------
    public Boolean marcaInserir(Marca mc){
        String msg = "";
        try{
            out.writeObject("MarcaInserir");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(mc); // escrevendo a Marca
            msg = (String) in.readObject(); // lendo ok
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

    public Boolean marcaAlterar(Marca mc){
        String msg = "";
        try{
            out.writeObject("MarcaAlterar");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(mc); // escrevendo a Marca
            msg = (String) in.readObject(); // lendo ok
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
    
    public Boolean marcaExcluir(Marca mc){
        String msg = "";
        try{
            out.writeObject("MarcaExcluir");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(mc); // escrevendo a Marca
            msg = (String) in.readObject(); // lendo ok
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
        
    public ArrayList<Marca> marcaLista(){
        String msg;
        try{
            out.writeObject("MarcaLista");
            msg = (String) in.readObject(); // lendo ok
            ArrayList<Marca> listamarca = (ArrayList<Marca>) in.readObject(); 
            return listamarca;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
     public ArrayList<Marca> marcaListaNome(String nome){
        String msg;
        try{
            out.writeObject("MarcaListaNome");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(nome); // escrevendo o filtro
            ArrayList<Marca> listamarca = (ArrayList<Marca>) in.readObject(); 
            return listamarca;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }     
     
     //=========================== USUARIO ==================
     
    public Usuario efetuarLogin(Usuario usr){
    String msg;
        try{
            out.writeObject("UsuarioEfetuarLogin");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(usr); // escrevendo o filtro
            Usuario usrselecionado = (Usuario) in.readObject(); 
            return usrselecionado;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }     
    }
            
    public Boolean usuarioInserir(Usuario usr){
        String msg = "";
        try{
            out.writeObject("UsuarioInserir");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(usr); // escrevendo o usuário
            msg = (String) in.readObject(); // lendo ok
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

    public Boolean usuarioExcluir(Usuario usr){
        String msg = "";
        try{
            out.writeObject("UsuarioExcluir");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(usr); // escrevendo o usuário
            msg = (String) in.readObject(); // lendo ok
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
    
    public Boolean usuarioAlterar(Usuario usr){
        String msg = "";
        try{
            out.writeObject("UsuarioAlterar");
            msg = (String) in.readObject(); // lendo ok
            out.writeObject(usr); // escrevendo o usuário
            msg = (String) in.readObject(); // lendo ok
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
    
    public ArrayList<Usuario> usuarioLista(){
        String msg;
        try{
            out.writeObject("UsuarioLista");
            msg = (String) in.readObject(); // lendo ok
            ArrayList<Usuario> listausr = (ArrayList<Usuario>) in.readObject(); 
            return listausr;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
     //=========================== FIM ==================
     public void fim(){
         String msg;
        try{
            out.writeObject("fim");
            in.close();
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
     }
}
