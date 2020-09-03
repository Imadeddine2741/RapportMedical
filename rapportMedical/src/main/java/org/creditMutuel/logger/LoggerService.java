package org.creditMutuel.logger;

import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;


@Service
public interface LoggerService {

	public static void setLevelLoggerService(Logger logger, Level level) {
		logger.setLevel(level);
	}
	
	public static String getLevelLoggerService(Logger logger) {
		
		Level level = logger.getLevel();
		String msg = "Logger " + logger.getName()+ ", niveau de log : " + level;
		logger.info(msg);
		if (level == null) {
			msg = "Si LOGGER.getLevel() est null, le niveau de log est INFO";
			logger.info(msg);
		}
		return msg;
	}
	
	public static void ecritLogMessage(Logger logger, Level level, String message, Object[] attributs) {
		ecritLog(logger, level, message, attributs);
	}
	
	public static void ecritLogException() {
		
	}
	
	public static void ecritLog(Logger logger, Level level, String message, Object[] attributs) {
		
		String strLevel;
		
		if (level == null) {
			strLevel = "INFO";
		} else {
			strLevel = level.toString();
		}
		
		switch(strLevel) {
		    case "TRACE": {ecritLogTrace(logger, message, attributs); break;}
		    case "DEBUG": {ecritLogDebug(logger, message, attributs); break;}
		    case "INFO": {ecritLogInfo(logger, message, attributs); break;}
		    case "WARN": {ecritLogWarn(logger, message, attributs); break;}
		    case "ERROR": {ecritLogError(logger, message, attributs); break;}
		    default: ecritLogInfo(logger, message, attributs);
		}
	}
	
	public static void ecritLogTrace(Logger logger, String message, Object[] attributs) {
		if(logger.isTraceEnabled()) { 
			logger.trace(message, attributs);
		}
	}
	
	public static void ecritLogDebug(Logger logger, String message, Object[] attributs) {
		if(logger.isDebugEnabled()) { 
			logger.debug(message, attributs);
		}
	}
	
	public static void ecritLogInfo(Logger logger, String message, Object[] attributs) {
		if(logger.isInfoEnabled()) { 
			logger.info(message, attributs);
		}
	}
	
	public static void ecritLogWarn(Logger logger, String message, Object[] attributs) {
		if(logger.isWarnEnabled()) { 
			logger.warn(message, attributs);
		}
	}
	
	public static void ecritLogError(Logger logger, String message, Object[] attributs) {
		if(logger.isErrorEnabled()) { 
			logger.error(message, attributs);
		}
	}
}
