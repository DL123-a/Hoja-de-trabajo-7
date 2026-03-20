public class Asociacion<K extends Comparable<K>, V> implements Comparable<Asociacion<K, V>> {

    private K clave;
    private V valor;

    public Asociacion(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    @Override
    public int compareTo(Asociacion<K, V> otra) {
        return this.clave.compareTo(otra.clave);
    }

    @Override
    public String toString() {
        return "(" + clave + ", " + valor + ")";
    }
}