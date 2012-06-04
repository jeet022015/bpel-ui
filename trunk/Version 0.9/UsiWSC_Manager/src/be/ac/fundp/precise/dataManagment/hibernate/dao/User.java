package be.ac.fundp.precise.dataManagment.hibernate.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * The Class User.
 */
@Entity(name="USERS")
public class User {
	
	/** The user id. */
	@Id
	private String userId;
	
	/** The password. */
	private String password;
	
	/** The is available. */
	private boolean isAvailable;
	
	/** The context. */
	@OneToOne
	private Context context;
	
	/** The role. */
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> role = new ArrayList<Role>();
	 
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the context.
	 *
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}
	
	/**
	 * Sets the context.
	 *
	 * @param context the new context
	 */
	public void setContext(Context context) {
		this.context = context;
	}
	
	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Collection<Role> getRole() {
		return role;
	}
	
	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Collection<Role> role) {
		this.role = role;
	}
	
	/**
	 * Checks if is available.
	 *
	 * @return true, if is available
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	
	/**
	 * Sets the available.
	 *
	 * @param isAvailable the new available
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
