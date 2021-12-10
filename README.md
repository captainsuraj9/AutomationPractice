Pre requIsites :-
To run the scenarios as TestNG test
1. File location given below has to be updated :-
/WebAutomationSuraj/src/main/java/Resources/data.properties
dataFilePath - Testdata source
sheetName -  sheet from which we need data.
2. Base class under Main folder has to be updated with chromedriver location in the machine

To run as Cucumber test :-
1. Base class under Main folder has to be updated with chromedriver location in the machine


Please find below the overview of the Project below :-
1. Maven,TestNG and Cucumber are the building blocks of the Selenium project as instructed.
2. 2. Both the mentioned scenarios are completed with each one having separate Feature file in the Feature package inside main.
3. 3. Both scenarios can be run from TestRunner class as JUnit tests under CucumberOptions package.
4. 4. OrderTshirt test can be also be run as TestNG test present under Tests package.5. As TestNG test , Order tshirt functionality has data provider taking data dynamically from excel and also has log4j reporting.

Please find below the enhancements that can be done :-
1. Credentials can be encrypted or masked before storing it in excel.
2. 2. Making the code generic to order anything alongside tshirt using the same code , Passing the products as parameters.
