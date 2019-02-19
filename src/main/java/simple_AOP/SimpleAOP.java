package simple_AOP;

import java.lang.reflect.Proxy;

import simple_AOP.advice.Advice;

public class SimpleAOP {

	public static Object getProxy(Object bean, Advice advice) {
		return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
				bean.getClass().getInterfaces(), advice);
	}
}
