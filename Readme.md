# Serenity Testautomation

This is an example implementation of a serenity test automation for this [Test Shopsystem](https://www.askomdch.com).

## Precondition
To run the test automation, you need the following system requirements:

* Java 23
* Maven
* git
* Chrome
* Firefox

After that, you have to clone the testdata project first.

    cd <project_folder>
    git clone https://github.com/kecks2010/testdata.git
    cd testdata
    git branch cucumber_test origin/cucumber_test
    git checkout cucumber_test
    git status

You should get the following output:

    On branch cucumber_test
    Your branch is up to date with 'origin/cucumber_test'.

    nothing to commit, working tree clean
    
And now, you have to install the project to your local maven repository.

    mvn clean install

The preconditions are ready, so that you can continue with test automation project.

## Serenity-Tests
After the installation of the testdata project, you can clone the serenity test automation project.

    cd <project_folder>
    git clone https://github.com/kecks2010/serenity-testautomation.git
    cd serenity-testautomation

Now the test automation is downloaded and if you got no problems, it should work.

    mvn clean verify

Maven starts the test automation headless and parallel with the Chrome browser on the default environment. To start the
test automation for all tests with tag "test" with firefox on dev environment, you need the following Maven command:

    mvn clean verify -Pdev -Denvironment=firefox -Dgroups="test"

The result of the test run, you find the report under:

    target/cucumber-reports/Cucumber.html
