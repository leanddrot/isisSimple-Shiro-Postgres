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


@DomainService(menuOrder = "45", repositoryFor = Permission.class)
@Named("Permission")
public class PermissionRepository {
	
	 //region > identification in the UI
    // //////////////////////////////////////

    public String getId() {
        return "Permission";
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
    public List<Permission> listAll() {
        return container.allInstances(Permission.class);
    }

    //endregion

    //region > create (action)
    // //////////////////////////////////////
    
    @MemberOrder(sequence = "2")
    
    public Permission create(
            final @Named("Description") String permissionDescription,
            final @Named("Permission") String permissionText) {
        final Permission obj = container.newTransientInstance(Permission.class);
        
        
        obj.setPermissionDescription(permissionDescription);
        obj.setPermissionText(permissionText);
        
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
