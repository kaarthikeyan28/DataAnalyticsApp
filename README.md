# DataAnalytics
DATA ANALYTICS

Modules used:

UI - It has Import files / View Waiting Imports

Import - File Extension identified using Factory method (returns corresponding FileObject)

ThreadQueue - It has addedFiles() , viewFiles() , deleteFiles() methods.

ThreadCall - It has run() method with Corresponding FileObject.

FileBufferReader - An Interface with 2 methods --> readFiles() , convertLines()

ConsoleFileReader - abstract class --> abstract convertLines() , concrete readLines()

CsvConsoleFileReader extends ConsoleFileReader --> implentation of convertLines()

JSonConsoleFileReader extends ConsoleFileReader -->implentation of convertLines()

Database - An interface with createTable(),InsertValues()

Mysql - Implements Database 

JDBC - provides Connection# DataAnalyticsZoho
