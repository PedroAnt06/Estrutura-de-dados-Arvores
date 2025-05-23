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

}