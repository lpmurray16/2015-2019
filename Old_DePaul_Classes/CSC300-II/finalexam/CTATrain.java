package finalexam;

// Logan Murray
// CSC300-601

public class CTATrain implements Comparable<CTATrain> {
	 
	private int runNumber;
	private String lineColor;
	private String nextStation;
	private String arrivalTime;
	
	public CTATrain(int runNum, String lineColor, String nextStation, String arrivalTime){
		this.runNumber = runNum;
		this.lineColor = lineColor;
		this.nextStation = nextStation;
		this.arrivalTime = arrivalTime;
			
		
	}
	
	public int getRunNum(){
		return this.runNumber;
	}
	
	public String getLineColor(){
		return this.lineColor;
	}
	
	public String getNextStation(){
		return this.nextStation;
	}
	
	public String getArrivalTime(){
		return this.arrivalTime;
	}
	
	public String toString(){
		String formatted = "["+this.lineColor+", "+this.runNumber+", "+this.nextStation+", "+this.arrivalTime+"]";
		return formatted;
	}

	
	public int compareTo(CTATrain that) {
		if(this.runNumber<that.runNumber){
			return -1;
		} else { 
			if(this.runNumber>that.runNumber){
				return 1;
			} else {
				return 0;
			}
			
			
		}
	}
	
	
}
