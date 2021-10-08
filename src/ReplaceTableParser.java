import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ReplaceTableParser {

    public static ElementList parse(Reader reader) throws IOException {
        ElementList res = new ElementList();
        BufferedReader rdFile = (BufferedReader) reader;
        String line;


        while ((line = rdFile.readLine()) != null) {
            String[] fields = line.split(":\\[");
            if (fields.length > 0) {
                res.addElement(new Element(fields[0].replace("\"", ""), fields[1].replace("\"", "").replace("]", "")));
            }
        }


        return res;
    }
}
