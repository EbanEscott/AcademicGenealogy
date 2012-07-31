package academicgenealogy
import geb.junit4.GebReportingTest
import org.junit.Test


class AcademicTest extends SystemTest {
	
	@Test
	void doListTest() {
		go "academic/list"
		assert title == "Academic List"
	}
	
	@Test
	void doCreateTest() {
		def testcases = getTestCases("AcademicCreateTest");
		System.out.println(testcases);
	}
}
