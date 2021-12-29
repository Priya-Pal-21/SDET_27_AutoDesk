package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;
/**
 * @author Priya Pal
 */
public class JavaUtility {
	/*
	 * It is use to generate random number
	 * @return int data
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		int randomNum = ran.nextInt(100);
		return randomNum;	
	}
	/*
	 * It is used to get system date and time in IST format
	 * @return String
	 */
	public String getSystemDateAndTime() {
		Date date=new Date();
		return date.toString();
	}
	/*
	 *It is used to get system date in YYYY-MM-DD format
	 * @return String 
	 */
	public String getSystemDateWithFormat() {
		Date date=new Date();
        String dateAndTime = date.toString();
        String yyyy = dateAndTime.split(" ")[5];
        String dd = dateAndTime.split(" ")[2];
        int mm = date.getMonth()+1; //Deprecate
        String finalFormat = yyyy+"-"+mm+"-"+dd;
        System.out.println(finalFormat);
		return finalFormat;     
	}
		
}
