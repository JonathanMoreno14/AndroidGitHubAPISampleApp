package com.jm.jonathanmoreno.androidgithubapi.model;

public class GitHubInfo {

    private String name;
    private String description;
    private String language;
    private String updated;
    private String img_url;
    private String user;

    public GitHubInfo(){

    }

    public GitHubInfo(String name, String description, String language, String updated, String img_url, String user){
        this.name = name;
        this.description = description;
        this.language = language;
        this.updated = updated;
        this.img_url = img_url;
        this.user = user;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getUser() { return user; }

    public void setUser(String user) { this.user = user; }
}
