package com.lboeri.boeriapi.dao.generator.entity;

import java.util.Date;

public class ApiConfig {
    private String apiId;

    private String apiName;

    private String apiIp;

    private String apiPort;

    private String apiParh;

    private String queryParams;

    private String sqlParams;

    private String dsName;

    private String publishFlag;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private String remark;

    private String apiStatus;

    private String excSql;

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId == null ? null : apiId.trim();
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getApiIp() {
        return apiIp;
    }

    public void setApiIp(String apiIp) {
        this.apiIp = apiIp == null ? null : apiIp.trim();
    }

    public String getApiPort() {
        return apiPort;
    }

    public void setApiPort(String apiPort) {
        this.apiPort = apiPort == null ? null : apiPort.trim();
    }

    public String getApiParh() {
        return apiParh;
    }

    public void setApiParh(String apiParh) {
        this.apiParh = apiParh == null ? null : apiParh.trim();
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams == null ? null : queryParams.trim();
    }

    public String getSqlParams() {
        return sqlParams;
    }

    public void setSqlParams(String sqlParams) {
        this.sqlParams = sqlParams == null ? null : sqlParams.trim();
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName == null ? null : dsName.trim();
    }

    public String getPublishFlag() {
        return publishFlag;
    }

    public void setPublishFlag(String publishFlag) {
        this.publishFlag = publishFlag == null ? null : publishFlag.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus == null ? null : apiStatus.trim();
    }

    public String getExcSql() {
        return excSql;
    }

    public void setExcSql(String excSql) {
        this.excSql = excSql == null ? null : excSql.trim();
    }
}