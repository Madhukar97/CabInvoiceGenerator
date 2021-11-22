public class CabInvoiceGenerator {

    final int COST_PER_KM = 10;
    final int COST_PER_MIN = 1;
    final int MIN_FARE = 5;

    public static void main(String[] args) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        System.out.println(cabInvoiceGenerator.calculateFare(5, 20) + " Rs");
    }

    public double calculateFare(double distance, double time) {
        double fare = COST_PER_KM * distance + COST_PER_MIN * time;
        if (fare > MIN_FARE) return fare;
        else return MIN_FARE;
    }
}

