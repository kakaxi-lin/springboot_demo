package com.yk.po;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class User {
    private Integer uid;
    
    @Range(min=5,max=10,message="年龄范围是5到10")
    private Integer age;
    
    @NotNull(message="姓名不能为空")
    @Size(min=1,max=10,message="姓名的长度为1到10")
    private String uname;
    
    @NotNull(message="密码不能为空")
    @Size(min=1,max=15,message="密码的长度为1到15")
    private String upwd;

    @Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + "]";
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }
}