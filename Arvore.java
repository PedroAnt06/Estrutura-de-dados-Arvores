import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore {

    No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    public int contarNos(No node) {
        if (node == null) return 0;
        return 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }


    public void preordem() {
        preordem(raiz);
    }

    public void preordem(No node) {
        if (node == null) return;

        System.out.println(node.valor + " ");
        preordem(node.esquerda);
        preordem(node.direita);
    }


    public void emordem() {
        emordem(raiz);
    }

    public void emordem(No node) {
        if (node == null) return;

        emordem(node.esquerda);
        System.out.println(node.valor + " ");
        emordem(node.direita);
    }

    public void posordem() {
        posordem(raiz);
    }

    public void posordem(No node) {
        if (node == null) return;

        posordem(node.esquerda);
        posordem(node.direita);
        System.out.println(node.valor + " ");
    }

    public void emnivel() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.println(atual.valor + " ");

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
    }

    public void preordemIterativa() {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.print(atual.valor + " ");

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
        System.out.println();
    }

    public void emordemIterativa() {
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }

            atual = pilha.pop();
            System.out.print(atual.valor + " ");
            atual = atual.direita;
        }
        System.out.println();
    }

    public void posordemIterativa() {
        if (raiz == null) return;

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            No atual = pilha1.pop();
            pilha2.push(atual);

            if (atual.esquerda != null) pilha1.push(atual.esquerda);
            if (atual.direita != null) pilha1.push(atual.direita);
        }

        while (!pilha2.isEmpty()) {
            System.out.print(pilha2.pop().valor + " ");
        }
        System.out.println();
    }

}