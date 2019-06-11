import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; //puxa as listas em java

public class transformaMatriz {

    static String[][] tira_repetida(String Matriz[][]) { //FUNCIONANDO
        String[][] aux;  //matriz que sera retornada
        int contador = 0;
        int corretor;
        ArrayList<Integer> linhas = new ArrayList<Integer>(); //lista que recebera o numero das linhas repetidas
        boolean igual = true; // vamos supor que as linhas sao iguais
        for (int i = 1; i < Matriz.length - 1; i++) { //percorre a matriz ate a penultima linha
            for (int j = i + 1; j < Matriz.length; j++) { //percorre da linha "i" ate a ultima
                for (int k = 0; k < Matriz[0].length - 1; k++) { //compara os elementos da linha
                    if (Matriz[i][k].equals(Matriz[j][k]) == false) {
                        igual = false; //se tiver diferenca muda para false
                    }
                }
                if (igual) { //se continuar igual entra no contador de linhas iguais e adiciona o indice da linha na lista
                    contador++;
                    linhas.add(j);
                }
                igual = true;
            }
            while (!linhas.isEmpty()) {
                if (!Matriz[i][Matriz[0].length - 1].contains(Matriz[linhas.get(0)][Matriz[0].length - 1])) { //se nao tiver listado a doenca adiciona
                    Matriz[i][Matriz[0].length - 1] = Matriz[i][Matriz[0].length - 1].concat(" ");
                    Matriz[i][Matriz[0].length - 1] = Matriz[i][Matriz[0].length - 1].concat(Matriz[linhas.get(0)][Matriz[0].length - 1]);
                }
                Matriz[linhas.get(0)][0] = "Sou igual"; //marca a linha para depois ser removida
                linhas.remove(0);
            }
        }
        aux = new String[Matriz.length - contador][Matriz[0].length]; //cria uma matriz com o numero de linhas sem as repetidas
        corretor = 0; //acertar a copia
        for (int i = 0; i < Matriz.length; i++) {  //copia
            if (!Matriz[i][0].contains("Sou igual")) { //se tiver marcada nao copia
                for (int j = 0; j < Matriz[0].length; j++) {
                    aux[i - corretor][j] = Matriz[i][j];
                }
            } else {
                corretor++;
            }
        }
        return aux; // retorna a matriz
    }

    static void printArray(String Matriz[][]) { //FUNCIONANDO imprime a matriz
        int n = Matriz.length;
        int m = Matriz[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(Matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int num_sintomas(String[][] matriz, String doenca) {
        int contador = 0;
        int sintomas = -1;
        for (int i = 0; i < matriz.length; i++) { //percorre a coluna das doencas
            if (matriz[i][matriz[0].length - 1].contains(doenca)) { // se achar a doenca 
                for (int j = 0; j < matriz[0].length - 1; j++) {
                    if (matriz[i][j].contains("t")) { // analisa o numero de sintomas
                        contador++;
                    }
                }
                if (contador > sintomas) { // se achar uma linha com mais sintomas, substitui para devolver o maximo
                    sintomas = contador;
                }
            }
        }
        return sintomas;
    }

    static int doencas_possiveis(String[][] Matriz, String sintoma) {
        int contador = 0;
        int doencas = -1;
        for (int i = 0; i < Matriz[0].length; i++) { //percorre a linha dos sintomas
            if (Matriz[0][i].contains(sintoma)) { //se achar o sintoma
                for (int j = 1; j < Matriz.length; j++) {
                    if (Matriz[j][i].contains("t")) { // ve quantas doencas tem esse sintoma
                        contador++;
                    }
                }
                if (contador > doencas) { // se achar uma coluna com mais doencas, substitui para devolver o maximo
                    doencas = contador;
                }
            }
        }
        return doencas;
    }

    static public void ordenar( String [][]ma , int col , int ini , int fim ){
        int x = ini ;
        String []aux = new String[ma[0].length];
        //x eh a margem, onde aparece o primeiro false.
        if( col >= ma[0].length - 1 || ini >= fim ){ //se chegar no final ou já dividiu a matriz para
            return ;
        }
        for( int i = ini ; i < fim ; i++ ){
            if(ma[i][col].contains("t")){
                for(int j=0; j<ma[0].length; j++){
                    aux[j] = ma[i][j];
                }
                for(int j=0; j<ma[0].length; j++){
                    ma[i][j] = ma[x][j];
                }
                for(int j=0; j<ma[0].length; j++){
                    ma[x][j] = aux[j];
                }
                x++ ;
            }
        }
        col++;
        ordenar( ma , col , ini , x ); //enquanto não acabar chama para a próxima coluna
        ordenar( ma , col , x , fim );
    }
    

    public static void CSV(String[][] Matriz) { //passa a Matriz para CSV

        try {
            FileWriter writer = new FileWriter("c:\\\\doencas.csv");
            PrintWriter p = new PrintWriter(writer);
            int n = Matriz.length;
            int m = Matriz[0].length;

            for (int i = 0; i < n; i++){
                for(int j = 0; j<m; j++){
                    p.print(Matriz[i][j]);
                    p.print(",");
                }
                p.println();
            }

            writer.flush();
            writer.close();
            System.out.println("foi");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
