//Codigo Quebrado!! 

import java.util.ArrayList;
public class transformaMatriz {
    public ArrayList<Integer> Troca_linha(String Matriz[][], int ini, int fim, int valor){ //com base no insertion sort
        String[] aux1 = new String[Matriz[0].length];
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i=ini; i<fim; i++){
            for(int j=0; j<Matriz[0].length; j++){
                aux1[j] = Matriz[i][j];
            }
            int k = i-1;
            while (k>=0 && Matriz[k][valor].contains("f")){
                for(int j=0; j<Matriz[valor].length; j++){
                    Matriz[k+1][j] = Matriz[k][j];
                }
                k=k-1;
            }
            for(int j=0; j<Matriz[0].length; j++){
                Matriz[k+1][j] = aux1[j];
            }
        }
        numbers.add(1);
        for(int a=1; a<Matriz[0].length; a++){
            if(Matriz[a][valor].contains("t") && Matriz[a+1][valor].contains("f")||Matriz[a][valor].contains("f") && Matriz[a+1][valor].contains("t")){
                numbers.add(a);
            }
        }
        numbers.add(Matriz[0].length);

        return numbers;
    }
    
    static void printArray(String Matriz[][]) { //FUNCIONANDO
        int n = Matriz.length;
        int m = Matriz[0].length;
        for (int i = 0; i < n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(Matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void organiza_troca(String Matriz[][]){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int cont = 0;
        numbers = Troca_linha(Matriz, 1, Matriz.length, cont);
        cont++;
        for(int i=0; i<Matriz.length-1; i++){
            for(int j=0; j<numbers.size()-1; j++){
                numbers = Troca_linha(Matriz, numbers.get(j), numbers.get(j+1), cont);
            }
            cont++;
        }
    }
    
    public static void main(String args[]) { //EXEMPLO
        String Matriz[][] = {{"S1", "S2", "S3", "S4", "D"},{"t1", "t2", "f3", "f4", "D9"},{"f5", "t6", "t7", "f8", "D2"},{"f9", "f10", "t11", "t12", "D3"},{"t13", "f14", "t15", "f16", "D4"},{"t17", "f18", "f19", "f20", "D5"}};
        transformaMatriz ob = new transformaMatriz();
        ob.organiza_troca(Matriz);
        printArray(Matriz);
    }
}
