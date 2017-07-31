package movieflix.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by Ankan on 7/23/2017.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Director.findAll", query = "SELECT d from  Director d ORDER BY d.directorId ASC"),
        @NamedQuery(name = "Director.findByName", query = "SELECT d from  Director  d where d.name=:pName")
})
public class Director {

    public String getDirectorId() {
        return imdbdirectorId;
    }

    public void setDirectorId(String imdbdirectorId) {
        this.imdbdirectorId = imdbdirectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    private  String imdbdirectorId;
    @NotNull
    private String name;

}
