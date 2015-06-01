package com.rhc.lab.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/", plugin = { "pretty", "html:target/cucumber" }, glue = { "com.rhc" })
public class RunCukesTest {
}