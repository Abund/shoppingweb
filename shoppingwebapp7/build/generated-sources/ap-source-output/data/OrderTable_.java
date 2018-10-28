package data;

import data.AdminTable;
import data.CustomerTable;
import data.ProductDetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:56:18")
@StaticMetamodel(OrderTable.class)
public class OrderTable_ { 

    public static volatile SingularAttribute<OrderTable, String> image;
    public static volatile SingularAttribute<OrderTable, Double> amount;
    public static volatile SingularAttribute<OrderTable, Integer> quantity;
    public static volatile SingularAttribute<OrderTable, ProductDetails> productID;
    public static volatile SingularAttribute<OrderTable, Integer> orderID;
    public static volatile SingularAttribute<OrderTable, AdminTable> adminID;
    public static volatile SingularAttribute<OrderTable, CustomerTable> customerID;
    public static volatile SingularAttribute<OrderTable, Date> orderDate;
    public static volatile SingularAttribute<OrderTable, String> status;

}