// Cianee Sumowalt
// Feburary 17 2023
// Keep Track of Time
import java.util.Scanner;
import java.lang.Math;

public class Time {
    private int seconds, minutes, hours, days;
    public Time(int seconds, int minutes, int hours, int days) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.days = days;
        reduceTime();
    }

    public void addTime(Time other) {
        this.seconds += other.seconds;
        this.minutes += other.minutes;
        this.hours += other.hours;
        this.days += other.days;
        reduceTime();
    }

    public void minusTime(Time other) {
        this.seconds -= other.seconds;
        this.minutes -= other.minutes;
        this.hours -= other.hours;
        this.days -= other.days;
        reduceTime();
    }

    private void reduceTime() {
        int r = 0;
        if (seconds >= 60) {
            r = seconds / 60;
            seconds %= 60;
        } else if (seconds < 0) {
            r = seconds / 60 - 1;
            seconds = 60 + seconds % 60;
        }
    
        minutes += r;
        r = 0;
        if (minutes >= 60) {
            r = minutes / 60;
            minutes %= 60;
        } else if (minutes < 0) {
            r = minutes / 60 - 1;
            minutes = 60 + minutes % 60;
        }
    // there was an issue where certain numbers wouldn't carry over. The function got changed so it accounted for negative numbers
        hours += r;
        r = 0;
        if (hours >= 24) {
            r = hours / 24;
            hours %= 24;
        } else if (hours < 0) {
            r = hours / 24 - 1;
            hours = 24 + hours % 24;
        }
    
        days += r;
    }

    public String toString() {
        return Math.abs(seconds) + " seconds " + Math.abs(minutes) + " minutes " + Math.abs(hours) + " hours " + Math.abs(days) + " days";
    } // so no value is negative

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int seconds1 = in.nextInt();
        int minutes1 = in.nextInt();
        int hours1 = in.nextInt();
        int days1 = in.nextInt();

        char operator = in.next().charAt(0);
        
        int seconds2 = in.nextInt();
        int minutes2 = in.nextInt();
        int hours2 = in.nextInt();
        int days2 = in.nextInt();
        in.close();

        Time time1 = new Time(seconds1, minutes1, hours1, days1); // creates the items we are adding or subtracting
        Time time2 = new Time(seconds2, minutes2, hours2, days2);

        if (operator == '+'){
            time1.addTime(time2);
            System.out.println(time1.toString());
        }
        if (operator == '-'){ // doesn't account for incorrect inputs
            time1.minusTime(time2);
            System.out.println(time1.toString());
        }
    }
}
