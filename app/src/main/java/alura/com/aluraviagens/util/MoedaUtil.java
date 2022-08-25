package alura.com.aluraviagens.util;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.math.BigDecimal;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String formataPreco(BigDecimal valor) {
        NumberFormat formatoBr = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatoBr.format(valor);
    }

}
