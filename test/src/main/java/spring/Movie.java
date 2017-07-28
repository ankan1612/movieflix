package spring;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankan on 7/27/2017.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "SELECT m from Movie m"),
        @NamedQuery(name = "Movie.findByName", query = "SELECT g from Movie  g WHERE g.title=:pName")
})
public class Movie {

    public Movie()
    {
        setGenre(new ArrayList<Genre>());
    }

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private String id;
    @NotNull
    private String title;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Movie_Genre", joinColumns=@JoinColumn(name="id"), inverseJoinColumns=@JoinColumn(name="genreID"))
    private List<Genre> genre;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(name="Movie_Type", joinColumns=@JoinColumn(name="id"), inverseJoinColumns=@JoinColumn(name="typeID"))
    private Type type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
