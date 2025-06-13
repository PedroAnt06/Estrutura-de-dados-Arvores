public class ArvoreRB {
    private NoRB raiz;

    public void inserir(int valor) {
        NoRB novo = new NoRB(valor);
        raiz = inserirRec(raiz, novo);
        corrigirInsercao(novo);
    }

    private NoRB inserirRec(NoRB atual, NoRB novo) {
        if (atual == null) return novo;

        if (novo.valor < atual.valor) {
            atual.esquerda = inserirRec(atual.esquerda, novo);
            atual.esquerda.pai = atual;
        } else if (novo.valor > atual.valor) {
            atual.direita = inserirRec(atual.direita, novo);
            atual.direita.pai = atual;
        }

        return atual;
    }

    private void corrigirInsercao(NoRB no) {
        while (no != raiz && no.pai.corVermelha) {
            NoRB avo = no.pai.pai;
            if (no.pai == avo.esquerda) {
                NoRB tio = avo.direita;
                if (tio != null && tio.corVermelha) {
                    no.pai.corVermelha = false;
                    tio.corVermelha = false;
                    avo.corVermelha = true;
                    no = avo;
                } else {
                    if (no == no.pai.direita) {
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    no.pai.corVermelha = false;
                    avo.corVermelha = true;
                    rotacaoDireita(avo);
                }
            } else {
                NoRB tio = avo.esquerda;
                if (tio != null && tio.corVermelha) {
                    no.pai.corVermelha = false;
                    tio.corVermelha = false;
                    avo.corVermelha = true;
                    no = avo;
                } else {
                    if (no == no.pai.esquerda) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.corVermelha = false;
                    avo.corVermelha = true;
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.corVermelha = false;
    }

    private void rotacaoEsquerda(NoRB x) {
        NoRB y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null) y.esquerda.pai = x;
        y.pai = x.pai;
        if (x.pai == null) raiz = y;
        else if (x == x.pai.esquerda) x.pai.esquerda = y;
        else x.pai.direita = y;
        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(NoRB y) {
        NoRB x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != null) x.direita.pai = y;
        x.pai = y.pai;
        if (y.pai == null) raiz = x;
        else if (y == y.pai.direita) y.pai.direita = x;
        else y.pai.esquerda = x;
        x.direita = y;
        y.pai = x;
    }

    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(NoRB no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.print(no.valor + "(" + (no.corVermelha ? "V" : "P") + ") ");
            emOrdemRec(no.direita);
        }
    }

    public static void main(String[] args) {
        ArvoreRB arvore = new ArvoreRB();
        int[] valores = {10,20,30,15};
        for (int v : valores) arvore.inserir(v);

        System.out.println("Em ordem (valor + cor):");
        arvore.emOrdem();
    }
}
