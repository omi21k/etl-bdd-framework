package utilities;

import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SQLFileReader {

    public static String readQueryFromFile(String filePath) throws IOException {
        InputStream inputStream = SQLFileReader.class.getClassLoader().getResourceAsStream(filePath);
        
        if (inputStream == null) {
            throw new IOException("SQL file not found: " + filePath);
        }

        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            scanner.useDelimiter("\\A");  // Read the entire file at once
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}
