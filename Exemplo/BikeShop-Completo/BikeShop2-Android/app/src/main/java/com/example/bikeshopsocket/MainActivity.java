package com.example.bikeshopsocket;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import controller.ConexaoController;
import modelDominio.Bike;

public class MainActivity extends AppCompatActivity {
    InformacoesApp infoApp;
    TextView tvUsuario;
    RecyclerView rvElementos;
    BikeAdapter bkAdapter;
    ArrayList<Bike> listaBikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Aqui você pode chamar uma tela de cadastro de bikes :D", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // obtendo o contexto
        infoApp = (InformacoesApp) getApplicationContext();

        // Associando componentes
        tvUsuario = findViewById(R.id.tvUsuario);
        rvElementos = findViewById(R.id.rvElementos);

        //atualizando informações na tela
        tvUsuario.setText("Bem vindo "+infoApp.user.getLogin()+". Veja a lista de bikes abaixo.");


    }

    private void atualizaListaBikes(){
        // preparando os dados a serem listados
        Thread t = new Thread(){
            @Override
            public void run() {
                ConexaoController ccont = new ConexaoController(infoApp);
                listaBikes = ccont.bikeLista();
                if (listaBikes != null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bkAdapter = new BikeAdapter(listaBikes,trataCliqueItem);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
                            rvElementos.setLayoutManager(mLayoutManager);
                            rvElementos.setItemAnimator(new DefaultItemAnimator());
                            rvElementos.setAdapter(bkAdapter);
                        }
                    });
                }
            }
        };
        t.start();
    }

    BikeAdapter.BikeOnClickListener trataCliqueItem = new BikeAdapter.BikeOnClickListener() {
        @Override
        public void onClickBike(View view, int position) {
            Bike bk = listaBikes.get(position);

            Intent it = new Intent(getApplicationContext(),BikeDetalhada.class);
            it.putExtra("Bike",bk);
            startActivity(it);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_trocasenha) {
            Intent it = new Intent(getApplicationContext(),AlterarSenhaActivity.class);
            startActivity(it);
            return true;
        }else if (id == R.id.action_sair) {
            finishAffinity();
            System.exit(0);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaListaBikes();
    }

    /*@Override
    protected void onDestroy() {
        // finalizando a conexão
        ConexaoController ccont = new ConexaoController(infoApp);
        ccont.fim();
        super.onDestroy();
    }*/
}
