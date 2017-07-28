package movieflix.entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
@Entity
@Table
public class Rating {
    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
    @GeneratedValue(generator = "customUUID")
    private  String ratingId;
    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(name="Rating_Movie", joinColumns=@JoinColumn(name="ratingID"), inverseJoinColumns=@JoinColumn(name="imdbId"))
    private Movie movie;
    @NotNull
    @OneToOne
    private User user;
    @NotNull
    private  int ratingScore;
    private  String comments;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
