package vn.com.hf.composite.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import io.github.jhipster.web.util.ResponseUtil;
import vn.com.hf.composite.service.ProductDTOService;
import vn.com.hf.composite.service.ReviewDTOService;
import vn.com.hf.composite.service.dto.ProductAggregatedDTO;
import vn.com.hf.profile.service.dto.ProductDTO;
import vn.com.hf.review.service.dto.ReviewDTO;

/**
 * REST controller for managing Product Composite.
 */
@RestController
@RequestMapping("/api")
public class ProductCompositeResource {
    private final Logger log = LoggerFactory.getLogger(ProductCompositeResource.class);
    
    private final ProductDTOService productDTOService;
    private final ReviewDTOService reviewDTOService;
    
    public ProductCompositeResource(ProductDTOService productDTOService, ReviewDTOService reviewDTOService){
        this.productDTOService = productDTOService;
        this.reviewDTOService = reviewDTOService;
    }
    
    /**
     * GET  /products/:id : get the "id" product.
     *
     * @param id the id of the productDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productDTO, or with status 404 (Not Found)
     */
    @GetMapping("/productComposite/{id}")
    @Timed
    public ProductAggregatedDTO getProduct(@PathVariable Long id) {
        log.debug("REST request to get Product Composite : {}", id);
        ProductDTO productDTO = productDTOService.getProductById(id);
        if (productDTO != null){
            List<ReviewDTO> reviewDTOs = reviewDTOService.getReviewById(id);
            return new ProductAggregatedDTO(productDTO, reviewDTOs);
        }
        return new ProductAggregatedDTO();
    }

}


