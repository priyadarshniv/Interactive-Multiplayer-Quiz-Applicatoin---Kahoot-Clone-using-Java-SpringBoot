package com.example.JavaProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class JavaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProjectApplication.class, args);
	}

	@Controller
	public static class HomeController {

		@RequestMapping("/")
		public String showIndex() {
			return "index";
		}

		@RequestMapping("/create")
		public String createQuiz() {
			return "Create";
		}
		@RequestMapping("/create/BasicScience")
		public String basicScience() {
			return "BasicScience";
		}

		@RequestMapping("/create/Geography")
		public String geography() {
			return "Geography";
		}

		@RequestMapping("/create/Economics")
		public String economics() {
			return "Economics";
		}

		@RequestMapping("/play")
		public String lets_play() {
			return "play";
		}

		@RequestMapping("/player1")
		public String player_one() {
			return "player1";
		}


	}
}
