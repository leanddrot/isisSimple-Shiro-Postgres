package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QUsuario extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Usuario> implements PersistableExpression<Usuario>
{
    public static final QUsuario jdoCandidate = candidate("this");

    public static QUsuario candidate(String name)
    {
        return new QUsuario(null, name, 5);
    }

    public static QUsuario candidate()
    {
        return jdoCandidate;
    }

    public static QUsuario parameter(String name)
    {
        return new QUsuario(Usuario.class, name, ExpressionType.PARAMETER);
    }

    public static QUsuario variable(String name)
    {
        return new QUsuario(Usuario.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression userName;
    public final StringExpression password;
    public final dom.simple.QRoles roles;

    public QUsuario(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.userName = new StringExpressionImpl(this, "userName");
        this.password = new StringExpressionImpl(this, "password");
        if (depth > 0)
        {
            this.roles = new dom.simple.QRoles(this, "roles", depth-1);
        }
        else
        {
            this.roles = null;
        }
    }

    public QUsuario(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.userName = new StringExpressionImpl(this, "userName");
        this.password = new StringExpressionImpl(this, "password");
        this.roles = new dom.simple.QRoles(this, "roles", 5);
    }
}
