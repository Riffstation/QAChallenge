QA Challenge - José Mascaró


*** Dependencies and how to install then *** 
(Included into the POM.xml file)

Selenium 2.52.0
ChormeDriver 2.53.1
cucumber-java 1.2.4
cucumber-junit 1.2.4
Plug in -> maven-failsafe-plugin 2.19.1

As maven does, building the solution all the dependecies are downloaded and added to the project automatically.


*** HOW TO RUN THE TESTS ***


1. INSTALL JAVA development kit 

http://www.oracle.com/technetwork/java/javase/downloads/index.html

In my case I have choosen the link for netbeans including the JDK (http://www.oracle.com/technetwork/java/javase/downloads/jdk-netbeans-jsp-142931.html) so we can build, debug and run the tests easyly from here, if you do that, you do not need to install maven as it is included with netBeans.

If you install netbeans that is the process for run the tests:

Menu File -> Open Project and inside the FenderQAChallenge folder we can open it. 
Then press right mouse button over the file CartManagementTests.java(script doing the automation example without cucumber) and select 'Test File' option. Or right mouse button over the file RunCucumberTests.java and select 'Test File' option.

If you choose to install netbeans you do not need to install maven, if not (so you only install the JDK) is IMPORTANT to set a new environment variable named JAVA_HOME with the path of your JDK installation.

2. INSTALL MAVEN

We need to download and install maven, in their web site there is specific information about how to do it, 
https://maven.apache.org/install.html, 

Briefly you need to download the zip file with the bin files, 

http://apache.osuosl.org/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip

Add to your Path environment var the folder of maven/bin.

Run mvn -v to check that maven has been installed correclty.

3. RUN THE TESTS

- You should have a VPN server provider situated in USA, to access to the us web shop online of Fender from Dublin.
- Download the files from the GitHub repository and go to FenderQAChallenge\ folder.

And run

mvn test -Dtest=CucumberTests.RunCucumberTests

And for the script done without cucumber(that is the first script that I have done)

mvn test -Dtest=CartManagementTests.CartManagementTests

   

** INFORMATION ABOUT THE SOLUTION **

I will us IIHMT to refer to If 'I have more time'  

Into the Sources Packages (src/main/java) there are two packages, FenderAutomationFrameWork and FenderOnlineShop. 

* About the test automation framework

There are a lot of things that could be added here,

IIHMT 
- add a Logger with different severity levels for manage the tests having one logger file per test.
- an exception manager, if a test get an exception we can choose if we would like to continue the test or not, and get an  screenshot should be saved (also i would check if that could be integrated with cucumber).
- support for testrail or another tool to inform if one test case has failled or not
- support for run the test in parallel that is mandatory
- support for retry a test an specific by user number of times
- one TestBase class for create and quit the web driver or better one TestWrapper class so each test could have his own logger, testenvironment, driver, timeouts...)
....

What exist,

-- AbstractWidget class

This class implements IWidget I have done that to force to all the widget to implement one method IsDoneLoading so if the elements of a widget displayed we can start working with it (that is not as so simple in some scenarios).

One widget is an abstraction of one element into the website, which could be one popup, something that is repeated several times, one web page and so on... All of them are childrens of this class, this class contains the actions and initialization methods for the widgets to be sure that a widget is loaded and initialized.

WaitForCondition --> This is a powerful method as we can pass any boolean function and if it is false will try to get the selenium result several times, if it get an exception (stale exception, not found element excetption, ...) it will get a refresh all the elements of the widget trying againg to get them. This is really useful and give us much more stability in our tests which is one of the big issues in test automation.

-- Navigable class

This class is support for the widget which implements INavigable (so we can navigate directly to that pages), I have choosen into the widget to use the URL instead of the menu buttons when possible, as we are not testing the navigation between pages.

Finally, about the Framework my idea is to have it in a completely separated project from the Automation project, in his own repository (maybe have it as a NuGet package into ProGet).

* FenderOnlineShop

Here we have two packages, PageObjects and TestDataObjects, PageObjects represents the pages in the screen they have the different properties that contains the screen and the services that the screen provide us, for instance imagine that we have an screen for edit, add and delete a song, that are exactly the services of the page, DeleteSong, AddSong... instead of do it in an user action perspective, TestDataObject contains the properties of the objects, in my example could be TestSong for instance.

IIHMT I would this for this challenge create one method for search the guitars using the search box and then select an specific guitar.

* Tests

I have done first one script using directly selenium and the same one using cucumber, about cucumber I have no time to do any complex test. I am not sure if cucumber will support the exception manager, or get screenshots and if it is really useful to add extra code and function only for translate from plain english to a java code in this case, because in a normal test if it is clearly done we and can add logger like

....
Logger.LogStep("When step description is here");.... 
MyStepAction();
....

That maybe would be almost the same and we do not need to duplicate code also may would give us more flexibility using the language features than cucumber but I am not sure as I know only a little bit about cucumber so I do not know about the number possibilities that it has.


Note: I have not time to do more than two scenarios although I was all the weekend working on this because I knew nothing about maven and cucumber before this assigment and also I needed to remember a lot of things of Java as is different how manage solutions and projects... than .Net, anyway I think that in this case add more scenarios maybe will not add more value to my proposal anyway if you would like I could add some more scenarios tomorrow after work.

Thank you very much

Regards
/Jose Mascaro

Note: After this weekend I am seriously thinking on buy a Fender Guitar ;)











