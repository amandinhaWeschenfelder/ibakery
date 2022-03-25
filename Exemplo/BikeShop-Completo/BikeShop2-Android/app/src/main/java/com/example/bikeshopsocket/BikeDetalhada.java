package com.example.bikeshopsocket;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.ByteArrayOutputStream;

import controller.ConexaoController;
import modelDominio.Bike;

public class BikeDetalhada extends AppCompatActivity {
    ImageView imgView;
    TextView tvModelo,tvMarca, tvPreco;
    Button btnBikeAlterarImagem;
    Button btnBikeSalvar;

    Bike bike;

    InformacoesApp infoApp;

    private static final String TAG = "BikeDetalhada";
    private static final int REQUEST_GET_SINGLE_FILE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_detalhada);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // associando componentes
        imgView  = findViewById(R.id.imgView);
        tvModelo = findViewById(R.id.tvModelo);
        tvMarca  = findViewById(R.id.tvMarca);
        tvPreco  = findViewById(R.id.tvPreco);

        btnBikeAlterarImagem = findViewById(R.id.btnBikeAlterarImagem);
        btnBikeSalvar = findViewById(R.id.btnBikeSalvar);

        infoApp =  (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        if (it != null){
            Bike bk = (Bike) it.getSerializableExtra("Bike");
            bike = bk;
            tvModelo.setText("Modelo: "+bk.getModelo());
            tvMarca.setText("Marca: "+bk.getMarca().getNomemarca());
            tvPreco.setText("Preço: "+bk.getPrecoString());
            // carregando imagem
            if (bk.getImagem() != null) {
                Bitmap bmp = BitmapFactory.decodeByteArray(bk.getImagem(), 0, bk.getImagem().length);
                imgView.setImageBitmap(bmp);
            }
        }

        btnBikeAlterarImagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_GET_SINGLE_FILE);
            }
        });

        btnBikeSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // COnvertendo a imagem para Bytes
                Bitmap bitmap = ((BitmapDrawable) imgView.getDrawable()).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] imagem = stream.toByteArray();

                // alterando a imagem no Objeto
                bike.setImagem(imagem);

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        ConexaoController ccont = new ConexaoController(infoApp);
                        ccont.bikeAlterar(bike);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(BikeDetalhada.this, "Bike atualizada", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                };
                thread.start();

                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (resultCode == RESULT_OK) {
                if (requestCode == REQUEST_GET_SINGLE_FILE) {
                    Uri selectedImageUri = data.getData();
                    imgView.setImageURI(selectedImageUri);
                }
            }
        } catch (Exception e) {
            Log.e("FileSelectorActivity", "File select error", e);
        }

    }

}
