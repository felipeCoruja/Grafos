public class Aresta{

    private String rotulo;
    private String ligacao1; // ligação com vertice ex => '1-3'
    private String ligacao2; // ligação com vertice ex => '3-1'
    private int    peso;
    private String tipo;



    public void Aresta(){
        this.rotulo = "";
        this.peso = -1;
        this.ligacao1 = '-';
        this.ligacao1 = '-';
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
}