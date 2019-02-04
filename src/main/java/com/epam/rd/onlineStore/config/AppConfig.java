//package com.epam.rd.onlinestore.config;
//
//import javax.sql.DataSource;
//
////import org.apache.commons.dbcp.BasicDataSource;
//
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//
//import java.util.Properties;
//
//public class AppConfig {
//
//
//    @Bean
//    public SessionFactory sessionFactory() {
//        LocalSessionFactoryBuilder builder =
//                new LocalSessionFactoryBuilder(dataSource());
//        builder.scanPackages("com.mkyong.users.model")
//                .addProperties(getHibernateProperties());
//
//        return builder.buildSessionFactory();
//    }
//
//    private Properties getHibernateProperties() {
//        Properties prop = new Properties();
//        prop.put("hibernate.format_sql", "true");
//        prop.put("hibernate.show_sql", "true");
//        prop.put("hibernate.dialect",
//                "org.hibernate.dialect.MySQL5Dialect");
//        return prop;
//    }
//
////    @Bean(name = "dataSource")
////    public BasicDataSource dataSource() {
////
////        BasicDataSource ds = new BasicDataSource();
////        ds.setDriverClassName("com.mysql.jdbc.Driver");
////        ds.setUrl("jdbc:mysql://localhost:3306/test");
////        ds.setUsername("root");
////        return ds;
////    }
//
//
//    //Create a transaction manager
//    @Bean
//    public HibernateTransactionManager txManager() {
//        return new HibernateTransactionManager(sessionFactory());
//    }
//
////    @Bean
////    public InternalResourceViewResolver viewResolver() {
////        InternalResourceViewResolver viewResolver
////                = new InternalResourceViewResolver();
////        viewResolver.setViewClass(JstlView.class);
////        viewResolver.setPrefix("/WEB-INF/pages/");
////        viewResolver.setSuffix(".jsp");
////        return viewResolver;
////    }
//
//
//
//}
