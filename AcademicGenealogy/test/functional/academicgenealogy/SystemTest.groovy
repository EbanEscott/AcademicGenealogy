package academicgenealogy

import geb.junit4.GebReportingTest
import org.junit.Test

import au.com.workingmouse.testcase.TestcaseDocument

class SystemTest extends GebReportingTest {
	
	def getTestCases(testName) {
		def testcases = []
		def count = 1
		def more = true;
		while(more) {
			def xmlFilename = testName + ".xml"
			def file = new File(xmlFilename)
			if (file.exists()) {
				//TODO Add jar to runtime classpath?
				def testcase = TestcaseDocument.Factory.parse(file);
				testcases.add(testcase)
			} else {
				more = false;
			}
		}
		return testcases
	}
	
	def getCountString(int count)
	{
		String countString = null;
		if (count < 10) {
			countString = "00" + count
		} else if (count < 100) {
			countString = "0" + count
		} else if (count < 1000) {
			countString = "" + count
		} else {
			throw new RuntimeException("More than 999 tests.");
		}
		return countString;
	}
	
	@Test
	void doNothing() {
		//Added so test-app has something to run.
	}
}
