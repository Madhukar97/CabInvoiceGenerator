import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
        CabInvoiceGenerator fare = new CabInvoiceGenerator();
        Assert.assertEquals(70, fare.calculateFare(5, 20), 0.000);
    }

    @Test
    public void whenGivenMultipleFaresShouldReturnAggregateTotalFare() {
        CabInvoiceGenerator obj = new CabInvoiceGenerator();
        Ride[] ridesArray = { new Ride(2 , 20),
                new Ride(4,10),
                new Ride(10 , 30) };
        Assert.assertEquals(220,obj.calculateFareForMultipleRides(ridesArray), 0.0);
    }
}