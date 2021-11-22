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
        Assert.assertEquals(70, fare.calculateFare(5, 20, CabInvoiceGenerator.RideType.NORMAL_RIDE), 0.000);
    }

    @Test
    public void whenGivenMultipleFaresShouldReturnAggregateTotalFare() {
        Ride[] ridesArray = {new Ride("1",2, 20, CabInvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride("1",4, 10, CabInvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride("2",10, 30, CabInvoiceGenerator.RideType.NORMAL_RIDE)};
        Assert.assertEquals(220, fare.calculateFareForMultipleRides(ridesArray), 0.0);
    }

    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride("1",2, 5, CabInvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride("2",3, 5, CabInvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride("1",1, 1, CabInvoiceGenerator.RideType.NORMAL_RIDE)
        };
        InvoiceSummary invoiceSummary = fare.invoiceSummaryCalculation(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 71);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdDistanceAndTimeShouldReturnInvoiceOfUser() {
        Ride[] rides = {
                new Ride("1",2, 5, CabInvoiceGenerator.RideType.PREMIUM_RIDE),
                new Ride("2",3, 5, CabInvoiceGenerator.RideType.PREMIUM_RIDE),
                new Ride("2",1, 1, CabInvoiceGenerator.RideType.PREMIUM_RIDE)
        };
        InvoiceSummary invoiceSummary = fare.listOfRidesOfUniqueUserId(rides,"2");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 75);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}
