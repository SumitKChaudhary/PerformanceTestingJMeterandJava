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
   
 public class CompleteNongraphicaljplan {  
   public static void main(String[] argv) throws Exception {  
   
     //Set jmeter home for the jmeter utils to load  
     String jmeterHomelocation = "F:\\apache-jmeter-5.2.1\\";  
     String jmeterPropertieslocation = jmeterHomelocation + "bin\\jmeter.properties";  
   
   
     //JMeter Engine  
     StandardJMeterEngine jmeter = new StandardJMeterEngine();  
   
     //JMeter initialization (properties, log levels, locale, etc)  
     JMeterUtils.setJMeterHome(new File(jmeterHomelocation).getPath());  
     JMeterUtils.loadJMeterProperties(new File(jmeterPropertieslocation).getPath());  
     // see extra log messages of i.e. DEBUG level  
     JMeterUtils.initLogging();  
     JMeterUtils.initLocale();  
   
     // JMeter Test Plan, basically JOrphan HashTree  
     HashTree testPlanTree = new HashTree();  
   
     // First HTTP Sampler - open google.com  
     HTTPSampler examplecomSampler = new HTTPSampler();  
     examplecomSampler.setDomain("127.0.0.1");  
     examplecomSampler.setPort(3000);  
     examplecomSampler.setPath("Simple_Json");  
     examplecomSampler.setMethod("GET");  
     examplecomSampler.setName("SampleAPI");  
     examplecomSampler.setProperty(TestElement.TEST_CLASS, HTTPSampler.class.getName());  
     examplecomSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());  
   
    
     // Loop Controller  
     LoopController loopCtrl = new LoopController();  
     loopCtrl.setLoops(10);  
     loopCtrl.setFirst(true);  
     loopCtrl.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());  
     loopCtrl.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());  
     loopCtrl.initialize();  
   
     
     // Thread Group  
     ThreadGroup threadGroup = new ThreadGroup();  
     threadGroup.setName("Test Thread Group");  
     threadGroup.setNumThreads(1);  
     threadGroup.setRampUp(1);  
     threadGroup.setSamplerController(loopCtrl);  
     threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());  
     threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());  
   
     // Test Plan  
     TestPlan testPlan = new TestPlan("Java code Test Plan");  
     testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());  
     testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());  
     testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());  
   
    
     // Construct Test Plan from previously initialized elements  
     testPlanTree.add(testPlan);  
     HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);  
     threadGroupHashTree.add(examplecomSampler);  
       
     
     // save generated test plan to JMeter's .jmx file format  
     SaveService.saveTree(testPlanTree, new FileOutputStream("C:\\Users\\Neelam-Sonu\\Desktop\\Report\\jmeter_api_sample2.jmx"));  
   
     //add Summarizer output to get test progress in stdout like:  
     // summary =   2 in  1.3s =  1.5/s Avg:  631 Min:  290 Max:  973 Err:   0 (0.00%)  
     Summariser summer = null;  
     String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");  
     if (summariserName.length() > 0) {  
       summer = new Summariser(summariserName);  
     }  
   
   
    
     // Store execution results into a .jtl file, we can save file as csv also  
     String reportFile = "C:\\Users\\Neelam-Sonu\\Desktop\\Report\\summaryreport2.jtl";  
     String csvFile = "C:\\Users\\Neelam-Sonu\\Desktop\\Report\\summaryreport2.csv";  
     ResultCollector logger = new ResultCollector(summer);  
     logger.setFilename(reportFile);  
     ResultCollector csvlogger = new ResultCollector(summer);  
     csvlogger.setFilename(csvFile);  
     testPlanTree.add(testPlanTree.getArray()[0], logger);  
     testPlanTree.add(testPlanTree.getArray()[0], csvlogger);  
      
     
           // Run Test Plan  
     jmeter.configure(testPlanTree);  
     jmeter.run();  
    
  
     System.exit(0);  
   
   
   }  
 }  