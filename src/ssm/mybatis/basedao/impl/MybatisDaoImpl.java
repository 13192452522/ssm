package ssm.mybatis.basedao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import ssm.mybatis.basedao.MybatisDao;
import ssm.mybatis.mapper.UserMapperExtend;
import ssm.mybatis.po.User;
import ssm.mybatis.po.UserExample;
import ssm.mybatis.po.UserExample.Criteria;
import ssm.utils.MybatisUtil;

@Repository
public class MybatisDaoImpl implements MybatisDao<User> {
	@Resource(name = "userMapperExtend")
	private UserMapperExtend userMapperExtend;

	public void save(User t) {
		userMapperExtend.insert(t);
	}

	public void saveOrUpdate(Serializable id, User t) {
		// 创建UserExample添加约束条件
		UserExample userExample = new UserExample();
		// 获取Criteria类添加条件
		Criteria criteria = userExample.createCriteria();
		// 健壮性判断是否是Integer
		Integer iid = null;
		if (id instanceof Integer) {
			iid = (Integer) id;
		} else if (id instanceof String) {
			String sid = (String) id;
			if (sid.matches("[0-9]+")) {
				iid = Integer.parseInt(sid);
			}
		} else {
			return;
		}
		// 设置条件
		userExample.or(criteria.andIdEqualTo(iid));
		List<User> list = userMapperExtend.selectByExample(userExample);
		if (list != null && list.size() > 0) {
			userMapperExtend.updateByExampleSelective(t, userExample);
		} else {
			userMapperExtend.insert(t);
		}
	}

	public void delete(User t) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		if (t != null) {
			// 创建UserExample添加约束条件
			UserExample userExample = new UserExample();
			userMapperExtend.deleteByExample((UserExample) MybatisUtil.addConditions(t, userExample));
		}
	}

	public void delete(Serializable id) {
		if (id != null) {
			UserExample userExample = new UserExample();
			userMapperExtend.deleteByExample(MybatisUtil.addOneCondition(id, userExample));
		}
	}

	public void update(User t) {
		UserExample userExample = new UserExample();
		userMapperExtend.updateByExampleSelective(t, (UserExample) MybatisUtil.addOneCondition(t.getId(), userExample));
	}

	public Long getTotalCount(User t) {
		Long totalCount = userMapperExtend.getTotalCount(t);
		return totalCount;
	}

	public User getById(Serializable id) {
		UserExample userExample = new UserExample();
		List<User> list = userMapperExtend.selectByExample((UserExample) MybatisUtil.addOneCondition(id, userExample));
		return list.get(0);
	}

	public List<User> getPageSize(User t, Long startIndex, Integer pageSize) {
		UserExample userExample = new UserExample();
		List<User> list = new ArrayList<User>();
		try {
			list = userMapperExtend.selectByExample((UserExample) MybatisUtil.addConditions(t, userExample));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void setUserMapperExtend(UserMapperExtend userMapperExtend) {
		this.userMapperExtend = userMapperExtend;
	}

	public User login(User user) {
		return userMapperExtend.login(user);
	}
}
