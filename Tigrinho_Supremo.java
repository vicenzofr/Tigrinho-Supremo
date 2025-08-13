package maratonajava.devdojo.Exercicios.Little_tiger;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.security.SecureRandom;

    public class Tigrinho_Supremo {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            double valorGanho = 0;
            boolean ganhou = false;
            final int coluna = 3;
            final int linhas = 3;
            int[][] roleta = new int[linhas][coluna];
            DecimalFormat df = new DecimalFormat("#.##");
            String[] tigrinho = {"💎", "🍒", "💸", "💣", "🍊", "🐯"};


            System.out.println("Olá bem-vindo ao Tigrinho do Felca");
            System.out.println("");
            System.out.println("Para jogar digite 1 e para sair 0");
            int inicio = sc.nextInt();

            System.out.println("");

            while (inicio == 1) {
                System.out.println("Qual o valor da aposta ?");
                double valorAposta = sc.nextDouble();
                System.out.println("");

                for (int l = 0; l < linhas; l++) {
                    for (int c = 0; c < coluna; c++) {
                        roleta[l][c] = new SecureRandom().nextInt(tigrinho.length);
                    }
                }

                // LINHAS
                for (int l = 0; l < linhas; l++) {
                    boolean todosIguaisLinha = true;
                    for (int c = 1; c < coluna; c++) {
                        if (roleta[l][c] != roleta[l][0]) {
                            todosIguaisLinha = false;
                            break;
                        }
                    }
                    if (todosIguaisLinha) {
                        ganhou = true;
                        switch (roleta[l][0]) {
                            case 0: valorGanho += valorAposta * 10; break;
                            case 1: valorGanho += valorAposta * 5; break;
                            case 2: valorGanho += valorAposta * 3; break;
                            case 3: valorGanho += valorAposta * 0; break;
                            case 4: valorGanho += valorAposta * 6; break;
                            case 5: valorGanho += valorAposta * 8; break;
                        }
                    }
                }

                // COLUNAS
                for (int c = 0; c < coluna; c++) {
                    boolean todosIguaisColuna = true;
                    for (int l = 1; l < linhas; l++) {
                        if (roleta[l][c] != roleta[0][c]) {
                            todosIguaisColuna = false;
                            break;
                        }
                    }
                    if (todosIguaisColuna) {
                        ganhou = true;
                        switch (roleta[0][c]) {
                            case 0: valorGanho += valorAposta * 10; break;
                            case 1: valorGanho += valorAposta * 5; break;
                            case 2: valorGanho += valorAposta * 3; break;
                            case 3: valorGanho += valorAposta * 0; break;
                            case 4: valorGanho += valorAposta * 6; break;
                            case 5: valorGanho += valorAposta * 8; break;
                        }
                    }
                }

                if (!ganhou) {
                    valorGanho = valorAposta * 1.4; // ganho mínimo
                }

                for (int l = 0; l < linhas; l++) {
                    for (int c = 0; c < coluna; c++) {
                        System.out.print(tigrinho[roleta[l][c]]);
                    }
                    System.out.println();
                }
                String numeroFormatado = df.format(valorGanho);

                System.out.println();
                System.out.println("O seu valor apostado foi de: " + valorAposta + "  | Seu resultado ganho foi: " + "R$" + numeroFormatado );
                System.out.println("---------------------------------");
            }
        }
    }