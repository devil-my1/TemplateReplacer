import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacer {
    public static void replace(ElementList elements, Reader reader, Writer writer) throws IOException {
        BufferedReader rdFile = (BufferedReader) reader;
        BufferedWriter wrFile = (BufferedWriter) writer;

        Pattern pattern = Pattern.compile("<\\W+\\s?\\d*>");
        Matcher matcher;
        String line;

        while ((line = rdFile.readLine()) != null) {

            matcher = pattern.matcher(line);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();

                String key = line.substring(start + 1, end - 1);

                wrFile.write(line.replaceFirst("<\\W+\\s?\\d*>", elements.getData(key)));
                wrFile.newLine();
            }
            matcher.reset();
            if (!matcher.find()) {
                wrFile.write(line);
                wrFile.newLine();
            }
            wrFile.flush();
        }

    }
}
