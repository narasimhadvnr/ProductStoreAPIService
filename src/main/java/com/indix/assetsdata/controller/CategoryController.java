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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by venkat on 12/11/16.
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET,value = "/{categoryId}")
    public MyPageResponse<Product> getProductsByCategory(@PathVariable String categoryId
                       , @RequestParam(value = "pageNumber" , defaultValue = "0") int pageNumber
                        , @RequestParam(value = "pageSize",defaultValue = "50" )  int pageSize){

        Logger logger= Logger.getLogger(CategoryController.class.getSimpleName());
        logger.log(Level.INFO,"Received request for category id: "+categoryId);
        Pageable pageRequest= new PageRequest(pageNumber, pageSize);

        Page<Product> resultPage=productRepository.findByCategoryId(Long.parseLong(categoryId),pageRequest);
        return new ResponseCreateFactory<Product>().createResponse(resultPage);

    }
}
