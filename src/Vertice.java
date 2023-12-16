class Vertice {
    String nomeCidade;
    Aresta[] conexoes = new Aresta[5];

    public Vertice(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void info_Vizinhos() {
        System.out.println("Cidades vizinhas de " + nomeCidade + " com distância até 50:");

        Aresta[] conexoesOrdenadas = new Aresta[conexoes.length];
        System.arraycopy(conexoes, 0, conexoesOrdenadas, 0, conexoes.length);

        int n = conexoesOrdenadas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (conexoesOrdenadas[j] != null && conexoesOrdenadas[j + 1] != null
                        && conexoesOrdenadas[j].getDistancia() > conexoesOrdenadas[j + 1].getDistancia()) {
                    Aresta temp = conexoesOrdenadas[j];
                    conexoesOrdenadas[j] = conexoesOrdenadas[j + 1];
                    conexoesOrdenadas[j + 1] = temp;
                }
            }
        }

        for (Aresta conexao : conexoesOrdenadas) {
            if (conexao != null && conexao.getDistancia() <= 50) {
                Vertice vizinho = conexao.getCidade1().equals(this) ? conexao.getCidade2() : conexao.getCidade1();
                System.out.println(" - " + vizinho.getNomeCidade() + " - Distância: " + conexao.getDistancia());
            }
        }
    }


}