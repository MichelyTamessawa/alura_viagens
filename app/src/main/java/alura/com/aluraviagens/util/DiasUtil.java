package alura.com.aluraviagens.util;

import org.jetbrains.annotations.NotNull;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NotNull
    public static String formataEmTexto(int qtdeDias) {
        if (qtdeDias > 1) {
            return qtdeDias + PLURAL;
        }
        return qtdeDias + SINGULAR;
    }
}
