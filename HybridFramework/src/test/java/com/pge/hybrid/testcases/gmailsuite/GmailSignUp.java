package com.pge.hybrid.testcases.gmailsuite;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pge.hybrid.base.BaseTest;
import com.pge.hybrid.util.Constants;
import com.pge.hybrid.util.DataUtil;

public class GmailSignUp extends BaseTest{

	@Test(dataProvider="getData")
	public void GmailSignUp(Hashtable <String,String> data ) throws Exception {
		test.log(Status.INFO, "Starting "+ testName);

		if(DataUtil.isSkip(testName, xls) ||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO)){
			test.log(Status.SKIP, "Runmode is set to NO");
			throw new SkipException("Runmode is set to NO");
		}		
	    ds.executeKeywords(testName, xls, data);
		}
}
