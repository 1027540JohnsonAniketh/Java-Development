package edu.neu.csye6200.model;

public class ImmunizationRecord {
	
	private int hepatitisCount;
	private int polioCount;
        
	public ImmunizationRecord(){
		this.setHepatitisCount(0);
		this.setPolioCount(0);
	}
	
	public ImmunizationRecord(String csvData) {
		String csvArray[]=csvData.split(",");
		this.setHepatitisCount(Integer.parseInt(csvArray[3]));
		this.setPolioCount(Integer.parseInt(csvArray[4]));
	}

	public int getHepatitisCount() {

		return hepatitisCount;
	}

	public void setHepatitisCount(int hepatitisCount){
		this.hepatitisCount = hepatitisCount;
	}

	public int getPolioCount() {

		return polioCount;
	}

	public void setPolioCount(int polioCount) {

		this.polioCount = polioCount;
	}

	@Override
	public String toString(){
		return this.hepatitisCount + ","+ this.polioCount;
	}
}
