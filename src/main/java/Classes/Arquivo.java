package Classes;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Arquivo{

    private String caminho;
    private ArrayList<String> lista;
    private BufferedReader file;   

    public Arquivo(String caminho) throws FileNotFoundException{
        
        this.caminho = caminho;    
        this.file = new BufferedReader(new FileReader(caminho));
        this.lista = new ArrayList<>(); 
    }

        
    public ArrayList<String> ReadFile() {//devolve o arquivo txt lido em forma de vetor, cada linha corresponde a uma celula da lista
      
        try{
            
            String line = this.file.readLine();
            System.out.println("Linha lida => "+line);
                while(line != null){
                    lista.add(line);
                    line = file.readLine();
                   
                }

                
            
        }catch(IOException error){
            System.out.println("Error em ReadFile(): " + error);
        }finally{
            try {
                this.file.close();
                System.out.println("Size lista "+lista.size());
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return lista;

    }


}
