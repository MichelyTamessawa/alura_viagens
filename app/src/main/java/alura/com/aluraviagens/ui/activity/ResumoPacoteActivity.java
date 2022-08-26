package alura.com.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import alura.com.aluraviagens.R;
import alura.com.aluraviagens.modelo.Pacote;
import alura.com.aluraviagens.util.DataUtil;
import alura.com.aluraviagens.util.DiasUtil;
import alura.com.aluraviagens.util.MoedaUtil;
import alura.com.aluraviagens.util.ResourceUtil;

import static alura.com.aluraviagens.ui.activity.PacoteAcivity.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);
        recuperaPacote();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void recuperaPacote() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            configuraCampos(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botao = findViewById(R.id.resumo_pacote_botao_pagamento);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaPagamento(pacote);
            }
        });
    }

    private void iniciaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void configuraCampos(Pacote pacote) {
        mostraImagem(pacote);
        mostraLocal(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void mostraData(Pacote pacote) {
        TextView intervalo_dias = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        intervalo_dias.setText(dataFormatadaDaViagem);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        preco.setText(MoedaUtil.formataPreco(pacote.getPreco()));
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        dias.setText(DiasUtil.formataEmTexto(pacote.getDias()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawablePacote = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawablePacote);
    }
}
