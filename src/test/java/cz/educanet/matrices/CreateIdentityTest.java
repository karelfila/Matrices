package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateIdentityTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_SizeIsValid() {

        int[] validSizes = {3, 5, 6, 10};

        for (int i = 0; i < validSizes.length; i++) {

            IMatrix matrix = MatrixFactory.instance.createIdentity(i);

            Assertions.assertEquals(i, matrix.getRows());
            Assertions.assertEquals(i, matrix.getColumns());
        }

    }

    @Test
    public void should_ThrowException_When_NegativeSize() {
        int[] negativeSizes = {-2, -5, -10, -12};

        for (int size : negativeSizes)
            Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createIdentity(size));
    }
}