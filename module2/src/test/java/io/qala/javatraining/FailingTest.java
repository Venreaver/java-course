package io.qala.javatraining;


import org.testng.annotations.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class FailingTest {
    @Test
    public void strangeFailure() throws Exception {
        InputStream is = getClass().getResourceAsStream("/myresource.txt");
        assertEquals(is.read(), 49);
    }
}
