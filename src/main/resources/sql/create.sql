create table BANK(
id number(4),
name varchar(50)
);

CREATE TABLE PARTY (
  id number(10),
  bank_id number(4),
  party_name varchar(255),
  phone varchar(16),
  party_type varchar(8)
)
;

CREATE TABLE CURRENCY (
  ID VARCHAR(3) AUTO_INCREMENT
, FULL_NAME VARCHAR2(50)
);


CREATE TABLE ACCOUNT (
  id number AUTO_INCREMENT,
  account_id number,
  currency_id varchar(3),
  balance number(18,2)
);


CREATE TABLE TRANSACTIONS (
TX_ID number AUTO_INCREMENT,
CREATE_DATE DATE,
TYPE VARCHAR(4),
SUMMA NUMBER(18,2),
DECRIPTION VARCHAR2(255)
);

create table WIRES (
ID number AUTO_INCREMENT,
TX_ID NUMBER,
FROM_PARTY_ID NUMBER,
TO_PARTY_ID BUMBER,
SUMMA NUMBER(18,2)
);

