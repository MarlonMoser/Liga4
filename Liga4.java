import java.util.Scanner;

public class Marlon {
    public static void main(String[] args) {

        jogo();
    }

    public static char escolheJogador() {
        Scanner teclado = new Scanner(System.in);
        char escolha = '0';

        do {
            System.out.println("Escolha a sua cor: V (Vermelho) ou A (Azul)");
            char entrada = teclado.next().toUpperCase().charAt(0);

            if (entrada == 'V') {
                System.out.println("Você escolheu: Vermelho");
                System.out.println("O computador será: Azul");

                escolha = entrada;
            } else if (entrada == 'A') {
                System.out.println("Você escolheu: Azul");
                System.out.println("O computador será: Vermelho");

                escolha = entrada;
            } else {
                System.out.println("Escolha inválida! Tente novamente.");
            }
        } while (escolha != 'V' && escolha != 'A');

        return escolha;
    }

    // Aqui pegamos e damos a outra cor para o computador
    public static char corcomputador(char jogador) {
        char corpc;

        if (jogador == 'V') {
            corpc = 'A';
            return corpc;
        }
        if (jogador == 'A') {
            corpc = 'V';
            return corpc;
        }

        return ' ';
    }

    // inicia o tabuleiro com "B"
    public static void iniciatabuleiro(char[][] Tabuleiro) {

        for (int i = 0; i < Tabuleiro.length; i++) {
            for (int j = 0; j < Tabuleiro[i].length; j++) {
                Tabuleiro[i][j] = 'B';
            }
        }
    }

    // Lê o tabuleiro
    public static void imprimetabuleiro(char[][] Tabuleiro) {
        System.out.println("---------------------------");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(Tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Pede jogada ao computador //

    public static int fazerjogadapc() {

        int numeroAleatorio = (int) (Math.random() * 7); // Gera um número aleatório entre 0 e 6

        int numeroimprimir = numeroAleatorio + 1;
        System.out.println("O computador Vai jogar na casa: " + numeroimprimir);
        return numeroAleatorio;

    }

    // insere a jogada do computador //
    public static void inserejogadaPC(int bcoluna, char[][] Tabuleiro, char computador) {
        for (int i = 5; i >= 0; i--) {
            if (Tabuleiro[i][bcoluna] == 'B') {
                Tabuleiro[i][bcoluna] = computador;
                break;
            }
        }

        imprimetabuleiro(Tabuleiro);
    }

    // insere a jogada do usuário //

    public static void inserejogada(int acoluna, char[][] Tabuleiro, char jogador) {
        Scanner teclado = new Scanner(System.in);
        for (int i = 5; i >= 0; i--) {

            if (Tabuleiro[i][acoluna] == 'B') {
                Tabuleiro[i][acoluna] = jogador;
                break;
            }

            while (Tabuleiro[0][acoluna] != 'B' && Tabuleiro[0][acoluna] == 'V' || Tabuleiro[0][acoluna] == 'A') {
                System.out.println("Esta coluna esta cheia!!");

                System.out.print("Escolha uma coluna 1 a 7: ");
                acoluna = teclado.nextInt();

            }
        }

    }

    // Se houver vitoria do jogador

    public static boolean jVitoria(char[][] Tabuleiro, char jogador) {

        // Se tiver Alguma Vitoria na Horizontal (jogador)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (Tabuleiro[i][j] == jogador && Tabuleiro[i][j + 1] == jogador &&
                        Tabuleiro[i][j + 2] == jogador && Tabuleiro[i][j + 3] == jogador) {

                    return true;

                }
            }
        }

        // Verificar vitória na vertical (jogador)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (Tabuleiro[i][j] == jogador && Tabuleiro[i + 1][j] == jogador &&
                        Tabuleiro[i + 2][j] == jogador && Tabuleiro[i + 3][j] == jogador) {
                    return true;
                }
            }
        }

        // Verificar vitória na diagonal (para a direita) (jogador)

        // São para verificar as mais de cima

        if (Tabuleiro[0][0] == jogador && Tabuleiro[0 + 1][0 + 1] == jogador &&
                Tabuleiro[0 + 2][0 + 2] == jogador && Tabuleiro[0 + 3][0 + 3] == jogador
                || Tabuleiro[0][0 + 1] == jogador && Tabuleiro[0 + 1][0 + 2] == jogador &&
                        Tabuleiro[0 + 2][0 + 3] == jogador && Tabuleiro[0 + 3][0 + 4] == jogador) {
            return true;
        }

        if (Tabuleiro[0][0 + 2] == jogador && Tabuleiro[0 + 1][0 + 3] == jogador &&
                Tabuleiro[0 + 2][0 + 4] == jogador && Tabuleiro[0 + 3][0 + 5] == jogador
                || Tabuleiro[0][0 + 3] == jogador && Tabuleiro[0 + 1][0 + 4] == jogador &&
                        Tabuleiro[0 + 2][0 + 5] == jogador && Tabuleiro[0 + 3][0 + 6] == jogador) {
            return true;
        }
        // ---------------------------------------------------------------------
        // São para verificar as do meio

        if (Tabuleiro[0 + 1][0] == jogador && Tabuleiro[0 + 2][0 + 1] == jogador &&
                Tabuleiro[0 + 3][0 + 2] == jogador && Tabuleiro[0 + 4][0 + 3] == jogador
                || Tabuleiro[0 + 1][0 + 1] == jogador && Tabuleiro[0 + 2][0 + 2] == jogador &&
                        Tabuleiro[0 + 3][0 + 3] == jogador && Tabuleiro[0 + 4][0 + 4] == jogador) {
            return true;
        }

        if (Tabuleiro[0 + 1][0 + 2] == jogador && Tabuleiro[0 + 2][0 + 3] == jogador &&
                Tabuleiro[0 + 3][0 + 4] == jogador && Tabuleiro[0 + 4][0 + 5] == jogador
                || Tabuleiro[0 + 1][0 + 3] == jogador && Tabuleiro[0 + 2][0 + 4] == jogador &&
                        Tabuleiro[0 + 3][0 + 5] == jogador && Tabuleiro[0 + 4][0 + 6] == jogador) {
            return true;
        }

        // ---------------------------------------------------------------------------
        // As mais abaixo

        if (Tabuleiro[0 + 2][0] == jogador && Tabuleiro[0 + 3][0 + 1] == jogador &&
                Tabuleiro[0 + 4][0 + 2] == jogador && Tabuleiro[0 + 5][0 + 3] == jogador
                || Tabuleiro[0 + 2][0 + 1] == jogador && Tabuleiro[0 + 3][0 + 2] == jogador &&
                        Tabuleiro[0 + 4][0 + 3] == jogador && Tabuleiro[0 + 5][0 + 4] == jogador) {
            return true;
        }

        if (Tabuleiro[0 + 2][0 + 2] == jogador && Tabuleiro[0 + 3][0 + 3] == jogador &&
                Tabuleiro[0 + 4][0 + 4] == jogador && Tabuleiro[0 + 5][0 + 5] == jogador
                || Tabuleiro[0 + 2][0 + 3] == jogador && Tabuleiro[0 + 3][0 + 4] == jogador &&
                        Tabuleiro[0 + 4][0 + 5] == jogador && Tabuleiro[0 + 5][0 + 6] == jogador) {
            return true;
        }

        // ----------------------------------------------------------------------------

        // Verificar vitória na diagonal (para a esquerda) (jogador)
        // São para verificar as do meio

        if (Tabuleiro[0][4] == jogador && Tabuleiro[1][3] == jogador &&
                Tabuleiro[2][2] == jogador && Tabuleiro[3][1] == jogador
                || Tabuleiro[1][4] == jogador && Tabuleiro[2][3] == jogador &&
                        Tabuleiro[3][2] == jogador && Tabuleiro[4][1] == jogador) {
            return true;
        }

        if (Tabuleiro[2][4] == jogador && Tabuleiro[3][3] == jogador &&
                Tabuleiro[4][2] == jogador && Tabuleiro[5][1] == jogador
                || Tabuleiro[3][4] == jogador && Tabuleiro[4][3] == jogador &&
                        Tabuleiro[5][2] == jogador && Tabuleiro[6][1] == jogador) {
            return true;
        }

        // ---------------------------------------------------------------------
        // São para verificar as de cima

        if (Tabuleiro[0][3] == jogador && Tabuleiro[1][2] == jogador &&
                Tabuleiro[2][1] == jogador && Tabuleiro[3][0] == jogador) {
            return true;
        }

        if (Tabuleiro[1][3] == jogador && Tabuleiro[2][2] == jogador &&
                Tabuleiro[3][1] == jogador && Tabuleiro[4][0] == jogador) {
            return true;
        }

        if (Tabuleiro[2][3] == jogador && Tabuleiro[3][2] == jogador &&
                Tabuleiro[4][1] == jogador && Tabuleiro[5][0] == jogador) {
            return true;
        }

        if (Tabuleiro[3][3] == jogador && Tabuleiro[4][2] == jogador &&
                Tabuleiro[5][1] == jogador && Tabuleiro[5][0] == jogador) {
            return true;
        }

        // ---------------------------------------------------------------------------
        // As de baixo

        if (Tabuleiro[0][5] == jogador && Tabuleiro[1][4] == jogador &&
                Tabuleiro[2][3] == jogador && Tabuleiro[3][2] == jogador) {
            return true;
        }

        if (Tabuleiro[1][5] == jogador && Tabuleiro[2][4] == jogador &&
                Tabuleiro[3][3] == jogador && Tabuleiro[4][2] == jogador) {
            return true;
        }

        if (Tabuleiro[2][5] == jogador && Tabuleiro[3][4] == jogador &&
                Tabuleiro[4][3] == jogador && Tabuleiro[5][2] == jogador) {
            return true;
        }

        if (Tabuleiro[3][5] == jogador && Tabuleiro[4][4] == jogador &&
                Tabuleiro[5][3] == jogador && Tabuleiro[6][2] == jogador) {
            return true;
        }
        return false;
    }

    // ----------------------------------------------------------------------------

    // Se houver empate do jogador

    public static boolean Empate(char[][] Tabuleiro, char jogador) {

        for (int i = 0; i < Tabuleiro.length; i++) {
            for (int j = 0; j < Tabuleiro[i].length; j++) {
                Tabuleiro[i][j] = 'B';
                return false;
            }
        }
        return true;
    }

    // Se houver vitoria do Computador

    public static boolean CVitoria(char[][] Tabuleiro, char computador) {

        // Se tiver Alguma Vitoria na Horizontal (Computador)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (Tabuleiro[i][j] == computador && Tabuleiro[i][j + 1] == computador &&
                        Tabuleiro[i][j + 2] == computador && Tabuleiro[i][j + 3] == computador) {

                    return true;

                }
            }
        }

        // Se tiver Alguma Vitoria na Vertical (Computador)

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (Tabuleiro[i][j] == computador && Tabuleiro[i + 1][j] == computador &&
                        Tabuleiro[i + 2][j] == computador && Tabuleiro[i + 3][j] == computador) {
                    return true;
                }
            }
        }

        // Verificar vitória na diagonal (para a direita) (Computador)

        // São para verificar as mais de cima

        if (Tabuleiro[0][0] == computador && Tabuleiro[0 + 1][0 + 1] == computador &&
                Tabuleiro[0 + 2][0 + 2] == computador && Tabuleiro[0 + 3][0 + 3] == computador) {
            return true;
        }

        if (Tabuleiro[0][0 + 1] == computador && Tabuleiro[0 + 1][0 + 2] == computador &&
                Tabuleiro[0 + 2][0 + 3] == computador && Tabuleiro[0 + 3][0 + 4] == computador) {
            return true;
        }

        if (Tabuleiro[0][0 + 2] == computador && Tabuleiro[0 + 1][0 + 3] == computador &&
                Tabuleiro[0 + 2][0 + 4] == computador && Tabuleiro[0 + 3][0 + 5] == computador) {
            return true;
        }

        if (Tabuleiro[0][0 + 3] == computador && Tabuleiro[0 + 1][0 + 4] == computador &&
                Tabuleiro[0 + 2][0 + 5] == computador && Tabuleiro[0 + 3][0 + 6] == computador) {
            return true;
        }
        // ---------------------------------------------------------------------
        // São para verificar as do meio

        if (Tabuleiro[0 + 1][0] == computador && Tabuleiro[0 + 2][0 + 1] == computador &&
                Tabuleiro[0 + 3][0 + 2] == computador && Tabuleiro[0 + 4][0 + 3] == computador) {
            return true;
        }

        if (Tabuleiro[0 + 1][0 + 1] == computador && Tabuleiro[0 + 2][0 + 2] == computador &&
                Tabuleiro[0 + 3][0 + 3] == computador && Tabuleiro[0 + 4][0 + 4] == computador) {
            return true;
        }

        if (Tabuleiro[0 + 1][0 + 2] == computador && Tabuleiro[0 + 2][0 + 3] == computador &&
                Tabuleiro[0 + 3][0 + 4] == computador && Tabuleiro[0 + 4][0 + 5] == computador) {
            return true;
        }

        if (Tabuleiro[0 + 1][0 + 3] == computador && Tabuleiro[0 + 2][0 + 4] == computador &&
                Tabuleiro[0 + 3][0 + 5] == computador && Tabuleiro[0 + 4][0 + 6] == computador) {
            return true;
        }

        // ---------------------------------------------------------------------------
        // As mais abaixo

        if (Tabuleiro[0 + 2][0] == computador && Tabuleiro[0 + 3][0 + 1] == computador &&
                Tabuleiro[0 + 4][0 + 2] == computador && Tabuleiro[0 + 5][0 + 3] == computador) {
            return true;
        }

        if (Tabuleiro[0 + 2][0 + 1] == computador && Tabuleiro[0 + 3][0 + 2] == computador &&
                Tabuleiro[0 + 4][0 + 3] == computador && Tabuleiro[0 + 5][0 + 4] == computador) {
            return true;
        }

        if (Tabuleiro[0 + 2][0 + 2] == computador && Tabuleiro[0 + 3][0 + 3] == computador &&
                Tabuleiro[0 + 4][0 + 4] == computador && Tabuleiro[0 + 5][0 + 5] == computador) {
            return true;
        }

        if (Tabuleiro[0 + 2][0 + 3] == computador && Tabuleiro[0 + 3][0 + 4] == computador &&
                Tabuleiro[0 + 4][0 + 5] == computador && Tabuleiro[0 + 5][0 + 6] == computador) {
            return true;
        }

        // Verificar vitória na diagonal (para a esquerda) (Computador)
        // São para verificar as do meio

        if (Tabuleiro[0][4] == computador && Tabuleiro[1][3] == computador &&
                Tabuleiro[2][2] == computador && Tabuleiro[3][1] == computador) {
            return true;
        }

        if (Tabuleiro[1][4] == computador && Tabuleiro[2][3] == computador &&
                Tabuleiro[3][2] == computador && Tabuleiro[4][1] == computador) {
            return true;
        }

        if (Tabuleiro[2][4] == computador && Tabuleiro[3][3] == computador &&
                Tabuleiro[4][2] == computador && Tabuleiro[5][1] == computador) {
            return true;
        }

        if (Tabuleiro[3][4] == computador && Tabuleiro[4][3] == computador &&
                Tabuleiro[5][2] == computador && Tabuleiro[6][1] == computador) {
            return true;
        }
        // ---------------------------------------------------------------------
        // São para verificar as de cima

        if (Tabuleiro[0][3] == computador && Tabuleiro[1][2] == computador &&
                Tabuleiro[2][1] == computador && Tabuleiro[3][0] == computador) {
            return true;
        }

        if (Tabuleiro[1][3] == computador && Tabuleiro[2][2] == computador &&
                Tabuleiro[3][1] == computador && Tabuleiro[4][0] == computador) {
            return true;
        }

        if (Tabuleiro[2][3] == computador && Tabuleiro[3][2] == computador &&
                Tabuleiro[4][1] == computador && Tabuleiro[5][0] == computador) {
            return true;
        }

        if (Tabuleiro[3][3] == computador && Tabuleiro[4][2] == computador &&
                Tabuleiro[5][1] == computador && Tabuleiro[6][0] == computador) {
            return true;
        }

        // ---------------------------------------------------------------------------
        // As de baixo

        if (Tabuleiro[0][5] == computador && Tabuleiro[1][4] == computador &&
                Tabuleiro[2][3] == computador && Tabuleiro[3][2] == computador) {
            return true;
        }

        if (Tabuleiro[1][5] == computador && Tabuleiro[2][4] == computador &&
                Tabuleiro[3][3] == computador && Tabuleiro[4][2] == computador) {
            return true;
        }

        if (Tabuleiro[2][5] == computador && Tabuleiro[3][4] == computador &&
                Tabuleiro[4][3] == computador && Tabuleiro[5][2] == computador) {
            return true;
        }

        if (Tabuleiro[3][5] == computador && Tabuleiro[4][4] == computador &&
                Tabuleiro[5][3] == computador && Tabuleiro[6][2] == computador) {
            return true;
        }
        return false;
    }

    // O jogo começa

    public static void jogo() {
        boolean jogar = true;
        Scanner teclado = new Scanner(System.in);

        char[][] Tabuleiro = new char[6][7];

        // Aqui e pra designar a cor do computador

        char jogador = escolheJogador();
        char computador = corcomputador(jogador);
        System.out.println(computador);
        iniciatabuleiro(Tabuleiro);
        imprimetabuleiro(Tabuleiro);
        int acoluna;
        while (jogar == true) {
            int acabou = 0;

            while (acabou == 0) {
                acoluna = 0;
                // Pede a jogada do usuário //
                System.out.print("Escolha uma coluna 1 a 7: ");
                acoluna = teclado.nextInt();
                acoluna = acoluna - 1;
                inserejogada(acoluna, Tabuleiro, jogador);

                if (jVitoria(Tabuleiro, jogador)) {
                    acabou++;
                    System.out.println("Parabéns Jogador ! Você GANHOU!!");
                    imprimetabuleiro(Tabuleiro);
                    break;
                }

                if (Empate(Tabuleiro, jogador)) {
                    acabou++;
                    System.out.println("A que pena, acabou empatando! Jogue Novamente!!");
                    imprimetabuleiro(Tabuleiro);
                    break;
                }

                System.out.println("Vez do computador");

                int bcoluna = fazerjogadapc();
                inserejogadaPC(bcoluna, Tabuleiro, computador);

                if (CVitoria(Tabuleiro, computador)) {
                    acabou++;
                    System.out.println("Que pena jogador! O computador acabou ganhando!");
                    imprimetabuleiro(Tabuleiro);
                    break;
                }
                System.out.println("Sua vez!!");

            }
            iniciatabuleiro(Tabuleiro);
            int repetir = jogardnv();

            if (repetir == 1) {

                jogo();

            }
            if (repetir != 1) {

                System.out.println("FIM DE JOGO");
                System.exit(0);
            }
        }

    }

    public static int jogardnv() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Deseja jogar Novamente? (1)para Sim // (0)para não");
        int jogar = teclado.nextInt();
        return jogar;
    }
}