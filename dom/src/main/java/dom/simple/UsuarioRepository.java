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

@DomainService(menuOrder = "20", repositoryFor = Usuario.class)
public class UsuarioRepository {
	
	// //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    public String getId() {
        return "user";
    }

    public String iconName() {
        return "SimpleObject";
    }

    

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////
    
    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named ("Listar Alumnos")
    public List<Usuario> listAll() {
        return container.allInstances(Usuario.class);
    }

    //region > create (action)
    // //////////////////////////////////////
    
    @MemberOrder(sequence = "2")
    public Usuario create(
            final @Named("Nombre de usuario") String userName,
            final @Named("Contraseña") String password,
            final @Named("Rol") Roles rol)
            {
        
    	final Usuario obj = container.newTransientInstance(Usuario.class);
        
    	obj.setUserName(userName);
        obj.setPassword(password);
        obj.setRoles(rol);
        container.persistIfNotAlready(obj);
        return obj;
    }

    //endregion
    
    
  //region > create rol (action)
    // //////////////////////////////////////
    
    @MemberOrder(sequence = "3")
    public List<Roles> createRol(
            final @Named("Nombre del rol") String nombre,
            final @Named("Permisos") String permisos)
            
            {
        
    	final Roles obj = container.newTransientInstance(Roles.class);
        
    	obj.setName(nombre);
        obj.setPermissions(permisos);
        
        container.persistIfNotAlready(obj);
        return listAllRoles();
    }

    //endregion
    
    // //////////////////////////////////////
    // List roles(action)
    // //////////////////////////////////////
    
    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named ("Listar roles")
    public List<Roles> listAllRoles() {
    	
        return container.allInstances(Roles.class);
    }

    
    
    // //////////////////////////////////////
    // Injected services
    // //////////////////////////////////////

    @javax.inject.Inject 
    DomainObjectContainer container;
}
