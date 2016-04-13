package com.auto.Runner;

/**
 * Created by tlqiao on 4/11/16.
 */

import com.auto.common.AutoTest;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(Cucumber.class)
@Cucumber.Options(features = {"src/test/resources/Features"},
		glue = {"com.auto.Steps"}
//		tags={"@test"},
		
////			dryRun = false,
//		monochrome = true
//			format={"pretty"})
)
public class TestRunner {
}


