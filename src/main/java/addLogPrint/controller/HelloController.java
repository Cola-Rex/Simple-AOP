package addLogPrint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import addLogPrint.util.LoggerManage;

@RestController
public class HelloController {

	@GetMapping("/hello")
	@LoggerManage(logDescription = "hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/login/{username}/{password}")
	@LoggerManage(logDescription = "登陆")
	public String login(@PathVariable("username") String username,
						@PathVariable("password") String password) {
		return "登陆成功";
	}
}
