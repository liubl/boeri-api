package com.lboeri.boeriapi.dao.generator.entity;

import java.util.Date;

public class SysFuncNodeEntity {
    private Integer id;

    private String funcNodeCode;

    private String funcNodeName;

    private String parentCode;

    private String toSystem;

    private String funcType;

    private Integer orderId;

    private String html;

    private String rel;

    private String isRoot;

    private String external;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private String isUsable;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuncNodeCode() {
        return funcNodeCode;
    }

    public void setFuncNodeCode(String funcNodeCode) {
        this.funcNodeCode = funcNodeCode == null ? null : funcNodeCode.trim();
    }

    public String getFuncNodeName() {
        return funcNodeName;
    }

    public void setFuncNodeName(String funcNodeName) {
        this.funcNodeName = funcNodeName == null ? null : funcNodeName.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getToSystem() {
        return toSystem;
    }

    public void setToSystem(String toSystem) {
        this.toSystem = toSystem == null ? null : toSystem.trim();
    }

    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType == null ? null : funcType.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel == null ? null : rel.trim();
    }

    public String getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(String isRoot) {
        this.isRoot = isRoot == null ? null : isRoot.trim();
    }

    public String getExternal() {
        return external;
    }

    public void setExternal(String external) {
        this.external = external == null ? null : external.trim();
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

    public String getIsUsable() {
        return isUsable;
    }

    public void setIsUsable(String isUsable) {
        this.isUsable = isUsable == null ? null : isUsable.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}