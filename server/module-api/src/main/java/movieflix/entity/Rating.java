package movieflix.entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ankan on 7/24/2017.
 */
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Rating.findAll", query = "SELECT r from Rating r"),
        @NamedQuery(name = "Rating.findByMovie", query = "SELECT r from Rating r where r.id.movie=:pName"),
        @NamedQuery(name = "Rating.deleteByMovie", query = "delete from Rating r where r.id.movie=:pName"),
        @NamedQuery(name = "Rating.deleteByUser", query = "delete from Rating r where r.id.user=:pName"),
        @NamedQuery(name = "Rating.findByUser", query = "SELECT r from Rating r where r.id.user=:pName"),
        @NamedQuery(name = "Rating.getAverageByMovie", query = "SELECT avg(r.ratingScore) from Rating r where r.id.movie=:pName group by r.id.movie")
})
public class Rating {

    @EmbeddedId
    private RatingId id;
    @NotNull
    private  int ratingScore;
    private  String comments;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    @PrePersist
    protected void onCreate() {
        timeStamp = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        timeStamp = new Date();
    }

    public RatingId getId() {
        return id;
    }

    public void setId(RatingId id) {
        this.id = id;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

}
