package movieflix.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by Ankan on 7/23/2017.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Actor.findAll", query = "SELECT a from  Actor  a ORDER BY a.imdbactorId ASC"),
        @NamedQuery(name = "Actor.findByName", query = "SELECT a from  Actor  a where a.name=:pName")
})
public class Actor {
    @Id
    private  String imdbactorId;
    @NotNull
    private String name;

    public String getActorId() {
        return imdbactorId;
    }

    public void setActorId(String imdbactorId) {
        this.imdbactorId = imdbactorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
