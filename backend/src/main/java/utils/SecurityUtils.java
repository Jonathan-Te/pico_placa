package utils;

import com.jt.backend.models.User;

import lombok.Getter;
import lombok.Setter;

public class SecurityUtils {
	  
	@Getter
	@Setter
	private static User currentUser;
	
	@Getter
	@Setter
	private static boolean logedBoolean = false;
}
