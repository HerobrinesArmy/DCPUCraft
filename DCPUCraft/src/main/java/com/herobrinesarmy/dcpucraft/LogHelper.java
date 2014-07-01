package com.herobrinesarmy.dcpucraft;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogHelper {
private static Logger logger = Logger.getLogger("DCPU");

public static void init() {
//logger.setParent(FMLLog.getLogger());
}

public static void log(Level logLevel, String message) {
//logger.log(logLevel, message);
}
}