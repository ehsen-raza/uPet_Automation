# uPet_Automation
A technical evaluation project by uPet company

#Technology
- Java
- Cucumber,
- Selenide
- BrowserStack
- Maven
- GitHub

#Pre-Requirements Before Run
- Java 8 JDK
- Maven 3
- Should be available in the system

#How to Run
- Download the package from git repo https://github.com/ehsen-raza/uPet_Automation.git {Ask for access from the author}
- Use any command line client e.g. CMD, PowerShell.
- Locate/navigate the pom.xml file in the root folder.
- Run the command ```mvn test``` {given you have Maven 3 package in the system}

#Notes
- On git push and pull request workflow_dispatcher will activate and by using Ubuntu it will run the test on BrowserStack.
- Fluent Pattern is used partially due to time limitation.
- SonarLint is used to maintain the code quality and identify potential bugs.
 
#What Can be Added More
- Extent report can be integrated, initially I was planning but could get time to add.
- Services and PageObjectModel packages are available but can be enhanced with additional tests e.g. Page Objects should be divided into three different layers to follow the Fluent pattern.