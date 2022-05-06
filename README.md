# CRM (Customer Relationship Management) demo project

## SQUAD 4 (@codebreackers):
-Paula Esteban
-Pilar Alvarez
-Maria Jerez
-Yadira Calzadilla

The project consists in a CRM demo for the LBL Trucking Company. The solution provides some options to the company administration for managing clients, possible clients and sales. The Diagram of Use Cases below show the possible actions:

## DIAGRAM OF USE CASES

![Case Use Diagram](https://user-images.githubusercontent.com/100872227/167144434-3cd0b7fa-0300-412a-8e1f-e8febf2ffdee.jpg)

For the functioning of the project there are the Class Diagram below:

## CLASS DIAGRAM

![Classes Diagram](https://user-images.githubusercontent.com/100872227/167144486-b0d85f54-8b3f-4d9f-aca6-3706ed5bbc86.jpg)


In order to perform the actions, the user has the following options:

![Menu options](https://user-images.githubusercontent.com/100872227/167144535-1dc20a45-0b6b-4230-a229-e24ae1d79b88.jpg)

The user must type the command for the option wants to perform:

“New Lead” for creating a new lead, and introduce all its information: name, phone number, email, and company name it work for.

![Create Lead](https://user-images.githubusercontent.com/100872227/167144608-14b5ccfe-38c6-480b-8b26-58ac5b99e434.jpg)

“Show Leads” display a list with the names of the Leads. 

![Show leads](https://user-images.githubusercontent.com/100872227/167144690-b2e96f9a-c375-4a58-8ccf-688b0474f610.jpg)


“Lookup Lead” display an individual Lead’s details typing in this case the id of the Lead.

![Show details of a Lead](https://user-images.githubusercontent.com/100872227/167144778-d2ba67c1-bf7f-4a98-9312-4adbb3372d7e.jpg)

“Convert” permit to transform a Lead into an Opportunity. In that case is necessary to type the id of the Lead to convert in. When a Lead is converted, the user will be prompted for the product and the number of trucks for this Opportunity. A new Opportunity is created with the above information and with the new Contact as the decisionmaker for the Opportunity and a status of “OPEN”. 

When a Lead is converted, the user will be prompted for the industry, number of employees, city, and country of the organization. An Account represents the company that is looking to buy a truck. Leads are removed from the system once they have been successfully converted.

![Convert aLead into Opportunity](https://user-images.githubusercontent.com/100872227/167144837-1a4a51d0-685e-4e87-af2d-de499f735fe5.jpg)

“Change status” permit to transform the status of the Opportunity. In that case the user, once selected the option, must indicate “close-lost id” or “close-won id” in order to change the Opportunity corresponding to the typed id.

![Change Opportunity status](https://user-images.githubusercontent.com/100872227/167144933-3130b895-99aa-48a0-ad23-fbba0ed29c38.jpg)

“Exit” the program is closed.

![Exit](https://user-images.githubusercontent.com/100872227/167144975-2da7a9e1-6c9d-43e8-9369-0fee7cbd911a.jpg)

@codebreackers

