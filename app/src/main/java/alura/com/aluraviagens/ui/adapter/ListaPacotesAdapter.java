package alura.com.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

import alura.com.aluraviagens.util.DiasUtil;
import alura.com.aluraviagens.util.MoedaUtil;
import alura.com.aluraviagens.R;
import alura.com.aluraviagens.util.ResourceUtil;
import alura.com.aluraviagens.modelo.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private List<Pacote> listaPacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> listaPacotes, Context context) {

        this.listaPacotes = listaPacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaPacotes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = listaPacotes.get(position);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String precoFormatado = MoedaUtil.formataPreco(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasTexto);
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
