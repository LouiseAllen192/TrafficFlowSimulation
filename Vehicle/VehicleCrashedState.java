package Vehicle;

import Road.Lane;

public class VehicleCrashedState implements I_VehicleState {

    public void accelerate(int speedModifier, Vehicle v, Lane l) {
        //Will not accelerate when Crashed
    }

    public VehicleStatesEnum getState() {
        return VehicleStatesEnum.CRASHED;
    }
    
    public void changeLane(int laneID, Vehicle v) {
        //Will not change lane when Crashed
	}
}
