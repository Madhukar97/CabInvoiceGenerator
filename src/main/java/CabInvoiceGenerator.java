public class CabInvoiceGenerator {

    final int COST_PER_KM = 10;
    final int COST_PER_MIN = 1;
    final int MIN_FARE = 5;

    final int COST_PER_KM_PREMIUM = 15;
    final int COST_PER_MIN_PREMIUM = 2;
    final int MIN_FARE_PREMIUM = 20;

    enum RideType{
        NORMAL_RIDE,
        PREMIUM_RIDE
    }

    public static void main(String[] args) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        System.out.println(cabInvoiceGenerator.calculateFare(5, 20, RideType.NORMAL_RIDE) + " Rs");
        Ride[] ridesArray = {
                new Ride("1",2, 5, RideType.PREMIUM_RIDE),
                new Ride("2",3, 5, RideType.PREMIUM_RIDE),
                new Ride("1",1, 1, RideType.PREMIUM_RIDE)
        };
        cabInvoiceGenerator.listOfRidesOfUniqueUserId( ridesArray,"1");
    }

    public double calculateFare(double distance, double time, RideType type) {
        if (type == RideType.NORMAL_RIDE) {
            double fare = COST_PER_KM * distance + COST_PER_MIN * time;
            if (fare > MIN_FARE) return fare;
            else return MIN_FARE;
        }else {
            double fare = COST_PER_KM_PREMIUM * distance + COST_PER_MIN_PREMIUM * time;
            if (fare > MIN_FARE_PREMIUM) return fare;
            else return MIN_FARE_PREMIUM;
        }
    }

    public double calculateFareForMultipleRides(Ride[] ridesArray) {
        double totalFare = 0;
        for (Ride ride : ridesArray) {
            totalFare += calculateFare(ride.distance, ride.time, ride.rideType);
        }
        return totalFare;
    }

    public InvoiceSummary invoiceSummaryCalculation(Ride[] ridesArray) {
        double totalFare = 0;
        for (Ride ride : ridesArray) {
            totalFare += this.calculateFare(ride.distance, ride.time, ride.rideType);
        }
        return new InvoiceSummary(ridesArray.length, totalFare);
    }

    public InvoiceSummary listOfRidesOfUniqueUserId(Ride[] ridesArray, String userID) {
        double totalFare = 0;
        int userRideCount=0;
        for (Ride ride : ridesArray){
            if (ride.getUserID().equals(userID)){
                totalFare+= this.calculateFare(ride.distance,ride.time, ride.rideType);
                userRideCount++;
            }
        }
        System.out.println(totalFare+" count = "+userRideCount);
        return new InvoiceSummary(userRideCount,totalFare);
    }
}

