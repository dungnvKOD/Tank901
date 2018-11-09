import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;

public class SoundManager {
    static void play(String name) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inStr = AudioSystem.getAudioInputStream(new File("src/sound/" + name));
            clip.open(inStr);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
