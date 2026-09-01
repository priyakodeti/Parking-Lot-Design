
class Calculator{
    Map<VehicleType,Double> rates;
    public Calculator()
    {
        rates=new HashMap<>();
        rates.put(VehicleType.bike,20.0);
        rates.put(VehicleType.car,40.0);
        rates.put(VehicleType.truck,60.0);

    }
    double calculatePayment(VehicleType vehicleType,LocalDateTime entryTime,LocalDateTime exitTime)
    {
        double duration= Duration.between(entryTime,exitTime).toMinutes();
        double hours=Math.ceil(duration/60.0);
        hours=Math.max(hours,1);
        return hours*rates.get(vehicleType);
    }
}
