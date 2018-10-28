package data;

import data.ProductDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-14T13:56:18")
@StaticMetamodel(CategoryDetails.class)
public class CategoryDetails_ { 

    public static volatile SingularAttribute<CategoryDetails, String> description;
    public static volatile CollectionAttribute<CategoryDetails, ProductDetails> productDetailsCollection;
    public static volatile SingularAttribute<CategoryDetails, String> categoryName;
    public static volatile SingularAttribute<CategoryDetails, Integer> categoryID;

}