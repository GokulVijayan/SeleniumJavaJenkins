package report;

import java.util.List;

public class TestReport {
	
	private List<TestReportSteps> TestReportSteps;

	public TestReport(List<TestReportSteps> testReportSteps) {
		TestReportSteps = testReportSteps;
	}

	public List<TestReportSteps> getTestReportSteps() {
		return TestReportSteps;
	}
	
}
