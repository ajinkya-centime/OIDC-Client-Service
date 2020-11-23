package com.centime.startup;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract definition of IntegrationTest.
 */
@SpringBootTest
@Transactional
public abstract class AbstractTransactionalIntegrationTest
    extends AbstractTransactionalTestNGSpringContextTests {
}
