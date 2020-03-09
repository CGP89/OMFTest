Readme:
I was unable to run docker on my pc. I have windows home version, So I'm using a local version of geckodriver and chromedriver.
I linked it to the folder C:\selenium\{driverfile.exe} which you can change in the DriverUtility.java class

How to start the tests.
Open the project in your preferred IDE> (I used netbeans).

navigate to mavenproject2>src>test>java>TestOMF.java
right click on TestOMF.java and click on Test File to run the test
once the test is finished. you can navigate to the project folder>target>surefire-reports>emailable-report.html or index.html to view the test results