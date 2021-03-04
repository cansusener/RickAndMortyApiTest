package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Base {
    @JsonProperty("name")
    protected String name;
    @JsonProperty("url")
    protected String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
