import java.util.Arrays;
import java.util.Scanner;

class Grafo {
    Vertice[] cidade = new Vertice[5];
    Aresta[] conexao = new Aresta[5];
    int numCidadesCadastradas = 0;
    int numConexoesCadastradas = 0;

    public void info_Cidades() {
        if (numCidadesCadastradas == 0) {
            System.out.println("Nenhuma cidade cadastrada.");
            return;
        }

        Arrays.sort(cidade, 0, numCidadesCadastradas, (cidade1, cidade2) ->
                cidade1.getNomeCidade().compareToIgnoreCase(cidade2.getNomeCidade()));

        System.out.println("Lista de cidades em ordem alfabética:");
        for (int i = 0; i < numCidadesCadastradas; i++) {
            System.out.println(i + ": " + cidade[i].getNomeCidade());
        }
    }

    public void info_Conexoes() {
        if (numConexoesCadastradas == 0) {
            System.out.println("Nenhuma conexão cadastrada.");
            return;
        }

        System.out.println("Lista de conexões:");
        for (int i = 0; i < numConexoesCadastradas; i++) {
            Aresta conexaoAtual = conexao[i];
            System.out.println("Conexão entre " + conexaoAtual.getCidade1().getNomeCidade() +
                    " e " + conexaoAtual.getCidade2().getNomeCidade() +
                    " possui uma distância de " + conexaoAtual.getDistancia());
        }
    }

    public void info_CidadesVizinhas() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite a cidade: ");
        String cidadeProcurada = tec.nextLine();

        Vertice verticeProcurado = encontrarVerticePorNome(cidadeProcurada);
        if (verticeProcurado != null) {
            verticeProcurado.info_Vizinhos();
        } else {
            System.out.println("Cidade não encontrada.");
        }
    }

    public void cadastraCidade() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite o nome da cidade: ");
        String nomeCidade = tec.nextLine();

        if (numCidadesCadastradas == cidade.length) {
            cidade = Arrays.copyOf(cidade, cidade.length * 2);
        }

        Vertice novaCidade = new Vertice(nomeCidade);
        cidade[numCidadesCadastradas] = novaCidade;
        numCidadesCadastradas++;
        System.out.println("Cidade cadastrada com sucesso!");
    }

    public Vertice encontrarVerticePorNome(String nome) {
        for (int i = 0; i < numCidadesCadastradas; i++) {
            if (cidade[i].getNomeCidade().equalsIgnoreCase(nome)) {
                return cidade[i];
            }
        }
        return null;
    }

    public void cadastraConexao() {
        Scanner tec = new Scanner(System.in);

        if (numCidadesCadastradas < 2) {
            System.out.println("Cadastre ao menos 2 cidades!");
            return;
        }

        System.out.println("Digite a cidade de origem: ");
        for (int i = 0; i < numCidadesCadastradas; i++) {
            System.out.println(i + ": " + cidade[i].getNomeCidade());
        }

        String cidadeOrigem = tec.nextLine();

        System.out.println("Digite o destino");
        for (int i = 0; i < numCidadesCadastradas; i++) {
            System.out.println(i + ": " + cidade[i].getNomeCidade());
        }

        String cidadeDestino = tec.nextLine();

        System.out.println("Digite a distância entre as cidades: ");
        int distancia = tec.nextInt();

        Vertice verticeOrigem = encontrarVerticePorNome(cidadeOrigem);
        Vertice verticeDestino = encontrarVerticePorNome(cidadeDestino);

        if (verticeOrigem != null && verticeDestino != null) {
            if (numConexoesCadastradas == conexao.length) {
                conexao = Arrays.copyOf(conexao, conexao.length * 2);
            }

            Aresta novaConexao = new Aresta(verticeOrigem, verticeDestino, distancia);
            verticeOrigem.conexoes[numConexoesCadastradas] = novaConexao;
            verticeDestino.conexoes[numConexoesCadastradas] = novaConexao;

            conexao[numConexoesCadastradas] = novaConexao;
            numConexoesCadastradas++;

            System.out.println("Conexão cadastrada com sucesso!");
        } else {
            System.out.println("Cidades de origem ou destino não encontradas.");
        }
    }
}