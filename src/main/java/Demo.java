import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Demo
{

    public static void main(String[] args) throws IOException {

        /*Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
        System.out.println("Recognition starts: ");
        recognizer.startRecognition(true);
        SpeechResult result;

        while ((result = recognizer.getResult()) != null) {
            System.out.format("Hypothesis: %s\n", result.getHypothesis());
        }
        recognizer.stopRecognition();
        String voiceName="kevin";
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice=vm.getVoice(voiceName);
        voice.allocate();
        try
        {
            String text = "System on, Ready to work";
            voice.speak(text);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/


        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        String text = "What is the time in India now?";

        Annotation document = new Annotation(text);

        pipeline.annotate(document);

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        System.out.println("String as input :\n"+text);

        for(CoreMap sentence: sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {

                String word = token.get(CoreAnnotations.TextAnnotation.class);

                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);

                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                System.out.println("Word : ["+word+"] \t Part of Speech : ["+pos+"] \t Named Entity : "+ne);
            }
        }
    }
}