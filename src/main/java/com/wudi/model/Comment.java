package com.wudi.model;

import java.util.Date;

public class Comment {
    private Integer bookid;

    private Integer userid;

    private Date datetime;

    private String content;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "bookid=" + bookid +
                ", userid=" + userid +
                ", datetime=" + datetime +
                ", content='" + content + '\'' +
                '}';
    }
}