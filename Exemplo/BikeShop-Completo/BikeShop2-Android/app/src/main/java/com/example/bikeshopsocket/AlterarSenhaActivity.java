package com.example.bikeshopsocket;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controller.ConexaoController;

public class AlterarSenhaActivity extends AppCompatActivity {
    InformacoesApp infoApp;
    EditText edtNovaSenha,edtNovaSenha2;
    Button btnAlterarSenha,btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_senha);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        infoApp = (InformacoesApp) getApplicationContext();

        edtNovaSenha = findViewById(R.id.edtNovaSenha);
        edtNovaSenha2 = findViewById(R.id.edtNovaSenha2);
        btnAlterarSenha = findViewById(R.id.btnAlterarSenha);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnAlterarSenha.setOnClickListener(cliqueAlterarSenha);
        btnCancelar.setOnClickListener(cliqueCancelar);

    }

    View.OnClickListener cliqueAlterarSenha = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Thread thread = new Thread() {
                @Override
                public void run() {
                    if (edtNovaSenha.getText().toString().equals(edtNovaSenha2.getText().toString())) {
                        ConexaoController ccont = new ConexaoController(infoApp);
                        String senhaAntiga = infoApp.user.getSenha();
                        // alterando o objeto
                        infoApp.user.setSenha(edtNovaSenha.getText().toString());
                        // enviando o comando de alterar a senha para o Servidor
                        if (ccont.usuarioAlterar(infoApp.user)) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(AlterarSenhaActivity.this, "Senha alterada com sucesso", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            });
                        } else {
                            infoApp.user.setSenha(senhaAntiga); // voltando senha antiga
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(AlterarSenhaActivity.this, "Não foi possível alterar a senha", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                edtNovaSenha.setError("Senhas não estão idênticas");
                            }
                        });
                    }
                }
            };
            thread.start();
        }
    };

    View.OnClickListener cliqueCancelar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
