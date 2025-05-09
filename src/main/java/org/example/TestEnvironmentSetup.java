package org.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestEnvironmentSetup {

    // This method will be called before any tests in this class
    @BeforeClass
    public void setupEnvironmentDetails() throws Exception {
        EnvironmentSetup.addEnvironmentDetails();  // Call to create the environment.properties file
    }
}
