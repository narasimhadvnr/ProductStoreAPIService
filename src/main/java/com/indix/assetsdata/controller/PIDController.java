package com.indix.assetsdata.controller;

import com.indix.assetsdata.model.Product;
import com.indix.assetsdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by venkat on 12/11/16.
 */
@RestController
@RequestMapping("/pid")
public class PIDController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{productId}")
    public Product getProductsByProductId(@PathVariable("productId") String productId){

        if(productId!=null && (!StringUtils.isEmpty(productId)) ){

          return  productRepository.findOne(productId);
        }else
            return new Product();

    }
}
