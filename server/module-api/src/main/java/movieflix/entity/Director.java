package movieflix.entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankan on 7/23/2017.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Director.findAll", query = "SELECT d from  Director d ORDER BY d.directorId ASC")
})
public class Director {

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private  String directorId;
    @NotNull
    private String name;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="director")
    private List<Movie> movie;

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
}
