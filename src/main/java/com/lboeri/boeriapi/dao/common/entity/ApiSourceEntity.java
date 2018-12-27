package com.lboeri.boeriapi.dao.common.entity;

import java.util.Date;

public class ApiSourceEntity {
    private String id;

    private Integer dsid;

    private String dbtype;

    private String driverclassname;

    private String url;

    private String username;

    private String password;

    private Integer initialsize;

    private Integer maxactive;

    private Integer minidle;

    private Integer maxwait;

    private String removeabandoned;

    private Integer removeabandonedtimeout;

    private Integer timebetweenevictionrunsmillis;

    private Integer minevictableidletimemillis;

    private String validationquery;

    private String testwhileidle;

    private String testonborrow;

    private String testonreturn;

    private String poolpreparedstatements;

    private Integer maxpoolprestatperconnsize;

    private String filters;

    private Integer hooktime;

    private String hooks;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getDsid() {
        return dsid;
    }

    public void setDsid(Integer dsid) {
        this.dsid = dsid;
    }

    public String getDbtype() {
        return dbtype;
    }

    public void setDbtype(String dbtype) {
        this.dbtype = dbtype == null ? null : dbtype.trim();
    }

    public String getDriverclassname() {
        return driverclassname;
    }

    public void setDriverclassname(String driverclassname) {
        this.driverclassname = driverclassname == null ? null : driverclassname.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getInitialsize() {
        return initialsize;
    }

    public void setInitialsize(Integer initialsize) {
        this.initialsize = initialsize;
    }

    public Integer getMaxactive() {
        return maxactive;
    }

    public void setMaxactive(Integer maxactive) {
        this.maxactive = maxactive;
    }

    public Integer getMinidle() {
        return minidle;
    }

    public void setMinidle(Integer minidle) {
        this.minidle = minidle;
    }

    public Integer getMaxwait() {
        return maxwait;
    }

    public void setMaxwait(Integer maxwait) {
        this.maxwait = maxwait;
    }

    public String getRemoveabandoned() {
        return removeabandoned;
    }

    public void setRemoveabandoned(String removeabandoned) {
        this.removeabandoned = removeabandoned == null ? null : removeabandoned.trim();
    }

    public Integer getRemoveabandonedtimeout() {
        return removeabandonedtimeout;
    }

    public void setRemoveabandonedtimeout(Integer removeabandonedtimeout) {
        this.removeabandonedtimeout = removeabandonedtimeout;
    }

    public Integer getTimebetweenevictionrunsmillis() {
        return timebetweenevictionrunsmillis;
    }

    public void setTimebetweenevictionrunsmillis(Integer timebetweenevictionrunsmillis) {
        this.timebetweenevictionrunsmillis = timebetweenevictionrunsmillis;
    }

    public Integer getMinevictableidletimemillis() {
        return minevictableidletimemillis;
    }

    public void setMinevictableidletimemillis(Integer minevictableidletimemillis) {
        this.minevictableidletimemillis = minevictableidletimemillis;
    }

    public String getValidationquery() {
        return validationquery;
    }

    public void setValidationquery(String validationquery) {
        this.validationquery = validationquery == null ? null : validationquery.trim();
    }

    public String getTestwhileidle() {
        return testwhileidle;
    }

    public void setTestwhileidle(String testwhileidle) {
        this.testwhileidle = testwhileidle == null ? null : testwhileidle.trim();
    }

    public String getTestonborrow() {
        return testonborrow;
    }

    public void setTestonborrow(String testonborrow) {
        this.testonborrow = testonborrow == null ? null : testonborrow.trim();
    }

    public String getTestonreturn() {
        return testonreturn;
    }

    public void setTestonreturn(String testonreturn) {
        this.testonreturn = testonreturn == null ? null : testonreturn.trim();
    }

    public String getPoolpreparedstatements() {
        return poolpreparedstatements;
    }

    public void setPoolpreparedstatements(String poolpreparedstatements) {
        this.poolpreparedstatements = poolpreparedstatements == null ? null : poolpreparedstatements.trim();
    }

    public Integer getMaxpoolprestatperconnsize() {
        return maxpoolprestatperconnsize;
    }

    public void setMaxpoolprestatperconnsize(Integer maxpoolprestatperconnsize) {
        this.maxpoolprestatperconnsize = maxpoolprestatperconnsize;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters == null ? null : filters.trim();
    }

    public Integer getHooktime() {
        return hooktime;
    }

    public void setHooktime(Integer hooktime) {
        this.hooktime = hooktime;
    }

    public String getHooks() {
        return hooks;
    }

    public void setHooks(String hooks) {
        this.hooks = hooks == null ? null : hooks.trim();
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
}