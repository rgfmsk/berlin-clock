package com.protel.emre.util;

import java.util.Calendar;
import java.util.Optional;

/**
 * Utility class for the webservice api of Berlin Clock Application
 *
 * @author Emre Ozdemir
 * @version 1.0
 * @since 2018-10-22
 */
public class ClockUtil {

    private final static String OFF = "O";
    private final static String RED = "R";
    private final static String YELLOW = "Y";
    private final static String NEW_LINE = System.getProperty("line.separator");
    private Calendar cal;

    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    /**
     * Constructor for the Utility Class, to perform conversion operation
     * <p>
     * initializes the attributes for this class from given time or the current time
     *
     * @param time Optional time parameter
     */
    public ClockUtil(Optional<String> time) {
        if (time.isPresent()) {
            try {
                String props[] = time.get().replaceAll("\"", "").split(":");
                this.hours = Integer.parseInt(props[0]);
                this.minutes = Integer.parseInt(props[1]);
                this.seconds = Integer.parseInt(props[2]);
            } catch (Exception e) {
                throw new IllegalArgumentException("Time format must be like : hh:mm:ss");
            }
        } else {
            cal = Calendar.getInstance();
            this.hours = cal.get(Calendar.HOUR_OF_DAY);
            this.minutes = cal.get(Calendar.MINUTE);
            this.seconds = cal.get(Calendar.SECOND);
        }
        this.validate();
    }

    /**
     * Validates the initialized attributes hours,minutes,seconds
     *
     * @throws IllegalArgumentException if any of the validations fail
     */
    public void validate() throws IllegalArgumentException {
        if (hours > 23 || hours < 0) throw new IllegalArgumentException("Hours must be between 00 <> 23");
        if (minutes > 59 || minutes < 0) throw new IllegalArgumentException("Minutes must be between 00 <> 59");
        if (seconds > 59 || seconds < 0) throw new IllegalArgumentException("Seconds must be between 00 <> 59");
    }

    /**
     * Fixes the Minutes in a BerlinClock since seconds must be in following format: YYRYYRYYRYY
     * <p>
     * R : Red Lamp
     * <p>
     * Y : Yellow Lamp
     * <p>
     * It helps to figure out the minutes at first look
     *
     * @param berlinFormat String representation of the time before fixing seconds
     * @return [String] fixed berlinClock Format
     */
    public String fixSecondsColors(String berlinFormat) {
        return berlinFormat.replaceAll("YYY", "YYR");
    }

    /**
     * String representation of the given time in BerlinClock format
     *
     * @return [String]
     */
    public String getBerlinFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append(writeLine((seconds % 2), 1, YELLOW, OFF));
        sb.append(writeLine((hours / 5), 4, RED, OFF));
        sb.append(writeLine((hours % 5), 4, RED, OFF));
        sb.append(writeLine((minutes / 5), 11, YELLOW, OFF));
        sb.append(writeLine((minutes % 5), 4, YELLOW, OFF));
        return sb.toString();
    }

    /**
     * Helper method for writing clock lines
     * <p>
     * Writes and concatenates the given String "ON" as much as count
     * Fills the remaining spaces with the given String "OFF"
     *
     * @param count lit lamp count
     * @param space all lamp count
     * @param ON    String representation for lit lamp
     * @param OFF   String representation for unlit lamp
     * @return [String]
     */
    private String writeLine(int count, int space, String ON, String OFF) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= space; i++) {
            if (i <= count) {
                sb.append(ON);
            } else {
                sb.append(OFF);
            }
        }
        sb.append(NEW_LINE);
        if (space == 11) {
            return fixSecondsColors(sb.toString());
        }
        return sb.toString();
    }
}
