# Documentação de componentes

A documentação será feita em Markdown, vide detalhes sobre ele em: https://guides.github.com/features/mastering-markdown/

E mais especificamente sobre tabelas em: https://help.github.com/en/articles/organizing-information-with-tables


# Componente `Tratamento_matriz`

Campo | Valor
----- | -----
Classe | `main.java`
Autores | Gustavo Praciano, Heigon Soldera, Karen Baliero, Mariana Megumi, Matheus Hatzlhoffer, Piethro Cesar
Objetivo | Realiza diversas funções na matriz para mudá-la conforme necessário.
Interface | `Tratamento_matriz`
~~~
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
~~~

# Componente `Transforma_binario`

Campo | Valor
----- | -----
Classe | `main.java`
Autores | Gustavo Praciano, Heigon Soldera, Karen Baliero, Mariana Megumi, Matheus Carvalho, Piethro Cesar
Objetivo | Interface transforma linha de sintomas em número binário, pega esse número e transforma em decimal.
Interface | `Transforma_binario`
~~~
// Transformar int em binario
public interface Transforma_binario {
    int binario(String[][] matriz);
    
    // Compara binário
    Arvore arvore_bin(String [][]matriz);
    Arvore balancear(String [][]matriz);
}
~~~

## Detalhamento das Interfaces

### Interface `Tratamento_matriz`
Realiza diversas funções na matriz para mudá-la conforme necessário.

Método | Objetivo
-------| --------
`trocaColuna` | Recebe uma matriz de String e duas colunas. Troca essas duas colunas da matriz.
`trocaLinha` | Recebe uma matriz de String e duas linhas. Troca essas duas linhas da matriz.
`tiraRepetida` | Recebe uma matriz. Concatena duas doenças que tenham sintomas iguais.
`ordenaLinha` | Recebe uma matriz e ordena as linhas conforme 
`ordenaColuna` | Recebe uma matriz e ordena as colunas conforme 
`diferencaColuna` | Recebe uma matriz e uma coluna. Retorna diferença entre número de True e False da coluna.
`numSintomas` | Recebe uma matriz e uma String de doença. Retorna o número de sintomas que uma doença tem.
`doencasPossiveis` | Recebe uma matriz e uma String de doença. Retorna o número de doenças que um sintoma tem.


### Interface `Transforma_binario`
Interface transforma linha de sintomas em número binário, pega esse número e transforma em decimal.

Método | Objetivo
-------| --------
`binario` | Recebe a matriz de doenças e sintomas. Retorna uma matriz de duas colunas, a primeira é de número respectivo aos sintomas e a segunda é o nome da doença.
`arvoreBin` | Transforma a matriz em uma árvore.
`balancear` | Compara os números da árvore e balanceia os nós de forma crescente dos números.
`buscaDoenca` | Recebe o número dos sintomas procurados e retorna o diagnóstico.

