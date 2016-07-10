***SOLID principles***

*S: Single responsibility principle*
 
    It's violated in Product class because it includes not only encapsulating fields
    but also logic related validation and delivering product
 
*O: Open Close principle* 

    In ProductService we use different logic for working with different repositories.
    When we will want to use new repository(for example in memory) we should add logic to ProductService.
    The better way is create ProductRepository interface and its instanse use to construct ProductService.
    Each approach for working with products will be implemented in classes based on this interfaces.
    
