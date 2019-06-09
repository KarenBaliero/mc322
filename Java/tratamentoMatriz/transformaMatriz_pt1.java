import java.util.ArrayList;
public class transformaMatriz_pt1 {
    static String[][] tira_repetida(String Matriz[][]) { //FUNCIONANDO
        String[][] aux;
        int contador = 0;
        int corretor;
        ArrayList<Integer> linhas = new ArrayList<Integer>();
        boolean igual = true;
        for (int i = 1; i < Matriz.length - 1; i++) {
            for (int j = i + 1; j < Matriz.length; j++) {
                for (int k = 0; k < Matriz[0].length - 1; k++) {
                    if (Matriz[i][k].equals(Matriz[j][k]) == false) {
                        igual = false;
                    }
                }
                if (igual) {
                    contador++;
                    linhas.add(j);
                }
                igual = true;
            }
            while (!linhas.isEmpty()) {
                if (!Matriz[i][Matriz[0].length - 1].contains(Matriz[linhas.get(0)][Matriz[0].length - 1])) {
                    Matriz[i][Matriz[0].length - 1] = Matriz[i][Matriz[0].length - 1].concat(" ");
                    Matriz[i][Matriz[0].length - 1] = Matriz[i][Matriz[0].length - 1].concat(Matriz[linhas.get(0)][Matriz[0].length - 1]);
                }
                Matriz[linhas.get(0)][0] = "Sou igual";
                linhas.remove(0);
            }
        }
        aux = new String[Matriz.length - contador][Matriz[0].length];
        corretor = 0;
        for (int i = 0; i < Matriz.length; i++) {
            if (!Matriz[i][0].contains("Sou igual")) {
                for (int j = 0; j < Matriz[0].length; j++) {
                    aux[i - corretor][j] = Matriz[i][j];
                }
            } else {
                corretor++;
            }
        }
        return aux;
    }

    static void printArray(String Matriz[][]) { //FUNCIONANDO
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
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][matriz[0].length - 1].contains(doenca)) {
                for (int j = 0; j < matriz[0].length - 1; j++) {
                    if (matriz[i][j].contains("t")) {
                        contador++;
                    }
                }
                if (contador > sintomas) {
                    sintomas = contador;
                }
            }
        }
        return sintomas;
    }

    static int doencas_possiveis(String[][] Matriz, String sintoma) {
        int contador = 0;
        int doencas = -1;
        for (int i = 0; i < Matriz[0].length; i++) {
            if (Matriz[0][i].contains(sintoma)) {
                for (int j = 1; j < Matriz.length; j++) {
                    if (Matriz[j][i].contains("t")) {
                        contador++;
                    }
                }
                if (contador > doencas) {
                    doencas = contador;
                }
            }
        }
        return doencas;
    }

    public static void main(String args[]) { //EXEMPLO
        String Matriz[][] = {{"S1", "S2", "S3", "S4", "D"}, {"t1", "t2", "f3", "f4", "D9"}, {"t1", "t2", "f3", "f4", "D1"}, {"f5", "t6", "t7", "f8", "D2"}, {"f9", "f10", "t11", "t12", "D3"}, {"t13", "f14", "t15", "f16", "D4"}, {"t17", "f18", "f19", "f20", "D5"}, {"t17", "f18", "f19", "f20", "D5"}};
        System.out.println(num_sintomas(Matriz, "D9"));
        String nova[][] = tira_repetida(Matriz);
        System.out.println(doencas_possiveis(Matriz, "S3"));
        printArray(nova);
    }
}
