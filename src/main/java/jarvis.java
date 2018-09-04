import java.io.IOException;

public class jarvis
{
    public static void main(String[] args)throws IOException{

        //------------Record
        voiceRecog voiceRecog = new voiceRecog();
        voiceRecog.recognition();

        //------------Analyse
        voiceAnalysis voiceAnalysis = new voiceAnalysis();
        voiceAnalysis.analyse("what is the time now?");

        //------------Response
        voiceOutput voiceOutput = new voiceOutput();
        voiceOutput.readString("System on. Ready to work!!");
        voiceOutput.readString("something");
    }
}