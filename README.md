# tomcat-access-logging

A very simple org.apache.catalina.AccessLog which writes access log entries to the regular log
framework java.util.logging. The standard access log valves in Tomcat uses file logging only.
Using this log valve the handling of the log is delegated to the logging framework and configuration
in logging.properties.

We use it together with https://github.com/KTH/java-logging-bunyan in order to log from Tomcat
to stdout in a node-bunyan format from Docker containers running Tomcat.

The log valve is built with and for Tomcat 9.x. Should work similarly with 8.x but this is not tested.

# Building

Regular build with maven. The release profile (`-Prelease`) will deploy and release to maven central
provided that additional configuration of the environment for signing is done. Prebuilt binary can 
be found in maven central and included as a maven dependency:

```
<dependencies>
  <dependency>
    <groupId>se.kth.infosys.tomcat</groupId>
    <artifactId>tomcat-access-logging</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies
```

# Use with Tomcat

Add the jar-file to the CATALINA_HOME/lib folder and configure it as a log valve in server.xml:

```
  <Valve className="se.kth.infosys.tomcat.AccessLogValve" 
         pattern="%h %l %u &quot;%r&quot; %s %b" />
```
