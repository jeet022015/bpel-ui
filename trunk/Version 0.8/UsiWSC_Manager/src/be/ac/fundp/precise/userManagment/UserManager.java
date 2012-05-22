package be.ac.fundp.precise.userManagment;

public class UserManager {
	
	protected static UserManager self;
	
	protected UserManager (){
		
	}
	
	public static UserManager getInstance() {
		if (self == null)
			self = new UserManager();
		return self;
	}

}
