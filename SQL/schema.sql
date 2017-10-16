CREATE TABLE LICENSE (
	lic_id INTEGER PRIMARY KEY,
	driverName VARCHAR(30),
	address VARCHAR(50),
	email VARCHAR(20),
	licenseNumber VARCHAR(20),
	licenseClass VARCHAR(10),
	expiryDate VARCHAR(10)
);

CREATE TABLE RENEWAL (
	rn_id INTEGER PRIMARY KEY,
	address VARCHAR(50),
	email VARCHAR(20),
	fee FLOAT,
	status INTEGER,
	issueDate VARCHAR(10),
	lastModified VARCHAR(10),
	lic_id INTEGER,
	p_id INTEGER,
	FOREIGN KEY (lic_id) REFERENCES LICENSE (lic_id),
	FOREIGN KEY (p_id) REFERENCES PAYMENT (p_id)
);

CREATE TABLE PAYMENT (
	p_id INTEGER PRIMARY KEY,
	amount FLOAT,
	paidDate VARCHAR(10),
	rn_id INTEGER,
	FOREIGN KEY (rn_id) REFERENCES RENEWAL (rn_id)
);