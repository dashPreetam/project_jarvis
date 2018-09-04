import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class voiceOutput
{
    void readString(String text){
        String voiceName="kevin16";
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice=vm.getVoice(voiceName);
        voice.allocate();
        try
        {
            voice.speak(text);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
