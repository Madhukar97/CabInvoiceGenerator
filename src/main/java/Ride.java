public class Ride {
    int distance;
    int time;
    String userID;

    public Ride(String userID, int distance, int time) {
        this.userID = userID;
        this.distance = distance;
        this.time = time;
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
