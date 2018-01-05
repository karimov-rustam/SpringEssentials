package edu.spring;

import edu.spring.config.AppConfig;
import edu.spring.entities.Game;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Game game = context.getBean("game", Game.class);
        System.out.println(game.playGame());

        System.out.println("There are " + context.getBeanDefinitionCount() + " beans");
        for (String name :
                context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}
