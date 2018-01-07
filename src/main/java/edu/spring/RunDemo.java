package edu.spring;

import edu.spring.config.AppConfig;
import edu.spring.entities.Game;
import edu.spring.entities.Team;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Game game = context.getBean("game", Game.class);
        Team royals = context.getBean("royals", Team.class);
        Team redSox = context.getBean("redSox", Team.class);
        Team cubs = context.getBean("cubs", Team.class);

        game.setHomeTeam(royals);
        game.setAwayTeam(cubs);
        System.out.println(game.playGame());

        game.setHomeTeam(cubs);
        game.setAwayTeam(redSox);
        System.out.println(game.playGame());

        context.close();
    }
}
