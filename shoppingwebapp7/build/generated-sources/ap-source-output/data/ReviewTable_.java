package data;

import data.CustomerTable;
import data.ProductDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:56:18")
@StaticMetamodel(ReviewTable.class)
public class ReviewTable_ { 

    public static volatile SingularAttribute<ReviewTable, ProductDetails> productID;
    public static volatile SingularAttribute<ReviewTable, String> review;
    public static volatile SingularAttribute<ReviewTable, String> subject;
    public static volatile SingularAttribute<ReviewTable, String> name;
    public static volatile SingularAttribute<ReviewTable, CustomerTable> customerID;
    public static volatile SingularAttribute<ReviewTable, Integer> reviewID;
    public static volatile SingularAttribute<ReviewTable, String> email;

}