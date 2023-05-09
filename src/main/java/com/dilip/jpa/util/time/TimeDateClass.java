package com.dilip.jpa.util.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeDateClass {
	
	public static String epochSecondsNow() {
		return Long.toString(Instant.now().getEpochSecond());
	}
	
	public static String epochSecondsMillisNow() {
		return Long.toString(Instant.now().toEpochMilli());
	}
	
	public static LocalDateTime getLocalDateTime() {
		
		Instant instant = new Date().toInstant();
		System.out.println("Zone Id: "+ ZoneId.systemDefault());
		return LocalDateTime.ofInstant(instant,  ZoneId.systemDefault());
	}
	
	public static String thisSec() {
		LocalTime thisSec = LocalTime.now();
		return ("Hour: "+thisSec.getHour()
					+ " Minute: "+ thisSec.getMinute()
					+ " Second: "+ thisSec.getSecond())
					+ " NanoSec : "+ thisSec.getNano();
	}
	
	public static String getNow() {
		Instant  instant = Instant.now();
		return instant.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("Epoch seconds now: "+ Instant.now().toEpochMilli());
		System.out.println("LocalDateTime: "+ getLocalDateTime());
		System.out.println(thisSec());
		System.out.println(getNow());
	}
}
