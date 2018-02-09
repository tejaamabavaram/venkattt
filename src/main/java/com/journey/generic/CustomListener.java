package com.journey.generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener,InterfaceConstants {

	@Override
	public void onTestStart(ITestResult result) {
		
		
		System.out.println("The name of the testcase Started is :"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		try{
			Robot r=new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();			
			Rectangle screenRect=new Rectangle(d);
			BufferedImage img = r.createScreenCapture(screenRect);
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			String now = s.format(new Date());
			ImageIO.write(img, "png",new File(PHOTOPATH_SUCESS+testName+now+".png"));
		   }
		 catch(Exception e){
			}
		System.out.println("The name of the testcase Sucess is :"+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	String testName = result.getName();
	try{
		Robot r=new Robot();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();			
		Rectangle screenRect=new Rectangle(d);
		BufferedImage img = r.createScreenCapture(screenRect);
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String now = s.format(new Date());
		ImageIO.write(img, "png",new File(PHOTOPATH_FAIL+testName+now+".png"));
		 System.out.println("The name of the testcase failed is :"+result.getName());
	   }
	 catch(Exception e){
		}
	}

	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		try{
			Robot r=new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();			
			Rectangle screenRect=new Rectangle(d);
			BufferedImage img = r.createScreenCapture(screenRect);
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			String now = s.format(new Date());
			ImageIO.write(img, "png",new File(PHOTOPATH_SKIP+testName+now+".png"));
			 System.out.println("The name of the testcase Skipped is :"+result.getName());
		   }
		 catch(Exception e){
			}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
