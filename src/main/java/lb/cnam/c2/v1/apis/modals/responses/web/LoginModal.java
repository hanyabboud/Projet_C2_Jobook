package lb.cnam.c2.v1.apis.modals.responses.web;

public class LoginModal {

	private UserModal user;
	
	private String privateEndpoint;
	
	public LoginModal(UserModal user, String privateEndpoint) {
		this.user = user;
		this.privateEndpoint = privateEndpoint;
	}

	public UserModal getUser() {
		return user;
	}

	public void setUserl(UserModal user) {
		this.user = user;
	}

	public String getPrivateEndpoint() {
		return privateEndpoint;
	}

	public void setPrivateEndpoint(String privateEndpoint) {
		this.privateEndpoint = privateEndpoint;
	}

}