class ParkingLot{
    List<ParkingFloor> floors;
    List<Ticket> activeTickets;
    Calculator c;
    PaymentGateway paymentGateway;
    int nextTicketNumber=1;
    ParkingLot(){
        floors=new ArrayList<>();
        activeTickets=new ArrayList<>();
        c=new Calculator();
        paymentGateway=new PaymentGateway();
    }
    Ticket findSlot(Vehicle vehicle)
    {
        for(ParkingFloor floor:floors){
            Slot s=floor.findSlot(vehicle);
            if(s!=null)
            {
                Ticket t=new Ticket(nextTicketNumber++,s,vehicle, LocalDateTime.now());

                s.parkVehicle(vehicle);
                activeTickets.add(t);
                return t;
            }

        }
        return null;
    }
    void vehicleExit(Ticket t){
        double amount=c.calculatePayment(t.vehicle.vehicleType,t.entryTime,LocalDateTime.now());
        System.out.println("Amount "+amount);
        boolean success=paymentGateway.processSuccess(amount);
        if(success)
        {
            System.out.println(t.vehicle.vehicleType+" vehicle leaved");
            System.out.println("payment successful.....");
            t.paymentStatus=true;
            t.slot.removeVehicle(t.vehicle);
            activeTickets.remove(t);
        }

    }

    public Ticket getActiveTickets(int tnumb) {
        for(Ticket t:activeTickets)
        {
            if(t.ticketNumber==tnumb)
                return t;
        }
        return null;
    }
}
