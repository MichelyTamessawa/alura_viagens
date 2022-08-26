package alura.com.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import alura.com.aluraviagens.R;
import alura.com.aluraviagens.modelo.Pacote;
import alura.com.aluraviagens.util.DataUtil;
import alura.com.aluraviagens.util.MoedaUtil;
import alura.com.aluraviagens.util.ResourceUtil;

import static alura.com.aluraviagens.ui.activity.PacoteAcivity.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);

        recuperaPacote();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void recuperaPacote() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            mostraImagem(pacote);
            mostraLocal(pacote);
            mostraData(pacote);
            mostraPreco(pacote);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        String precoFormatado = MoedaUtil.formataPreco(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataFormatada = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatada);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem);
        Drawable drawableDevolvida = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDevolvida);
    }
}
