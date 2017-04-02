package SensoryPerception;

import Road.Lane;
public class Sight {

    public Sight() {

    }

	public boolean checkLane(Lane currentLane, int currentCell, int vehicleID, int cellsBehind, int cellsAhead) {
		int cell_count = currentLane.getNumCells();
		int i = currentCell - cellsBehind;
		int limit = Math.floorMod((currentCell+cellsAhead), cell_count);
		int otherCarID;
		boolean vehicleSpotted = false;
		
		while(i != limit && !vehicleSpotted) {
			otherCarID = currentLane.getCarAtCell(i);
			
			if((otherCarID != -1) && (otherCarID != vehicleID)) {
				vehicleSpotted = true;
				// System.out.println("Vehicle "+vehicleID+"spotted "+otherCarID);
			}
			i = Math.floorMod((i+1), cell_count);
		}
		return vehicleSpotted;
	}
}
