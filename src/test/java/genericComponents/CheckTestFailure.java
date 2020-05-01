package genericComponents;

import java.util.List;

import report.TestReportSteps;

public class CheckTestFailure {
		
		private static int testResult = 0;
		/**
		 * Test for failure condition in the report parameter passed and update value
		 * of static variable testCheck if failed  else return actual value of testCheck
		 * @param report - test report of test performed
		 * @param testCheck - static variable to test for check failure
		 * @return testResult - testCheck value 
		 */
		public static int test(List<TestReportSteps> report, int testCheck)
		{
			testResult = testCheck;
			for (TestReportSteps r : report) {
				if (r.getActualResultFail() != "") {
					testResult++;
					break;
				}
			}
			return testResult;
		}
}
