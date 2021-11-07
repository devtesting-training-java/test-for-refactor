package io.xp.kata.gildedrose;

import io.xp.kata.Main;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class SafeNetTest {
//    @Test
    public void testOutput() throws URISyntaxException, IOException {
        String output = Main.generateOutput(new String[0]);
        Path path = Paths.get(this.getClass().getResource("/baseline.txt").toURI());
        String baseline = new String(Files.readAllBytes(path));
        assertEquals(baseline, output);
    }
}
