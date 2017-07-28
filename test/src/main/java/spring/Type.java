package spring;

/**
 * Created by Ankan on 7/27/2017.
 */

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Type.findAll", query = "SELECT t from Type t"),
        @NamedQuery(name = "Type.findByName", query = "SELECT t from Type  t WHERE t.name=:pName")
})
public class Type {
    public Type()
    {
       setMovie(new ArrayList<Movie>());
    }

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private String typeId;
    @NotNull
    private String name;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="type")
    private List<Movie> movie;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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
        return "Type{" +
                "typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
