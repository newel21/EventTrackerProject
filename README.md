## Event Tracker Project - Weekend 11 Skill Distillery Project

### How the program works: Equipment Tracker
The program has an Entity (equipment) where a full CRUD functionality can be
implemented. You can test these functionality through the postman app.

CREATE:
Change the method to POST. Then put "http://localhost:8085/api/equipment" in the
Request URL. Go to the "body" tag, select the "raw" button, then select JSON
from the dropdown menu. You will then copy a sample JSON body from a GET method
provide the information needed to add an equipment then hit the "send" button.

READ:
Select the GET method. Then put "http://localhost:8085/api/equipment" in the
Request URL if you want to search a list or equipment. You can also put
"http://localhost:8085/api/equipment/1" to view the equipment with the id:1.
Hit the "send" button to proceed with the search.

UPDATE:
Select the PUT method. Then put "http://localhost:8085/api/equipment/1" in the
Request URL to be able to edit the equipment id:1. You will need to copy the
JSON body from the GET method and change whatever detail you wish to change.
Hit the "send" button to proceed with the change.

DELETE:
Select the DELETE method. Then put "http://localhost:8085/api/equipment/1" or
try the id from the one you just created. Then hit the "send" button to delete
the selected item.

## Technology used:
Gradle, JPA, REST, Postman, JUnit (to test the Entity Mapping), MySQL Workbench
