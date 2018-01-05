package edu.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.spring")
public class AppConfig {

//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired @Qualifier("redSox")
//    private Team home;
//
//    @Autowired @Qualifier("cubs")
//    private Team away;
//
//    @Bean
//    public Game game() {
//        BaseballGame baseballGame = new BaseballGame(home, away);
//        baseballGame.setDataSource(dataSource);
//        return baseballGame;
//    }
}
