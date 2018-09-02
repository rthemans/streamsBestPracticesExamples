package com.capgemini.streams.common.logging;

import com.capgemini.streams.common.BestPracticeExample;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public abstract class AbstractTest<TargetClass extends BestPracticeExample> {

    private final Logger LOGGER = Logger.getLogger(AbstractTest.class.getName());
    protected TargetClass target;
    List<String> logs;
    @Mock
    protected Logger loggerMock;

    public abstract TargetClass setTarget();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        target = setTarget();
        logs = new ArrayList<>();
        doAnswer(answer -> logs.add(answer.getArguments()[0].toString()))
                .when(loggerMock).info(anyString());
        doAnswer(answer -> logs.add(((Supplier)answer.getArguments()[0]).get().toString()))
                .when(loggerMock).info(any(Supplier.class));
        when(loggerMock.isLoggable(any(Level.class))).thenReturn(true);
    }

    @Test
    public void good() {
        target.good();
        logs.stream().forEach(LOGGER::info);
        verifyGood(logs);
    }

    public abstract void verifyGood(List<String> logs);

    @Test
    public void bad() {
        target.bad();
        logs.stream().forEach(LOGGER::info);
        verifyBad(logs);
    }

    protected abstract void verifyBad(List<String> logs);

    @Test
    public void compareGoodAndBad() {
        target.good();
        List<String> goodLogs = new ArrayList<>();
        goodLogs.addAll(logs);
        logs.clear();

        target.bad();
        List<String> badLogs = new ArrayList<>();
        badLogs.addAll(logs);

        assertThat(goodLogs, equalTo(badLogs));
    }
}
