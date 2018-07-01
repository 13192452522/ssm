package ssm.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.junit.Test;

public class Demo {
	@Resource(name="abc")
	private Object mapperExtend;
	private final Map<String, String> map = new HashMap<String, String>();
	@Test
	public void fun() throws Exception {
		Class<? extends Demo> clazz = this.getClass();
		Field field = clazz.getDeclaredField("mapperExtend");
		Resource annotation = field.getAnnotation(Resource.class);
		InvocationHandler handler = Proxy.getInvocationHandler(annotation);
		Field declaredField = handler.getClass().getDeclaredField("memberValues");
		declaredField.setAccessible(true);
		Map memberValues = (Map) declaredField.get(handler);
		memberValues.put("name", "123");
		System.out.println(annotation.name());
	}
	@Test
	public void fun2() throws Exception {
		Class<? extends Demo> clazz = this.getClass();
		Field field = clazz.getDeclaredField("map");
		Map memberValues = (Map) field.get(this);
		memberValues.put("name", "123");
		System.out.println(map.get("name"));
	}
	
	@Test
	public void fun1() {
		map.put("1", "2");
		map.put("1", "3");
		Object obj = map;
		System.out.println(map.get("1"));
	}
}
