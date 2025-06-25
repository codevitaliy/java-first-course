package MagicSquare;

public class MagicSquareChecker {
    private int[][] magicSquare;

    public MagicSquareChecker(int[][] magicSquare) {
        this.magicSquare = magicSquare;
    }

    public String checkMagicSquare() {
        int rowSum = 0;
        int columnSum = 0;
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;

        int matrixLength = magicSquare[0].length;
        if (matrixLength != magicSquare.length) {
            return "Not even a square :(";
        }

        for (int i = 0; i < magicSquare.length; i++) {
            mainDiagonalSum += magicSquare[i][i];
        }

        for (int i = 0, j = magicSquare.length - 1; i < magicSquare.length; i++, j--) {
            antiDiagonalSum += magicSquare[j][i];
        }

        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare.length; j++) {
                rowSum += magicSquare[i][j];
                columnSum += magicSquare[j][i];
            }

            if (rowSum != columnSum || rowSum != mainDiagonalSum || rowSum != antiDiagonalSum ||
                columnSum != mainDiagonalSum || columnSum != antiDiagonalSum) {
                return "Not a magic square";
            } else {
                rowSum = 0;
                columnSum = 0;
            }
        }

        return "It is a Magic Square";
    }
}
