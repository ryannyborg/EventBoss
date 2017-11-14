package org.system.event;

public class Time{

	int month;
	int day;
	int year;
	int hour;
	String minute;
	String timeConvention;
	String convertedDate;
	String convertedTime;
	
	//constructors
	public Time() {
		this.month = -1;
		this.day = -1;
		this.year = -1;
		this.hour = -1;
		this.minute = "-1";
		this.timeConvention = "N/A";
	}
	
	public Time(int month, int day, int year, int hour, String minute, String timeConvention) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.timeConvention = timeConvention;
		convertedDate = dateToString(this.month, this.day, this.year);
		convertedTime = timeToString(this.hour, this.minute, this.timeConvention);
	}

	//getters and setters
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public String getMinute() {
		return minute;
	}
	public void setMinute(String minute) {
		this.minute = minute;
	}
	public String getTimeConvention(){
		return timeConvention;
	}
	public void setTimeConvention(String timeConvention){
		this.timeConvention = timeConvention;
	}
	public String timeString(){
		String x;
		x = this.month + "/" + this.day + "/" + this.year + " " + this.hour 
				+ ":" + this.minute + " " + timeConvention;
		return x;
	}
	
	public String dateToString(int MM, int DD, int YYYY){
		String x;
		x = MM + "/" + DD + "/" + YYYY;
		return x;
	}
	
	public String timeToString(int hour, String minute, String timeConvention){
		String x;
		x = hour + ":" + minute + " " + timeConvention;
		return x;	
	}
	
	
}
