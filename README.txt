CS542 Design Patterns
Fall 2016
ASSIGNMENT-5 README FILE

Due Date: <Wednesday, Thursday December 15, 2016>
Submission Date: <Wednesday, December 14, 2016>
Grace Period Used This Project: 0 Days
Grace Period Remaining: 2 Days
Author: Shashi Upadhyay
e-mail: supadhy2@binghamton.edu

PURPOSE:

[
Use java reflection ( newInstance method) to create an object and Populate the data structures with instances of objects
]

PERCENT COMPLETE:

[
100%
]


PARTS THAT ARE NOT COMPLETE:

[
None
]


BUGS:

[
All the corner cases uploaded on the blackboard are verified and code is validated for those cases.
]

FILES:

[
Below listed files are included with the attachment:
Total files : 10
upadhyay_shashi_assign5/genericDeser/build.xml
upadhyay_shashi_assign5/genericDeser/README.txt
upadhyay_shashi_assign5/genericDeser/src/genericDeser/util/First.java
upadhyay_shashi_assign5/genericDeser/src/genericDeser/util/genericDeserTokens.java
upadhyay_shashi_assign5/genericDeser/src/genericDeser/util/InputValidations.java
upadhyay_shashi_assign5/genericDeser/src/genericDeser/util/LoggerHandler.java
upadhyay_shashi_assign5/genericDeser/src/genericDeser/util/PopulateObjects.java
upadhyay_shashi_assign5/genericDeser/src/genericDeser/util/Second.java
upadhyay_shashi_assign5/genericDeser/src/genericDeser/fileOperations/FileProcessor.java
upadhyay_shashi_assign5/genericDeser/src/genericDeser/driver/Driver.java		
]

SAMPLE OUTPUT:

[

ant run -Darg0=input.txt -Darg1=0

run:
     [java] Number of unique First objects	:	2
     [java] Total Number of First objects	:	2
     [java] Number of unique Second objects	:	2
     [java] Total Number of Second objects	:	2

BUILD SUCCESSFUL
Total time: 0 seconds

ant run -Darg0=input1.txt -Darg1=0

run:
     [java] Number of unique First objects	:	4952
     [java] Total Number of First objects	:	4952
     [java] Number of unique Second objects	:	5018
     [java] Total Number of Second objects	:	5048

BUILD SUCCESSFUL
Total time: 1 second

ant run -Darg0=input2.txt -Darg1=0

run:
     [java] Number of unique First objects	:	359994
     [java] Total Number of First objects	:	498623
     [java] Number of unique Second objects	:	100643
     [java] Total Number of Second objects	:	501377

BUILD SUCCESSFUL
Total time: 11 seconds

]
 
CHOICE OF DATA STRUCTURE:

[
Data structre to hold contents:
HashMap: HashMap are used for this assignment.
Purpose: 
1) It provides the feature to store the contents in key-value pairs.
2) Fast retrieval of the values stored corresponding to the key.
 
]

TO UNTAR:

[
Untar the files using the below mentioned command. 
Command to untar : tar -xvzf  upadhyay_shashi_assign5.tar.gz
]

TO COMPILE:

[

Go to upadhyay_shashi_assign5 folder using below command
Command :  cd upadhyay_shashi_assign5/genericDeser/

Please compile as : ant compile_all

]

TO RUN:

[
Go to upadhyay_shashi_assign5 folder using below command
Command :  cd upadhyay_shashi_assign5/genericDeser/
And then run below mentioned command

Please run as     : ant run -Darg0=input.txt -Darg1=0

If already inside upadhyay_shashi_assign5/genericDeser/ then directly command : 
ant run -Darg0=input.txt -Darg1=0
]

TO CREATE JAVADOCS:

[
Go to upadhyay_shashi_assign5 folder using below command
Command :  cd upadhyay_shashi_assign5/genericDeser/
And then run below mentioned command

Please run as     : ant create_javadocs

If already inside upadhyay_shashi_assign5/genericDeser/ then directly execute : ant create_javadocs
]

EXTRA CREDIT:

[
N/A
]


BIBLIOGRAPHY:

[
Below websites were referred for the code.
http://www.cs.binghamton.edu/~mgovinda/courses/csx42/assignments/assign5/assign5.html
http://tutorials.jenkov.com/java/enums.html
http://stackoverflow.com/questions/2215843/using-reflection-in-java-to-create-a-new-instance-with-the-reference-variable-ty
http://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html
https://www.tutorialspoint.com/java/lang/float_equals.html
]

ACKNOWLEDGEMENT:

[
During coding, websites mentioned in the Bibliography section were being referred.
]
