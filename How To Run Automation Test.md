# How to run Java automation test project

This doucment describes how to run the Java automation test project within Eclipse. In real project, it should be running in a CI/CD system, like Jenkins.

There is a screen record video of this automation test. It is in the document directory(documents/Screen recording of automation test.mp4).

The java project depends on the following libraries:

- TestNG(https://testng.org/doc/)
- Selenium()

## Config development Environment

### Java Environment

This project is build on the windwons 10 machine with JDK 1.8 . All the machine with JDK 1.8+ should work fine.

### Eclipse

The development tool is Eclipse IDE for Enterprise Java Developers 2020-09(4.17.0). The download link of Eclipse IDE is https://www.eclipse.org/downloads/packages/.

### Install TestNG for Eclipse plugin 

See the document of [the TestNG offical website](https://github.com/cbeust/testng-eclipse/).

To install it:

- Open Eclipse
- Click "Help -> Install New Software..." on top level menu
- Paste the url https://dl.bintray.com/testng-team/testng-eclipse/ to Work with: text field and press enter.
- Select the plugins
- Click "Next" button and accept the license to complete the installation.
- Restart Eclipse

### Install Chrome driver

See the document of [the selenium offical website](https://chromedriver.chromium.org/getting-started).

To install it:

Follow these steps to setup your tests for running with ChromeDriver:

- Ensure Google Chrome is installed in a recognized location.
  ChromeDriver expects you to have Chrome installed in the default location for your platform. You can also force ChromeDriver to use a custom location by setting a special capability.
- Download the ChromeDriver binary for your platform under [the downloads url](https://chromedriver.chromium.org/downloads).
- Include the ChromeDriver location in your PATH environment variable

## Run the project

This java project depends on the testNG plugin, please install it before import the project.

To run the project:

1. Use 'git clone" to get the project from (the project url)[https://github.com/seashellwj/qa-dev-2020-11.git].
2. Import the project into Eclipse, java project is in the "./automation-test/testQaExercise".
- Open File->Import.
- Select "Existing Projects into Workspace" from the Selection Wizard.
- Select Next to get the Import Wizzard. Browse to find the location of the Project("./automation-test/testQaExercise").
- Make sure the Project you want is checked, then hit Finish.
3. If there are any building issue, such as testNG or Selenium package not found. Please add testNG library and Selenium jars into the project.
- Right click the project, select "properties".
- Select "Java Build Path" in the left panel.
- Remove all the jars that are not available(which has a red cross on the icon).
- Select "Add Library"(Add TestNG).
- Select "TestNG", and click "Next", then click "Finish".
- Select "Add External Jars".
- Select "automation-test/selenium-java-3.141.59/client-combined-3.141.59.jar" and all jars in "automation-test/selenium-java-3.141.59/libs/*.jar".
- click "Apply and Close".
The project should rebuild and all the building error should be solved.
4. Right click the java souce file(TestItemList.java),  Select "Run As" -> "TestNG Test".
5. The Chrome should open automaticlly and the automation test program will execute.
6. After all the test done, the chrome will close automaticlly and the testing report will be displayed on the console.
7. The TestNG generated a test report in the directory "automation-test/testQaExercise/test-output". Open the index.html to see the report.