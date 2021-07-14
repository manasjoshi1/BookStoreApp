package com.assignment.bookstore.aop;

import com.assignment.bookstore.model.Book;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Log4j2
public class UserAcceptAspect {
//    @Before(value="execution(* com.assignment.bookstore.service.BookService.*(..)) and args(id)")
//    public void before(JoinPoint joinPoint, Book book) {
//        //Advice
//        System.out.println("Inside add book");
//        log.info(" Check for user access ");
//        log.info(" Allowed execution for {}", joinPoint);
//    }
}
