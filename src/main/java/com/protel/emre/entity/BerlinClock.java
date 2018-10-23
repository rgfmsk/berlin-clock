package com.protel.emre.entity;

/**
 * Entity for the webservice api of Berlin Clock Application
 *
 * @author Emre Ozdemir
 * @version 1.0
 * @since 2018-10-22
 */
public class BerlinClock {
    private String time;

    /**
     * Constructor for the BerlinClock entity object
     *
     * @param time sets the value of time
     */
    public BerlinClock(String time) {
        this.time = time;
    }

    /**
     * Getter method of BerlinClock object
     *
     * @return [String]
     */
    public String getTime() {
        return time;
    }

    /**
     * Setter method of BerlinClock object
     *
     * @param time Value to be set in objects value
     */
    public void setTime(String time) {
        this.time = time;
    }
}
