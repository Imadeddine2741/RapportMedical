package org.creditMutuel.logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@Service
public class LoggerInFileImpl { 
	
	private static final Logger LOGGER = 
			(ch.qos.logback.classic.Logger) LoggerFactory.getLogger(LoggerInFileImpl.class);
	
	public static void ecritLogMessage(Level level, String message, Object[] attributs) {
		LoggerService.ecritLogMessage(LOGGER, level, message, attributs);
	}
}
