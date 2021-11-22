import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator fare;

    @Before
    public void setUp() throws Exception {
        fare = new CabInvoiceGenerator();
    }

    @Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
        Assert.assertEquals(70, fare.calculateFare(5, 20), 0.000);
    }

    @Test
    public void whenGivenMultipleFaresShouldReturnAggregateTotalFare() {
        Ride[] ridesArray = {new Ride(2, 20),
                new Ride(4, 10),
                new Ride(10, 30)};
        Assert.assertEquals(220, fare.calculateFareForMultipleRides(ridesArray), 0.0);
    }

    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2, 5),
                new Ride(3, 5),
                new Ride(1, 1)
        };
        InvoiceSummary invoiceSummary = fare.invoiceSummaryCalculation(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 71);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}