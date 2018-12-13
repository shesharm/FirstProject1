package com.pge.hybrid.testcases.facebooksuite;

import java.io.File;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pge.hybrid.base.BaseTest;
import com.pge.hybrid.util.Constants;
import com.pge.hybrid.util.DataUtil;

public class FacebookTest extends BaseTest{

	@Test(dataProvider="getData")
	public void facebookLogin(Hashtable <String,String> data ) throws Exception {
		test.log(Status.INFO, "Starting "+ testName);
		System.out.println("Test 1");
		System.out.println(System.getProperty("USERNAME"));
		if(DataUtil.isSkip(testName, xls) ||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO)){
			test.log(Status.SKIP, "Runmode is set to NO");
			throw new SkipException("Runmode is set to NO");
		}		
	    ds.executeKeywords(testName, xls, data);
	}
	
	@Test(dataProvider="getData")
	public void AppScanSite(Hashtable <String,String> data ) throws Exception {
		test.log(Status.INFO, "Starting "+ testName);

		File file = new File("C:\\test\\test.txt");
		file.createNewFile();
		if(DataUtil.isSkip(testName, xls) ||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO)){
			test.log(Status.SKIP, "Runmode is set to NO");
			throw new SkipException("Runmode is set to NO");
		}		
	    ds.executeKeywords(testName, xls, data);
	}
}
