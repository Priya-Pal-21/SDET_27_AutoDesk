package SDET_27;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeSetTest {

	@Test(dataProvider="getData")
	public void readTheDataFromDataProvider(String mobileName,int qty) {
		System.out.println("==Mobile Name==>>"+mobileName+"==Quantity==>>"+qty);
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		
		objArr[0][0]="IPhone";
		objArr[0][1]=10;
		
		objArr[1][0]="Samsung";
		objArr[1][1]=20;
		
		objArr[2][0]="RedMI";
		objArr[2][1]=30;
		
		return objArr;	
	}
	
	
	
	
	
	
	
	
}
