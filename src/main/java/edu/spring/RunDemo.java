package edu.spring;

import edu.spring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.NumberFormat;

public class RunDemo {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        NumberFormat nf = context.getBean(NumberFormat.class);
        double amount = 12345678.9012345;
        System.out.println(nf.format(amount));

//        Team royals = context.getBean("royals", Team.class);
//
//        Game game1 = context.getBean("game", Game.class);
//        System.out.println(game1.playGame());
//
//        Game game2 = context.getBean("game", Game.class);
//        game2.setAwayTeam(royals);
//        System.out.println(game2.playGame());
//
//        System.out.println(game1);
    }
}
