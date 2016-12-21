package com.zhang.movie.Utils;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JDOUtils {
	
	@Bean
	@Scope
    public PersistenceManagerFactory getPersistenceManagerFactory() {
        return JDOHelper.getPersistenceManagerFactory("zhang");
    }
}
