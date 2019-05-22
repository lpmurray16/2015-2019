package finalexam;




import stdlib.*;


public class Chord {

	public double duration;
	public double[] frequencie;
		
		public Chord(double duration, double[] frequencies){
			this.frequencie = frequencies.clone();
			this.duration = duration;
		}
		
		public void play(){
			playChord(this.duration, this.frequencie);
		}
		
		public String toString(){
			String chord = "["+this.duration+": "+this.frequencie[0]+" "+this.frequencie[1]+" "+this.frequencie[2]+"]";
			return chord;
		}



		private void playChord(double duration, double[] frequencies) {
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
		}
}