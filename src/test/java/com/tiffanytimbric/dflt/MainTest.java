package com.tiffanytimbric.dflt;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class MainTest {

    @Test
    public void testMain() {
        Main.main("Tiffany");
    }

    @Test
    public void testApply_Success() {
        final ResultStatus resultStatus = new Main().apply(List.of("Tiffany"));

        assertNotNull(
                resultStatus, "The result status was null."
        );
        assertEquals(
                ResultStatus.Success, resultStatus,
                "The result status was non-success."
        );
        assertEquals(
                "Success", resultStatus.getMessage()
        );
    }

    @Test
    public void testApply_Failure() {
        final ResultStatus resultStatus = new Main().apply(List.of(""));

        assertNotNull(
                resultStatus, "The result status was null."
        );
        assertEquals(
                ResultStatus.Failure, resultStatus,
                "The result status was non-success."
        );
        assertEquals(
                "Failure: At least one argument must be provided.",
                resultStatus.getMessage()
        );
    }

}
