##Now all the configuration in pom.xml is done. We need to run the testcases and generate the Allure report post-execution. So, for that make sure you don’t run your test cases from the testng.xml file and rather execute it from pom.xml. Because all the plugins related to the allure are been configured in pom.xml and not testing.xml

#1) Open the command prompt in that path and run the following command:
mvn clean test
The scripts should run and give some result either fail/pass/skip

#2) To generate Allure reports, on the same terminal, run the following command:

allure generate --single-file target/allure-results -o target/allure-report –clean
allure serve target/allure-results

##The above command generates a report in the temporary folder from the data found in target/surefire-reports/ and
then creates a local Jetty server instance, serves generated report, and opens the HTML report in the default browser.

#3) Emailable Report can be generated.

zip -r allure-report.zip target/allure-report

##It's useful when you want to share a directory (like an Allure test report) with all its contents in one compressed file.
By creating a ZIP archive, you can easily email or upload the entire report, and the recipient can extract it and
view the report in a browser.

We can see a folder allure-report.zip is created to share emailable report under target folder names index.html
