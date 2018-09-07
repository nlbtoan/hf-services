package vn.com.hf.review.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Review entity.
 */
public class ReviewDTO implements Serializable {

    private Long id;

    @NotNull
    private Long productId;

    private String author;

    private String subject;

    @NotNull
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReviewDTO reviewDTO = (ReviewDTO) o;
        if (reviewDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reviewDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
            "id=" + getId() +
            ", productId=" + getProductId() +
            ", author='" + getAuthor() + "'" +
            ", subject='" + getSubject() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }
}
