
/*PARA O FUNCIONAMENTO CORRETO DESTA CLASSE � NECESS�RIA A CLASSE DATASETCOMPONENT
 * 
 * Colocar o arquivo de entrada junto dessa classe
 * 
 * Essa classe recebe o nome do arquivo com a matriz de doen�as X sintomas , abre ela e cria um arquivo com o segundo nome fornecido e com a matriz otimizada para eliminar mais doen�as com menos perguntas
 *Na chamada dessa classe voc� coloca o nome do arquivo de entrada na forma de String  e o nome do arquivo de saida na forma de String
 *
 *Todas as vari�veis est�o acess�veis aos programadores atrav�s de m�todos get e set...
 **/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PreparadorDeMatriz {
	private String entrada;
	private String saida;
	private String[] sintomas;
	private String[][] dados;

	public PreparadorDeMatriz(String in , String out) {
		this.entrada=in;
		this.saida=out;
	}

	public void setEntrada(String nova) {
		this.entrada=nova;
	}
	public void setSaida(String nova) {
		this.saida=nova;
	}

	public String getEntrada() {
		return this.entrada;
	}
	public String getSaida() {
		return this.saida;
	}

	public void Prepara() {
		DataSetComponent matriz = new DataSetComponent();
		matriz.setDataSource(this.getEntrada());
		this.sintomas = matriz.requestAttributes();
		this.dados = matriz.requestInstances();
		int[] proport= new int[this.sintomas.length-1];
		for(int i=0;i<this.sintomas.length-1;i++) {
			int x=0;
			for(int j=0;j<this.dados.length;i++) {
				if(this.dados[i][j].equalsIgnoreCase("t")|| this.dados[i][j].equalsIgnoreCase("1")||this.dados[i][j].equalsIgnoreCase("true")) {			 
					x++;
				}
			}
			proport[i]= Math.abs(x-this.dados.length);
		}
		for (int fixo = 0; fixo < proport.length - 1; fixo++) {
			int menor = fixo;
			for (int k = menor + 1; k < proport.length; k++) {
				if (proport[k] < proport[menor]) {
					menor = k;
				}
			}
			if (menor != fixo) {
				for(int a=0; a<this.dados.length;a++) {
					String temp=this.dados[a][fixo];
					this.dados[a][fixo]=this.dados[a][menor];
					this.dados[a][menor]=temp;

				}
				int t = proport[fixo];
				proport[fixo] = proport[menor];
				proport[menor] = t;
			}
		}
		
		PreparadorDeMatriz.Divide(0, dados.length, 0, sintomas.length-1);
		
		try {
            arquivo = new PrintWriter(new FileWriter(this.saida));
            arquivo.println(this.sintomas);
            for(int m;m<dados.length;m++){
            	arquivo.println(this.sintomas);
            }  
            arquivo.close();
        } catch (IOException erro) {
            System.out.println("Nao consegui criar o arquivo =(");
        }  
	}



	private static void Divide(int inicio, int fim, int coluna, int ultimacoluna) {
		
		if(inicio !=fim && coluna!=ultimacoluna ) {
			
			int meio=0;
			for (int fixo = inicio; fixo < fim - 1; fixo++) {
				int menor = fixo;
				for (int i = menor + 1; i < fim; i++) {
					if (this.dados[i][coluna].equalsIgnoreCase("t")) {
						menor = i;
						meio++;
					}
				}
				if (menor != fixo) {
					
					String temp=this.dados[fixo][coluna];
					this.dados[fixo][coluna]=this.dados[menor][coluna];
					this.dados[menor][coluna]=temp;

				}
			}
			PreparadorDeMatriz.Divide(inicio, meio, coluna+1, ultimacoluna);
			PreparadorDeMatriz.Divide(meio, fim, coluna+1, ultimacoluna);
			
			
		}
		
		
		

	} 
}
