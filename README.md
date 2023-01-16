# Gilded Rose Refactoring Kata In Java

## Instructions

### IntelliJ IDEA

1. Open IntelliJ IDEA and select _File > Open..._.
2. Choose the GildedRose-Refactoring-Kata-Java directory and click _OK_.
3. Select _File > Project Structure..._ and ensure that the Project SDK and language level are set to use Java 8.
4. Open the Maven view with _View > Tool Windows > Maven_.
5. In the Maven view, run the `compile` phase under _Lifecycle_ and then the `exec:java` goal to run the app.

### Eclipse

1. Open Eclipse and select _File > Import_.
2. In the import wizard, choose _Maven > Existing Maven Projects_, then click _Next_.
3. Select the GildedRose-Refactoring-Kata-Java as the project root directory.
4. Click _Finish_ to complete the import.
5. Select _Project > Properties_ . In _Java Build Path_, ensure that under the Libraries tab, _Modulepath_ is set to JRE System Library (JavaSE-8). In _Java Compiler_, ensure that the _Use compliance from execution environment 'JavaSE-8' on the 'Java Build Path'_ checkbox is selected.
6. Right-click the project in the Project Explorer or Package Explorer and choose _Run As > Maven Build..._. In the _Edit Configuration_ dialog, create a run configuration with name `run`. In the _Goals_ field, enter `compile exec:java`. Click _Run_ to run the goal. The app should compile and launch the JavaFX window.

### Command Line


1. To build it, you will need to download and unpack the latest (or recent) version of Maven (https://maven.apache.org/download.cgi)
   and put the `mvn` command on your path.
   Then, you will need to install a Java 1.8 (or higher) JDK (not JRE!), and make sure you can run `java` from the command line.
2. `cd` into the project's root directory.
3. run `mvn clean install` and Maven will compile your project,
   an put the results it in a jar file in the `target` directory.


