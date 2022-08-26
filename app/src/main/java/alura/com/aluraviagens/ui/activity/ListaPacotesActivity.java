package alura.com.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import alura.com.aluraviagens.R;
import alura.com.aluraviagens.dao.PacoteDAO;
import alura.com.aluraviagens.modelo.Pacote;
import alura.com.aluraviagens.ui.adapter.ListaPacotesAdapter;

import static alura.com.aluraviagens.ui.activity.PacoteAcivity.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaPacotesView = findViewById(R.id.lista_pacotes_listview);
        PacoteDAO dao = new PacoteDAO();
        List<Pacote> listaDePacotes = dao.lista();
        listaPacotesView.setAdapter(new ListaPacotesAdapter(listaDePacotes, this));

        listaPacotesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteSelecionado = listaDePacotes.get(position);
                iniciaResumoPacote(pacoteSelecionado);
            }
        });
    }

    private void iniciaResumoPacote(Pacote pacote) {
        Intent resumo = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        resumo.putExtra(CHAVE_PACOTE, pacote);
        startActivity(resumo);
    }
}
