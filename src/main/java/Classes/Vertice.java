package Classes;

import java.util.ArrayList;

public class Vertice{

    private String rotulo;
    private int    peso;
    private ArrayList<Aresta> listaLigacoes;


    public void Vertice(){
      this.rotulo = "";
      this.peso = -1;
      this.listaLigacoes = new ArrayList<Aresta>();
    }
    
    
    public boolean procuraLigacao(String x, String y, Vertice v){
        boolean flag = false;
        
        String ligacao1 = "";
        String ligacao2 = "";  
        
        for (int i = 0; i < v.getListaLigacoes().size(); i++) {
            ligacao1 = v.getListaLigacoes().get(i).getLigacao1();
            ligacao2 = v.getListaLigacoes().get(i).getLigacao2();
            
            if(ligacao1.equals(x) && ligacao2.equals(y)){
                flag = true;
            }
            
            if(ligacao1.equals(x) && ligacao2.equals(y)){
                flag = true;
            }
        }
        
       
        return flag;
    }
    
    

    public String getRotulo(){
        return this.rotulo;
    }

    public void setRotulo(String rotulo){
        this.rotulo = rotulo;
    }

    public int getPeso(){
        return this.peso;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    /**
     * @return the listaLigacoes
     */
    public ArrayList<Aresta> getListaLigacoes() {
        return listaLigacoes;
    }

    /**
     * @param listaLigacoes the listaLigacoes to set
     */
    public void setListaLigacoes(ArrayList<Aresta> listaLigacoes) {
        this.listaLigacoes = listaLigacoes;
    }
}