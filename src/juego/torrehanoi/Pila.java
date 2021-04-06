package juego.torrehanoi;

public class Pila {
    
    private int contadorNodo = 0;
    private Nodo Cabeza;

    public int getContadorNodo() {
        return contadorNodo;
    }

    public Nodo getCabeza() {
        return Cabeza;
    }

    public void Push(Nodo N) {
        contadorNodo++;
        if (Cabeza == null) {
            Cabeza = N;
        } else {
            N.setAbajo(Cabeza);
            Cabeza.setArriba(N);
            Cabeza = N;
        }
    }

    public void Pop() {
        if (contadorNodo > 0) {
            contadorNodo--;
            Cabeza = Cabeza.getAbajo();
        }
    }

    public String Peek() {
        return Cabeza.getDato();
    }

}
