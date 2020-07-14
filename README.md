# 

Download the framwork and open in a IDE or navigate to the path of the folder on file explorer.
Run the framework with the command mvn test . 
Go to the folder \\WP\src\main\java\TestFramework\report to see the htmp report generated.
Sample LOG:

[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< TestFrameworkWP:WP >-------------------------
[INFO] Building WP 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ WP ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ WP ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 8 source files to C:\Users\master\Downloads\Compressed\WP-master\WP\target\classes
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ WP ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\master\Downloads\Compressed\WP-master\WP\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ WP ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to C:\Users\master\Downloads\Compressed\WP-master\WP\target\test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ WP ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestFrameworkWP.homePage.HomePageTest
C:\Users\master\Downloads\Compressed\WP-master\WP
2020-07-14 16:19:16 INFO  TestBase:112 - loading config.properties
2020-07-14 16:19:16 INFO  TestBase:117 - loading or.properties
Starting ChromeDriver 83.0.4103.39 (ccbf011cb2d2b19b506d844400483861342c20cd-refs/branch-heads/4103@{#416}) on port 14487
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
Jul 14, 2020 4:19:20 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
2020-07-14 16:19:20 INFO  HomePageTest:31 - TestFrameworkWP.homePage.HomePageTest started
2020-07-14 16:19:20 INFO  HomePageTest:34 - https://www.westpac.co.nz started for testWebsiteNavigation
2020-07-14 16:19:20 INFO  HomePageTest:35 - Testing Scenario : Given User Clicks information icon besides Current age the message “This calculator has an age
limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.” is displayed below
the current age field.
2020-07-14 16:19:29 INFO  HomePageTest:58 - Message verified : This calculator has an age limit of 18 to 64 years old.
2020-07-14 16:19:30 INFO  HomePageTest:101 - https://www.westpac.co.nz started for GetKiwiSaverHighRiskBalance
2020-07-14 16:19:30 INFO  HomePageTest:102 - Testing Scenario : User whose Current age is 30 is Employed @ a Salary 82000 p/a and contributes to
KiwiSaver @ 4% has a PIR 17.5% and chooses a high risk profile is able to calculate his
projected balances at retirement.
2020-07-14 16:19:35 INFO  HomePageTest:127 -  Viewing KiwiSaverProjections 
2020-07-14 16:19:36 INFO  HomePageTest:140 - https://www.westpac.co.nz started for GetKiwiSaverMediumRiskAged45Balance
2020-07-14 16:19:36 INFO  HomePageTest:141 - Testing Scenario :User whose current aged 45 is Self-employed, has a PIR 10.5%, current KiwiSaver
balance is $100000, voluntary contributes $90 fortnightly and chooses medium risk
profile with saving goals requirement of $290000 is able to calculate his projected
balances at retirement.
2020-07-14 16:19:42 INFO  HomePageTest:172 -  Input Savings goal 290000 
2020-07-14 16:19:42 INFO  HomePageTest:176 -  Viewing KiwiSaverProjections 
2020-07-14 16:19:43 INFO  HomePageTest:190 - https://www.westpac.co.nz started for GetKiwiSaverMediumRiskAged55Balance
2020-07-14 16:19:43 INFO  HomePageTest:191 - Testing Scenario :User whose current aged 55 is not employed, has a PIR 10.5%, current KiwiSaver balance
is $140000, voluntary contributes $10 annually and chooses medium risk profile with
saving goals requirement of $200000 is able to calculate his projected balances at
retirement.
2020-07-14 16:19:49 INFO  HomePageTest:223 -  Input Savings goal 200000 
2020-07-14 16:19:49 INFO  HomePageTest:225 -  Viewing KiwiSaverProjections 
2020-07-14 16:19:50 INFO  HomePageTest:70 - https://www.westpac.co.nz started for testOpeningRetirementCalculatorPage
2020-07-14 16:19:50 INFO  HomePageTest:71 - Testing Scenario : User can successfuly navigate around : Navigation Flow KiwiSaver &gt; KiwiSaver Calculators &gt; Click here to get started button
under (Westpac KiwiSaver Scheme Retirement Calculator)
2020-07-14 16:19:53 INFO  HomePageTest:85 -  verified :Opening Retirement Calculator Page 
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 37.313 s - in TestFrameworkWP.homePage.HomePageTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  42.577 s
[INFO] Finished at: 2020-07-14T16:19:53+12:00
[INFO] ------------------------------------------------------------------------
