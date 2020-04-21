package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Testing1 extends BaseClass {

  	@Test 
  		public void SampleTest()
  			{
  		ExtentTest test=extent.createTest("Test one","Sample Description");
  		test.log(Status.INFO,"Test one Started");
  		System.out.println("Test Method");
  		System.out.println("Complete testing");
  		test.log(Status.PASS,"Test one Started");


  					}
  // Set job name



}
