CREATE database if not exists Payments;

create table if not exists payment
(name varchar(200),display_name varchar(200),payment_type varchar(200),primary key(payment_type))

create table if not exists paymentplans
(id SERIAL,net_amount float,tax_amount float,gross_amount float,currency varchar(200),duration varchar(200),payment_type varchar(200),primary key(id))

ALTER TABLE paymentplans 
ADD CONSTRAINT fk_paymentplans FOREIGN KEY (payment_type) REFERENCES payment (payment_type);
    
 INSERT INTO payment(name,display_name,payment_type)
VALUES ('BilalFarooq','Bilal','Card');  

INSERT INTO paymentplans(id,net_amount,tax_amount,gross_amount,currency,duration,payment_type)
VALUES (1,2.1,100,200,'USD','month','Card');
   