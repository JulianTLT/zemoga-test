package com.zemoga.zemogatest.dto;

public class PortfolioDto {
    private Integer idPortFolio;
    private String imageUrl;
    private String title;
    private String description;
    private String twitterUserName;

    public Integer getIdPortFolio() {
        return idPortFolio;
    }

    public void setIdPortFolio(Integer idPortFolio) {
        this.idPortFolio = idPortFolio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTwitterUserName() {
        return twitterUserName;
    }

    public void setTwitterUserName(String twitterUserName) {
        this.twitterUserName = twitterUserName;
    }

    @Override
    public String toString() {
        return "PortfolioDto{" +
                "idPortFolio=" + idPortFolio +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", twitterUserName='" + twitterUserName + '\'' +
                '}';
    }
}
