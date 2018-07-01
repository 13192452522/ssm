package ssm.mybatis.basedao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ssm.mybatis.po.User;

public interface MybatisDao<T> {
	/**
	 * 保存对象
	 * 
	 * @param t
	 */
	void save(T t) throws Exception;

	/**
	 * 更新或保存
	 * 
	 * @param t
	 */
	void saveOrUpdate(Serializable id, T t) throws Exception;

	/**
	 * 删除对象
	 * 
	 * @param t
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 */
	void delete(T t) throws Exception;

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	void delete(Serializable id) throws Exception;

	/**
	 * 更新对象
	 * 
	 * @param t
	 */
	void update(T t) throws Exception;

	// 查
	/**
	 * 获取总页数
	 * 
	 * @param t
	 * @return 总页数
	 */
	Long getTotalCount(T t) throws Exception;

	/**
	 * 根据id获取对象
	 * 
	 * @param id
	 * @return 对象
	 */
	T getById(Serializable id) throws Exception;

	/**
	 * 获取分页的对象结果集
	 * 
	 * @param t
	 * @param startIndex
	 * @param pageSize
	 * @return Collection<T>
	 */
	List<T> getPageSize(T t, Long startIndex, Integer pageSize) throws Exception;

	User login(User user);
}
