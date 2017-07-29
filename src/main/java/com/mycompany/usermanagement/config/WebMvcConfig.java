package com.mycompany.usermanagement.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
   // Static Resource Config
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
    
       // Css resource.
       registry.addResourceHandler("/users/**") //
                 .addResourceLocations("/WEB-INF/resources/css/").setCachePeriod(31556926);
        
   }
   
//   @Bean
  // public DataSource getDataSource() {
 //      DriverManagerDataSource dataSource = new DriverManagerDataSource();
   //    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
   //    dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
   //    dataSource.setUsername("root");
   //    dataSource.setPassword("P@ssw0rd");
        
  //     return dataSource;
  // }
 
    
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
 
}
