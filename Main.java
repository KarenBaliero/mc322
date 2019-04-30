public interface Tratamento_coluna {
    void troca_coluna(String[][] matriz, int col1, int col2) {}
}

public interface Tratamento_linha{
    void troca_linha(String [][]matriz, int lin1, int lin2){}
}

public interface Tratamento_matriz{
    void tira_repitida(String [][]matriz){}
}

public interface Tratamento_ordem_linha {
    void ordena_linha(String[][] matriz) {}
}

public interface num_sintomas {
    int num_sintomas(String[][] matriz, String doenca) {}
}

public interface doencas_possiveis {
    int doencas_possiveis(String[][] matriz, String sintoma) {}
}

public interface Tratamento_ordem_coluna {
    void ordena_coluna(String[][] matriz) {}
}

public interface transforma_binario{
    int binario(String[][] matriz) {}
}

public interface comparacao_bin{
    Arvore arvore_bin(String [][]matriz){}
}
