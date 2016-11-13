package com.indix.assetsdata.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by venkat on 13/11/16.
 */
public class MyPageResponse<T> implements Serializable{

    private int NoOfPages;
    private int noOfElements;
    private String errorMessage="";
    private int currentPageNumber;
    private List<T> data;
    public MyPageResponse(){

    }

    public int getNoOfPages() {
        return NoOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        NoOfPages = noOfPages;
    }

    public int getNoOfElements() {
        return noOfElements;
    }

    public void setNoOfElements(int noOfElements) {
        this.noOfElements = noOfElements;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
