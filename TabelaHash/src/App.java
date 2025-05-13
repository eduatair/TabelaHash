import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static int funcaoHash(String palavra, int tam) {
        int hash = 0;
        hash = 13 + palavra.toUpperCase().charAt(0);
        return hash % tam;
    }

    public static boolean buscarPalavra(String palavra, ArrayList<String>[] tabelaHash, int tam) {
        int categoria = funcaoHash(palavra, tam);
        ArrayList<String> lista = tabelaHash[categoria];

        if (lista != null && lista.contains(palavra)) {
            System.out.println(" Palavra '" + palavra + "' encontrada na categoria " + categoria + ".");
            return true;
        } else {
            System.out.println( "Palavra '" + palavra + "' não encontrada.");
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        int totalCategorias = 26;
        ArrayList<String>[] tabelaHash = new ArrayList[totalCategorias];

        // Inicializa a tabela hash
        for (int i = 0; i < tabelaHash.length; i++) {
            tabelaHash[i] = new ArrayList<String>();
        }

        System.out.println(" Gerando 100 palavras aleatórias e inserindo na tabela hash...\n");

        // Gera e insere as palavras
        for (int i = 0; i < 100; i++) {
            String palavra = GeradorPalavras.gerarPalavraAleatoria(3, 10);
            int categoria = funcaoHash(palavra, totalCategorias);
            tabelaHash[categoria].add(palavra);
        }

        // Exibe todas as palavras geradas por categoria
        System.out.println(" Palavras organizadas na tabela hash:");
        for (int i = 0; i < tabelaHash.length; i++) {
            char letraCategoria = (char) ('A' + i);
            System.out.println(letraCategoria + " (" + i + "): " + tabelaHash[i]);
        }

        // Solicita palavra para busca
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Digite uma palavra para buscar: ");
        String palavraBusca = scanner.nextLine();

        buscarPalavra(palavraBusca, tabelaHash, totalCategorias);

        scanner.close();
    }
}
