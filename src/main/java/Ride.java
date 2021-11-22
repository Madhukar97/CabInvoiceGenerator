public class Ride {
    int distance;
    int time;
    String userID;
    CabInvoiceGenerator.RideType rideType;

    public Ride(String userID, int distance, int time, CabInvoiceGenerator.RideType variable) {
        this.userID = userID;
        this.distance = distance;
        this.time = time;
        this.rideType = variable;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
