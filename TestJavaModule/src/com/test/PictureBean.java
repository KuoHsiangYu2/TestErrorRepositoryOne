package com.test;

import java.io.Serializable;

public class PictureBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int key;
    private String url;

    public PictureBean() {
        super();
    }

    public PictureBean(int _key, String _url) {
        super();
        this.key = _key;
        this.url = _url;
    }

    @Override
    public String toString() {
        return "PictureBean [key=" + key + ", url=" + url + "]";
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
