import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        int opcao = -1;
        Grafo g = new Grafo();
        while (opcao != 0) {
            System.out.println("-------Interface-------");

            System.out.println("1- Cadastrar cidade: ");
            System.out.println("2- Cadastrar conexão: ");
            System.out.println("3- Listar cidades: ");
            System.out.println("4- Listar conexões: ");
            System.out.println("5- Listar cidades vizinhas: ");

            opcao = tec.nextInt();
            tec.nextLine();
            if(opcao==1){
                g.cadastraCidade();
            }
            if(opcao==2){
                g.cadastraConexao();
            }
            if(opcao==3){
                g.info_Cidades();
            }
            if(opcao==4){
                g.info_Conexoes();
            }
            if(opcao==5){
                g.info_CidadesVizinhas();
            }
            if(opcao==0){
                System.out.println("programa finalizado...");
            }

        }
    }
}