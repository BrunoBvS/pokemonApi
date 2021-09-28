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


**IMPORTANT NOTES:** 
* The boot of the application will already parse the pokemons from the resource "src\main\resources\pokemon.csv" to the memory
  * The file was obtained from the provided url : https://gist.github.com/armgilles/194bcff35001e7eb53a2a8b441e8b2c6

## CRUD Operations

### Create a Pokemon (POST)
* curl --location --request POST 'http://localhost:8080/pokemon' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "speed": 80,
  "attack": 100,
  "spDef": 120,
  "legendary": false,
  "total": 625,
  "type1": "Grass",
  "spAtl": 122,
  "name": "VenusaurMega Venusaur",
  "defense": 123,
  "number": 3,
  "hp": 80,
  "type2": "Poison",
  "generation": 1
  }'

### Read a Pokemon (GET)
* curl --location --request GET 'http://localhost:8080/pokemon/<id>'
  * Example: curl --location --request GET 'http://localhost:8080/pokemon/4' 
  * NOTE: Here is used the "id" property and not the "number" property, as there are many Pokemons sharing the same "number", but then having different "id" values!

### Read a page of Pokemons (GET)
* curl --location --request GET 'http://localhost:8080/pokemon'

### Update a Pokemon (PUT & PATCH)
* curl --location --request PUT 'http://localhost:8080/pokemon/801' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "speed": 81,
  "attack": 101,
  "spDef": 121,
  "legendary": true,
  "total": 631,
  "type1": "Poison",
  "spAtl": 123,
  "name": "VenusaurMega Venusaur Changed",
  "defense": 124,
  "number": 333,
  "hp": 81,
  "type2": "Grass",
  "generation": 2
  }'
* curl --location --request PATCH 'http://localhost:8080/pokemon/801' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "name": "VenusaurMega Venusaur Changed 2"
  }'

### Delete a Pokemon (DELETE)
* curl --location --request DELETE 'http://localhost:8080/pokemon/<id>'
  * Example: curl --location --request DELETE 'http://localhost:8080/pokemon/3'
  * NOTE: Here is used the "id" property and not the "number" property, as there are many Pokemons sharing the same "number", but then having different "id" values!
