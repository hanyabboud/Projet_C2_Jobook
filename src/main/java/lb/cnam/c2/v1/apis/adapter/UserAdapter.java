package lb.cnam.c2.v1.apis.adapter;

import lb.cnam.c2.v1.apis.entities.UserEntity;
import lb.cnam.c2.v1.apis.modals.responses.web.UserModal;

public class UserAdapter {

	public static UserModal build(UserEntity in) {
		UserModal out = null;
		try {
			if(in != null) {
				out = new UserModal();
				out.setId(in.getId());
				out.setUsername(in.getUsername());
				out.setEmail(in.getEmail());
				out.setFirstName(in.getFirstName());
				out.setLastName(in.getLastName());
				out.setTitle(in.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}
	
}
