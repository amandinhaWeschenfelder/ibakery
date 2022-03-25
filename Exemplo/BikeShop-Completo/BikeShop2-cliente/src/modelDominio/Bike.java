/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDominio;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author herrmann
 */
public class Bike implements Serializable{
     private static final long serialVersionUID = 123456789L;
    
    private int codBike;
    private String modelo;
    private Marca marca;
    private float preco;
    private byte[] imagem;

    public int getCodBike() {
        return codBike;
    }

    public void setCodBike(int codBike) {
        this.codBike = codBike;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    // usado em selects e updates
    public Bike(int codBike, String modelo, Marca marca, float preco, byte[] imagem) {
        this.codBike = codBike;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.imagem = imagem;
    }

    // usado em deletes
    public Bike(int codBike) {
        this.codBike = codBike;
    }

    // usado em inserts
    public Bike(String modelo, Marca marca, float preco, byte[] imagem) {
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Bike{" + "codBike=" + codBike + ", modelo=" + modelo + ", marca=" + marca + ", preco=" + preco + ", imagem=" + imagem + '}';
    }
    
    public String getPrecoString(){
        String pattern = "###,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(preco);
    }
}


