package SensoryPerception;

import java.util.ArrayList;
import java.util.HashMap;

import Road.Lane;
import Road.Road;
import Threading.Lock;
import Threading.UnknownLockException;

public class Sight {

	/*
	 * Sight should be able to return to a Driver what is in front of them.
	 * It should be global and just know about lanes.
	 * Should take in current_cell and current_lane and return info about cells_around. 
	 */
	
	ArrayList<Lane> lanes;
	
	public Sight(Road road) {
		this.lanes = road.getLanes();
	}
	
	public HashMap<Integer, Integer> getRoadInformation(int lane, int cell, int vehicleID) {
		HashMap <Integer, Integer> roadInfo = new HashMap<>();
		try {
			if (Lock.getInstance().hasLock("lanes")) {
				Object lock = Lock.getInstance().getLock("lanes");
				synchronized(lock) {
					Lane l;
					int lim = cell + 100;
					for (int i = 0; i < this.lanes.size(); i++) {
						roadInfo.put(i, -100);
						l = this.lanes.get(i);
						HashMap<Integer, Integer> oc = l.getOccupiedCells();
						for (int j = (cell-50); j < lim; j++) {
							if (oc.containsKey(Math.floorMod(j, 1000))) {
								if(oc.get(Math.floorMod(j, 1000)) != vehicleID && (i != lane || (100 - (lim - j)) > 0)) { //we don't care what's behind us in our currentLane
									roadInfo.put(i, 100 - (lim - j));
									break;
								}
							}
						}
					}
				}
			} else {
				System.err.println("Lock doesn't exist - lanes!");
			}
		} catch (UnknownLockException e) {
			System.err.println(e.getMessage());
		}
		return roadInfo;
	}	
}
