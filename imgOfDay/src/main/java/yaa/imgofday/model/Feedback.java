package yaa.imgofday.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String author;
    private String comment;
    private int likes;
    private LocalDate date;

    public Feedback() {
        this.likes = 0;
        this.date = LocalDate.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
