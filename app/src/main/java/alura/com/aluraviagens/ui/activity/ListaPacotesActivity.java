package alura.com.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import alura.com.aluraviagens.R;
import alura.com.aluraviagens.dao.PacoteDAO;
import alura.com.aluraviagens.modelo.Pacote;
import alura.com.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle("Pacotes");

        configuraLista();

        Intent resumo = new Intent(this, ResumoPacote.class);
        startActivity(resumo);
    }

    private void configuraLista() {
        ListView listaPacotesView = findViewById(R.id.lista_pacotes_listview);
        PacoteDAO dao = new PacoteDAO();
        List<Pacote> listaDePacotes = dao.lista();
        listaPacotesView.setAdapter(new ListaPacotesAdapter(listaDePacotes, this));
    }
}
