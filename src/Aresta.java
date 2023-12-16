class Aresta {
    Vertice cidade1;
    Vertice cidade2;
    int distancia;

    public Aresta(Vertice cidade1, Vertice cidade2, int distancia) {
        this.cidade1 = cidade1;
        this.cidade2 = cidade2;
        this.distancia = distancia;
    }

    public Vertice getCidade1() {
        return cidade1;
    }

    public Vertice getCidade2() {
        return cidade2;
    }

    public int getDistancia() {
        return distancia;
    }

    public void info_Aresta() {
        System.out.println("Conexão entre " + getCidade1().getNomeCidade() + " e " + getCidade2().getNomeCidade() + " Possui uma distancia de " + distancia);
    }
}