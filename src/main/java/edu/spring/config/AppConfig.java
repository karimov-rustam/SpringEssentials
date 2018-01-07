package edu.spring.config;

import edu.spring.entities.BaseballGame;
import edu.spring.entities.Game;
import edu.spring.entities.RedSox;
import edu.spring.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.text.NumberFormat;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "edu.spring")
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private List<Team> teams;

    @Bean
    public NumberFormat nf() {
        return NumberFormat.getCurrencyInstance();
    }

    @Bean
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(redSox(), teams.get(0));
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }

    @Bean
    public Team redSox() {
        return new RedSox();
    }
}
