package com.trainings.algorithms.designpatterns;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class CodeBuilderTest {

	@Test
	void test() {
		Assert.assertEquals("public class Person\n" + 
				"{\n" + 
				"  public String name;\n" + 
				"  public int age;\n" + 
				"}", new CodeBuilder("Person").addField("name", "String").addField("age", "int").toString());
	}

}
