package dom.simple;

import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;


@PersistenceCapable(table = "roles")
@Bounded
public class Roles {
	
	// {{ Name (property)
	private String name;

	@Title
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull="false", name = "name")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	// }}


	// {{ Permissions (property)
	private String permissions;

	@MemberOrder(sequence = "1.5")
	@javax.jdo.annotations.Column(allowsNull="false", name = "permissions")
	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(final String permissions) {
		this.permissions = permissions;
	}
	// }}

	
	

}
