package rodrigo.provatecnica.codeheros.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("modified")
    private String modified;
    @SerializedName("thumbnail")
    private Thumbnail thumbnail;
    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("comics")
    private Comics comics;
    @SerializedName("series")
    private Series series;
    @SerializedName("stories")
    private Stories stories;
    @SerializedName("url")
    private UrlMarvel url;
    @SerializedName("events")
    private Events events;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Stories getStories() {
        return stories;
    }

    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public UrlMarvel getUrl() {
        return url;
    }

    public void setUrl(UrlMarvel url) {
        this.url = url;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }
}

