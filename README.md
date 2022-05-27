# Farm Game Back End


Our application is a farm game where the user can play around with funtionality involving building farms, inputting fields, buying/selling crops and acummulating money.


## Project Description
### What the application does
Farm - The user can create and name a farm which will automatically have funds of £1000. Here they can fill it with fields.
<br/>

Field - Within the farm, the user can purchase many fields which must be given a name and a fieldtype. 
<br/>

Fieldtype - Each fieldtype will have a cost and size.
<br/>

Crop - The user can also purchase crops which have a price, stock and time for growth. Only 1 crop can be put into a field. When purchased, the stock of the crop is reduced by the size of the field it is put on.
<br/>

Soil - There are also preset soil types and soil effects which can be selected from an enum list that affect the growth time of the crops and therefore affect when they're ready to sell. They can also effect the price at which the crop is sold at.
<br/>

The user can move to the next day and the application will record this. If crops are ready to sell (growing time is reached) then the fields get automatically cleared and sold and the money is generated in the farm.



### How to use the application
When the application is run, user can connect to swagger ui via local host port 8080 URL - http://localhost:8080/swagger-ui/index.html#/
<br/>

Here they can use the GET, POST, PUT, DELETE and PATCH mapping in each controller to alter the game.
<br/>

The user can view the relations between the objects using the h2 console. It can be accessed by URL http://localhost:8080/h2
<br/>

Here they can connect to the database and view the different tables generated from the application and use SELECT queries for filteration.
