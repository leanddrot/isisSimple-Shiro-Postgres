package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QRoles extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Roles> implements PersistableExpression<Roles>
{
    public static final QRoles jdoCandidate = candidate("this");

    public static QRoles candidate(String name)
    {
        return new QRoles(null, name, 5);
    }

    public static QRoles candidate()
    {
        return jdoCandidate;
    }

    public static QRoles parameter(String name)
    {
        return new QRoles(Roles.class, name, ExpressionType.PARAMETER);
    }

    public static QRoles variable(String name)
    {
        return new QRoles(Roles.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression name;
    public final StringExpression permissions;

    public QRoles(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.name = new StringExpressionImpl(this, "name");
        this.permissions = new StringExpressionImpl(this, "permissions");
    }

    public QRoles(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.name = new StringExpressionImpl(this, "name");
        this.permissions = new StringExpressionImpl(this, "permissions");
    }
}
