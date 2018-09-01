package com.capgemini.streams.common.logging;

import java.util.logging.Formatter;
import java.util.logging.*;

public class LogHandler extends StreamHandler {

    // Private method to configure a ConsoleHandler from LogManager
    // properties and/or default values as specified in the class
    // javadoc.
    private void configure() {
        LogManager manager = LogManager.getLogManager();
        String cname = getClass().getName();

        String levelProperty = manager.getProperty(cname + ".level");
        if (levelProperty != null) {
            setLevel(Level.parse(levelProperty));
        }
        String filterProperty = manager.getProperty(cname +".filter");
        if (filterProperty != null) {
            setFilter(getInstance(Filter.class, filterProperty));
        }

        String formatterProperty = manager.getProperty(cname + ".formatter");
        if (formatterProperty != null) {
            setFormatter(getInstance(Formatter.class, formatterProperty, new SimpleFormatter()));
        }
        try {
            String encodingProperty = manager.getProperty(cname + ".encoding");
            if (encodingProperty != null) {
                setEncoding(encodingProperty);
            } else {
                setEncoding(null);
            }
        } catch (Exception ex) {
            try {
                setEncoding(null);
            } catch (Exception ex2) {
                // doing a setEncoding with null should always work.
                // assert false;
            }
        }
    }

    private <T> T getInstance(Class<T> superType, String actualType) {
        return getInstance(superType, actualType, null);
    }

    private <T> T getInstance(Class<T> superType, String actualType, T defaultInstance) {
        if (actualType != null && !"".equals(actualType)) {
            try {
                Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(actualType);
                return (T) clazz.newInstance();
            } catch (Exception e) {
                // unable to load given instance, using the default instead
            }

        }
        return defaultInstance;
    }

    /**
     * Create a <tt>ConsoleHandler</tt> for <tt>System.err</tt>.
     * <p>
     * The <tt>ConsoleHandler</tt> is configured based on
     * <tt>LogManager</tt> properties (or their default values).
     *
     */
    public LogHandler() {
        configure();
        setOutputStream(System.out);
    }

    /**
     * Publish a <tt>LogRecord</tt>.
     * <p>
     * The logging request was made initially to a <tt>Logger</tt> object,
     * which initialized the <tt>LogRecord</tt> and forwarded it here.
     * <p>
     * @param  record  description of the log event. A null record is
     *                 silently ignored and is not published
     */
    @Override
    public void publish(LogRecord record) {
        super.publish(record);
        flush();
    }

    /**
     * Override <tt>StreamHandler.close</tt> to do a flush but not
     * to close the output stream.  That is, we do <b>not</b>
     * close <tt>System.err</tt>.
     */
    @Override
    public void close() {
        flush();
    }
}
