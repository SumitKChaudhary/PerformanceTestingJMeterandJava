/**
 * @author 			:	 Sumit Kumar
 *	DATE       		:	 30-Jul-2020
 *  FILE NAME  		: 	 CompleteNongraphicaljplan.java
 *  PROJECT NAME 	:	 JmeterRead
 * 	Class Time		:    4:29:59 pm
 */
package com.Jmeter.API;

import com.Jmeter.Method.PerformanceTestGeneratJMXandReport;  
   
 public class CompleteNongraphicaljplan {  
   
	 public static void main(String[] argv) throws Exception {  
   
     
		 PerformanceTestGeneratJMXandReport.
		 performanceGenerateTestReport(
				 "F:\\apache-jmeter-5.2.1", 							/*Provide JMeter installed directory*/
				 "F:\\apache-jmeter-5.2.1\\bin\\jmeter.properties",		/*Provide jmeter properties which is under bin folder*/
				 "127.0.0.1",											/*Port number --I have giving my local */
				 "Simple_Json",											/*URL path*/
				 "GET",				 									/*Method which we want to perform*/
				 "SampleTest",											/*Name which want to generate in the report*/
				 "APILoadTestPlan", 									/*Name of the JMX file*/
				 "JTLTestReportFile",									/*Name of JTL report file*/
				 "CSVTestReport");										/*Name of CSV file*/
   }  
 }  