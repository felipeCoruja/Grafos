package Main;



import Classes.Aresta;
import Classes.Arquivo;
import Classes.Grafo;
import Classes.Vertice;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main{

    public static void main(String[] args) {
	String caminho = "E:\\bakup grafos\\grafos\\src\\main\\java\\ArquivosTxt\\teste.txt";
        
        Arquivo arquivo = null;
        try {
            arquivo = new Arquivo(caminho);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
//        
//        ArrayList<Aresta> listAresta = new ArrayList<>();
//        ArrayList<Vertice> listVertice = new ArrayList<>();
//         
//        Vertice v = new Vertice();
//        
//        listVertice.add(v);
        
        Grafo grafo = new Grafo();
        
        grafo.montaGrafo(arquivo.ReadFile());
        
        grafo.matrizAdjacencia();
        grafo.matrizDeIncidencia();
                
    }


}
