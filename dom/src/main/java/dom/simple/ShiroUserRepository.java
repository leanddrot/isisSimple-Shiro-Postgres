package dom.simple;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics.Of;


@DomainService(menuOrder = "25", repositoryFor = ShiroUser.class)
@Named("ShiroUser")
public class ShiroUserRepository {
	

    //region > identification in the UI
    // //////////////////////////////////////

    public String getId() {
        return "shirouser";
    }

    public String iconName() {
        return "SimpleObject";
    }

    //endregion

    //region > listAll (action)
    // //////////////////////////////////////

    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<ShiroUser> listAll() {
        return container.allInstances(ShiroUser.class);
    }

    //endregion

    //region > create (action)
    // //////////////////////////////////////
    
    @MemberOrder(sequence = "2")
    
    public ShiroUser create(
            final @Named("Name") String userName,
            final @Named("Password") String password,
            final @Named("Role") Role role) {
        final ShiroUser obj = container.newTransientInstance(ShiroUser.class);
        
        final SortedSet<Role> rolesList = new TreeSet<Role>();
        rolesList.add(role);
        obj.setUserName(userName);
        obj.setPassword(password);
        obj.setRolesList(rolesList);
        container.persistIfNotAlready(obj);
        return obj;
    }

    //endregion
    
    
  
    //region > injected services
    // //////////////////////////////////////

    @javax.inject.Inject 
    DomainObjectContainer container;

    //endregion

	
}
