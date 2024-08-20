public abstract class Logger {
    final private int MAX_LOGS = 5;
    private static int numLogs;

    public abstract int getNumLogs();
    public abstract void log(String message);
    public abstract void clearLogs();
    public abstract void printLogs();
    public abstract void setLogLevel(int level);
    public abstract int getLogLevel();
    public abstract void setLogSize(int size);
    public abstract int getLogSize();
    public abstract void setLogName(String name);
    public abstract String getLogName();
    public abstract void setLogPath(String path);
    public abstract String getLogPath();
    public abstract void saveLogs();
}
