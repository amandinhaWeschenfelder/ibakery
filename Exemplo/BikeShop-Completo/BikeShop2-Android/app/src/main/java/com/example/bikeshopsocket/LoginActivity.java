package com.example.bikeshopsocket;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controller.ConexaoController;
import modelDominio.Usuario;

public class LoginActivity extends AppCompatActivity {
    Button btnEntrar, btnCancelar;
    EditText edtUsuario, edtSenha;
    InformacoesApp infoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //associando botoes
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCancelar = findViewById(R.id.btnCancelar);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);

        //Eventos
        btnEntrar.setOnClickListener(clickEntrar);
        btnCancelar.setOnClickListener(clickCancelar);

        // contexto
        infoApp = (InformacoesApp) getApplicationContext();

        // Cria o conexão contreller, mas conecta somente 1 vez no Servidor durante toda a aplicacao.
        Thread t = new Thread(){
            @Override
            public void run() {
                ConexaoController ccont = new ConexaoController(infoApp);
                ccont.Conectar();
            }
        };
        t.start();

    }

    View.OnClickListener clickEntrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Thread thread = new Thread() {
                @Override
                public void run() {
                    ConexaoController ccont = new ConexaoController(infoApp);
                    Usuario usr = new Usuario(edtUsuario.getText().toString(), edtSenha.getText().toString());
                    infoApp.user = ccont.efetuarLogin(usr);
                    // se algum usuario foi selecionado então pode abrir a tela principal
                    if (infoApp.user != null) {
                        Intent it = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(it);
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "Usuário ou senha inválida!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            };
            thread.start();
        }
    };

    View.OnClickListener clickCancelar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            edtUsuario.setText("");
            edtSenha.setText("");
            edtUsuario.requestFocus();
        }
    };
}