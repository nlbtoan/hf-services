package vn.com.hf.composite.service.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import vn.com.hf.profile.service.dto.ProductDTO;
import vn.com.hf.review.service.dto.ReviewDTO;

public class ProductAggregatedDTO {
    private long productId;
    private String name;
    private float weight;
    private List<ReviewSummary> reviews;

    public ProductAggregatedDTO(ProductDTO product, List<ReviewDTO> reviews) {

        // 1. Setup product info
        this.productId = product.getProductId();
        this.name = product.getName();
        this.weight = product.getWeight();

        // Copy summary review info, if available
        if (reviews != null)
            this.reviews = reviews.stream()
                .map(r -> new ReviewSummary(r.getId(), r.getAuthor(), r.getSubject()))
                .collect(Collectors.toList());
    }
    
    public ProductAggregatedDTO(){
        this.productId = 0;
        this.name = "";
        this.weight = 0;
        this.reviews = new ArrayList<>();
    }

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public List<ReviewSummary> getReviews() {
        return reviews;
    }
}
