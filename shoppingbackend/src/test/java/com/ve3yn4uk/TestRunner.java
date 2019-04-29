package com.ve3yn4uk;

import com.ve3yn4uk.shoppingbackend.dao.CategoryDAOTest;
import com.ve3yn4uk.shoppingbackend.dao.ProductDAOTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by 8e3Yn4uK on 27.04.2019
 */

/**
 * Unit tests for shoppingbackend
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({CategoryDAOTest.class, ProductDAOTest.class})
public class TestRunner {
}
