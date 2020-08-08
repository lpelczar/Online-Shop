# Online shop

## Description

In an Online Shop, there are Products, which you can browse. They are usually categorised within ProductCategory, and sometimes they have an expiration date. User can add some products to Basket

The following UML class diagram shows the structure and relationships of program. 

![c1](https://raw.github.com/lpelczar/Online-Shop/master/docs/UML-part1.png)

Please use the following package package name: frompythontojava.onlineshop.part1
- In the package, implement all the classes (Product, ProductCategory, FeaturedProductCategory, Basket, ProductIterator, Iterator) from the diagram.
- Constructors has to automatically generate an ID value for the instances.
- Use Iterator pattern to iterate through all products in basket. 
- Implement all the methods with the specified return values. Follow the rules from the diagram.
- Decide which fileds should be accessed by user and create getters and setters for them. 
- The toString() methods have to return the following:
- default: a comma separated list of Object Fields, example: ID:1,name:dvdplayer,defaultprice:2.33,etc.
- If it's overriden, it starts with the name of the actual class, example: FeaturedProductCategory:ID:1,name:dvdplayer,etc.
- You don't need to write other business logic inside the methods, focus on the interactions between classes.
- Test your solution with instances in a Main class, with a main() method. 
- Call all the constructors and methods in different ways and print out the results to System.out
- It's not enough to test only one constructor for example, so test it precisely.

In an Online Shop, when you finished adding your Products to the Basket , you want to checkout and pay. Usually in the background, there's an Order entity which has a status field and it changes through this process.

Here's an UML class diagram, which shows the structure and relationships between the Order and the 2 processes: CheckoutProcess and PayProcess.

![c1](https://raw.github.com/lpelczar/Online-Shop/master/docs/UML-part2.png)

Please use the following package package name: frompythontojava.onlineshop.part2. 
- In the package, implement all the classes ( AbstractProcess, CheckoutProcess, PaymentProcess, Orderable, Order ) from the diagram.
- Constructors have to automatically generate an id value for the instances.
- Implement all the methods with the specified return values:
- In the Order class, the checkout() and pay() methods have to change the status of the instance: new -> checked -> payed
- In the AbstractProcess class, the  process() method should initiate the changes, but it contains substeps ( stepBefore and stepAfter ) which are defined in the abstract level.
- Implementation of stepBefore() and stepAfter() methods is up to you.
- You don't need to write other business logic inside the methods, focus on the interactions between classes.
- Test your solution with instances in a Main class , with a main() method. 
- Call all the constructors and methods in different ways and print out the results to System.out

## User stories

1. As a user I would like to create new product. 
2. As a user I would like to create new product category or new featured product category.
3. As a user I would like to add some products to the basket.
4. As a user I would like to see all products in my basket. 
5. As a user I would like to remove product from basket.
6. As a user I would like to get list of all available products. 
7. As a user I would like to get list of products from specific product category.
8. As a user I would like to check availability of specific product. 
9. As a user I would like to pay for my order.

## More info

Project made for [Codecool](https://codecool.com/) programming course.
