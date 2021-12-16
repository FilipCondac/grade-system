
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileReadMain {

    public static void main(String[] args) throws IOException {

        File textFile = new File("Metamorphosis.txt");
        Scanner read = new Scanner(textFile);


        FileInputStream fis = new FileInputStream(textFile);
        byte[] bytesArray = new byte[(int)textFile.length()];

        while(read.hasNextLine()){
            System.out.println(read.nextLine());
        }

        System.out.println("The total number of characters in the file are: " + textFile.length());

        //Word counter
        int wordCount = 0;
        fis.read(bytesArray);
        String wordS = new String(bytesArray);
        String [] wordData = wordS.split(" ");
        for (int i=0; i<wordData.length; i++) {
            wordCount++;

        }

        System.out.println("Number of words in the given file are " +wordCount);
        BufferedReader reader = new BufferedReader(new FileReader("Metamorphosis.txt"));
        int sentenceCount = 0;
        int paragraphCount = 0;

        String line;

        String delimiters = "?!.";

        while ((line = reader.readLine()) != null) { // Continue reading until end of file is reached

            if(line.equals("")){
                paragraphCount++;
            }
            for (int i = 0; i < line.length(); i++) {
                if (delimiters.indexOf(line.charAt(i)) != -1) { // If the delimiters string contains the character
                    sentenceCount++;
                }
            }

        }
        Path path = Paths.get("metamorphosis.txt");
        try {
            String text = Files.readString(path); // throws java.io.IOException
            text = text.toLowerCase();
            wordFrequencyCounter(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader.close();
        System.out.println("The number of sentences is " + sentenceCount);
        System.out.println("The number of paragraphs is " + paragraphCount);



    }

    public static void wordFrequencyCounter(String str) throws FileNotFoundException {


            List<String> list = Stream.of(str).map(w -> w.split("\\b+")).flatMap(Arrays::stream)
                    .collect(Collectors.toList());

            Map<String, Integer > wordCounter = list.stream()
                    .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

            PrintWriter out = new PrintWriter("frequencies.txt");
            out.println(wordCounter);
            out.close();


    }



}







