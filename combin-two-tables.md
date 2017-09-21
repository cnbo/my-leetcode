## Combine Two Tables

Table: ``Person``

> | Column Name | Type |
> | ---- | ---- |
> | PersonId | int |
> | FirstName | varchar |
> | LastNmae | varchar |
> PersonId is the primary key Column for this table.

Table: ``Address``

> | Column Name | Type |
> | ---- | ---- |
> | AddressId | int |
> | PersonId | int |
> | City | varchar |
> | State | varchar |
> AddressId is the primary key Column for this table.

Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

> FirstName, LastNmae, City, State

## 代碼實現

```
SELECT 
    FIRSTNAME, LASTNAME, CITY, STATE 
FROM 
    PERSON, ADDRESS 
WHERE 
    PERSON.PERSONID = ADDRESS.PERSONID;
```