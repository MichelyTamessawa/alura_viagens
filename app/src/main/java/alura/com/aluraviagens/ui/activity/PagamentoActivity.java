package alura.com.aluraviagens.ui.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import alura.com.aluraviagens.R;
import alura.com.aluraviagens.modelo.Pacote;
import alura.com.aluraviagens.util.MoedaUtil;

import static alura.com.aluraviagens.ui.activity.PacoteAcivity.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

        recuperaPacote();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void recuperaPacote() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            mostraPreco(pacote);
            configuraBotao(pacote);

        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botao = findViewById(R.id.pagamento_botao_finaliza_compra);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaResumoCompra(pacote);
            }
        });
    }

    private void iniciaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco);
        String precoFormatado = MoedaUtil.formataPreco(pacote.getPreco());
        preco.setText(precoFormatado);
    }
}
