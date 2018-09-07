package vn.com.hf.composite.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.hf.composite.client.AuthorizedFeignClient;
import vn.com.hf.review.service.dto.ReviewDTO;

@AuthorizedFeignClient(name = "hfReviewService")
public interface ReviewDTOService {
    
    @GetMapping(value = "/api/reviews/product/{id}")
    List<ReviewDTO> getReviewById(@PathVariable(value = "id") Long id);

}
