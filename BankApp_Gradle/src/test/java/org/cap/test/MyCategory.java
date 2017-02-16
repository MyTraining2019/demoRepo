package org.cap.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Categories.class)
@SuiteClasses({BankAppTestCase.class,MyDemoTestCase.class})
@ExcludeCategory({GoodTestCategory.class})
public class MyCategory {

	

}
