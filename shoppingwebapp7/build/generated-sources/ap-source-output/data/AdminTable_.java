package data;

import data.OrderTable;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:56:18")
@StaticMetamodel(AdminTable.class)
public class AdminTable_ { 

    public static volatile SingularAttribute<AdminTable, String> password;
    public static volatile SingularAttribute<AdminTable, String> address;
    public static volatile SingularAttribute<AdminTable, String> gender;
    public static volatile SingularAttribute<AdminTable, Integer> phone;
    public static volatile SingularAttribute<AdminTable, Integer> adminID;
    public static volatile SingularAttribute<AdminTable, String> adminFirstName;
    public static volatile SingularAttribute<AdminTable, String> adminLastName;
    public static volatile CollectionAttribute<AdminTable, OrderTable> orderTableCollection;
    public static volatile SingularAttribute<AdminTable, String> email;

}