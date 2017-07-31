package com.mycompany.usermanagement.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mycompany.usermanagement.dao.GroupDAO;
import com.mycompany.usermanagement.dao.GroupDAOImpl;
import com.mycompany.usermanagement.dao.UserDAO;
import com.mycompany.usermanagement.dao.UserDAOImpl;


@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
   // Static Resource Config
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
    
       // Css resource.
       registry.addResourceHandler("/js/**") //
                 .addResourceLocations("/WEB-INF/resources/css/").setCachePeriod(31556926);
        
   }
   
  @Bean
   public DataSource getDataSource() {
     DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
      dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
      dataSource.setUsername("hr");
      dataSource.setPassword("xxx");
        
      return dataSource;
   }
  
  @Bean
  public UserDAO getContactDAO() {
      return new UserDAOImpl(getDataSource());
  }
  
  @Bean
  public GroupDAO getGroupDAO() {
      return new GroupDAOImpl(getDataSource());
  }
 
    
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
 
}
