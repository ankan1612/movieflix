package movieflix.entity;

import com.sun.istack.internal.NotNull;
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
        @NamedQuery(name = "Year.findAll", query = "SELECT y from  Year  y ORDER BY y.yearId ASC"),
        @NamedQuery(name = "Year.findByYear", query = "SELECT y from Year y WHERE y.year=:pYear")
})
public class Year {

    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private  String yearId;
    @NotNull
    private int year;

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

    @OneToMany(cascade=CascadeType.ALL, mappedBy="year")
    private List<Movie> movie;

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
