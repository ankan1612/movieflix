package movieflix.entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Ankan on 7/23/2017.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Genre.findAll", query = "SELECT g from  Genre  g ORDER BY c.genreId ASC"),
        @NamedQuery(name = "Genre.findByName", query = "SELECT g from Genre  g WHERE c.name=:pName")
})
public class Genre {
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

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private  String genreId;
    @NotNull
    private String name;
}
