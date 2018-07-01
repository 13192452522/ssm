package ssm.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssm.mybatis.po.User;
import ssm.service.UserService;
public class Demo2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		UserService userService = (UserService)applicationContext.getBean("userServiceImpl2");
		User user = new User();
		user.setUsername("tommao");
		user.setRealname("汤姆");
		user.setPassword("123");
		userService.save(user);
	}
}
