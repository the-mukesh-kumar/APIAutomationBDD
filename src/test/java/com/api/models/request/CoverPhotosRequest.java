package com.api.models.request;

public class CoverPhotosRequest {
    private int id;
    private int idBook;
    private String url;

    public CoverPhotosRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String   toString() {
        return "CoverPhotosRequest{" +
                "id=" + id +
                ", idBook=" + idBook +
                ", url='" + url + '\'' +
                '}';
    }
}
