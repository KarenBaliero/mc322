package Binario_Componente ;

public class FactoryNo implements IFactoryNo {

    public No createNo( int k , String d ){
        return new No( k , d );
    }
}