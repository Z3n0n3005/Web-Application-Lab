/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cn.techtutorial.cib.admin.model;

public class Movie {
    private int id;
    private String name;
    private String director;
    private String description;
    private String releaseDate;
    private String casts;
    private String posterName;
    private String trailerLink;
    private String duration;
    private String categoryId;

    public Movie() {
    }

    public Movie(int id, String name, String director, String description, String releaseDate, String casts, String posterName, String trailerLink, String duration, String categoryId) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.description = description;
        this.releaseDate = releaseDate;
        this.casts = casts;
        this.posterName = posterName;
        this.trailerLink = trailerLink;
        this.duration = duration;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCasts() {
        return casts;
    }

    public String getPosterName() {
        return posterName;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public String getDuration() {
        return duration;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", director=" + director + ", description=" + description + ", releaseDate=" + releaseDate + ", casts=" + casts + ", posterName=" + posterName + ", trailerLink=" + trailerLink + ", duration=" + duration + ", categoryId=" + categoryId + '}';
    }
    
    
}
