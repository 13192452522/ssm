package ssm.utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ssm.mybatis.po.UserExample;

public class MybatisUtil {
	public static Object addConditions(Object object, Object example) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		if (example == null) {
			return null;
		}
		// 获取字节码对象
		Class<?> clazz = object.getClass();
		// 获取所有字段
		Field[] fields = clazz.getDeclaredFields();
		// 将第一个小写字母转化成大写字母
		StringBuffer fieldStr = null;
		String str = null;
		// 获取example的字节码对象
		Class exampleClass = example.getClass();
		// 获取Example中Criteria对象，方法对象
		Method createCriteria = exampleClass.getMethod("createCriteria");
		// 获取到Criteria
		Object criteria = createCriteria.invoke(example);
		// 获取Criteria的字节码文件
		Class criteriaClass = criteria.getClass();
		Method or = exampleClass.getMethod("or", criteriaClass);
		// 遍历
		for (Field field : fields) {
			field.setAccessible(true);
			str = field.toString();
			String[] split = str.split("\\.");
			if (split.length > 0) {
				str = split[split.length - 1];
			}
			// 将第一个字母舍去
			fieldStr = new StringBuffer(str.substring(1));
			// 获取相应bean字段的方法的get方法
			String toUpCase = fieldStr.insert(0, str.substring(0, 1).toUpperCase()).toString();
			Method method = clazz.getMethod("get" + toUpCase);
			// 执行get方法获取相应值
			Object invoke = method.invoke(object);
			// 判断值是否为空
			if (invoke == null || invoke == "") {
				continue;
			} else {
				// 获取对应字段的参数类型
				Class<?> type = field.getType();
				// 将条件添加到Criteria中？如何获取?通过Example的字节码对象，获取他的方法
				// example.getClass()再调用createCriteria方法获取该对象，
				// 获取其字节码对象调用该对象方法，参数字节码对象可以通过field.getType
				Method criteriaClassMethod = criteriaClass.getMethod("and" + toUpCase + "EqualTo", type);
				// 添加条件，并将其添加到Example中的ArrayList<Criteria>中
				// 在添加条件时，需要添加的是Integer等类型;
				criteriaClassMethod.invoke(criteria, invoke);
			}
		}
		or.invoke(example, criteria);
		return example;
	}

	public static UserExample addOneCondition(Serializable id, Object example) {
		try {
			Class<? extends Object> clazz = example.getClass();
			Method method = clazz.getMethod("createCriteria");
			Object criteria = method.invoke(example);
			Class<? extends Object> criteriaClass = criteria.getClass();
			Method and = criteriaClass.getMethod("andIdEqualTo", id.getClass());
			and.invoke(criteria, id);
			Method or = clazz.getMethod("or", criteriaClass);
			or.invoke(example, criteria);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (UserExample) example;
	}
}
