package vn.com.hf.review.service.impl;

import vn.com.hf.review.service.ReviewService;
import vn.com.hf.review.service.dto.ReviewDTO;
import vn.com.hf.review.domain.Review;
import vn.com.hf.review.repository.ReviewRepository;
import vn.com.hf.review.service.mapper.ReviewMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Review.
 */
@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    /**
     * Save a review.
     *
     * @param reviewDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ReviewDTO save(ReviewDTO reviewDTO) {
        log.debug("Request to save Review : {}", reviewDTO);
        Review review = reviewMapper.toEntity(reviewDTO);
        review = reviewRepository.save(review);
        return reviewMapper.toDto(review);
    }

    /**
     * Get all the reviews.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReviewDTO> findAll() {
        log.debug("Request to get all Reviews");
        return reviewRepository.findAll().stream()
            .map(reviewMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one review by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReviewDTO> findOne(Long id) {
        log.debug("Request to get Review by product id: {}", id);
        return reviewRepository.findById(id)
            .map(reviewMapper::toDto);
    }

    /**
     * Delete the review by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Review : {}", id);
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDTO> findAllReviewOfProduct(Long id) {
        log.debug("Request to get all Reviews of product id {}", id);
//        return reviewRepository.findByProductId(id).stream()
//            .map(reviewMapper::toDto)
//            .collect(Collectors.toCollection(LinkedList::new));
        Review review = new Review();
        review.setProductId(id);
        Example<Review> reviewExample = Example.of(review);
        return reviewRepository.findAll(reviewExample).stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
