/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadobleenlazada;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author oreyes
 */
public class ListaDobleEnlazada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaDoble ld = new ListaDoble();
        ld.ingresar(34);
        ld.ingresar(76);
        ld.ingresar(27);
        ld.ingresar(12);
        ld.ingresar(28);
        
        ld.desplegarLista();
        
        ld.buscarNodo(12);
        
        ld.eliminarNodo(34);
        
        ld.desplegarLista();
        ld.desplegarListaAtras();
        
        // escribir("C:/Users/oreyes/Desktop/diagrama.dot", ld.obtenerStringParaGraphviz());
        // dibujar("C:/Users/oreyes/Desktop/diagrama.dot","C:/Users/oreyes/Desktop/diagrama.png");
    }
    
    public static void escribir(String rutaArchivo, String contenido) {
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter(rutaArchivo);
            pw = new PrintWriter(fichero);
            pw.write(contenido);
            pw.close();
            fichero.close();
        } catch (Exception e) {
            System.out.println("Error al tratar de escribir el archivo: " + e.getMessage());
        } finally {
            try {

            } catch (Exception e) {
                System.out.println("No se pudo cerrar el archivo: " + e.getMessage());
            }
        }

    }
    
    public static void dibujar(String rutaArchivoDot, String rutaArchivoPng) {
        try {
            ProcessBuilder pbuilder;

            /*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
             */
            
            pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", rutaArchivoPng, rutaArchivoDot );
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
