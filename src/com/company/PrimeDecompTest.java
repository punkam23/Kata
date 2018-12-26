package com.company;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class PrimeDecompTest {
    @Test
    public void testPrimeDecompOne() {
        int lst = 7775460;
            assertEquals(
                    "(2**2)(3**3)(5)(7)(11**2)(17)",
                    PrimeDecomp.factors(lst));
    }
}

