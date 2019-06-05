package com.lboeri.boeriapi.dao.generator.entity;

import java.util.Date;

public class SysRoleEntity {
    private Integer id;

    private String roleCode;

    private String roleName;

    private String roleDesc;

    private String funcNodeCode;

    private String roleInherent;

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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public String getFuncNodeCode() {
        return funcNodeCode;
    }

    public void setFuncNodeCode(String funcNodeCode) {
        this.funcNodeCode = funcNodeCode == null ? null : funcNodeCode.trim();
    }

    public String getRoleInherent() {
        return roleInherent;
    }

    public void setRoleInherent(String roleInherent) {
        this.roleInherent = roleInherent == null ? null : roleInherent.trim();
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