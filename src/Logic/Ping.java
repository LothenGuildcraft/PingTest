package Logic;

import java.net.*;

public class Ping {

    private long time;
    private int code;
    private URL url;

    /**
     * Initializes the Ping class to test a given URL string
     * 
     * @param url The URL as a string for any website. If no protocol is specified, HTTP will be the default
     */
    public Ping(String url) {
        if(!url.contains("http")) {
            url = "http://" + url;
        }

        try{
            this.url = new URL(url);
        } catch(Exception e) {
            this.url = null;
        }

        this.time = 0;
        this.code = 0;
    }

    /**
     * Creates a connection with the given URL. 
     * <p>
     * Records the system time when the connection starts and records the system time when the connection ends.
     * </p><p>
     * Sets the values of time to the end time minus the start time.
     * </p><p>
     * Sets the value of code to the HTTP response code from the webpage.
     * </p>
     */
    public void testURL() {
        try{
            HttpURLConnection urlConn = (HttpURLConnection) this.url.openConnection();
            long startTime = System.currentTimeMillis();
            urlConn.connect();
            long endTime = System.currentTimeMillis();

            this.code = urlConn.getResponseCode();
            this.time = endTime - startTime;
        } catch(Exception e) {
        }
    }

    /**
     * 
     * @return The time it took to test the provided URL
     */
    public long getTime() {
        return this.time;
    }

    /**
     * 
     * @return The HTTP Response Code for the providede URL
     */
    public int getCode() {
        return this.code;
    }
    
}
