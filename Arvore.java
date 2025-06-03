
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore {
    No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public int contarNos() {
        return this.contarNos(this.raiz);
    }

    public int contarNos(No node) {
        return node == null ? 0 : 1 + this.contarNos(node.esquerda) + this.contarNos(node.direita);
    }

    public void preordem() {
        this.preordem(this.raiz);
    }

    public void preordem(No node) {
        if (node != null) {
            System.out.println(node.valor + " ");
            this.preordem(node.esquerda);
            this.preordem(node.direita);
        }
    }

    public void emordem() {
        this.emordem(this.raiz);
    }

    public void emordem(No node) {
        if (node != null) {
            this.emordem(node.esquerda);
            System.out.println(node.valor + " ");
            this.emordem(node.direita);
        }
    }

    public void posordem() {
        this.posordem(this.raiz);
    }

    public void posordem(No node) {
        if (node != null) {
            this.posordem(node.esquerda);
            this.posordem(node.direita);
            System.out.println(node.valor + " ");
        }
    }

    public void emnivel() {
        if (this.raiz != null) {
            Queue<No> fila = new LinkedList();
            fila.add(this.raiz);

            while(!fila.isEmpty()) {
                No atual = (No)fila.poll();
                System.out.println(atual.valor + " ");
                if (atual.esquerda != null) {
                    fila.add(atual.esquerda);
                }

                if (atual.direita != null) {
                    fila.add(atual.direita);
                }
            }

        }
    }

    public void preordemIterativa() {
        if (this.raiz != null) {
            Stack<No> pilha = new Stack();
            pilha.push(this.raiz);

            while(!pilha.isEmpty()) {
                No atual = (No)pilha.pop();
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
    }

    public void emordemIterativa() {
        Stack<No> pilha = new Stack();

        for(No atual = this.raiz; atual != null || !pilha.isEmpty(); atual = atual.direita) {
            while(atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }

            atual = (No)pilha.pop();
            System.out.print(atual.valor + " ");
        }

        System.out.println();
    }

    public void posordemIterativa() {
        if (this.raiz != null) {
            Stack<No> pilha1 = new Stack();
            Stack<No> pilha2 = new Stack();
            pilha1.push(this.raiz);

            while(!pilha1.isEmpty()) {
                No atual = (No)pilha1.pop();
                pilha2.push(atual);
                if (atual.esquerda != null) {
                    pilha1.push(atual.esquerda);
                }

                if (atual.direita != null) {
                    pilha1.push(atual.direita);
                }
            }

            while(!pilha2.isEmpty()) {
                System.out.print(((No)pilha2.pop()).valor + " ");
            }

            System.out.println();
        }
    }

    public void contarNosComPilha() {
        if (this.raiz != null) {
            Stack<No> pilha = new Stack();
            pilha.push(this.raiz);
            int contador = 0;

            while(!pilha.isEmpty()) {
                No atual = (No)pilha.pop();
                ++contador;
                if (atual.direita != null) {
                    pilha.push(atual.direita);
                }

                if (atual.esquerda != null) {
                    pilha.push(atual.esquerda);
                }
            }

            System.out.println(contador);
        }
    }

    public void contarNosComFila() {
        if (this.raiz != null) {
            Queue<No> fila = new LinkedList();
            fila.add(this.raiz);
            int contador = 0;

            while(!fila.isEmpty()) {
                No atual = (No)fila.poll();
                ++contador;
                if (atual.direita != null) {
                    fila.add(atual.direita);
                }

                if (atual.esquerda != null) {
                    fila.add(atual.esquerda);
                }
            }

            System.out.println(contador);
        }
    }

    public void contarFolhas() {
        if (this.raiz != null) {
            Queue<No> fila = new LinkedList();
            fila.add(this.raiz);
            int folhas = 0;

            while(!fila.isEmpty()) {
                No atual = (No)fila.poll();
                if (atual.esquerda == null && atual.direita == null) {
                    ++folhas;
                }

                if (atual.esquerda != null) {
                    fila.add(atual.esquerda);
                }

                if (atual.direita != null) {
                    fila.add(atual.direita);
                }
            }

            System.out.println(folhas);


        }

    }

    public void inserir(String valor) {
        raiz = inserirAVL(raiz, valor);
    }

    private int altura(No no) {
        return no == null ? 0 : no.altura;
    }

    private int fatorBalanceamento(No no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    private No inserirAVL(No no, String valor) {
        if (no == null)
            return new No(valor);

        if (valor.compareTo(no.valor) < 0)
            no.esquerda = inserirAVL(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = inserirAVL(no.direita, valor);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int balance = fatorBalanceamento(no);


        if (balance > 1 && valor.compareTo(no.esquerda.valor) < 0)
            return rotacaoDireita(no);

        if (balance < -1 && valor.compareTo(no.direita.valor) > 0)
            return rotacaoEsquerda(no);

        if (balance > 1 && valor.compareTo(no.esquerda.valor) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balance < -1 && valor.compareTo(no.direita.valor) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }
}