import java.io.*;
import java.util.Scanner;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.result.WordResult;

public class Transcribe {

   private static String OUTPUT_DIR = "output/";

   public static void main(String[] args) throws Exception {

      Configuration configuration = new Configuration();

      final Scanner scanner = new Scanner(System.in);

      // Set path to acoustic model, dictionary, and language model, then initialize recognizer.
      configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
      configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
      configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

      StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);

      System.out.println("Welcome to the Lexure audio file transcriber!\n");

      // Setup input
      String fname = null;
      while (true) {
         try {
            fname = prompt(scanner, "Please input the file name to be transcribed.");
            System.out.println(fname);
            InputStream stream = new FileInputStream(new File(fname));
            recognizer.startRecognition(stream);
            break;
         } catch (FileNotFoundException e) {
            System.out.printf("File %s not found. Please enter another filename to try or type quit to quit. \n", fname);
         }
      }
      SpeechResult result;

      // Setup output
      PrintWriter writer;
      while (true) {
         try {
            fname = prompt(scanner, "Please input the file name to be used for output relative to the output folder.");
            writer = new PrintWriter(OUTPUT_DIR + fname, "UTF-8");
            break;
         } catch (FileNotFoundException e) {
            System.err.printf("Unable to open %s. Please enter another filename to try. \n", fname);
         }
      }

      while ((result = recognizer.getResult()) != null) {
         System.out.format("Hypothesis: %s\n", result.getHypothesis());

         // Get individual words and their times.
         for (WordResult r : result.getWords()) {
            System.out.println(r);
         }

         // Write to output file
         writer.println(result.getHypothesis());
      }

      writer.close();
      recognizer.stopRecognition();
   }

   public static String prompt(Scanner console, String s) {
      System.out.println(s);
      String out = console.nextLine();
      if (out.equalsIgnoreCase("quit")) {
         System.out.println("Thank you for using the Lexure audio file transcriber.");
         System.exit(0);
      }
      return out;
   }
}