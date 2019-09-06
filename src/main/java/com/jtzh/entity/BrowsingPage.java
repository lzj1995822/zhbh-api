package com.jtzh.entity;

public class BrowsingPage {

    int newsId;
    int pageSize;
    int start;
    private String name;

    public Integer getNewsId() {
        return newsId;
    }
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getStart() {
        return start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
