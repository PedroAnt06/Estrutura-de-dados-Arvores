public class NoRB {
    int valor;
    NoRB esquerda, direita, pai;
    boolean corVermelha;

    public NoRB(int valor) {
        this.valor = valor;
        this.corVermelha = true;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
