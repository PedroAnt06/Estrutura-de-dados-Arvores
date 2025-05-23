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

        System.out.println("Pre Ordem");
        arvore.preordem();

        System.out.println("\n");

        System.out.println("Em Ordem");
        arvore.emordem();

        System.out.println("\n");

        System.out.println("Pos Ordem");
        arvore.posordem();

        System.out.println("\n");

        System.out.println("Em nivel");
        arvore.emnivel();

        System.out.println("Pre Ordem Iterativo");
        arvore.preordemIterativa();

        System.out.println("\n");

        System.out.println("Em Ordem Iterativo");
        arvore.emordemIterativa();

        System.out.println("\n");

        System.out.println("Pos Ordem Iterativo");
        arvore.posordemIterativa();

    }

}

