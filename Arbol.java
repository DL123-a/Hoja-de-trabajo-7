public class Arbol<E extends Comparable<E>> {

    private class Nodo {
        E valor;
        Nodo izquierda;
        Nodo derecha;

        public Nodo(E valor) {
            this.valor = valor;
            this.izquierda = null;
            this.derecha = null;
        }
    }

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    
    // INSERTAR
    
    public void insertar(E valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo nodo, E valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor.compareTo(nodo.valor) < 0) {
            nodo.izquierda = insertarRec(nodo.izquierda, valor);
        } else if (valor.compareTo(nodo.valor) > 0) {
            nodo.derecha = insertarRec(nodo.derecha, valor);
        }

        return nodo;
    }

   
    // BUSCAR
    public E buscar(E valor) {
        return buscarRec(raiz, valor);
    }

    private E buscarRec(Nodo nodo, E valor) {
        if (nodo == null) {
            return null;
        }

        int comparacion = valor.compareTo(nodo.valor);

        if (comparacion == 0) {
            return nodo.valor;
        } else if (comparacion < 0) {
            return buscarRec(nodo.izquierda, valor);
        } else {
            return buscarRec(nodo.derecha, valor);
        }
    }

    
    // IN-ORDER
    public void inOrder() {
        inOrderRec(raiz);
    }

    private void inOrderRec(Nodo nodo) {
        if (nodo != null) {
            inOrderRec(nodo.izquierda);
            System.out.println(nodo.valor);
            inOrderRec(nodo.derecha);
        }
    }
}