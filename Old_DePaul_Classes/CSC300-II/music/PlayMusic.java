package music;
import stdlib.*;
import music.Chord;
public class PlayMusic {

	public static void main(String[] args) {
		double[] array = {440.0, 880.0, 1760.0};
		double duration = 1.5;
		
		
		
		
		Chord newChord = new Chord(duration, array);
		newChord.play();
		newChord.toString();
		

	}

}
