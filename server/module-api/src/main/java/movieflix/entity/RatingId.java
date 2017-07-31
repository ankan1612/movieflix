package movieflix.entity;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Ankan on 7/30/2017.
 */
@Embeddable
public class RatingId implements Serializable {
    @OneToOne
    private Movie movie;

    @OneToOne
    private User user;

    public RatingId() {
    }

    public RatingId(Movie movie, User user) {
        this.movie = movie;
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RatingId)) {
            return false;
        }
        RatingId old = (RatingId) obj;
        return Objects.equals(getMovie(), old.getMovie()) && Objects.equals(getUser(), old.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovie(), getUser());
    }
}
