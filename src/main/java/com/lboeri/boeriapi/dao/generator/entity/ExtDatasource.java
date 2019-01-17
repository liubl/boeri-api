package com.lboeri.boeriapi.dao.generator.entity;

public class ExtDatasource {
    private String dsName;

    private String dsCnName;

    private String dbType;

    private String dsType;

    private String driverClassName;

    private String dsUrl;

    private String userName;

    private String userPassword;

    private String iniSize;

    private String minIdle;

    private String maxIdle;

    private String maxActive;

    private String maxWait;

    private String removeAbandoned;

    private String removeAbandonedTimeout;

    private String timeBwtEvnMillis;

    private String testWhileIdle;

    private String validationQuery;

    private String dsStatus;

    private String createTime;

    private String createUser;

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName == null ? null : dsName.trim();
    }

    public String getDsCnName() {
        return dsCnName;
    }

    public void setDsCnName(String dsCnName) {
        this.dsCnName = dsCnName == null ? null : dsCnName.trim();
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType == null ? null : dbType.trim();
    }

    public String getDsType() {
        return dsType;
    }

    public void setDsType(String dsType) {
        this.dsType = dsType == null ? null : dsType.trim();
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName == null ? null : driverClassName.trim();
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl == null ? null : dsUrl.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getIniSize() {
        return iniSize;
    }

    public void setIniSize(String iniSize) {
        this.iniSize = iniSize == null ? null : iniSize.trim();
    }

    public String getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(String minIdle) {
        this.minIdle = minIdle == null ? null : minIdle.trim();
    }

    public String getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(String maxIdle) {
        this.maxIdle = maxIdle == null ? null : maxIdle.trim();
    }

    public String getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(String maxActive) {
        this.maxActive = maxActive == null ? null : maxActive.trim();
    }

    public String getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(String maxWait) {
        this.maxWait = maxWait == null ? null : maxWait.trim();
    }

    public String getRemoveAbandoned() {
        return removeAbandoned;
    }

    public void setRemoveAbandoned(String removeAbandoned) {
        this.removeAbandoned = removeAbandoned == null ? null : removeAbandoned.trim();
    }

    public String getRemoveAbandonedTimeout() {
        return removeAbandonedTimeout;
    }

    public void setRemoveAbandonedTimeout(String removeAbandonedTimeout) {
        this.removeAbandonedTimeout = removeAbandonedTimeout == null ? null : removeAbandonedTimeout.trim();
    }

    public String getTimeBwtEvnMillis() {
        return timeBwtEvnMillis;
    }

    public void setTimeBwtEvnMillis(String timeBwtEvnMillis) {
        this.timeBwtEvnMillis = timeBwtEvnMillis == null ? null : timeBwtEvnMillis.trim();
    }

    public String getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(String testWhileIdle) {
        this.testWhileIdle = testWhileIdle == null ? null : testWhileIdle.trim();
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery == null ? null : validationQuery.trim();
    }

    public String getDsStatus() {
        return dsStatus;
    }

    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus == null ? null : dsStatus.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }
}