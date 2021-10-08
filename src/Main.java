import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader readerTemp, readerRT;
        BufferedWriter writer;
        String replaceFileName,tempFileName,outputFileName;


        try {
            System.out.print("Template File --> ");
            tempFileName = sc.next();

            System.out.print("ReplaceTable File --> ");
            replaceFileName = sc.next();

            System.out.print("Output File --> ");
            outputFileName = sc.next();

            readerRT = new BufferedReader(new InputStreamReader(new FileInputStream(replaceFileName)));
            ElementList elementList = ReplaceTableParser.parse(readerRT);

            readerTemp = new BufferedReader(new InputStreamReader(new FileInputStream(tempFileName)));


            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)));

            Replacer.replace(elementList, readerTemp, writer);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
