package edu.spring;

import edu.spring.config.AppConfig;
import edu.spring.entities.Game;
import edu.spring.entities.Team;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Game game1 = context.getBean("game", Game.class);
        System.out.println(game1);

        Game game2 = context.getBean("game", Game.class);
        Team royals = context.getBean("royals", Team.class);
        game2.setAwayTeam(royals);
        System.out.println(game2);

        System.out.println(game1);

//        System.out.println("There are " + context.getBeanDefinitionCount() + " beans");
//        for (String name :
//                context.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
    }
}
