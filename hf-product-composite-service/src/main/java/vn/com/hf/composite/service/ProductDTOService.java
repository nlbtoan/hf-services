package vn.com.hf.composite.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.hf.composite.client.AuthorizedFeignClient;
import vn.com.hf.profile.service.dto.ProductDTO;

@AuthorizedFeignClient(name = "hfProfileService")
public interface ProductDTOService {
    @GetMapping(value = "/api/products/{id}")
    ProductDTO getProductById(@PathVariable(value = "id") Long id);
}
