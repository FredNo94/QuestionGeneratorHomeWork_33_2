package org.example;

import org.junit.Test;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;

public class UnitTest {

    @Test(expected = AccessDeniedException.class)
    public  void nullValueInURLDataFile() throws IOException {
        App.getDataFromFile("");
    }

    @Test(expected = NoSuchFileException.class)
    public  void randomStringInURLDataFile() throws IOException {
        App.getDataFromFile("RandomURL");
    }

    @Test(expected = RuntimeException.class)
    public  void checkAddNullValueArray() throws IOException {
        String[] arrayStringNull = null;
        App.createFileWithStudentsAndQuestion(arrayStringNull, arrayStringNull);
    }
}
