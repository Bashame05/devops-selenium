Step 8: Configure Build Steps

Navigate to the Build Steps section.

Click Add build step.

Select Invoke top-level Maven targets.

Select the configured Maven installation.

Enter the Maven goals:

clean test -DTest=DemoTest

Save the configuration.

Step 9: Configure Post-Build Actions

Navigate to Post-Build Actions.

Click Add post-build action.

Select Publish JUnit test result report.

Enter the test report path:

target/surefire-reports/*.xml
