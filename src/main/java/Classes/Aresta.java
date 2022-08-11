package Classes;

public class Aresta{

    

    private String rotulo;
    private String ligacao1; // ligação com vertice ex => '1-3'
    private String ligacao2; // ligação com vertice ex => '3-1'
    private int    peso;
    private String tipo;



    public void Aresta(){
        this.rotulo = "-";
        this.peso = -1;
        this.ligacao1 = "-";
        this.ligacao2 = "-";
        this.tipo = "-";
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
     * @return the ligacao1
     */
    public String getLigacao1() {
        return ligacao1;
    }

    /**
     * @param ligacao1 the ligacao1 to set
     */
    public void setLigacao1(String ligacao1) {
        this.ligacao1 = ligacao1;
    }

    /**
     * @return the ligacao2
     */
    public String getLigacao2() {
        return ligacao2;
    }

    /**
     * @param ligacao2 the ligacao2 to set
     */
    public void setLigacao2(String ligacao2) {
        this.ligacao2 = ligacao2;
    }
}