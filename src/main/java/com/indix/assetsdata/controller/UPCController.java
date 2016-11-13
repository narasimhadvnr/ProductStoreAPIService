package com.indix.assetsdata.controller;

import com.indix.assetsdata.model.Product;
import com.indix.assetsdata.repository.ProductRepository;
import com.indix.assetsdata.utils.AppConstants;
import com.indix.assetsdata.utils.MyPageResponse;
import com.indix.assetsdata.utils.ResponseCreateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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
@RequestMapping("/upc")
public class UPCController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/{upcId}" , method = RequestMethod.GET)
    @ResponseBody
    public MyPageResponse<Product> getItems(@PathVariable("upcId") String upcId
            , @RequestParam(value = "pageNumber",defaultValue = "0") int pageNumber ){

        Logger logger= Logger.getLogger(UPCController.class.getSimpleName());
        logger.log(Level.INFO,"Received request for upc id:"+upcId);
        Pageable pageRequest= new PageRequest(pageNumber, AppConstants.PAGE_SIZE);
        Page<Product> page= productRepository.findByUpcs(upcId,pageRequest);
        return new ResponseCreateFactory<Product>().createResponse(page);

    }

}
