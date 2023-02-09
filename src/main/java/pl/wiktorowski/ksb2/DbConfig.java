package pl.wiktorowski.ksb2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration

public class DbConfig {


//    @Bean
//    public DataSource getDataSource(){
//        DataSourceBuilder dataSourceBuilder =
//                DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/jeden");
//        dataSourceBuilder.username("root1");
//        dataSourceBuilder.password("root");
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        return dataSourceBuilder.build();

    private DataSource dataSource;

    @Autowired

    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean

    public JdbcTemplate getJdbctemplate()

    {

        return new JdbcTemplate(dataSource);


    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        String sql = "CREATE TABLE videos(video_id int, title varchar(255), url varchar (255), PRIMARY KEY (video_id))";
        getJdbctemplate().update(sql);

    }



}
