package com.indix.assetsdata.utils;

import org.springframework.data.domain.Page;

/**
 * Created by venkat on 13/11/16.
 */
public class ResponseCreateFactory<T> {


    public MyPageResponse<T> createResponse(Page<T> page ,String errorMessage){

        MyPageResponse<T> response=createResponse(page);
        response.setErrorMessage(errorMessage);
        return response;
    }

    public MyPageResponse<T> createResponse(Page<T> page ){

        MyPageResponse<T> pageResponse=new MyPageResponse<T>();
        pageResponse.setData(page.getContent());
        pageResponse.setNoOfElements(page.getNumberOfElements());
        pageResponse.setNoOfPages(page.getTotalPages());
        pageResponse.setCurrentPageNumber(page.getNumber());
        return pageResponse;
    }
}
