SELECT * FROM signup;
USE bankSystem;
CREATE TABLE signuptwo(
form_no VARCHAR(30),
religion VARCHAR(30),
category VARCHAR(30),
income VARCHAR(30),
education VARCHAR(30),
occupation VARCHAR(30),
pan VARCHAR(60),
aadhar VARCHAR(60),
seniorcitizen VARCHAR(30),
existing_account VARCHAR(30)
);
SELECT * FROM signuptwo;

CREATE TABLE signupthree(
form_no VARCHAR(30),
account_type VARCHAR(60),
card_number VARCHAR(60),
pin VARCHAR(30),
facility VARCHAR(200)
);
SELECT * FROM signupthree;

DROP TABLE IF EXISTS login;
CREATE TABLE login(
form_no VARCHAR(30),
 card_number VARCHAR(50),
pin VARCHAR(30)
);
SELECT * FROM login;

SHOW TABLES;

CREATE TABLE bank (
pin VARCHAR(10),
date VARCHAR(50),
type VARCHAR(20),
amount VARCHAR(20)
);

SELECT * FROM bank;
