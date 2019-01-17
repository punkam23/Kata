import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeDecompTest {
    @Test
    public void testPrimeDecompOne() {
        int lst = 38037787;
            assertEquals(
                    "(38037787)",
                    PrimeDecomp.factors(lst));
    }
}

