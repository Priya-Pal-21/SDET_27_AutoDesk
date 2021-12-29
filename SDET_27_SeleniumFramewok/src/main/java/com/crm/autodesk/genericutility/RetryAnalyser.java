package com.crm.autodesk.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer
{
	int count=1;
	int retryCount=4;
	public boolean retry(ITestResult result) {
		while(count<=retryCount) 
		{
			count++;
			return true;
		}		
		return false;
	}   
}
