package report;

public class TestReportSteps {

	private String testObjective;
	private String stepName;
	private String stepDescription;
	private String expectedResult;
	private String actualResultPass;
	private String actualResultFail;
	
	public TestReportSteps(String testObjective, String stepName, String stepDescription, String expectedResult, String actualResultPass, String actualResultFail)
	{
		this.testObjective = testObjective;
		this.stepName = stepName;
		this.stepDescription = stepDescription;
		this.expectedResult = expectedResult;
		this.actualResultPass = actualResultPass;
		this.actualResultFail = actualResultFail;
	}
	
	/**
	* Retrieve test objective 
	*/
	public String getTestObjective()
	{
		return testObjective;
	}
	
	/**
	* Set test objective
	*/
	public void setTestObjective(String testObjective)
	{
		this.testObjective = testObjective;
	}
	
	/**
	* Retrieve step name
	*/
	public String getStepName()
	{
		return stepName;
	}
	
	/**
	* Set step name
	*/
	public void setStepName(String stepName)
	{
		this.stepName = stepName;
	}
	
	/**
	* Retrieve step description
	*/
	public String getStepDescription()
	{
		return stepDescription;
	}
	
	/**
	* Set step description
	*/
	public void setStepDescription(String stepDescription)
	{
		this.stepDescription = stepDescription;
	}
	
	/**
	* Retrieve expected result
	*/
	public String getExpectedResult()
	{
		return expectedResult;
	}
	
	/**
	* Set expected result
	*/
	public void setExpectedResult(String expectedResult)
	{
		this.expectedResult = expectedResult;
	}
	
	/**
	* Retrieve actual result for test pass 
	*/
	public String getActualResultPass()
	{
		return actualResultPass;
	}
	
	/**
	* Set actual result for test pass 
	*/
	public void setActualResultPass(String actualResultPass)
	{
		this.actualResultPass = actualResultPass;
	}
	
	/**
	* Generate actual result for test fail 
	*/
	public String getActualResultFail()
	{
		return actualResultFail;
	}
	
	/**
	* Set actual result for test fail
	*/
	public void setActualResultFail(String actualResultFail)
	{
		this.actualResultFail = actualResultFail;	
	}
	
}
