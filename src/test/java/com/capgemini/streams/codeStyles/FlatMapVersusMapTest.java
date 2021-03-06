package com.capgemini.streams.codeStyles;

import com.capgemini.streams.common.logging.AbstractTest;
import com.capgemini.streams.service.impl.LibraryServiceIntegrationTestImpl;

import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;


public class FlatMapVersusMapTest extends AbstractTest<FlatMapVersusMap> {

    @Override
    public FlatMapVersusMap setTarget() {
        return new FlatMapVersusMap(new LibraryServiceIntegrationTestImpl(), loggerMock);
    }

    @Override
    protected void verifyGood(List<String> logs) {
        assertThat(logs, not(empty()));
    }

    @Override
    protected void verifyBad(List<String> logs) {
        assertThat(logs, not(empty()));
    }
}