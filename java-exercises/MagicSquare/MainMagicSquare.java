import MagicSquare.MagicSquareChecker;

public class MainMagicSquare {
    public static void main(String[] args) {
        int[][] magicSquare = {
            { 10, 7, 3 },
            { 4, 6, 10 },
            { 6, 10, 4 }
        };

        int[][] notMagicSquare = {
            { 5, 1, 9 },
            { 7, 8, 3 },
            { 2, 6, 4 }
        };

        int[][] notEvenSquare = {
            { 2, 4, 6 },
            { 1, 3, 5 },
            { 7, 8, 9 },
            { 0, 1, 2 }
        };

        MagicSquareChecker checker1 = new MagicSquareChecker(magicSquare);
        System.out.println(checker1.checkMagicSquare());

        MagicSquareChecker checker2 = new MagicSquareChecker(notMagicSquare);
        System.out.println(checker2.checkMagicSquare());

        MagicSquareChecker checker3 = new MagicSquareChecker(notEvenSquare);
        System.out.println(checker3.checkMagicSquare());
    }
}
