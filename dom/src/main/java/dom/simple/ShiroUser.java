package dom.simple;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Render;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("ShiroUser")
public class ShiroUser {
	
	// {{ UserName (property)
	private String userName;

	@MemberOrder(sequence = "1")
	@Column(allowsNull = "false")
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
	@Column(allowsNull = "false")
	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
	// }}
	
	
	// {{ RolesList (Collection)
	@Join
	@Element(dependent = "true")
	
	private SortedSet<Role> rolesList = new TreeSet<Role>();

	
	@MemberOrder(sequence = "3")
	@Render(org.apache.isis.applib.annotation.Render.Type.EAGERLY)
	public SortedSet<Role> getRolesList() {
		return rolesList;
	}

	public void setRolesList(final SortedSet<Role> rolesList) {
		this.rolesList = rolesList;
	}
	// }}

	//region > add role (action)
    // //////////////////////////////////////
    
    @MemberOrder(sequence = "3")
    
    public ShiroUser addRole(
            final @Named("Role") Role role) {
              
        rolesList.add(role);
        
        return this;
    }

    //endregion



    //region > injected services
    // //////////////////////////////////////

    @javax.inject.Inject 
    DomainObjectContainer container;

    //endregion

}
