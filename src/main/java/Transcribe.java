import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class Transcribe {

   public static void main(String[] args) throws Exception {

      Configuration configuration = new Configuration();

      // Set path to acoustic model
      configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");

      // Set path to dictionary
      configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");

      // Set language model
      configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

      StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
      InputStream stream = new FileInputStream(new File("joey.wav"));

      recognizer.startRecognition(stream);
      SpeechResult result;

      // Setup output file
      PrintWriter writer = new PrintWriter("joey.out", "UTF-8");

      while ((result = recognizer.getResult()) != null) {
         System.out.format("Hypothesis: %s\n", result.getHypothesis());

         // Write to output file
         writer.println(result.getHypothesis());
      }

      writer.close();
      recognizer.stopRecognition();
   }
}