package ssm.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.mybatis.basedao.MybatisDao;
import ssm.mybatis.po.User;
import ssm.mybatis.po.vo.UserVo;
import ssm.service.UserService;

@Service
public class UserServiceImpl2 implements UserService {
	@Resource(name = "mybatisDaoImpl2")
	private MybatisDao<User> mybatisDao;

	public void save(User user) {
		try {
			mybatisDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setMybatisDao(MybatisDao<User> mybatisDao) {
		this.mybatisDao = mybatisDao;
	}

	public User login(User user) {
		return mybatisDao.login(user);
	}

	public void delete(User user) {
		try {
			mybatisDao.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shamDelete(User user) {

	}

	public void update(User user) {
		try {
			mybatisDao.update(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void saveOrUpdate(Serializable id, User user) {
		try {
			mybatisDao.saveOrUpdate(id, user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public User getUserById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getTotalCount(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserList(User user, Long startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
