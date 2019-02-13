package cn.gzsendi.model.nagios;

/**
 * nagios主机表实体类
 * @Author Nacht
 * Created on 27/11/2018
 */
public class NagiosHost {

    private int hostId;

    private int instanceId;

    private int configType;

    private int hostObjectId;

    private String alias;

    private String displayName;

    private String address;

    private int importance;

    private int checkCommandObjectId;

    private String checkCommandArgs;

    private int eventhandlerCommandObjectId;

    private String eventhandlerCommandArgs;

    private int notificationTimeperiodObjectId;

    private int checkTimeperiodObjectId;

    private String failurePredictionOptions;

    private double checkInterval;

    private double retryInterval;

    private int maxCheckAttempts;

    private double firstNotificationDelay;

    private double notificationInterval;

    private int notifyOnDown;

    private int notifyOnUnreachable;

    private int notifyOnRecovery;

    private int notifyOnFlapping;

    private int notifyOnDowntime;

    private int stalkOnUp;

    private int stalkOnDown;

    private int stalkOnUnreachable;

    private int flapDetectionEnabled;

    private int flapDetectionOnUp;

    private int flapDetectionOnDown;

    private int flapDetectionOnUnreachable;

    private double lowFlapThreshold;

    private double highFlapThreshold;

    private int processPerformanceData;

    private int freshnessChecksEnabled;

    private int freshnessThreshold;

    private int passiveChecksEnabled;

    private int eventHandlerEnabled;

    private int activeChecksEnabled;

    private int retainStatusInformation;

    private int retainNonstatusInformation;

    private int notificationsEnabled;

    private int obsessOverHost;

    private int failurePredictionEnabled;

    private String notes;

    private String notesUrl;

    private String actionUrl;

    private String iconImage;

    private String iconImageAlt;

    private String vrmlImage;

    private String statusmapImage;

    private int have2dCoords;

    private int x2d;

    private int y2d;

    private int have3dCoords;

    private double x3d;

    private double y3d;

    private double z3d;

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public int getConfigType() {
        return configType;
    }

    public void setConfigType(int configType) {
        this.configType = configType;
    }

    public int getHostObjectId() {
        return hostObjectId;
    }

    public void setHostObjectId(int hostObjectId) {
        this.hostObjectId = hostObjectId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getCheckCommandObjectId() {
        return checkCommandObjectId;
    }

    public void setCheckCommandObjectId(int checkCommandObjectId) {
        this.checkCommandObjectId = checkCommandObjectId;
    }

    public String getCheckCommandArgs() {
        return checkCommandArgs;
    }

    public void setCheckCommandArgs(String checkCommandArgs) {
        this.checkCommandArgs = checkCommandArgs;
    }

    public int getEventhandlerCommandObjectId() {
        return eventhandlerCommandObjectId;
    }

    public void setEventhandlerCommandObjectId(int eventhandlerCommandObjectId) {
        this.eventhandlerCommandObjectId = eventhandlerCommandObjectId;
    }

    public String getEventhandlerCommandArgs() {
        return eventhandlerCommandArgs;
    }

    public void setEventhandlerCommandArgs(String eventhandlerCommandArgs) {
        this.eventhandlerCommandArgs = eventhandlerCommandArgs;
    }

    public int getNotificationTimeperiodObjectId() {
        return notificationTimeperiodObjectId;
    }

    public void setNotificationTimeperiodObjectId(int notificationTimeperiodObjectId) {
        this.notificationTimeperiodObjectId = notificationTimeperiodObjectId;
    }

    public int getCheckTimeperiodObjectId() {
        return checkTimeperiodObjectId;
    }

    public void setCheckTimeperiodObjectId(int checkTimeperiodObjectId) {
        this.checkTimeperiodObjectId = checkTimeperiodObjectId;
    }

    public String getFailurePredictionOptions() {
        return failurePredictionOptions;
    }

    public void setFailurePredictionOptions(String failurePredictionOptions) {
        this.failurePredictionOptions = failurePredictionOptions;
    }

    public double getCheckInterval() {
        return checkInterval;
    }

    public void setCheckInterval(double checkInterval) {
        this.checkInterval = checkInterval;
    }

    public double getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(double retryInterval) {
        this.retryInterval = retryInterval;
    }

    public int getMaxCheckAttempts() {
        return maxCheckAttempts;
    }

    public void setMaxCheckAttempts(int maxCheckAttempts) {
        this.maxCheckAttempts = maxCheckAttempts;
    }

    public double getFirstNotificationDelay() {
        return firstNotificationDelay;
    }

    public void setFirstNotificationDelay(double firstNotificationDelay) {
        this.firstNotificationDelay = firstNotificationDelay;
    }

    public double getNotificationInterval() {
        return notificationInterval;
    }

    public void setNotificationInterval(double notificationInterval) {
        this.notificationInterval = notificationInterval;
    }

    public int getNotifyOnDown() {
        return notifyOnDown;
    }

    public void setNotifyOnDown(int notifyOnDown) {
        this.notifyOnDown = notifyOnDown;
    }

    public int getNotifyOnUnreachable() {
        return notifyOnUnreachable;
    }

    public void setNotifyOnUnreachable(int notifyOnUnreachable) {
        this.notifyOnUnreachable = notifyOnUnreachable;
    }

    public int getNotifyOnRecovery() {
        return notifyOnRecovery;
    }

    public void setNotifyOnRecovery(int notifyOnRecovery) {
        this.notifyOnRecovery = notifyOnRecovery;
    }

    public int getNotifyOnFlapping() {
        return notifyOnFlapping;
    }

    public void setNotifyOnFlapping(int notifyOnFlapping) {
        this.notifyOnFlapping = notifyOnFlapping;
    }

    public int getNotifyOnDowntime() {
        return notifyOnDowntime;
    }

    public void setNotifyOnDowntime(int notifyOnDowntime) {
        this.notifyOnDowntime = notifyOnDowntime;
    }

    public int getStalkOnUp() {
        return stalkOnUp;
    }

    public void setStalkOnUp(int stalkOnUp) {
        this.stalkOnUp = stalkOnUp;
    }

    public int getStalkOnDown() {
        return stalkOnDown;
    }

    public void setStalkOnDown(int stalkOnDown) {
        this.stalkOnDown = stalkOnDown;
    }

    public int getStalkOnUnreachable() {
        return stalkOnUnreachable;
    }

    public void setStalkOnUnreachable(int stalkOnUnreachable) {
        this.stalkOnUnreachable = stalkOnUnreachable;
    }

    public int getFlapDetectionEnabled() {
        return flapDetectionEnabled;
    }

    public void setFlapDetectionEnabled(int flapDetectionEnabled) {
        this.flapDetectionEnabled = flapDetectionEnabled;
    }

    public int getFlapDetectionOnUp() {
        return flapDetectionOnUp;
    }

    public void setFlapDetectionOnUp(int flapDetectionOnUp) {
        this.flapDetectionOnUp = flapDetectionOnUp;
    }

    public int getFlapDetectionOnDown() {
        return flapDetectionOnDown;
    }

    public void setFlapDetectionOnDown(int flapDetectionOnDown) {
        this.flapDetectionOnDown = flapDetectionOnDown;
    }

    public int getFlapDetectionOnUnreachable() {
        return flapDetectionOnUnreachable;
    }

    public void setFlapDetectionOnUnreachable(int flapDetectionOnUnreachable) {
        this.flapDetectionOnUnreachable = flapDetectionOnUnreachable;
    }

    public double getLowFlapThreshold() {
        return lowFlapThreshold;
    }

    public void setLowFlapThreshold(double lowFlapThreshold) {
        this.lowFlapThreshold = lowFlapThreshold;
    }

    public double getHighFlapThreshold() {
        return highFlapThreshold;
    }

    public void setHighFlapThreshold(double highFlapThreshold) {
        this.highFlapThreshold = highFlapThreshold;
    }

    public int getProcessPerformanceData() {
        return processPerformanceData;
    }

    public void setProcessPerformanceData(int processPerformanceData) {
        this.processPerformanceData = processPerformanceData;
    }

    public int getFreshnessChecksEnabled() {
        return freshnessChecksEnabled;
    }

    public void setFreshnessChecksEnabled(int freshnessChecksEnabled) {
        this.freshnessChecksEnabled = freshnessChecksEnabled;
    }

    public int getFreshnessThreshold() {
        return freshnessThreshold;
    }

    public void setFreshnessThreshold(int freshnessThreshold) {
        this.freshnessThreshold = freshnessThreshold;
    }

    public int getPassiveChecksEnabled() {
        return passiveChecksEnabled;
    }

    public void setPassiveChecksEnabled(int passiveChecksEnabled) {
        this.passiveChecksEnabled = passiveChecksEnabled;
    }

    public int getEventHandlerEnabled() {
        return eventHandlerEnabled;
    }

    public void setEventHandlerEnabled(int eventHandlerEnabled) {
        this.eventHandlerEnabled = eventHandlerEnabled;
    }

    public int getActiveChecksEnabled() {
        return activeChecksEnabled;
    }

    public void setActiveChecksEnabled(int activeChecksEnabled) {
        this.activeChecksEnabled = activeChecksEnabled;
    }

    public int getRetainStatusInformation() {
        return retainStatusInformation;
    }

    public void setRetainStatusInformation(int retainStatusInformation) {
        this.retainStatusInformation = retainStatusInformation;
    }

    public int getRetainNonstatusInformation() {
        return retainNonstatusInformation;
    }

    public void setRetainNonstatusInformation(int retainNonstatusInformation) {
        this.retainNonstatusInformation = retainNonstatusInformation;
    }

    public int getNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(int notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public int getObsessOverHost() {
        return obsessOverHost;
    }

    public void setObsessOverHost(int obsessOverHost) {
        this.obsessOverHost = obsessOverHost;
    }

    public int getFailurePredictionEnabled() {
        return failurePredictionEnabled;
    }

    public void setFailurePredictionEnabled(int failurePredictionEnabled) {
        this.failurePredictionEnabled = failurePredictionEnabled;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotesUrl() {
        return notesUrl;
    }

    public void setNotesUrl(String notesUrl) {
        this.notesUrl = notesUrl;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    public String getIconImageAlt() {
        return iconImageAlt;
    }

    public void setIconImageAlt(String iconImageAlt) {
        this.iconImageAlt = iconImageAlt;
    }

    public String getVrmlImage() {
        return vrmlImage;
    }

    public void setVrmlImage(String vrmlImage) {
        this.vrmlImage = vrmlImage;
    }

    public String getStatusmapImage() {
        return statusmapImage;
    }

    public void setStatusmapImage(String statusmapImage) {
        this.statusmapImage = statusmapImage;
    }

    public int getHave2dCoords() {
        return have2dCoords;
    }

    public void setHave2dCoords(int have2dCoords) {
        this.have2dCoords = have2dCoords;
    }

    public int getX2d() {
        return x2d;
    }

    public void setX2d(int x2d) {
        this.x2d = x2d;
    }

    public int getY2d() {
        return y2d;
    }

    public void setY2d(int y2d) {
        this.y2d = y2d;
    }

    public int getHave3dCoords() {
        return have3dCoords;
    }

    public void setHave3dCoords(int have3dCoords) {
        this.have3dCoords = have3dCoords;
    }

    public double getX3d() {
        return x3d;
    }

    public void setX3d(double x3d) {
        this.x3d = x3d;
    }

    public double getY3d() {
        return y3d;
    }

    public void setY3d(double y3d) {
        this.y3d = y3d;
    }

    public double getZ3d() {
        return z3d;
    }

    public void setZ3d(double z3d) {
        this.z3d = z3d;
    }

    @Override
    public String toString() {
        return "NagiosHost{" +
                "hostId=" + hostId +
                ", instanceId=" + instanceId +
                ", configType=" + configType +
                ", hostObjectId=" + hostObjectId +
                ", alias='" + alias + '\'' +
                ", displayName='" + displayName + '\'' +
                ", address='" + address + '\'' +
                ", importance=" + importance +
                ", checkCommandObjectId=" + checkCommandObjectId +
                ", checkCommandArgs='" + checkCommandArgs + '\'' +
                ", eventhandlerCommandObjectId=" + eventhandlerCommandObjectId +
                ", eventhandlerCommandArgs='" + eventhandlerCommandArgs + '\'' +
                ", notificationTimeperiodObjectId=" + notificationTimeperiodObjectId +
                ", checkTimeperiodObjectId=" + checkTimeperiodObjectId +
                ", failurePredictionOptions='" + failurePredictionOptions + '\'' +
                ", checkInterval=" + checkInterval +
                ", retryInterval=" + retryInterval +
                ", maxCheckAttempts=" + maxCheckAttempts +
                ", firstNotificationDelay=" + firstNotificationDelay +
                ", notificationInterval=" + notificationInterval +
                ", notifyOnDown=" + notifyOnDown +
                ", notifyOnUnreachable=" + notifyOnUnreachable +
                ", notifyOnRecovery=" + notifyOnRecovery +
                ", notifyOnFlapping=" + notifyOnFlapping +
                ", notifyOnDowntime=" + notifyOnDowntime +
                ", stalkOnUp=" + stalkOnUp +
                ", stalkOnDown=" + stalkOnDown +
                ", stalkOnUnreachable=" + stalkOnUnreachable +
                ", flapDetectionEnabled=" + flapDetectionEnabled +
                ", flapDetectionOnUp=" + flapDetectionOnUp +
                ", flapDetectionOnDown=" + flapDetectionOnDown +
                ", flapDetectionOnUnreachable=" + flapDetectionOnUnreachable +
                ", lowFlapThreshold=" + lowFlapThreshold +
                ", highFlapThreshold=" + highFlapThreshold +
                ", processPerformanceData=" + processPerformanceData +
                ", freshnessChecksEnabled=" + freshnessChecksEnabled +
                ", freshnessThreshold=" + freshnessThreshold +
                ", passiveChecksEnabled=" + passiveChecksEnabled +
                ", eventHandlerEnabled=" + eventHandlerEnabled +
                ", activeChecksEnabled=" + activeChecksEnabled +
                ", retainStatusInformation=" + retainStatusInformation +
                ", retainNonstatusInformation=" + retainNonstatusInformation +
                ", notificationsEnabled=" + notificationsEnabled +
                ", obsessOverHost=" + obsessOverHost +
                ", failurePredictionEnabled=" + failurePredictionEnabled +
                ", notes='" + notes + '\'' +
                ", notesUrl='" + notesUrl + '\'' +
                ", actionUrl='" + actionUrl + '\'' +
                ", iconImage='" + iconImage + '\'' +
                ", iconImageAlt='" + iconImageAlt + '\'' +
                ", vrmlImage='" + vrmlImage + '\'' +
                ", statusmapImage='" + statusmapImage + '\'' +
                ", have2dCoords=" + have2dCoords +
                ", x2d=" + x2d +
                ", y2d=" + y2d +
                ", have3dCoords=" + have3dCoords +
                ", x3d=" + x3d +
                ", y3d=" + y3d +
                ", z3d=" + z3d +
                '}';
    }
}
