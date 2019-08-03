/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadobleenlazada;

/**
 *
 * @author oreyes
 */
public class ListaDoble {
    Nodo primero;
    Nodo ultimo;
    
    public ListaDoble() {
        primero = null;
        ultimo = null;
    }
    
    public void ingresar(int dato) {
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        
        if(primero == null) {
            primero = nuevo;
            primero.siguiente = null;
            primero.anterior = null;
            ultimo = primero;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            nuevo.siguiente = null;
            ultimo = nuevo;
        }
    }
    
    public void desplegarLista() {
        Nodo actual = new Nodo();
        actual = primero;
        while(actual != null) {
            System.out.print(actual.dato+" <-> ");
            // System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
    
    public void desplegarListaAtras() {
        Nodo actual = new Nodo();
        actual = ultimo;
        while(actual != null) {
            System.out.print(actual.dato+" <-> ");
            // System.out.println(actual.dato);
            actual = actual.anterior;
        }
    }
    
    public void buscarNodo(int dato) {
        Nodo actual = new Nodo();
        actual =primero;
        while(actual != null) {
            if(actual.dato == dato) {
                System.out.println("Nodo encontrado " + dato);
            }
            actual = actual.siguiente;
        }
    }
    
    public void eliminarNodo(int dato) {
        Nodo actual = new Nodo();
        Nodo atras = new Nodo();
        atras = null;
        actual = primero;
        while(actual != null) {
            if(actual.dato == dato) {
                if(actual == primero) {
                    primero = primero.siguiente;
                    primero.anterior = null;
                } else {
                    atras.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
            }
            atras = actual;
            actual = actual.siguiente;
        }
    }

  public String obtenerStringParaGraphviz(){
        Nodo temporal = primero;
        String texto = "digraph G \n" +
"{\n" +
" node [shape=circle];\n" +
" node [style=filled];\n" +
" node [fillcolor=\"#EEEEEE\"];\n" +
" node [color=\"#EEEEEE\"];\n" +
" edge [color=\"#31CEF0\"];\n";
        while(temporal!=null){
            texto += temporal.dato+"<->";
            temporal = temporal.siguiente;
        }
        texto += "null;\n" +
"rankdir=LR;\n" +
"}" ;
        
        return texto;
    }

}

