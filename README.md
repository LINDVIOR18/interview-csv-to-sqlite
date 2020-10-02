# Interview-Task

In this task I had to transfer the data from the CSV file to SQLite DB.

Customer X just informed us that we need to churn out a code enhancement ASAP for a new project.  Here is what they need:

 
1. We need a Java application that will consume a CSV file, parse the data and insert to a SQLite In-Memory database.  

a. Table X has 10 columns A, B, C, D, E, F, G, H, I, J which correspond with the CSV file column header names.

b. Include all DDL in submitted repository

c. Create your own SQLite DB

 
2. The data sets can be extremely large so be sure the processing is optimized with efficiency in mind.  

 
3. Each record needs to be verified to contain the right number of data elements to match the columns.  

a. Records that do not match the column count must be written to the bad-data-<timestamp>.csv file

b. Elements with commas will be double quoted

 
4. At the end of the process write statistics to a log file

a. # of records received

b. # of records successful

c. # of records failed

## Installation

1. First of all you need to install java.11 and Maven.
2. Install sqlite3 depending on which system you use.

linux
```bash
sudo apt-get install sqlite3
```

windows

Step 1 − Go to SQLite [download page](https://www.sqlite.org/download.html), and download precompiled binaries from Windows section.

Step 2 − Download sqlite-shell-win32-*.zip and sqlite-dll-win32-*.zip zipped files.

Step 3 − Create a folder C:\>sqlite and unzip above two zipped files in this folder, which will give you sqlite3.def, sqlite3.dll and sqlite3.exe files.

Step 4 − Add C:\>sqlite in your PATH environment variable and finally go to the command prompt and issue sqlite3 command, which should display the following result.

```cmd
C:\>sqlite3
SQLite version 3.7.15.2 2013-01-09 11:53:05
Enter ".help" for instructions
Enter SQL statements terminated with a ";"
sqlite>
```

## Usage

To run the given project, go to the project directory and run.

```bash
mvn -e compile exec:java
```
And to run the generated jar again use


```bash
java -jar target/Interview-Task-1.0-SNAPSHOT-jar-with-dependencies.jar
```

