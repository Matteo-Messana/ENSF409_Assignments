import java.util.Scanner;

public class Clock 
{
	
	private int day;
	private int hour;
	private int minute;
	private int second;
	
	public Clock()
	{
		this(0,0,0,0);
	}
	
	public Clock(int day, int hour, int minute, int second)
	{
		setDay(day);
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	
	public void setDay(int day)
	{
		this.day = day;
	}
	
	public void setHour(int hour)
	{
		if(hour >= 0 && hour <= 23)
			this.hour = hour;
		else
		{
			System.err.println("Error: Time input is invalid");
			return;
		}
	}
	
	public void setMinute(int minute)
	{
		if(minute >= 0 && minute <= 59)
			this.minute = minute;
		else
		{
			System.err.println("Error: Time input is invalid");
			return;
		}
	}
	
	public void setSecond(int second)
	{
		if(second >= 0 && second <= 59)
			this.second = second;
		else
		{
			System.err.println("Error: Time input is invalid");
			return;
		}
	}
	
	public int getDay()
	{
		return this.day;
	}
	
	public int getHour()
	{
		return this.hour;
	}
	
	public int getMinute()
	{
		return this.minute;
	}
	
	public int getSecond()
	{
		return this.second;
	}	
	
	public void increment(int updateSeconds)
	{
		int seconds = getSecond();
		int minutes = getMinute();
		int hours = getHour();
		int days = getDay();
		
		seconds = seconds + updateSeconds;
		if(seconds >= 60)
		{
			seconds = seconds - 60;
			minutes++;
		}
		if(minutes >= 60)
		{
			minutes = minutes - 60;
			hours++;
		}
		if(hours >= 23)
		{
			hours = hours - 24;
			days++;
		}
		
		setSecond(seconds);
		setMinute(minutes);
		setHour(hours);
		setDay(days);
	}
	
	public int calculateTotalSeconds()
	{
		int seconds = getSecond();
		int minutes = getMinute();
		int hours = getHour();
		int days = getDay();
		
		minutes = minutes * 60;
		hours = hours * 3600;
		days = days * 86400;
		
		seconds = seconds + minutes + hours + days;
		return seconds;
		
	}
	
	
	public static void main(String[] args) 
	{
			// Create elapsed time with the default values of zeros for day, hour,
			// minute and second.
			Clock t1 = new Clock(); // Default constructor
			// sets hour to 23
			t1.setHour(23);
			// sets day to 1
			t1.setDay(1);
			// sets minute to 59
			t1.setMinute(59);
			// sets day to 16
			t1.setSecond(16);
			// prints: 1:23:59:16
			System.out.println(t1.getDay() + ":" + t1.getHour() +":" + t1.getMinute() + ":" + t1.getSecond());
			// increments time t1 by 44 seconds:
			t1.increment(44);
			// prints: 2:0:0:0
			System.out.println(t1.getDay() + ":" + t1.getHour() +":" +t1.getMinute() + ":" + t1.getSecond());
			// prints the total elapsed time in seconds: 172,800
			System.out.printf("The elapsed time in seconds is: %d\n", t1.calculateTotalSeconds());
			// REPEAT SIMILAR TESTS FOR t2
			//Elapsed time is 3 days, 1 hour, 4 mins and 5 secs
			Clock t2 = new Clock(3, 1, 4, 5);
			
			t2.increment(600);
			System.out.println(t2.getDay() + ":" + t2.getHour() +":" +t2.getMinute() + ":" + t2.getSecond());
			
			System.out.printf("The elapsed time in seconds is: %d", t2.calculateTotalSeconds());
			
			
	}
}
