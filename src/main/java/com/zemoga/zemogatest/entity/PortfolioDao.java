package com.zemoga.zemogatest.entity;

import javax.persistence.*;

@Entity
@Table(name ="portfolio")
public class PortfolioDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPORTFOLIO")
    private Integer idPortfolio;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TWITTER_USER_NAME")
    private String twitterUserName;

    public Integer getIdPortfolio() {
        return idPortfolio;
    }

    public void setIdPortfolio(Integer idPortfolio) {
        this.idPortfolio = idPortfolio;
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
        return "PortfolioDao{" +
                "idPortfolio=" + idPortfolio +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", twitterUserName='" + twitterUserName + '\'' +
                '}';
    }
}
