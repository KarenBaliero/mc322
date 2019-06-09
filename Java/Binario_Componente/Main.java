package Binario_Componente;

public class Main {

    public static void main(String[] args){
        System.out.println(3);
        ArvoreAvl x = new ArvoreAvl();
        IBinario y = new Binario( );
        x.inserir(3 , "asldajdh") ;
        x.inserir(4 , "kleber");
        x.inserir(5 , "ghghjghg");
        x.inserir(6 , "jkhjkhjhjk");
        x.inserir( 7 , "dhsajhdahd");
        x.inserir( 8 , "hjkhkjhhj");
        x.inserir( 9 , "hkjhjkhjh");
        x.inserir( 10 , "dadjasdjahsdg");
        System.out.println( y.busca_doenca( x.raiz , 4 ) ) ;
        x.posordem( x.raiz );
    }
}
