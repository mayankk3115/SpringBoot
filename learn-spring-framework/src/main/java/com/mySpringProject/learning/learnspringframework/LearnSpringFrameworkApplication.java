package com.mySpringProject.learning.learnspringframework;

import com.mySpringProject.learning.learnspringframework.enterprise.MywebController;
import com.mySpringProject.learning.learnspringframework.game.GameRunner;
import com.mySpringProject.learning.learnspringframework.game.MarioGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
//		MarioGame game = new MarioGame();
//		GameRunner gameRunner = new GameRunner(game);
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();

		MywebController controller = context.getBean(MywebController.class);
		System.out.println(controller.returnValueFromBusinessValue());
	}

}
