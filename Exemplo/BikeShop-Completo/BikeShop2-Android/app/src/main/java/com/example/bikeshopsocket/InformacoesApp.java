package com.example.bikeshopsocket;

import android.app.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelDominio.Usuario;

public class InformacoesApp extends Application {
    // variáveis para conexão socket
        public Socket socket;
    public ObjectInputStream in;
    public ObjectOutputStream out;

    // atributo para armazenar o usuário
    public Usuario user;

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
