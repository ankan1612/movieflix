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
        @NamedQuery(name = "Director.findAll", query = "SELECT a from  Director  a ORDER BY a.directorId ASC"),
        @NamedQuery(name = "Director.findByName", query = "SELECT a from  Director  a where a.name=:pName")
})
public class Director {

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private  String directorId;
    @NotNull
    private String name;

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
}
