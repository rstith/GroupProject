You can connect to the database, through your terminal using the following code:

`mysql -h 162.226.167.3 -P 3306 -u testuser -p BankHW`

You must enter the password `password`, when prompted.

bankHW = database

* Should change the package from `bankHW` to `database` for clarity.


Create the MySQL Database

```
DROP DATABASE BankHW;

CREATE DATABASE BankHW;

USE BankHW;

CREATE USER testuser IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON *.* TO 'testuser'@'%' WITH GRANT OPTION;

CREATE TABLE customer
(
  LName varchar(30) NOT NULL,
  FName Varchar(30),
  CustID Int(10) NOT NULL AUTO_INCREMENT,
  SSN Varchar(10),
  Street Varchar(128),
  City Varchar(30),
  State Varchar(2),
  ZIP Varchar(5),
  PRIMARY KEY (CustID)
);

CREATE TABLE employee(
LName 	VARCHAR(30),  
FName 	VARCHAR(30),  
EmpID 	Int(10) NOT NULL AUTO_INCREMENT,  
UName VARCHAR(30),  
Pass VARCHAR(30),  
Manager boolean,  
PRIMARY KEY (EmpID)
); 

CREATE TABLE savings(
  AccountID Int(10) NOT NULL AUTO_INCREMENT,
  Interest decimal(4,2) NOT NULL,
  Balance decimal(12,2) NOT NULL,
  Overdraft decimal(5,2) NOT NULL,
  Opened date,
  Active boolean,
  CustID Int(10) NOT NULL,
  PRIMARY KEY (AccountID),
  FOREIGN KEY (CustID) REFERENCES customer(CustID)
);

CREATE TABLE savingsrecord(
  TransactionID int(10) NOT NULL AUTO_INCREMENT,
  AccountID Int(10) NOT NULL,
  TransDate date,
  Description varchar(256) NOT NULL,
  Amount decimal(10,2) NOT NULL,
  PRIMARY KEY (TransactionID),
  FOREIGN KEY (AccountID) REFERENCES savings(AccountID)
);

CREATE TABLE cd(
  CustID Int(10) NOT NULL,
  AccountID int(10) NOT NULL AUTO_INCREMENT,
  Value decimal(10,2) NOT NULL,
  Interest decimal(5,3) NOT NULL,
  Maturity date NOT NULL,
  Opened date NOT NULL,
  Rollover date,
  Penalty varchar(256),
  PRIMARY KEY (AccountID),
  FOREIGN KEY (CustID) REFERENCES customer(CustID)
);

CREATE TABLE checking(
  CustID Int(10) NOT NULL,
  AccountID int(10) NOT NULL AUTO_INCREMENT,
  Value decimal(10,2) NOT NULL,
  Interest decimal(5,3) NOT NULL,
  Opened date NOT NULL,
  SavingsAcct Int(10),
  Type varchar(10) NOT NULL,
  AvgBal decimal(12,2),
  Active boolean NOT NULL,
  PRIMARY KEY (AccountID),
  FOREIGN KEY (CustID) REFERENCES customer(CustID),
  FOREIGN KEY (SavingsAcct) REFERENCES savings(AccountID)
);

CREATE TABLE checkingrecord(
  TransactionID	 int(10) NOT NULL AUTO_INCREMENT,
  AccountID int(10) NOT NULL,
  TransDate date NOT NULL,
  Amount decimal(10,2) NOT NULL,
  Description varchar(256),
  PRIMARY KEY (TransactionID),
  FOREIGN KEY (AccountID) REFERENCES checking(AccountID)
);

CREATE TABLE loan(
  CustID Int(10) NOT NULL,
  AccountID int(10) NOT NULL AUTO_INCREMENT,
  Type varchar(10) NOT NULL,
  Interest decimal(5,3) NOT NULL,
  Monthly decimal(7,2) NOT NULL,
  TotalAmt decimal(10,2) NOT NULL,
  NextDue date NOT NULL,
  CurrAmt decimal(10,2) NOT NULL,
  Flag boolean NOT NULL,
  LastFull date NOT NULL,
  PRIMARY KEY (AccountID),
  FOREIGN KEY (CustID) REFERENCES customer(CustID)
);

CREATE TABLE loanrecord(
  TransactionID int(10) NOT NULL AUTO_INCREMENT,
  AccountID int(10) NOT NULL,
  TransDate date NOT NULL,
  Amount decimal(10,2) NOT NULL,
  Description varchar(256),
  PRIMARY KEY (TransactionID),
  FOREIGN KEY (AccountID) REFERENCES loan(AccountID)
);

CREATE TABLE ccard(
  CustID Int(10) NOT NULL,
  AccountID int(10) NOT NULL AUTO_INCREMENT,
  Interest decimal(5,3) NOT NULL,
  TotalCredit decimal(12,2) NOT NULL,
  OpenCredit decimal(12,2) NOT NULL,
  UsedCredit decimal(12,2) NOT NULL,
  NextDue date NOT NULL,
  Penalty varchar(256),
  PRIMARY KEY (AccountID),
  FOREIGN KEY (CustID) REFERENCES customer(CustID)
);

CREATE TABLE ccardrecord(
  TransactionID	 int(10) NOT NULL AUTO_INCREMENT,
  AccountID int(10) NOT NULL,
  TransDate date NOT NULL,
  Amount decimal(10,2) NOT NULL,
  Description varchar(256),
  PRIMARY KEY (TransactionID),
  FOREIGN KEY (AccountID) REFERENCES ccard(AccountID)
);