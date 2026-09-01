
public class ParkingLotDesign {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ParkingLot parkingLot=new ParkingLot();

        ParkingFloor floor1=new ParkingFloor("f1");
        ParkingFloor floor2=new ParkingFloor("f2");
        ParkingFloor floor3=new ParkingFloor("f3");
        floor1.createSlot(new Slot(1,VehicleType.bike));
        floor1.createSlot(new Slot(2,VehicleType.car));
        floor1.createSlot(new Slot(3,VehicleType.truck));
        floor2.createSlot(new Slot(1,VehicleType.car));
        floor2.createSlot(new Slot(2,VehicleType.bike));
        floor2.createSlot(new Slot(3,VehicleType.truck));
        floor3.createSlot(new Slot(1,VehicleType.bike));
        floor3.createSlot(new Slot(2,VehicleType.car));
        floor3.createSlot(new Slot(3,VehicleType.truck));
        parkingLot.floors.add(floor1);
        parkingLot.floors.add(floor2);
        parkingLot.floors.add(floor3);
        while(true)
        {
            System.out.println("Enter your choice");
            System.out.println("1. Vehicle enters");
            System.out.println("2. Vehicle exits");
            System.out.println("3. Display Available slots for each floor");
            System.out.println("4. Stop");
            int ch=sc.nextInt();
            switch(ch){
                case 1: System.out.println("Enter vehicle details {number and vehicle type}");
                        String vehicleNumber=sc.next();
                        VehicleType vtype=VehicleType.valueOf(sc.next());
                        Vehicle vehicle=new Vehicle(vehicleNumber,vtype);
                        Ticket t=parkingLot.findSlot(vehicle);
                        if(t!=null)
                        {
                            System.out.println("Ticket generated successfully.....");
                            System.out.println("Ticket number :"+t.ticketNumber);
                            break;
                        }
                        else
                        {
                            System.out.println("No suitable slot available.....");
                            break;
                        }
                case 2: System.out.println("Enter ticket number");
                        int tnumb=sc.nextInt();
                        Ticket ticket=parkingLot.getActiveTickets(tnumb);
                        if(ticket!=null)
                        {
                            parkingLot.vehicleExit(ticket);
                            System.out.println("Vehicle left the parking lot");
                            break;
                        }
                        else{
                            System.out.println("No ticket with given number available");
                            break;
                        }

                case 3: System.out.println(
                        "Floor 1 available slots: "
                                + floor1.getAvailableSlotCount());

                    System.out.println(
                            "Floor 2 available slots: "
                                    + floor2.getAvailableSlotCount()
                    );

                    break;
                case 4: System.exit(0);

            }
        }

    }
}
