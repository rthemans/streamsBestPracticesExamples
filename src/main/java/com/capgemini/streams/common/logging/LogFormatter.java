package com.capgemini.streams.common.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {

    public static final LogManager logManager = LogManager.getLogManager();
    private static final String format;
    static {
        String actualFormat;
        actualFormat = logManager.getProperty(LogFormatter.class.getCanonicalName() + ".format");
        if (actualFormat == null) {
            actualFormat = "";
        }
        format = actualFormat;
    }

    private final Date dat = new Date();

    @Override
    public synchronized String format(LogRecord record) {
        dat.setTime(record.getMillis());
        String source;
        if (record.getSourceClassName() != null) {
            source = record.getSourceClassName();
            if (record.getSourceMethodName() != null) {
                source += " " + record.getSourceMethodName();
            }
        } else {
            source = record.getLoggerName();
        }
        String message = formatMessage(record);
        String throwable = "";
        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            pw.println();
            record.getThrown().printStackTrace(pw);
            pw.close();
            throwable = sw.toString();
        }
        return String.format(format,
                dat,
                source,
                record.getLoggerName(),
                record.getLevel().getLocalizedName(),
                message,
                throwable);
    }
}
