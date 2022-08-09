public class Vertice{

    private String rotulo;
    private int    peso;



    public void Vertice(){
      this.rotulo = "";
      this.peso = -1;
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