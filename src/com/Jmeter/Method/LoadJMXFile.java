/**
 * @author 			:	 Sumit Kumar
 *	DATE       		:	 01-Jul-2020
 *  FILE NAME  		: 	 LoadJMXFile.java
 *  PROJECT NAME 	:	 JmeterRead
 * 	Class Time		:    5:03:38 pm
 */
package com.Jmeter.Method;

import java.io.File;
import java.io.FileInputStream;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

public class LoadJMXFile 
{
	public static void readJMXFile(String jmeterHomelocation, String jmeterPropertieslocation, String jmxFileLocation ) throws Exception {  
		   
	     //Set jmeter home for the jmeter utils to load  
	   //  String jmeterHomelocation = "F:\\apache-jmeter-5.2.1\\";  
	   //  String jmeterPropertieslocation = jmeterHomelocation + "bin\\jmeter.properties";  
	   
	     // JMeter Engine  
	     StandardJMeterEngine jmeter = new StandardJMeterEngine();  
	   
	   
	     // Initialize Properties, logging, locale, etc.  
	     JMeterUtils.loadJMeterProperties(new File(jmeterPropertieslocation).getPath());  
	     JMeterUtils.setJMeterHome(new File(jmeterHomelocation).getPath());  
	     // you can comment this line out to see extra log messages of i.e. DEBUG level  
	     JMeterUtils.initLogging();  
	     JMeterUtils.initLocale();  
	   
	     // Initialize JMeter SaveService  
	     SaveService.loadProperties();  
	   
	     // Load existing .jmx Test Plan  
	    File jmxFilePath = new File(jmxFileLocation);
	     HashTree testPlanTree = SaveService.loadTree(jmxFilePath);
	     
	             
	     Summariser summer = null;  
	     String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");  
	   
	     if (summariserName.length() > 0) {  
	       summer = new Summariser(summariserName);  
	     }  
	   
	     ResultCollector logger = new ResultCollector(summer);  
	     testPlanTree.add(testPlanTree.getArray()[0], logger);  
	   
	     // Run JMeter Test  
	     jmeter.configure(testPlanTree);  
	     jmeter.run();  
	   }  

}
