package com.lboeri.boeriapi.dao.generator.entity;

import java.util.Date;

public class ApiConfig {
    private String id;

    private String apiname;

    private String apiip;

    private String apiport;

    private String apipath;

    private String queryparams;

    private String sqlparams;

    private Integer dsid;

    private String publishFlag;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String querySql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApiname() {
        return apiname;
    }

    public void setApiname(String apiname) {
        this.apiname = apiname == null ? null : apiname.trim();
    }

    public String getApiip() {
        return apiip;
    }

    public void setApiip(String apiip) {
        this.apiip = apiip == null ? null : apiip.trim();
    }

    public String getApiport() {
        return apiport;
    }

    public void setApiport(String apiport) {
        this.apiport = apiport == null ? null : apiport.trim();
    }

    public String getApipath() {
        return apipath;
    }

    public void setApipath(String apipath) {
        this.apipath = apipath == null ? null : apipath.trim();
    }

    public String getQueryparams() {
        return queryparams;
    }

    public void setQueryparams(String queryparams) {
        this.queryparams = queryparams == null ? null : queryparams.trim();
    }

    public String getSqlparams() {
        return sqlparams;
    }

    public void setSqlparams(String sqlparams) {
        this.sqlparams = sqlparams == null ? null : sqlparams.trim();
    }

    public Integer getDsid() {
        return dsid;
    }

    public void setDsid(Integer dsid) {
        this.dsid = dsid;
    }

    public String getPublishFlag() {
        return publishFlag;
    }

    public void setPublishFlag(String publishFlag) {
        this.publishFlag = publishFlag == null ? null : publishFlag.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql == null ? null : querySql.trim();
    }
}