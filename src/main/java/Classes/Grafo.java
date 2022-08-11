package Classes;


import java.util.ArrayList;



public class Grafo{
       
    private ArrayList<Vertice> listaVertice;//cada vertice já contem suas relações de ligação
    private int quantVertices;
    private ArrayList<Aresta> listaAresta;

    public void Grafo(){
        
        this.listaVertice = new ArrayList<>();
        this.quantVertices = -1;
        this.listaAresta = new ArrayList<>();
    }
    

    public void propriedadesMatrizAdjacencia(int[][]mat, int linha, int coluna){
        boolean temLaco = false;
        boolean biDirecionado = false;
        boolean multigrafo = false;
        boolean isVazio = false;
        
        //verificação de laço
        for (int i = 0; i < coluna; i++) {
            for(int j=0;j<linha;j++){
                if(i==j){
                    if(mat[i][j]==1){
                        temLaco = true;
                    }
                    
                }
            }
        }
        
        //verificação de duplo direcionamento
        int aux = -1;
        for (int k = 0; k < coluna; k++) {
            for(int l=0;l<linha;l++){
                aux = mat[k][l];
                
                if(aux==mat[l][k]){
                    biDirecionado = true;
                }
            }
        }
       
        //Se é multiGrafo
        //Maior Grau do grafo
        int cont = -1;
        int maior = -99999999;
        Aresta aresta = new Aresta();
        String str = "";
        for (int m = 0; m < this.listaAresta.size(); m++) {
            
            
            if(this.listaAresta.get(m) == aresta){
                multigrafo = true;
            }
            
            aresta = this.listaAresta.get(m);
            
            
            if(str.equals(this.listaAresta.get(m).getLigacao1())){
                cont++;
            }else{
                if(cont>maior){
                    maior = cont;
                }
                cont = 0;
            }
            str = this.listaAresta.get(m).getLigacao1();
            
        }
        
        if(this.listaAresta.size()==0){
            isVazio = true;
        }
        
        
        System.out.println("Maior grau do grafo >> "+ maior);
        System.out.println("Grafo de Ordem >> "+ this.quantVertices);
        System.out.println("Tamanho do grafo >> "+this.listaAresta.size());
        System.out.println("Grafo tem laço >> " +temLaco);
        System.out.println("Pseudo Grafo >> " +temLaco);
        System.out.println("Grafo bidirecionado >> " +biDirecionado);
        System.out.println("É multigrafo >> " +multigrafo);
        System.out.println("Eleé vazio >> "+ isVazio);
    }
    
    
    public void montaGrafo(ArrayList<String> lista){
        
        String aresta = "";
        String vertice = "";
        String[] vetAux1 = null;
        String[] vetAux2 = null;
        ArrayList<Aresta> listaAresta = new ArrayList<>();
        Vertice v ;
        ArrayList<Vertice> listaAux = new ArrayList<>();
        
        
        for(int i=0;i<lista.size();i++){
            
            
            //MONTANDO OS VERTICES
            if(i==0){ //então estou lendo a primeira linha do arquivo que corresponde 
                        //somente aos vertices do grafo ex: a-2;b-2;c-3;d-5;
                        
                vetAux1 = lista.get(i).split(";");//separando o rotulo do vertice junto com o peso ex: "a-2"
                this.quantVertices = vetAux1.length;
                
                for(int j = 0;j<vetAux1.length;j++){
                    
                    vetAux2 = vetAux1[j].split("-");//separando o rotulo do peso ex: "a" e "2"
                    v = new Vertice();
                    v.setRotulo(vetAux2[0]);
                    v.setPeso(Integer.parseInt(vetAux2[1]));
                    
                   
                    listaAux.add(v);
                   
                }
                
                i++;
            }
            
            this.listaVertice = listaAux;
            
            //MONTANDO AS ARESTAS
            vetAux1 = lista.get(i).split("-");//separando a ligação ex: "1-2"
            
            Aresta arestaAux = new Aresta();
            
            arestaAux.setLigacao1(vetAux1[0]);
            arestaAux.setLigacao2(vetAux1[1]);
            
            listaAresta.add(arestaAux);
            this.listaAresta = listaAresta;
            
        }
        
        
        
        //  MONTANDO AS RELAÇÕES DOS VERTIVES
        
        
        String rotulo = "";
        String ligacao1 = "";
        String ligacao2 = "";
        ArrayList<Aresta> listaAux2 = new ArrayList<Aresta>();
        
        for (int m = 0; m < this.listaVertice.size(); m++) {//0-4
            for (int n = 0; n < listaAresta.size(); n++) {//procurandoos correspondentes do vertice "A" na lista de aresta
                
                rotulo = this.listaVertice.get(m).getRotulo();
                ligacao1 = listaAresta.get(n).getLigacao1();
                ligacao2 = listaAresta.get(n).getLigacao2();
                
                
                if(rotulo.equals(ligacao1) && rotulo.equals(ligacao2)){
                    listaAux2.add(listaAresta.get(n));
                   
                }else{
                    if(rotulo.equals(ligacao1)){
                   
                    listaAux2.add(listaAresta.get(n));
                   
                     
                    }
                
                    if(rotulo.equals(ligacao2)){
                        
                        listaAux2.add(listaAresta.get(n));
                       
                        
                    }
                }
                                 
                //CASO SEJA UM LOOPING EX: "A-A" ELE ADICIONA APENAS UMA VEZ NA LISTA
                
            }
            
            this.listaVertice.get(m).setListaLigacoes(listaAux2);
        }
      
    
    }
    

    
    
    public void matrizAdjacencia(){
        int largura = quantVertices;
        int comprimento = quantVertices;
        
        int[][] matriz = new int[largura][comprimento];
        matriz = zeraMatriz(matriz, largura, comprimento);
        
        for (int i = 0; i < this.getListaVertices().size(); i++) {
            for (int j = 0; j < this.getListaVertices().size(); j++) {
               
                //Analizando se existe uma ligação entre o vertice i e o vertice j
                
                String x = this.getListaVertices().get(i).getRotulo();
                String y = this.getListaVertices().get(j).getRotulo();
                Vertice v = this.getListaVertices().get(i);
               
                if(this.getListaVertices().get(i).procuraLigacao(x, y, v)){
                    matriz[i][j] = 1;
                }
                 
            }
        }
        
        //PRINTANDO NA TELA
        
        printMatrizAdjacencia(largura, comprimento, matriz);
    
        propriedadesMatrizAdjacencia(matriz, largura,largura);
    }
    
    private void printMatrizAdjacencia(int largura, int comprimento, int[][]matriz){
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < comprimento; y++) {
                System.out.print("| "+matriz[x][y]+" |"+"");
                
            }
            System.out.print("\n");
        }
    
    }
    
    // printMatrizIncidencia(linha,coluna, matriz);
    
    private void printMatrizIncidencia(int linha,int coluna, int[][]matriz){
        
        
        
        for (int x = 0; x < linha; x++) {
            System.out.print("\n"+" "+(x+1)+">>");
           //System.out.print("| "+x+" |"+"");
            for (int y = 0; y < coluna; y++) {
                System.out.print("| "+matriz[y][x]+" |"+"");
                
            }
            
        }
    
    }
    
    
    public void matrizDeIncidencia(){
        int linha = quantVertices;//9
        int coluna = this.listaAresta.size();//4
        
        int[][] matriz = new int[coluna][linha];
        matriz = zeraMatriz(matriz, coluna, linha);
        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                int auxInt = Integer.parseInt(listaAresta.get(j).getLigacao1());
                int auxInt2 = Integer.parseInt(listaAresta.get(j).getLigacao2());
                
                if(i == auxInt-1){
                    matriz[j][i] = 1;
                }  
                if(i == auxInt2-1){
                    matriz[j][i] = 1;
                }
               
            }
        }


        
        
        printMatrizIncidencia(linha,coluna, matriz);
    }
    
    private int[][] zeraMatriz(int[][] mat, int largura, int comprimento){
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < comprimento; j++) {
                mat[i][j] = 0;
            }
        }
        
        return mat;
    }
    
    private int[][] zeraMatriz2(int[][] mat, int linha, int coluna){
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                mat[i][j] = 0;
            }
        }
        
        return mat;
    }
    

    /**
     * @return the listaVertices
     */
    public ArrayList<Vertice> getListaVertices() {
        return listaVertice;
    }

    /**
     * @param listaVertices the listaVertices to set
     */
    public void setListaVertices(ArrayList<Vertice> listaVertices) {
        this.listaVertice = listaVertices;
    }
}