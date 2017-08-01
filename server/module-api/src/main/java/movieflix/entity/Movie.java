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
        @NamedQuery(name = "Movie.findAll", query = "SELECT m from  Movie  m ORDER BY m.imdbId ASC"),
        @NamedQuery(name = "Movie.findByTitle", query = "SELECT m from  Movie  m where m.title=:pName")
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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Genre.class)
    private Set<Genre> genre;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = Director.class)
    private Set<Director> director;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = Writer.class)
    private Set<Writer> writer;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = Actor.class)
    private Set<Actor> actor;
    private String plot;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = Language.class)
    private Set<Language> language;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = Country.class)
    private Set<Country> country;
    private String awards;
    private String poster;
    private int metaScore;
    @Column(columnDefinition="Decimal(3,1) default '0.0'")
    private double imdbRating;
    private int imdbVotes;
    @Column(columnDefinition="Decimal(3,1) default '0.0'")
    private double userRating;
    @NotNull
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
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

    public Set<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Set<Genre> genre) {
        this.genre = genre;
    }

    public Set<Director> getDirector() {
        return director;
    }

    public void setDirector(Set<Director> director) {
        this.director = director;
    }

    public Set<Writer> getWriter() {
        return writer;
    }

    public void setWriter(Set<Writer> writer) {
        this.writer = writer;
    }

    public Set<Actor> getActor() {
        return actor;
    }

    public void setActor(Set<Actor> actor) {
        this.actor = actor;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Set<Language> getLanguage() {
        return language;
    }

    public void setLanguage(Set<Language> language) {
        this.language = language;
    }

    public Set<Country> getCountry() {
        return country;
    }

    public void setCountry(Set<Country> country) {
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
