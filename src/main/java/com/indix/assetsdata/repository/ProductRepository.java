package com.indix.assetsdata.repository;

import com.indix.assetsdata.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by venkat on 12/11/16.
 */
public interface ProductRepository extends MongoRepository<Product,String> {

    public Page<Product> findByCategoryId(long category,Pageable pageable);

    public Page<Product> findByUpcs(String upcs, Pageable pageable);

    public List<Product> findByProductId(String productId);

    @Query("{ 'title' : {$regex:?0,$options:'i'}, 'price': {$gte:?1,$lte:?2}  }")
    public Page<Product> findByTitleAndPriceRange(String title, double fromPrice,double toPrice,Pageable pageable );

}
