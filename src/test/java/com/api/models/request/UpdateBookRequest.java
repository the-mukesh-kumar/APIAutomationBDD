package com.api.models.request;

import lombok.Getter;

@Getter
public class UpdateBookRequest {


       private  int  id;
          private String   title;
         private String   description;
         private int   pageCount;
       private     String  excerpt;
       private String     publishDate;


    public UpdateBookRequest() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "UpdateBookRequest{" +
                "id=" + id +
                ", title=" + title +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", excerpt='" + excerpt + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }
}
