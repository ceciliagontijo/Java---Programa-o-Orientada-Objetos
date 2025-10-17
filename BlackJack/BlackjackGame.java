import java.util.Scanner;

public class BlackjackGame {

    public static int calcularValorDaMao(Card[] mao, int qtdCartas) {
        int total = 0;
        int ases = 0;

        for (int i = 0; i < qtdCartas; i++) {
            String face = mao[i].toString().split(" ")[0]; // pega a palavra antes de "of"

            switch (face) {
                case "Ace":
                    ases++;
                    total += 11;
                    break;
                case "Jack":
                case "Queen":
                case "King":
                    total += 10;
                    break;
                default:
                    total += Integer.parseInt(face.equals("Deuce") ? "2" : face.equals("Three") ? "3"
                        : face.equals("Four") ? "4" : face.equals("Five") ? "5" : face.equals("Six") ? "6"
                        : face.equals("Seven") ? "7" : face.equals("Eight") ? "8" : face.equals("Nine") ? "9"
                        : face.equals("Ten") ? "10" : "0");
            }
        }

        // ajusta o valor dos ases (se o total passou de 21, alguns ases valem 1)
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DeckOfCards baralho = new DeckOfCards();
        baralho.shuffle();

        Card[] maoJogador = new Card[10];
        Card[] maoDealer = new Card[10];
        int qtdJogador = 0, qtdDealer = 0;

        // Distribui as 2 primeiras cartas
        maoJogador[qtdJogador++] = baralho.dealCard();
        maoDealer[qtdDealer++] = baralho.dealCard();
        maoJogador[qtdJogador++] = baralho.dealCard();
        maoDealer[qtdDealer++] = baralho.dealCard();

        System.out.println("Suas cartas:");
        for (int i = 0; i < qtdJogador; i++) {
            System.out.println("  " + maoJogador[i]);
        }
        System.out.println("Total: " + calcularValorDaMao(maoJogador, qtdJogador));
        System.out.println();

        System.out.println("Carta visível do dealer: " + maoDealer[0]);
        System.out.println();

        // Turno do jogador
        while (true) {
            int totalJogador = calcularValorDaMao(maoJogador, qtdJogador);
            if (totalJogador == 21) {
                System.out.println("Blackjack! Você tem 21 pontos.");
                break;
            }
            if (totalJogador > 21) {
                System.out.println("Você estourou! (" + totalJogador + ")");
                System.out.println("Dealer vence.");
                input.close();
                return;
            }

            System.out.print("Deseja outra carta? (s/n): ");
            String escolha = input.nextLine().toLowerCase();
            if (escolha.equals("s")) {
                maoJogador[qtdJogador++] = baralho.dealCard();
                System.out.println("Você recebeu: " + maoJogador[qtdJogador - 1]);
                System.out.println("Total: " + calcularValorDaMao(maoJogador, qtdJogador));
            } else {
                break;
            }
        }

        System.out.println("\n--- Turno do Dealer ---");
        System.out.println("Cartas do dealer:");
        for (int i = 0; i < qtdDealer; i++) {
            System.out.println("  " + maoDealer[i]);
        }

        // Turno do dealer
        while (calcularValorDaMao(maoDealer, qtdDealer) < 17) {
            maoDealer[qtdDealer++] = baralho.dealCard();
            System.out.println("Dealer compra: " + maoDealer[qtdDealer - 1]);
        }

        int totalJogador = calcularValorDaMao(maoJogador, qtdJogador);
        int totalDealer = calcularValorDaMao(maoDealer, qtdDealer);

        System.out.println("\nTotal do jogador: " + totalJogador);
        System.out.println("Total do dealer: " + totalDealer);

        // Resultado final
        if (totalDealer > 21 || totalJogador > totalDealer && totalJogador <= 21) {
            System.out.println("Você venceu!");
        } else if (totalJogador == totalDealer) {
            System.out.println("Empate!");
        } else {
            System.out.println("Dealer venceu!");
        }

        input.close();
    }
}
