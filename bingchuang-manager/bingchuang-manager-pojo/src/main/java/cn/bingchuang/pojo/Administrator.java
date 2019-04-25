package cn.bingchuang.pojo;

public class Administrator {
	private int administratorId;		//管理员ID
	private String administratorName;      //管理员名字
	private String administratorPassword;	//管理员密码
	public int getAdministratorId() {
		return administratorId;
	}
	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}
	public String getAdministratorName() {
		return administratorName;
	}
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
	public String getAdministratorPassword() {
		return administratorPassword;
	}
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}
	
	@Override
	public String toString() {
		return "Administrator [administratorId=" + administratorId + ", administratorName=" + administratorName
				+ ", administratorPassword=" + administratorPassword + "]";
	}
}
