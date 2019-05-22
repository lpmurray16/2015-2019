package playChords;


// Logan Murray
// CSC 300 - 601 
import stdlib.*;

public class PlayChords {

	public static void playChord(double duration, double[] frequencies) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			double chord = 0.0;
			for (double frequency: frequencies) {
				chord += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
			}
			slices[i] = chord/frequencies.length;
		}
		StdAudio.play(slices);
		StdOut.print(slices+ " ");
	}
	
	public static void main(String[] args) {
		StdIn.fromFile("data/chords.txt");
		double [] chordsArray = StdIn.readAllDoubles();
		while(!StdIn.isEmpty()){
			double[] freq = new double[2];
			double duration = StdIn.readDouble();
			for(int i = 0; i < 2; i++){
				freq[i] = chordsArray[i];
			}
			playChord(duration, freq);
			
		}
		
		for(double chord: chordsArray){
			StdOut.print(chord+" ");
		}
		
		
		
		
		
		

	}

}
