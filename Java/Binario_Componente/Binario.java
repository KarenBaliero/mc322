package Binario_Componente;

public class Binario implements IBinario {

    /*Coloca se a linha de String da matriz, com os elementos de "t", "f", e o nome da doença no final*/
    public int transforma_bin( String []linha ){
        int bin = 0 ;

        for( int i = 0; i < linha.length; i++ ){
            if( linha[i].equalsIgnoreCase("t") ){
                bin = bin + (int)Math.pow( 2.0 , i );
            }
        }
        return bin ;
    }

    /*Transforma a matriz em uma arvore binário, os nos serão compostos por um inteiro e o nome da doença*/
    public ArvoreAvl arv_bin_bin( String [][]ma ){

        ArvoreAvl arv = new ArvoreAvl() ;

        int pos_doenca = ma[0].length - 1 ;
        for(int i = 0 ; i < pos_doenca ; i++ ){
            arv.inserir( transforma_bin(ma[i]), ma[i][pos_doenca] ); ;
        }

        return arv ;
    }

    /*entrada eh a raiz da arvore, tf eh valor corresponte da resposta do usuário já processado, retorna string vazia se não encontrar o valor*/
    public String busca_doenca( No arv, int tf ){

        if( arv == null ){
            return "" ;
        }
        else if( arv.getChave() == tf ){
            return arv.getDoenca() ;
        }
        else if( tf < arv.getChave() ){
            return busca_doenca( arv.getEsquerda() , tf );
        }
        else{
            return busca_doenca( arv.getDireita() , tf );
        }
    }

}