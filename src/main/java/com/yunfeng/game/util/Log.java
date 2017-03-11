package com.yunfeng.game.util;

import org.apache.log4j.Logger;

public class Log {

	private static Logger logTrace = Logger.getLogger("logTrace");
	private static Logger logDebug = Logger.getLogger("logDebug");
	private static Logger logInfo = Logger.getLogger("logInfo");
	private static Logger logError = Logger.getLogger("logError");

	public static final void t(Object obj) {
		logTrace.trace(obj);
	}

	public static final void d(Object obj) {
		logDebug.debug(obj);
	}

	public static final void i(Object obj) {
		logInfo.info(obj);
	}

	public static final void e(Object obj) {
		logError.error(obj);
	}

}
