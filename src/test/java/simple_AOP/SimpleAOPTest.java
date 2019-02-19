package simple_AOP;

import org.junit.Test;

import simple_AOP.advice.Advice;
import simple_AOP.advice.BeforeAdvice;
import simple_AOP.helloService.HelloService;
import simple_AOP.helloService.HelloServiceImpl;

public class SimpleAOPTest {

	@Test
	public void getProxy() throws Exception {
		//1.创建1个 MethodInvocation 实现类
		MethodInvocation logTask = () -> System.out.println("log task start");
		HelloServiceImpl helloServiceImpl = new HelloServiceImpl();
		
		//2.创建1个 Advice
		Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);
		
		//3.为目标对象生成代理
		HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl, beforeAdvice);
		
		helloServiceImplProxy.sayHelloWorld();
	}
}
