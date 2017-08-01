package movieflix.entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Ankan on 7/27/2017.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Type.findAll", query = "SELECT t from  Type  t ORDER BY t.typeId ASC"),
        @NamedQuery(name = "Type.findByName", query = "SELECT t from Type t WHERE t.name=:pName")
})
public class Type {

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private  String typeId;
    @NotNull
    private String name;

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

}
