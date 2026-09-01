class ParkingFloor{
    String floorNumber;
    List<Slot> slots;
    public ParkingFloor(String fn){
        floorNumber=fn;
        slots=new ArrayList<>();
    }
    void createSlot(Slot slot)
    {
        slots.add(slot);
    }
    int getAvailableSlotCount(){
        int cnt=0;
        for(Slot slot:slots)
        {
            if(slot.isAvailable())cnt++;
        }
        return cnt;
    }
    Slot findSlot(Vehicle vehicle)
    {
        for(Slot slot:slots)
        {
            if(slot.canVehicleFit(vehicle))
                return slot;
        }
        return null;
    }

}
