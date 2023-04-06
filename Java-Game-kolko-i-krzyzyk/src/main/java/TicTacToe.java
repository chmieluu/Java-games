

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        char currentPlayer = 'X';
        boolean gameEnded = false;

        // Inicjuj planszę
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        while (!gameEnded) {
            // Wyświetl planszę
            System.out.println("Plansza do gry:");
            displayBoard(board);

            // Pobierz ruch użytkownika
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ruch gracza " + currentPlayer);
            int row, col;
            do {
                System.out.print("Podaj wiersz (0-2): ");
                row = scanner.nextInt();
                System.out.print("Podaj kolumnę (0-2): ");
                col = scanner.nextInt();
            } while (!isValidMove(board, row, col));

            // Wykonaj ruch
            board[row][col] = currentPlayer;

            // Sprawdź czy gracz wygrał
            if (hasWon(board, currentPlayer) || isDiagonalWin(board, currentPlayer)) {
                System.out.println("Gracz " + currentPlayer + " wygrał!");
                gameEnded = true;
            } else if (isBoardFull(board)) {
                // Sprawdź czy plansza jest pełna
                System.out.println("Remis!");
                gameEnded = true;
            } else {
                // Przełącz gracza
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        // Wyświetl końcową planszę
        System.out.println("Plansza końcowa:");
        displayBoard(board);
    }

    // Metoda wyświetlająca planszę do gry
    public static void displayBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Metoda sprawdzająca czy ruch jest poprawny
    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Nieprawidłowy ruch. Podaj wartości między 0 a 2.");
            return false;
        } else if (board[row][col] != ' ') {
            System.out.println("To pole jest już zajęte. Podaj inne pole.");
            return false;
        } else {
            return true;
        }
    }

    // Metoda sprawdzająca czy plansza jest pełna
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Metoda sprawdzająca czy gracz wygrał
    public static boolean hasWon(char[][] board, char player) {
// Sprawdź wiersze
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Sprawdź kolumny
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }

        }
        return false;
    }

    public static boolean isDiagonalWin(char[][] board, char player) {
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }


}

