package ssm.mybatis.mapper;

import java.util.List;

import ssm.mybatis.po.User;

public interface UserMapperExtend extends UserMapper {
	/**
	 * 获取总页数
	 * @param user
	 * @return Number
	 */
	Long getTotalCount(User user);
	
	/**
	 * 获取分页的对象结果集
	 * @param t
	 * @param startIndex
	 * @param pageSize
	 * @return Collection<T>
	 */
	List<? extends User> getPageSize(User user, Long startIndex, Integer pageSize);

	User login(User user);
}
