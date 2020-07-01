/**
 * @author 			:	 Sumit Kumar Chaudhary
 *	DATE       		:	 01-Jul-2020
 *  FILE NAME  		: 	 GetTestJMXFileResult.java
 *  PROJECT NAME 	:	 JmeterRead
 * 	Class Time		:    5:52:08 pm
 */
package com.Jmeter.API;

import com.Jmeter.Method.LoadJMXFile;

public class GetTestJMXFileResult 
{
	public static void main(String[] args) throws Exception {
		
		LoadJMXFile.readJMXFile("F:\\apache-jmeter-5.2.1\\", "F:\\apache-jmeter-5.2.1\\bin\\jmeter.properties", "C:\\Users\\Neelam-Sonu\\Desktop\\Thread Group.jmx");
	}

}
