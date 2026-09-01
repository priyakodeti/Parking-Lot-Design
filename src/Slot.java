class Slot{
    Vehicle vehicle;
    VehicleType slotType;
    int slotNumber;
    public Slot(int slotNumber,VehicleType slotType)
    {
        this.slotNumber=slotNumber;
        this.slotType=slotType;
    }
    void parkVehicle(Vehicle vehicle)
    {
        this.vehicle=vehicle;
    }
    void removeVehicle(Vehicle vehicle)
    {
        this.vehicle=null;
    }
    boolean canVehicleFit(Vehicle vehicle)
    {
        if(isAvailable())
            return vehicle.getVehicleType().equals(slotType);
        return false;
    }
    boolean isAvailable()
    {
        return this.vehicle==null;
    }

}
