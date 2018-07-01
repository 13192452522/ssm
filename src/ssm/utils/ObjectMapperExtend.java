package ssm.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
/**
 * 该类封装,调用Mapper对象的方法
 * @author linux
 *
 */
public class ObjectMapperExtend {
	/*1.通过反射动态改变Mapper注入的类
	 * 2.获取动态调用不同Mapper共有的方法
	 * */
	@Resource(name="")
	private Object mapperExtend;
	private static Class<? extends Object> clazz = ObjectMapperExtend.class;
	private static Field field  = null;
	static Object object = null;
	{
		try {
			field = clazz.getDeclaredField("mapperExtend");
			field.setAccessible(true);
			object = field.get(this);
		} catch (NoSuchFieldException e) {
			System.out.println(e.getMessage());
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void insert(Object entity) {
		String entityName = entity.getClass().getSimpleName();
		String mapperExtendName = entityName + "MapperExtend";
		setResourceName(mapperExtendName); 
		//执行mapper方法
		excetueMapperFunction(entity, mapperExtendName);
	}
	private static void excetueMapperFunction(Object entity, String mapperExtendName) {
		try {
			Method method = object.getClass().getMethod("insert", entity.getClass());
			method.invoke(object, entity);
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void setResourceName(String mapperExtendName) {
		//设置注入的mapper
		try {
			Field mapperExtendField = ObjectMapperExtend.class.getDeclaredField("mapperExtend");
			mapperExtendField.setAccessible(true);
			//获取该字段的注解
			Resource resource = mapperExtendField.getAnnotation(Resource.class);
			//获取注解的代理执行器
			InvocationHandler handler = Proxy.getInvocationHandler(resource);
			//获取该代理执行器的map字段
			Field memberValuesField = handler.getClass().getDeclaredField("memberValues");
			memberValuesField.setAccessible(true);
			//获取该字段的值
			Map map = (Map) memberValuesField.get(handler);
			String name = toLowerCase(mapperExtendName);
			map.put("name", name);
		} catch (NoSuchFieldException ex) {
			System.out.println(ex.getMessage());
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	public static String toLowerCase(String mapperExtendName) {
		String substring = mapperExtendName.substring(1);
		StringBuffer buffer = new StringBuffer(substring);
		
		return buffer.insert(0, mapperExtendName.substring(0, 1).toLowerCase()).toString();
	}
}

