package se.kth.infosys.tomcat;

import java.io.CharArrayWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.catalina.AccessLog;
import org.apache.catalina.valves.AbstractAccessLogValve;

/**
 * An extremely basic AccessLog which delegates to the java.util.logging framework and 
 * configuration with logging.properties to handle the log output.
 */
public class AccessLogValve extends AbstractAccessLogValve implements AccessLog {
    private static final Logger logger = Logger.getLogger("AccessLog");

    /**
     * {@inheritDoc}
     */
    @Override
    protected void log(CharArrayWriter message) {
        logger.log(Level.INFO, message.toString());
    }
}
