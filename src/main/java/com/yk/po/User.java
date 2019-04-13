package com.yk.po;

public class User {
    private Integer uid;

    private String uname;

    private String utext;

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

    public String getUtext() {
        return utext;
    }

    public void setUtext(String utext) {
        this.utext = utext == null ? null : utext.trim();
    }

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", utext=" + utext + "]";
	}
}