# Orso


School project from course "Webservices in Java" 

För att starta programmet så öppna först filen docker-composer.yaml och kör den från toppen.

Gå sedan in i filen src/main/java/com/nosa/orso/OrsoApplication.java och kör programmet där.

Sen går det att testa vi Postman.

Jag tror att denna länk går till en collection i Postman:
https://api.postman.com/collections/21044339-092fa96d-9742-4644-a29a-40246085c4ed?access_key=PMAT-01GKMCGDEW6N78C2VNH8NHTBD4

Annars är det:

localhost:8080/customer/getAllCustomers

localhost:8080/customer/saveCustomer

localhost:8080/customer/deleteCustomer/{id}

localhost:8080/customer/updateCustomer/{id}

localhost:8080/customer/getCustomer/{id}

localhost:8080/customer/getVegetarians

Om programmet strular och ger ett felmeddelande som lyder någonting i stilen "authentication issue".
Testa då att byta portarna i docker-composer.yaml från 27017:27017 till 8082:27017.
Gör även detta för src/main/resources/application.properties. Från 27017:27017 till 8082:27017.
