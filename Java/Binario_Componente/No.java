package Binario_Componente;

public class No {

    private No esquerda;
    private No direita;
    private No pai;
    private int chave;
    private String doenca ;
    private int balanceamento;

    public No(int k, String doenca ) {
        setEsquerda(setDireita(setPai(null)));
        setBalanceamento(0);
        setDoenca(doenca);
        setChave(k);
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public String getDoenca() {
        return doenca ;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    public No getPai() {
        return pai;
    }

    public No setPai(No pai) {
        this.pai = pai;
        return pai;
    }

    public No getDireita() {
        return direita;
    }

    public No setDireita(No direita) {
        this.direita = direita;
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
}