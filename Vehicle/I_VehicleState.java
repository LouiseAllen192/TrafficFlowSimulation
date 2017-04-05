package Vehicle;

import Road.Lane;

public interface I_VehicleState {
    void accelerate(int speedModifier, Vehicle v, Lane l);
    VehicleStatesEnum getState();
    void changeLane(int laneID, Vehicle v);
}
