package org.cap.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MyDemoTestCase {

	@Category(BadTestCategory.class)
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
