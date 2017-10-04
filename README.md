# Supermarket Checkout

## Requirements:

* Design and implement supermarket checkout component with readable API that calculates the total price of a number of items.
* Checkout mechanism can scan items and return actual price (is stateful)
* Our goods are priced individually. In addition, some items are multi-priced: "buy n of them, and they’ll cost you y cents"

| Item   | Unit price           | Special price |
| ------ |:-------------:| -----:|
| A      | 40 | 3 for 70 |
| B      | 10      |  2 for 15 |
| C      | 30      |  |
| D      | 25   | |

    
## Assumptions:

* price is integral number,
* item identifiers, unit price and special price are constant,
* list of items is not extensible,
* checkout method can be called multiple times on the same service instance. As a result total price of all already passed items will be returned    
    
## Getting Started

Master branch contains supermarket checkout component without any client.

Cli branch additionaly contains command line interface, which uses supermarket checkout service. On the cli branch you can build executable jar by running command:

```
mvn clean install
```
Then start cli by running command:

```
java -jar <path_to_executable_jar>
```

## TO DOs:

* improve logging
* items data in json or xml file to provide possibility to modify it
