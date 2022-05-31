# Farm Game Back End


Our application is a farm game where the user can play around with funtionality involving building farms, inputting fields, buying/selling crops and acummulating money.


## Project Description
### What the application does
Farm - The user can create and name a farm which will automatically have funds of £1000. Here they can fill it with fields.
<br/>

Field - Within the farm, the user can purchase many fields which must be given a name and a fieldtype. If the fieldtype selected is already associated with a soil type, then the field is assigned that soil type, otherwise the field gets a soil type assigned randomly.
<br/>

Fieldtype - Each fieldtype will have a cost and size.
<br/>

Crop - The user can also purchase crops which have a price, stock and time for growth. Only 1 crop can be put into a field. When purchased, the stock of the crop is reduced by the size of the field it is put on.
<br/>

Soil - There are also preset soil types and soil effects which can be selected from an enum list that affect the growth time of the crops and therefore affect when they're ready to sell. They can also affect the price at which the crop is sold at. The soil types and effects appear in the database as integers starting from 0, and their integer value here is their index in the enum they belong to.
<br/>

The user can move to the next day on a given farm and the application will record this. If crops are ready to sell (growing time is reached) then the fields get automatically cleared and sold and the money is generated in the farm.

### ER diagrams

<img width="703" alt="image" src="https://user-images.githubusercontent.com/93927995/171015421-3401598d-4e0e-4499-93d2-3bd7c534a7fe.png">

## Functionality Available

Farms, fields, crops and field types all have the following routines:
* to return all of their elements, 
* to return individual elements based on index, 
* post a new item (a farm only requires a name as its funds are set to 1000 and fields to null, and a field starts with no crop on it),
* to delete an element based on index (with a cascading effect, so that for example if a farm is deleted so are all its assiocated fields).

Crops has an update feature that allows any property assiocated with a pre-existing crop (identified by its id) to be updated. <br/>

Farms has two extra routines:
* a buy field routine, which creates a new field associated with a given farm, taking away the field price from that farm's funds. The field does not start with a crop on it,
* a next day routine, which decreases the time left on any field associated with a given farm by 1, unless it is already 0 and has a crop, in which case the money generated from all such fields is calculated and added to the farm's funds, and those field are cleared.

Fields has the put a crop in a field routine, which puts a given crop in a given field. The growth time for the crop based on its associated soil types and effects is calculated and this change is recorded in the database.

### How to use the application
When the application is run, user can connect to swagger ui via local host port 8080 URL - http://localhost:8080/swagger-ui/index.html#/
<br/>

Here they can use the GET, POST, PUT, DELETE and PATCH mapping in each controller to alter the game.
<br/>

The user can view the relations between the objects using the h2 console. It can be accessed by URL http://localhost:8080/h2
<br/>

Here they can connect to the database and view the different tables generated from the application and use SELECT queries for filteration.
