package playScale;

// Logan Murray
// CSC300-601

import stdlib.StdAudio;
import stdlib.StdIn;
import stdlib.StdOut;

public class PlayScale {
	
	public static void playTone(double frequency, double duration) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}

	public static void main(String[] args) {
		StdIn.fromFile("scalenotes.txt");
		
		double[] noteScale = StdIn.readAllDoubles();
		StdOut.println(noteScale);
		
		for (int i = 0; i <= noteScale.length; i++){
			playTone(noteScale[i], 0.125);
		}

	}

}
