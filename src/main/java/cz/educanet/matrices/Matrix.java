package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {

        Matrix matrix1 = new Matrix(rawArray);
        Matrix matrix2 = (Matrix) matrix;
        double[][] result = new double[matrix1.getRows()][matrix2.getColumns()];

        if (matrix1.getColumns() != matrix2.getRows()) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                for (int k = 0; k < matrix1.getRows(); k++) {
                    result[i][j] += (matrix1.get(i, k) * matrix2.get(k, j));
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public IMatrix times(Number scalar) {

        double[][] matrix = rawArray;

        int number = (int) scalar;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] *= number;
            }
        }
        return new Matrix(matrix);

    }

    @Override
    public IMatrix add(IMatrix matrix) {

        double[][] sumMatrix = rawArray;

        for (int i = 0; i < sumMatrix.length; i++)
            for (int j = 0; j < sumMatrix.length; j++)
                sumMatrix[i][j] += matrix.get(i, j);

        return new Matrix(sumMatrix);
    }

    @Override
    public IMatrix transpose() {

        double[][] transpose = new double[this.getColumns()][this.getRows()];

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                transpose[j][i] = this.rawArray[i][j];
            }
        }

        return MatrixFactory.instance.create(transpose);
    }

    /**
     * TODO: Implement
     */
    @Override
    public double determinant() {
        return 0;
    }

    @Override
    public boolean isSquare() {
        return this.getRows() == this.getColumns();
    }


    @Override
    public boolean isDiagonal() {

        if (!this.isSquare()) {
            return false;
        }

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (i != j && this.rawArray[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * TODO: Implement
     */
    @Override
    public Number getTrace() {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException();
        }

        double trace = 0;
        for (int i = 0; i < this.getRows(); i++) {
            trace += this.rawArray[i][i];
        }

        return trace;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;
        return 0;
    }

    @Override
    public double get(int n, int m) {
        if (n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}
