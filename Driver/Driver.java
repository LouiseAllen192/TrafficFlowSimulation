package Driver;

import SensoryPerception.Hearing;
import SensoryPerception.Sight;
import Vehicle.Vehicle;

public class Driver {
    
    private Hearing driverHearing;
    private Sight driverSight;
    private Vehicle driverVehicle;
    private String name;
    private int age;
    private String sex;
    private boolean hasCrashed;
    
    public Driver()
    {
        driverHearing = new Hearing();
        driverSight = new Sight();
        //driverVehicle = new Vehicle();
        name = "default";
        age = 12;
        sex = "Male";
        hasCrashed = false;
    }

    public Driver(Hearing driverHearing, Sight driverSight, Vehicle driverVehicle, String name, int age, String sex, boolean hasCrashed)
    {
        this.driverHearing = driverHearing;
        this.driverSight = driverSight;
        this.driverVehicle = driverVehicle;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hasCrashed = hasCrashed;
    }
    
    public Hearing getDriverHearing()
    {
        return driverHearing;
    }

    public void setDriverHearing(Hearing driverHearing)
    {
        this.driverHearing = driverHearing;
    }

    public Sight getDriverSight()
    {
        return driverSight;
    }

    public void setDriverSight(Sight driverSight)
    {
        this.driverSight = driverSight;
    }

    public Vehicle getDriverVehicle()
    {
        return driverVehicle;
    }

    public void setDriverVehicle(Vehicle driverVehicle)
    {
        this.driverVehicle = driverVehicle;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public boolean hasCrashed()
    {
        return hasCrashed;
    }

    public void setHasCrashed(boolean hasCrashed)
    {
        this.hasCrashed = hasCrashed;
    }
    
    public void Overtake()
    {
        //We don't know how this will work yet
    }
    
    public void Stop()
    {
        //driverVehicle.setCurrentSpeed(0);
    }
    
    public void Drive()
    {
        //Is drive going to be continuously called or a constantly looping while-loop?
        /*boolean vehicleAhead = driverSight.lookForVehicles();
        if(vehicleAhead)
            driverVehicle.decellerate();
        else
            driverVehicle.accellerate();
        
        driverVehicle.updateCurrentCell(); //is this called from here or accelerate/decellerate?
        
        graphics.updatePosition(driverVehicle);*/
    }
}
