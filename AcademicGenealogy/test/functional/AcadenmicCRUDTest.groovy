import geb.junit4.GebReportingTest
import org.junit.Test

class AcadenmicCRUDTest extends GebReportingTest {
	
	@Test
	void doListTest() {
		go "academic/list"
		assert title == "Academic List"
	}
}
