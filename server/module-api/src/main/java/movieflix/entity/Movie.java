package movieflix.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Ankan on 7/23/2017.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "SELECT m from  Movie  m ORDER BY m.imdbId ASC")
})
public class Movie {
    @Id
    private  String imdbId;
    @NotNull
    private String title;
    private int year;
    private String rated;
    @Temporal(TemporalType.DATE)
    private Date released;
    private String runtime;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Movie_Genre", joinColumns=@JoinColumn(name="imdbId"), inverseJoinColumns=@JoinColumn(name="genreID"))
    private List<Genre> genre;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Movie_Director", joinColumns=@JoinColumn(name="imdbId"), inverseJoinColumns=@JoinColumn(name="directorID"))
    private List<Director> director;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Movie_Writer", joinColumns=@JoinColumn(name="imdbId"), inverseJoinColumns=@JoinColumn(name="writerID"))
    private List<Writer> writer;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Movie_Actor", joinColumns=@JoinColumn(name="imdbId"), inverseJoinColumns=@JoinColumn(name="actorID"))
    private List<Actor> actor;
    private String plot;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Movie_Language", joinColumns=@JoinColumn(name="imdbId"), inverseJoinColumns=@JoinColumn(name="langID"))
    private List<Language> language;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Movie_Country", joinColumns=@JoinColumn(name="imdbId"), inverseJoinColumns=@JoinColumn(name="countryID"))
    private List<Country> country;
    private String awards;
    private String poster;
    private int metaScore;
    private double imdbRating;
    private int imdbVotes;
    private double userRating;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(name="Movie_Type", joinColumns=@JoinColumn(name="imdbId"), inverseJoinColumns=@JoinColumn(name="typeID"))
    private Type type;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public List<Director> getDirector() {
        return director;
    }

    public void setDirector(List<Director> director) {
        this.director = director;
    }

    public List<Writer> getWriter() {
        return writer;
    }

    public void setWriter(List<Writer> writer) {
        this.writer = writer;
    }

    public List<Actor> getActor() {
        return actor;
    }

    public void setActor(List<Actor> actor) {
        this.actor = actor;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getMetaScore() {
        return metaScore;
    }

    public void setMetaScore(int metaScore) {
        this.metaScore = metaScore;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
