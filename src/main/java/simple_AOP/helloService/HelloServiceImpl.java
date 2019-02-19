package simple_AOP.helloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHelloWorld() {
		System.out.println("hello from the other side");
	}
}
