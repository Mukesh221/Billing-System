/* Execute these commands step by step*/

/*		Command 1(This will create a database)		*/
/* create database surabi;*/
 
 
 /*		Command 2(Use the surabi database for next commands)		*/
 use surabi;
 
 
 /*		Command 3(Create a Bill table. This will store all the orders made by user)		*/
 create table Bill(
 billId int NOT NULL auto_increment,
 billDate varchar(30),
 totalAmount int,
 primary key (billId)
 );
 
 /*		Command 4(Create the menu table. This will store the items available in the restaurant)	*/
 create table Menu(
 menuId int,
 itemName varchar(30),
 itemCost int
 );
 
  
  
 /*		Command	5(Create a user table. This will store the credentials of all users)		*/
 create table User(
 userId int not null auto_increment,
 userName varchar(40),
 userPassword varchar(50),
 primary key(userId)
 );
 
 /*		Command	6(Insert some users into the users table)		*/
 insert into User
 values
 (1,'FirstUser','qwerty'),
 (2,'SecondUser','123456');
 
 
 /*		Command	7(Insert the items available at the restaurant in the menu)*/
  insert into Menu
  value 
  (1,'item1', 40),
  (2,'item2',50),
  (3,'item3',60),
  (4,'item4', 20),
  (5,'item5', 30),
  (6,'item6',70),
  (7,'item7',30),
  (8,'item8',60);
  
  /*	Command8 (Create a admin table. This will store the credentials of all admin) */
 create table Admin(
 adminId int NOT NULL auto_increment,
 adminName varchar(40),
 adminPassword varchar(50),
 primary key(adminId)
 );
 
  /*		Command	9(Insert some admin into the users table)		*/
 insert into Admin
 values
 (1,'FirstAdmin','qwerty'),
 (2,'SecondAdmin','123456'); 
  
   
  select * from admin;
  select * from bill;
  select * from menu;
  select * from user;
   
    
 