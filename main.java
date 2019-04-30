
public interface Tratamento_matriz {
    void troca_coluna(String[][] matriz, int col1, int col2);
    void troca_linha(String [][]matriz, int lin1, int lin2);  
    
    // Junta as doenças que tem os mesmos sintomas
    void tira_repetida(String [][]matriz);
    
    void ordena_linha(String[][] matriz);
    void ordena_coluna(String[][] matriz);    
    
    // Retorna o número de sintomas que uma doença tem
    int num_sintomas(String[][] matriz, String doenca);
    // Retorna o número de doenças que um sintoma pode ter
    int doencas_possiveis(String[][] matriz, String sintoma);        
}

// Transformar int em binario
public interface Transforma_binario {
    int binario(String[][] matriz);
    
    // Compara binário
    Arvore arvore_bin(String [][]matriz);
    Arvore balancear(String [][]matriz);
}
