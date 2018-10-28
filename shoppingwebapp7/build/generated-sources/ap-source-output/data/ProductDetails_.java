package data;

import data.CategoryDetails;
import data.OrderTable;
import data.ReviewTable;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:56:18")
@StaticMetamodel(ProductDetails.class)
public class ProductDetails_ { 

    public static volatile SingularAttribute<ProductDetails, String> subCategory;
    public static volatile SingularAttribute<ProductDetails, String> image3;
    public static volatile SingularAttribute<ProductDetails, Integer> productID;
    public static volatile SingularAttribute<ProductDetails, Double> oldPrice;
    public static volatile SingularAttribute<ProductDetails, String> description;
    public static volatile SingularAttribute<ProductDetails, String> minDescription;
    public static volatile SingularAttribute<ProductDetails, String> image1;
    public static volatile SingularAttribute<ProductDetails, Double> newPrice;
    public static volatile SingularAttribute<ProductDetails, String> image2;
    public static volatile SingularAttribute<ProductDetails, String> productName;
    public static volatile CollectionAttribute<ProductDetails, ReviewTable> reviewTableCollection;
    public static volatile CollectionAttribute<ProductDetails, OrderTable> orderTableCollection;
    public static volatile SingularAttribute<ProductDetails, Integer> stock;
    public static volatile SingularAttribute<ProductDetails, CategoryDetails> categoryID;

}