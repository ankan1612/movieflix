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
        @NamedQuery(name = "Genre.findAll", query = "SELECT g from Genre g"),
        @NamedQuery(name = "Genre.findByName", query = "SELECT g from Genre  g WHERE g.name=:pName")
})
public class Genre {

    public Genre()
    {
        setMovie(new ArrayList<Movie>());
    }

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private String genreId;
    @NotNull
    private String name;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="genre")
    private List<Movie> movie;

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId='" + genreId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
