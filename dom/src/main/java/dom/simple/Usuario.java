package dom.simple;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;


@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE,
						table = "usuarios")
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")

@ObjectType("USER")
@Bookmarkable

public class Usuario {
	
	// {{ UserName (property)
	private String userName;

	@javax.jdo.annotations.Column(allowsNull="false", name = "name")
	@MemberOrder(sequence = "1")
	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}
	// }}


	// {{ Password (property)
	private String password;

	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull="false", name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
	// }}
	
	// {{ Roles (property)
	private Roles roles;

	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(allowsNull="false", name = "roles")
	public Roles getRoles() {
		return roles;
	}

	public void setRoles(final Roles roles) {
		this.roles = roles;
	}
	// }}



	
}
