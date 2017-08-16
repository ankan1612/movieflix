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
        @NamedQuery(name = "Writer.findAll", query = "SELECT w from  Writer w ORDER BY w.writerId ASC"),
        @NamedQuery(name = "Writer.findByName", query = "SELECT w from Writer w WHERE w.name=:pName")
})
public class Writer {

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
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
    private  String writerId;
    @NotNull
    private String name;

}
