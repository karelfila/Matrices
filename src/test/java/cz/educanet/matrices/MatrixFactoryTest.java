package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixFactoryTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_CreateMatrix_When_NumbersAreValid() {

        double[][] validNumbers = {{1, 2}, {3, 4}};

        IMatrix matrix = MatrixFactory.instance.create(validNumbers);

        assertNotNull(matrix);
        assertEquals(2, matrix.getRows());
        assertEquals(2, matrix.getColumns());
    }

    @Test
    public void should_CreateEmptyMatrix_When_NoNumbersAreProvided() {
        double[][] data = {};

        IMatrix matrix = MatrixFactory.instance.create(data);

        assertEquals(0, matrix.getRows());
        assertEquals(0, matrix.getColumns());
    }

    @Test
    public void should_CreateMatrix_When_NumbersOfRowsAndColumnsIsValid() {

        double[][] matrixSizes = new double[3][4];

        IMatrix matrix = MatrixFactory.instance.create(matrixSizes);

        assertEquals(3, matrix.getRows());
        assertEquals(4, matrix.getColumns());
    }


}