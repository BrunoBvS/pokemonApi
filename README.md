# pokemonApi

## Author
👤 **Bruno Vieira**

## Table of Contents
* Description to this "Back-End Technical Test"
  * INSTRUCTIONS (Français)
  * INSTRUCTIONS (English)
* Prerequisites to Run the Project
  * Java SDK 8
  * Grails 4
* How to Run the Tests (unit and integration)
* How to Run the Project
* CRUD Operations Examples
  * Create a Pokemon (POST)
  * Read a Pokemon (GET)
  * Read a page of Pokemons (GET)
  * Update a Pokemon (PUT & PATCH)
  * Delete a Pokemon (DELETE)

## Description to this "Back-End Technical Test"

**INSTRUCTIONS (Français) :**

L'objectif de l’exercice technique est de créer un petit projet qui exposera un API Restful à un éventuel client. Nous validerons le fonctionnement du projet via l'application Postman.

Il n'y a pas de cadre ou de technologie obligatoire, bien que nous recommandons l’utilisation du framework Ruby on Rails. Nous vous encourageons également à écrire des tests unitaires, bien que  ce ne soit pas une obligation.

Vous aurez accès à un fichier en format CSV (lien ci-bas) qui contient une liste de Pokémon. Ce  fichier fera office de base de données, et nous vous demandons donc, à partir de cette liste, d’exposer un API permettant d'effectuer les actions CRUD (Create, Read, Update, Delete). Nous aimerions également obtenir une liste paginée de tous les Pokémon présents dans le fichier.

Une fois le projet terminé vous devez nous partager le lien du projet dans votre GitHub ou autre solution similaire.

Voici le lien pour le fichier CSV :

https://gist.github.com/armgilles/194bcff35001e7eb53a2a8b441e8b2c6

**INSTRUCTIONS (English) :**

The goal of the technical exercise is to create a small project that will expose a Restful API to a potential customer. We will validate how the project works via the Postman application.

There is no required framework or technology, although we recommend using the Ruby on Rails  framework. We also encourage you to write unit tests, although this is not a requirement.

You will have access to a CSV file (link below) that contains a list of Pokémon. This file will act  as a database, so we ask you to expose an API from this list to perform CRUD (Create, Read,

Update, Delete) actions. We would also like to get a paginated list of all Pokémon in the file.

Once the project is finished you should share the project link with us in your GitHub or similar solution.

Here is the link for the CSV file:

https://gist.github.com/armgilles/194bcff35001e7eb53a2a8b441e8b2c6

## Prerequisites to Run the Project
  
### Java SDK 8

* Download and Install
  * https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html
* Configure `JAVA_HOME` with installation folder
  * Example: C:\Program Files\Java\jdk1.8.0_202
* Configure `Path` adding the "bin" folder from the other environment variable
  * Example: %JAVA_HOME%\bin
* Open a new terminal/prompt to test java with the command:
  * ```java -version```
  * **NOTE:** This project was built using: `java version "1.8.0_202"`

### Grails 4

* Download and Unzip
  * https://grails.org/download.html
* Configure `GRAILS_HOME` with installation folder
  * Example: C:\Grails\grails-4.0.12
* Configure `Path` adding the "bin" folder from the other environment variable
  * Example: %GRAILS_HOME%\bin
* Open a new terminal/prompt to test java with the command:
  * ```grails -version```
  * **NOTE:** This project was built using: `Grails Version: 4.0.12`

## How to Run the Tests (unit and integration)
* Open the "pokemonApi" root folder of this project, just where is this "README.md" and execute the command:
  * ```grails test-app```
* The application should download everything it needs, compile, and run the tests, ending with a message showing:
  * `Tests PASSED`
  * **NOTE:** The first execution might need a few minutes do download, compile and configure, but the next executions will start up a lot faster
* Open the file "build\reports\tests\index.html" in your browser to see the results

## How to Run the Project

* Open the "pokemonApi" root folder of this project, just where is this "README.md" and execute the command:
  * ```grails run-app```
* The application should download everything it needs, compile, and boot up, ending with a message showing:
  * `Grails application running at http://localhost:8080 in environment: development`
  * **NOTE:** The first execution might need a few minutes do download, compile and configure, but the next executions will start up a lot faster
* The application is already running and ready to be used and tested in the shown ip and port


**IMPORTANT NOTES:** 
* The boot of the application will already parse the pokemons from the resource "src\main\resources\pokemon.csv" to the memory
  * The file was obtained from the provided url : https://gist.github.com/armgilles/194bcff35001e7eb53a2a8b441e8b2c6

[comment]: <> (* The ending/closing of the application will write back the pokemons from the memory to the resource "src\main\resources\pokemon.csv", so that the next boot will continue with the changed data from the previous execution, similarly to a database.)

[comment]: <> (* To "restart" the database to the original settings &#40;original provided "pokemon.csv" file&#41;:)

[comment]: <> (  * Stop the application)

[comment]: <> (  * Discard the local changes made in this specific file with the GIT command:)

[comment]: <> (    * git checkout HEAD -- src/main/resources/pokemon.csv)

[comment]: <> (  * Restart the application)

## CRUD Operations Examples

### Create a Pokemon (POST)
```
curl --location --request POST 'http://localhost:8080/pokemon' \
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
```

### Read a Pokemon (GET)
```
curl --location --request GET 'http://localhost:8080/pokemon/<id>'
```
* Example: ```curl --location --request GET 'http://localhost:8080/pokemon/4'``` 
* **NOTE:** Here is used the "id" property and not the "number" property, as there are many Pokemons sharing the same "number", but then having different "id" values!

### Read a page of Pokemons (GET)
```
curl --location --request GET 'http://localhost:8080/pokemon'
```

### Update a Pokemon (PUT & PATCH)
```
curl --location --request PUT 'http://localhost:8080/pokemon/801' \
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
```
```
curl --location --request PATCH 'http://localhost:8080/pokemon/801' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "name": "VenusaurMega Venusaur Changed 2"
  }'
```

### Delete a Pokemon (DELETE)
```
curl --location --request DELETE 'http://localhost:8080/pokemon/<id>'
```
* Example: ```curl --location --request DELETE 'http://localhost:8080/pokemon/3'```
* **NOTE:** Here is used the "id" property and not the "number" property, as there are many Pokemons sharing the same "number", but then having different "id" values!
