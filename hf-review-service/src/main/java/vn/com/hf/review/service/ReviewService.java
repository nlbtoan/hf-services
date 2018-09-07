package vn.com.hf.review.service;

import java.util.List;
import java.util.Optional;

import vn.com.hf.review.service.dto.ReviewDTO;


/**
 * Service Interface for managing Review.
 */
public interface ReviewService {

    /**
     * Save a review.
     *
     * @param reviewDTO the entity to save
     * @return the persisted entity
     */
    ReviewDTO save(ReviewDTO reviewDTO);

    /**
     * Get all the reviews.
     *
     * @return the list of entities
     */
    List<ReviewDTO> findAll();


    /**
     * Get the "id" review.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ReviewDTO> findOne(Long id);
    
    /**
     * Get all the reviews of product id.
     *
     * @return the list of entities
     */
    List<ReviewDTO> findAllReviewOfProduct(Long id);

    /**
     * Delete the "id" review.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
