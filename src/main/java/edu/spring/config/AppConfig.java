package edu.spring.config;

import edu.spring.entities.BaseballGame;
import edu.spring.entities.Game;
import edu.spring.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "edu.spring")
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired @Qualifier("redSox")
    private Team home;

    @Autowired @Qualifier("cubs")
    private Team away;

    @Bean
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(home, away);
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
}
