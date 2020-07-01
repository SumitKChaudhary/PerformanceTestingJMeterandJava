package com.Jmeter.API;
import java.io.File;  
 import java.io.FileOutputStream;

import org.apache.commons.net.util.ListenerList;
import org.apache.jmeter.config.Arguments;  
 import org.apache.jmeter.config.gui.ArgumentsPanel;  
 import org.apache.jmeter.control.LoopController;  
 import org.apache.jmeter.control.gui.LoopControlPanel;  
 import org.apache.jmeter.control.gui.TestPlanGui;  
 import org.apache.jmeter.engine.StandardJMeterEngine;  
 import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.protocol.http.util.HTTPResultConverter;
import org.apache.jmeter.reporters.ResultCollector;  
 import org.apache.jmeter.reporters.Summariser;  
 import org.apache.jmeter.save.SaveService;  
 import org.apache.jmeter.testelement.TestElement;  
 import org.apache.jmeter.testelement.TestPlan;  
 import org.apache.jmeter.threads.ThreadGroup;  
 import org.apache.jmeter.threads.gui.ThreadGroupGui;  
 import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.visualizers.ViewResultsFullVisualizer;
import org.apache.jorphan.collections.HashTree;

import com.Jmeter.Method.PerformanceTestGeneratJMXandReport;  
   
 public class CompleteNongraphicaljplan {  
   public static void main(String[] argv) throws Exception {  
   
     PerformanceTestGeneratJMXandReport.performanceGenerateTestReport("F:\\apache-jmeter-5.2.1", "F:\\apache-jmeter-5.2.1\\bin\\jmeter.properties", "127.0.0.1", "Simple_Json","GET","SampleTest", "APILoadTestPlan", "JTLTestReportFile", "CSVTestReport");
   }  
 }  