package com.capgemini.streams.codeStyles;

import com.capgemini.streams.common.logging.AbstractTest;
import com.capgemini.streams.service.impl.LibraryServiceIntegrationTestImpl;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class BracesAreEvilsTest extends AbstractTest<BracesAreEvils> {

    @Override
    public BracesAreEvils setTarget() {
        return new BracesAreEvils(new LibraryServiceIntegrationTestImpl(), loggerMock);
    }

    @Override
    protected void verifyGood(List<String> logs) {
        assertThat(logs, not(empty()));
    }

    @Override
    protected void verifyBad(List<String> logs) {
        assertThat(logs, not(empty()));
    }

    @Test
    public void old() {
        target.old();
    }
}