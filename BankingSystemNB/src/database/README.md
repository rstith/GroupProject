You can connect to the database, through your terminal using the following code:

`mysql -h 162.226.167.3 -P 3306 -u testuser -p BankHW`

You must enter the password `password`, when prompted.

bankHW = database

* Should change the package from `bankHW` to `database` for clarity.


Create the MySQL Database

```
CREATE TABLE customer
(
  LName varchar(30) NOT NULL,
  FName	     VARCHAR(30),
  CustID INT(10) NOT NULL,
  PRIMARY KEY ( CustID )
);

CREATE TABLE savings(
  AcctID	  int(10) NOT NULL,
  Interest    decimal(4,2) NOT NULL,
  Balance  	  decimal(12,2) NOT NULL,
  Overdraft	  decimal(5,2) NOT NULL,
  Opened	  date,
  Active	  boolean,
  Owner		  int(10) NOT NULL,
  PRIMARY KEY (AcctID),
  FOREIGN KEY (Owner) REFERENCES customer(CustID)
);

CREATE TABLE savingsrecord(
  TransactionID	 int(10) NOT NULL,
  Date		     date,
  Description	 varchar(256) NOT NULL,
  Amount	     decimal(10,2) NOT NULL,
  Account	 int(10) NOT NULL,
  PRIMARY KEY (TransactionID),
  FOREIGN KEY (Account) REFERENCES savings(AcctID)
);

CREATE TABLE cd(
  OwnerID	 int(10),
  DepositID	 int(10),
  Value		 decimal(10,2),
  Interest	 decimal(5,3),
  Maturity	 date,
  Opened	 date,
  Rollover	 date,
  Penalty	 varchar(256),
  PRIMARY KEY (DepositID),
  FOREIGN KEY (OwnerID) REFERENCES customer(CustID)
);

CREATE TABLE checking(
  OwnerID	 int(10),
  AcctID	 int(10),
  Value		 decimal(10,2),
  Interest	 decimal(5,3),
  Opened	 date,
  SavingsAcct	 int(10),
  Type		 varchar(10),
  AvgBal	 decimal(12,2),
  Active	 boolean,
  PRIMARY KEY (AcctID),
  FOREIGN KEY (OwnerID) REFERENCES customer(CustID)
);

CREATE TABLE checkingrecord(
  TransactionID	 int(10),
  AcctID	 int(10),
  TransDate      date,
  Value		 decimal(10,2),
  Description	 varchar(256),
  PRIMARY KEY (TransactionID),
  FOREIGN KEY (AcctID) REFERENCES checking(AcctID)
);

CREATE TABLE loan(
  OwnerID	 int(10),
  LoanID	 int(10),
  Type		 varchar(10),
  Interest	 decimal(5,3),
  Monthly	 decimal(7,2),
  TotalAmt	 decimal(10,2),
  NextDue	 date,
  CurrAmt	 decimal(10,2),
  Flag		 boolean,
  LastFull	 date,
  PRIMARY KEY (LoanID),
  FOREIGN KEY (OwnerID) REFERENCES customer(CustID)
);

CREATE TABLE ccard(
  OwnerID	 int(10),
  CardID	 int(10),
  Interest	 decimal(5,3),
  TotalCredit	 decimal(12,2),
  OpenCredit	 decimal(12,2),
  UsedCredit	 decimal(12,2),
  NextDue	 date,
  Penalty	 varchar(256),
  PRIMARY KEY (CardID),
  FOREIGN KEY (OwnerID) REFERENCES customer(CustID)
);

CREATE TABLE ccardrecord(
  TransactionID	 int(10),
  CardID	 int(10),
  TransDate	 date,
  Amount	 decimal(10,2),
  Description	 varchar(256),
  PRIMARY KEY (TransactionID),
  FOREIGN KEY (CardID) REFERENCES ccard(CardID)
);
```
