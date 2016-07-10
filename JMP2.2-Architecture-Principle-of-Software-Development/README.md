**Task: Mentee has to implement examples of erroneous application with using SOLID principles**


***SOLID principles***

*S: Single responsibility principle*
 
    It's violated in Product class because it includes not only encapsulating fields
    but also logic related validation and delivering product
 
*O: Open Close principle* 

    In ProductService we use different logic for working with different repositories.
    When we will want to use new repository(for example in memory) we should add logic to ProductService.
    The better way is create ProductRepository interface and its instanse use to construct ProductService.
    Each approach for working with products will be implemented in classes based on this interfaces.
    
*L: Liskov's substitution principle*

    It's broken in inheritance between Product and CubeProduct.
    After creating cube product with lenth of side 3 for example we can change it's heigh field directly.
    After invoking getVolume() method we will get unexpected result. 
    
*I: Interface segregation principle*

    IProductService is used to saving, getting products. For adding them to cart, checkout and delivering.
    Their goals should be implemented in different services as CheckoutService, DeliveringService, CartService.
    
*D: Dependency Inversion principle*

    Its broken in ProductService. We hardcoded instantiantiating instanse for this class in static method initWithDb 
    and initWithFile where we create according repository.
    The better way is pass this repository(based on the same interface) to constructor of ProductService.
    
