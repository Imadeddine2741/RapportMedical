package org.creditMutuel.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.creditMutuel.logger.LoggerInFileImpl;
import org.creditMutuel.logger.LoggerService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@ResponseStatus ( value= HttpStatus.NOT_FOUND)
public class MyException extends Exception {

	private static final long serialVersionUID =1L;

	@SuppressWarnings("unused")
	private static final Logger LOGGER = 
	(ch.qos.logback.classic.Logger) LoggerFactory.getLogger(MyException.class);

	public MyException (Logger Logger,String message) {
		// Spring Boot by default provides /error mapping where 
		// all exception/errors are forwarded. In case of Thymeleaf 
		// (or other template engines), we can map errors to a global custom 
		// template file by name 'error' under src/main/resources/templates/ directory.		
		super(message);
		LoggerService.ecritLogMessage(LOGGER, Level.ERROR, "Exception controlée de type MyException levée!", (Object[])null);
		LoggerService.ecritLogMessage(Logger, Level.ERROR, message, (Object[])null);
		LoggerInFileImpl.ecritLogMessage(Level.ERROR, message, (Object[])null);
		StringWriter stringWriter = new StringWriter();
		this.printStackTrace(new PrintWriter(stringWriter));
		LoggerInFileImpl.ecritLogMessage(Level.ERROR, stringWriter.toString(), (Object[])null);
	}

}
