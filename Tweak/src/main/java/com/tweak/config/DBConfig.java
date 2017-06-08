package com.tweak.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tweak.DAO.UserDAOImp;
import com.tweak.modal.Blog;
import com.tweak.modal.BlogComment;
import com.tweak.modal.Forum;
import com.tweak.modal.ForumComment;
import com.tweak.modal.Friends;
import com.tweak.modal.Jobs;
import com.tweak.modal.UserTable;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		//Hibernate related properties
		Properties hibernateprop=new Properties();
		hibernateprop.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateprop.put("hibernate.show_sql", "true"); //optional
		hibernateprop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		//Adding the Database related Properties
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/tweak");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(hibernateprop);
		sessionBuilder.addAnnotatedClass(UserTable.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(ForumComment.class);
		sessionBuilder.addAnnotatedClass(Friends.class);
		sessionBuilder.addAnnotatedClass(Jobs.class);
		SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
		
		System.out.println("Session Factory Object Created");
		
		return sessionFactory;
		
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction Manager");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}