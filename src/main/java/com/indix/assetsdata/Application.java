package com.indix.assetsdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by venkat on 12/11/16.
 */
@SpringBootApplication
@EnableMongoRepositories("com.indix.assetsdata.repository")
public class Application {

    public static void main(String args[]){

        ApplicationContext context= SpringApplication.run(Application.class,args);

    }


}
