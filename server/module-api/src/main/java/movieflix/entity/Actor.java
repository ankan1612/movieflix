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
        @NamedQuery(name = "Actor.findAll", query = "SELECT a from  Actor  a ORDER BY a.actorId ASC"),
        @NamedQuery(name = "Actor.findByName", query = "SELECT a from  Actor  a where a.name=:pName")
})
public class Actor {

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private  String actorId;
    @NotNull
    private String name;

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
