package ssm.service;

import java.io.Serializable;
import java.util.List;

import ssm.mybatis.po.User;
import ssm.mybatis.po.vo.UserVo;

public interface UserService {
	/**
	 * 保存用户
	 * @param user
	 */
	void save(User user);
	
	/**
	 * 验证用户是否存在
	 * @param userVo
	 * @return Boolean
	 */
	User login(User user);
	
	/**
	 * 真正删除用户
	 * @param user
	 */
	void delete(User user);
	 
	/**
	 * 伪删除用户
	 * @param user
	 */
	void shamDelete(User user);
	
	/**
	 * 更新用户信息
	 * @param userVo
	 */
	void update(User user);
	
	/**
	 * 判断是否是更新还是添加用户
	 * @param user
	 */
	void saveOrUpdate(Serializable id, User user);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return User
	 */
	User getUserById(Serializable id);
	
	/**
	 * 获取符合条件的数量
	 * @param user
	 * @return Long
	 */
	Long getTotalCount(User user);
	
	List<User> getUserList(User user, Long startIndex, Integer pageSize);
}
