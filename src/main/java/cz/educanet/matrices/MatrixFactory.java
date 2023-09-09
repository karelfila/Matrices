package cz.educanet.matrices;

public class MatrixFactory implements IMatrixFactory {

    public static final IMatrixFactory instance = new MatrixFactory();

    private MatrixFactory() {
    }

    @Override
    public IMatrix create(double[][] data) {

        return new Matrix(data);

    }

    @Override
    public IMatrix createDiagonal(double[] diagonal) {

        double[][] matrix = new double[diagonal.length][diagonal.length];

        for (int i = 0; i < diagonal.length; i++) {
            matrix[i][i] = diagonal[i];
        }


        return new Matrix(matrix);
    }


    @Override
    public IMatrix createIdentity(int size) {

        if (size < 0)
            throw new IllegalArgumentException();

        double[][] matrix = new double[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }

        return new Matrix(matrix);
    }

    @Override
    public IMatrix createZero(int size) {
        if (size < 0)
            throw new IllegalArgumentException();

        return new Matrix(new double[size][size]);
    }
}
