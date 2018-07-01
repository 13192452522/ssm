package ssm.mybatis.basedao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import ssm.mybatis.basedao.MybatisDao;
import ssm.mybatis.po.User;

@Repository
public class MybatisDaoImpl2<T> implements MybatisDao<T> {
	@Resource(name="")
	private Object obj;
	public void save(T t) throws Exception {
//		this.getClass().
	}
	public void insert(T t) throws Exception {
		Class<? extends MybatisDaoImpl2> clazz = this.getClass();
		Field field = clazz.getDeclaredField("obj");
		field.setAccessible(true);
		Method method = field.getClass().getMethod("insert", t.getClass());
		method.invoke(clazz.newInstance(), t);
	}

	public void saveOrUpdate(Serializable id, T t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delete(T t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delete(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void update(T t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Long getTotalCount(T t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public T getById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getPageSize(T t, Long startIndex, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}
//	@Resource(name = "userMapperExtend")

}
