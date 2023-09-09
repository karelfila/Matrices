package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateDiagonalTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_DiagonalLengthIsValid() {

        double[] validDiagonal = {2, 4, 6, 10};

        for (int i = 0; i < validDiagonal.length; i++) {

            IMatrix matrix = MatrixFactory.instance.createDiagonal(validDiagonal);

            Assertions.assertEquals(validDiagonal.length, matrix.getRows());
            Assertions.assertEquals(validDiagonal.length, matrix.getColumns());
        }

    }

    @Test
    public void should_CreateEmptyDiagonalMatrix_When_NoNumbersAreProvided() {
        double[] diagonal = {};

        IMatrix matrix = MatrixFactory.instance.createDiagonal(diagonal);

        assertEquals(0, matrix.getRows());
        assertEquals(0, matrix.getColumns());
    }

}