package vn.com.hf.composite.service.dto;

public class ReviewSummary {
    private long reviewId;
    private String author;
    private String subject;

    public ReviewSummary(long reviewId, String author, String subject) {
        this.reviewId = reviewId;
        this.author = author;
        this.subject = subject;
    }

    public long getReviewId() {
        return reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }
}
