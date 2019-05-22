package playFNotes;

import stdlib.StdAudio;

// Logan Murray
// CSC300-601

public class PlayFNotes {
	
	public static void playTone(double frequency, double duration) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}

	public static void main(String[] args) {
		playTone(349.228, 1.5);
		playTone(698.456, 1.5);
		playTone(1396.91, 1.5);
	    StdAudio.close();
        System.exit(0);

	}

}
