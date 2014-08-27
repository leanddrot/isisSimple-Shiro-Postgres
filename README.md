
isisSimple-Shiro-Postgres
=========================


(ENG)


_Test of Shiro users management from Isis, and persistence in PostgreSQL_

* Create a user "isis" with password "isis" in PostgreSQL
* Create a database named "isisSimple"
* Compile and run the project:

$ mvn clean install

$ java -jar webapp/target/isisSimple-webapp-1.0-SNAPSHOT-jetty-console.jar

* Run these scripts to add a user named "pepito", with password "123456", who has an "administrator" role
  and full permissions
* login with user "pepito" and pass "123456"


(SPA)

 
_Prueba de manejo de usuarios Shiro desde Isis, y persistencia en PostgreSQL_

* Crea un usuario "isis" con password "isis" en postgreSQL
* Crea una base de datos llamada "isisSimple"
* Compila y ejecuta el proyecto:

$ mvn clean install

$ java -jar webapp/target/isisSimple-webapp-1.0-SNAPSHOT-jetty-console.jar

* Ejecuta estos scripts para crear un usuario llamado "pepito" con password "123456", que tiene un rol 
  "administrator" que le da permisos totales
* logueate con usuario "pepito" y pass "123456"


_SQL_
===

INSERT INTO "ShiroUser"(
            id, password, "userName", version)
    VALUES (100, '123456', 'pepito', 1);

INSERT INTO "Role"(
            id, "roleName", version)
    VALUES (100, 'administrator', 1);

INSERT INTO "Permission"(
            id, "permissionDescription", "permissionText", version)
    VALUES (100, 'everything', '*', 1);

INSERT INTO "ShiroUser_rolesList"(
            "id_OID", "id_EID")
    VALUES (100, 100);

INSERT INTO "Role_permissionsList"(
            "id_OID", "id_EID")
    VALUES (100, 100);
