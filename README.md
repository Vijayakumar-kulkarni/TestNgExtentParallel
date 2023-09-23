# TestNgExtentParallel
Framework for integrating the Extent reports with TestNG framework supporting parallel execution 

This work focuses mainly on integrating the extent report to a TestNG automation framework.This covers
1. Integrating the extent report with the help of Extent library and apprpriate usage of Listners
2. Retrying the failed tests and updating the status of the test in report as per the final run. If, while retrying the test gets PASSED then the report will get updated with the new
   status as PASS and the previous status of SKIPPED will not be dispalyed for such tests
3. If any tests are SKIPPED not because of the failure of the tests then they will be reported as SKIPPED
4. Different listeners like ITestListeners, IRetryAnalyzer, IAnnotationTrabsformer and ISuiteListener have been used to achieve the end result



