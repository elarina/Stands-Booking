	CREATE DATABASE stands_state;
	
	\c stands_state
	
	CREATE TABLE stands (
		id SERIAL PRIMARY KEY,
		name VARCHAR (100),
		ip VARCHAR (50),
		username VARCHAR (100),
		password VARCHAR (100)
	);
	
	INSERT INTO stands (name, ip, username, password) values ('Stand 1', '123.345.22.11', 'usr1', 'pwd1');
	INSERT INTO stands (name, ip, username, password) values ('Stand 2', '11.32.21.22', 'usr2', 'pwd2');
	INSERT INTO stands (name, ip, username, password) values ('Stand 3', '33.333.333.32', 'usr3', 'pwd3');
	
	CREATE TABLE employees (
		username varchar(50) not null primary key,
		password varchar(500) not null,
		enabled boolean not null,
		name VARCHAR (100),
		lastname VARCHAR (100)
	);

	create table authorities (
		username varchar(50) not null,
		authority varchar(50) not null,
		constraint fk_authorities_users foreign key(username) references employees(username)
	);
	
	create unique index ix_auth_username on authorities (username,authority);
	

	
	INSERT INTO employees (username, password, enabled, name, lastname) values ('petrovp','12345',true,'Petr', 'Petrov');
	INSERT INTO employees (username, password, enabled, name, lastname) values ('ivanovi','12345',true,'Ivan', 'Ivanov');
	INSERT INTO employees (username, password, enabled, name, lastname) values ('fedorovf','12345',true,'Fedor', 'Fedorov');
	
	CREATE TABLE statuses (
		id SERIAL PRIMARY KEY,
		status BOOLEAN,
		FK_stands INTEGER REFERENCES stands(id),
		FK_employees VARCHAR(50) REFERENCES employees(username)
	);
	
	INSERT INTO statuses (status, FK_stands, FK_employees) values (true, 1, 'petrovp');
	INSERT INTO statuses (status, FK_stands, FK_employees) values (true, 2, 'ivanovi');