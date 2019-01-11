package com.testingfly.automation.core.execution;

import java.util.List;

import com.testingfly.automation.core.data.ITestSet;
import com.testingfly.automation.core.testngdata.TestNGSuite;

public interface SuiteCreator {

	TestNGSuite createSuite(List<ITestSet> testSets);

	

}