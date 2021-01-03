package edu.neu.csye6200.model;

public class Regulations {

	private final int minAge;
	private final int maxAge;
	private final int groupSize;
	private final String ratio;
	private final int maxGroupPerRoom;
	
	public Regulations(String csvData) {
		String[] s = csvData.split(",");
		minAge = Integer.parseInt(s[0].split("-")[0]);
		maxAge = Integer.parseInt(s[0].split("-")[1]);

		groupSize = Integer.parseInt(s[1]);
		ratio = s[2];
		maxGroupPerRoom = Integer.parseInt(s[3]);
	}

	public int getGroupSize() {

		return groupSize;
	}

	public String getRatio() {

		return ratio;
	}

	public int getMaxGroupPerRoom() {

		return maxGroupPerRoom;
	}

	public int getMinAge() {

		return minAge;
	}

	public int getMaxAge() {

		return maxAge;
	}
	
	@Override
	public String toString() {

		return minAge + "-" + maxAge + "," + groupSize + "," + ratio + "," + maxGroupPerRoom+"||";
	}

}
