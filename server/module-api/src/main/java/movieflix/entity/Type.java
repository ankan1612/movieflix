package movieflix.entity;

import com.sun.istack.internal.NotNull;
import com.sun.org.apache.xpath.internal.operations.String;
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
        @NamedQuery(name = "Year.findAll", query = "SELECT t from  Type  t ORDER BY t.typeId ASC"),
        @NamedQuery(name = "User.findByType", query = "SELECT t from Type t WHERE t.type=:pType")
})
public class Type {

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private  String typeId;
    @NotNull
    private String type;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="type")
    private List<Movie> movie;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
}
