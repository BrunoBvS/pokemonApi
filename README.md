# pokemonApi (By Bruno Vieira)

## Prerequisites to Run the Project
  
### Java SDK 8

* Download and Install
  * https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html
* Configure **JAVA_HOME** with installation folder
  * Example: C:\Program Files\Java\jdk1.8.0_202
* Configure **Path** adding the "bin" folder from the other environment variable
  * Example: %JAVA_HOME%\bin
* Open a new terminal/prompt to test java with the command:
  * java -version
  * NOTE: This project was built using: java version "1.8.0_202"

### Grails 4

* Download and Unzip
  * https://grails.org/download.html
* Configure **GRAILS_HOME** with installation folder
  * Example: C:\Grails\grails-4.0.12
* Configure **Path** adding the "bin" folder from the other environment variable
  * Example: %GRAILS_HOME%\bin
* Open a new terminal/prompt to test java with the command:
  * java -version
  * NOTE: This project was built using: Grails Version: 4.0.12

## How to run the project

* Open the "pokemonApi" root folder of this project, just where is this "README.md" and execute the command:
  * grails run-app
* The application should download everything it needs, compile, and boot up, ending with a message showing:
  * Grails application running at http://localhost:8080 in environment: development
  * NOTE: The first execution might need a few minutes do download, compile and configure, but the next executions will start up a lot faster
* The application is already running and ready to be used and tested in the shown ip and port