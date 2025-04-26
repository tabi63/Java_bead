-- DROP SCHEMA "Orders";

CREATE SCHEMA "Orders" AUTHORIZATION postgres;

-- Drop table

-- DROP TABLE "Orders".orderstate;

CREATE TABLE "Orders".orderstate (
	id serial4 NOT NULL,
	description varchar(20) NOT NULL,
	CONSTRAINT orderstate_pk PRIMARY KEY (id)
);


-- "Orders"."order" definition

-- Drop table

-- DROP TABLE "Orders"."order";

CREATE TABLE "Orders"."order" (
	id bigserial NOT NULL,
	costumername varchar(100) NOT NULL,
	costumeraddress varchar(1000) NOT NULL,
	orderdate timestamp NOT NULL,
	amount int4 NOT NULL,
	orderstateid int4 NOT NULL,
	createdon timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	createdby varchar(100) NOT NULL,
	lastmodifiedon timestamp NULL,
	lastmodifiedby varchar(100) NULL,
	CONSTRAINT order_pk PRIMARY KEY (id),
	CONSTRAINT order_orderstate_fk FOREIGN KEY (orderstateid) REFERENCES "Orders".orderstate(id)
);


-- "Orders".orderitem definition

-- Drop table

-- DROP TABLE "Orders".orderitem;

CREATE TABLE "Orders".orderitem (
	id bigserial NOT NULL,
	orderid int8 NOT NULL,
	productname varchar(100) NOT NULL,
	piece int4 NOT NULL,
	unitprice int4 NOT NULL,
	createdon timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	createdby varchar(100) NOT NULL,
	lastmodifiedon timestamp NULL,
	lastmodifiedby varchar(100) NULL,
	CONSTRAINT orderitem_pk PRIMARY KEY (id),
	CONSTRAINT orderitem_order_fk FOREIGN KEY (orderid) REFERENCES "Orders"."order"(id)
);