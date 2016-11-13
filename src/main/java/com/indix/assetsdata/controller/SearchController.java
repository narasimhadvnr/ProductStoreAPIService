package com.indix.assetsdata.controller;
import com.indix.assetsdata.model.Product;
import com.indix.assetsdata.repository.ProductRepository;
import com.indix.assetsdata.utils.AppConstants;
import com.indix.assetsdata.utils.MyPageResponse;
import com.indix.assetsdata.utils.ResponseCreateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by venkat on 12/11/16.
 */
@RestController
@RequestMapping("/search")
public class SearchController {


    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public MyPageResponse<Product> getProductsBySearchCriteria(
            @RequestParam("q") String queryTokens,
            @RequestParam("minPrice") double minPrice,
            @RequestParam("maxPrice")  double maxPrice,
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber){

        Pageable pageRequest= new PageRequest(pageNumber, AppConstants.PAGE_SIZE);

        Page<Product> page =productRepository.findByTitleAndPriceRange(queryTokens,minPrice,maxPrice,pageRequest);

        return new ResponseCreateFactory<Product>().createResponse(page);

    }
}
