package com.orangehrm.demo.utilities;

import org.apache.log4j.PropertyConfigurator;


final public class Logger implements LogFilePaths {
	
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("Log");
	
	static{
		PropertyConfigurator.configure(LogFilePaths.log4jPropPath);
	}

	private Logger(){
		
	}
	
@SuppressWarnings("rawtypes")
public static void logError(Class className,String message){
	log(LogLevel.Error,className,message,null);
}

@SuppressWarnings("rawtypes")
public static void logWarn(Class className,String message){
	log(LogLevel.Warn,className,message,null);
}

@SuppressWarnings("rawtypes")
public static void logInfo(Class className,String message){
	log(LogLevel.Info,className,message,null);
}

@SuppressWarnings("rawtypes")
public static void logFatal(Class className,String message){
	log(LogLevel.Fatal,className,message,null);
}

@SuppressWarnings("rawtypes")
public static void logDebug(Class className,String message){
	log(LogLevel.Debug,className,message,null);
}

//overloaded methods
@SuppressWarnings("rawtypes")
public static void logError(Class className,String message,Throwable exceptionObj){
	log(LogLevel.Error,className,message,exceptionObj);
}

@SuppressWarnings("rawtypes")
public static void logWarn(Class className,String message,Throwable exceptionObj){
	log(LogLevel.Warn,className,message,exceptionObj);
}

@SuppressWarnings("rawtypes")
public static void logInfo(Class className,String message,Throwable exceptionObj){
	log(LogLevel.Info,className,message,exceptionObj);
}

@SuppressWarnings("rawtypes")
public static void logFatal(Class className,String message,Throwable exceptionObj){
	log(LogLevel.Fatal,className,message,exceptionObj);
}

@SuppressWarnings("rawtypes")
public static void logDebug(Class className,String message,Throwable exceptionObj){
	log(LogLevel.Debug,className,message,exceptionObj);
}


private static void log(LogLevel level,Class className,String msg,Throwable exceptionObj){
	String message = String.format("[%s] : %s", className,msg);
	switch(level){
	case Info:
		logger.info(message, exceptionObj);
		break;
	case Warn:
		logger.warn(message,exceptionObj);
		break;
	case Error:
		logger.error(message, exceptionObj);
		break;
	case Fatal:
		logger.fatal(message, exceptionObj);
		break;
	default:
	case Debug:
	  logger.debug(message, exceptionObj);
	
	}//end of switch
		
	
}
	
}//end of class
