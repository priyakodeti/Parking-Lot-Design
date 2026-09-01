
class Ticket{
    int ticketNumber;
    Vehicle vehicle;
    LocalDateTime entryTime,exitTime;
    Slot slot;
    boolean paymentStatus;
    public Ticket(int ticketnumber,Slot s,Vehicle vehicle,LocalDateTime entryTime)
    {
        ticketNumber=ticketnumber;
        slot=s;
        this.vehicle=vehicle;
        this.entryTime=entryTime;
    }
}
