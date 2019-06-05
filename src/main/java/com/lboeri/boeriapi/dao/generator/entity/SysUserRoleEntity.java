package com.lboeri.boeriapi.dao.generator.entity;

public class SysUserRoleEntity {
    private Integer id;

    private String userCode;

    private String roleCode;

    private String roleDefaul;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleDefaul() {
        return roleDefaul;
    }

    public void setRoleDefaul(String roleDefaul) {
        this.roleDefaul = roleDefaul == null ? null : roleDefaul.trim();
    }
}