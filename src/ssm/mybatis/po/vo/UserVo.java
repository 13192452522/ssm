package ssm.mybatis.po.vo;

import ssm.mybatis.po.User;

public class UserVo extends User {
	private User user;
	private UserVo userVo;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}

}
