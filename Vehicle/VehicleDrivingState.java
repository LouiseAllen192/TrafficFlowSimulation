package Vehicle;

import Road.*;

public class VehicleDrivingState implements I_VehicleState{

    public void accelerate(int speedModifier, Vehicle v, Lane l) {
        v.incrementCellID(speedModifier);
        v.updatePosition(l.getPosition(v.getCurrentCellID()));
        v.updateAngle(l.getCarAngle(v.getCurrentCellID()));
    }

    public VehicleStatesEnum getState() {
        return VehicleStatesEnum.DRIVING;
    }           
    
    public void changeLane(int laneID, Vehicle v) {
    	v.getLane().removeFromCell(v.getCurrentCell());
		v.setLane(laneID);
		v.updatePosition(v.getLane().getPosition(v.getCurrentCell()));
		v.getLane().addToOccupiedCells(v.getCurrentCell(), v.getID());
	}
}
