package com.capgemini.streams.codeStyles;

import com.capgemini.streams.common.logging.AbstractTest;
import com.capgemini.streams.service.impl.LibraryServiceIntegrationTestImpl;

import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class OneLineOneMeaningTest extends AbstractTest<OneLineOneMeaning> {

    @Override
    public OneLineOneMeaning setTarget() {
        return new OneLineOneMeaning(new LibraryServiceIntegrationTestImpl(), loggerMock);
    }

    @Override
    public void verifyGood(List<String> logs) {
        assertThat(logs, not(empty()));
    }

    @Override
    protected void verifyBad(List<String> logs) {
        assertThat(logs, not(empty()));
    }
}