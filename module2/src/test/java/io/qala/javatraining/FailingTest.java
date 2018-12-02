package io.qala.javatraining;


import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.Assert.assertEquals;

public class FailingTest {
    // Solving by using InputStream instead of FileInputStream
    @Test
    public void strangeFailure() throws Exception {
        InputStream is = getClass().getResourceAsStream("/myresource.txt");
        assertEquals(is.read(), 49);
    }

    // Solving by using the temp copy of the file
    @Test
    public void strangeFailureAnotherOption() throws Exception {
        Path temp = Files.createTempFile("myresource", ".txt");
        Files.copy(getClass().getResourceAsStream("/myresource.txt"), temp, StandardCopyOption.REPLACE_EXISTING);
        assertEquals(new FileInputStream(temp.toFile()).read(), 49);
    }
}
