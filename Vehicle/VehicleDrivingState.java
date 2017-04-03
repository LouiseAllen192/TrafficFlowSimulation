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
    
    public void moveLane(int laneID, Vehicle v) {
		v.getLane().removeVehicle(v.getCurrentCell());
		v.setLane(laneID);
	}
}
