import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        No raiz = new No("A");
        raiz.esquerda = new No("B");
        raiz.direita = new No("C");
        raiz.esquerda.esquerda = new No("D");
        raiz.esquerda.direita = new No("E");
        raiz.direita.direita = new No("F");

        Arvore arvore = new Arvore(raiz);


        System.out.println("Quantidade de nos:" + arvore.contarNos());

        arvore.preordem();
    }

}

