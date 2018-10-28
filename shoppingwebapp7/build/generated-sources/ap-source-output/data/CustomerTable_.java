package data;

import data.OrderTable;
import data.ReviewTable;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:56:18")
@StaticMetamodel(CustomerTable.class)
public class CustomerTable_ { 

    public static volatile SingularAttribute<CustomerTable, String> image;
    public static volatile SingularAttribute<CustomerTable, String> newsletter;
    public static volatile SingularAttribute<CustomerTable, String> address;
    public static volatile SingularAttribute<CustomerTable, String> gender;
    public static volatile SingularAttribute<CustomerTable, Integer> creditCardNo;
    public static volatile SingularAttribute<CustomerTable, String> creditCardType;
    public static volatile SingularAttribute<CustomerTable, String> password;
    public static volatile SingularAttribute<CustomerTable, String> phone;
    public static volatile SingularAttribute<CustomerTable, String> customerFirstName;
    public static volatile SingularAttribute<CustomerTable, Integer> customerID;
    public static volatile CollectionAttribute<CustomerTable, ReviewTable> reviewTableCollection;
    public static volatile SingularAttribute<CustomerTable, String> customerLastName;
    public static volatile CollectionAttribute<CustomerTable, OrderTable> orderTableCollection;
    public static volatile SingularAttribute<CustomerTable, String> email;

}