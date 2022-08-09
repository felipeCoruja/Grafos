import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Arquivo(){

    private String caminho;
    private ArrayList<String> lista;
    private File file;   

    public void Arquivo(String caminho){
        
        this.caminho = caminho;    
        this.file = new File();
    }
        
    public ArrayList<String> ReadFile(){
      
        String line = this.file.readLine();
            while(line != null){
                lista.add(line);
                line = file.readLine();
            }
        }catch(IOException error){
            System.out.println("Error em ReadFile(): " + error);
        }
        return lista;

    }


}
