package SDET_27;

import static org.junit.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDumy {

	@Test(retryAnalyzer = com.crm.autodesk.genericutility.RetryAnalyser.class)
	public void iRetryAnalyser() {
		System.out.println("Retry Analyzer");
		Assert.fail();
	}
}
