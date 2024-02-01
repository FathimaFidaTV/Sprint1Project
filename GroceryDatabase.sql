create database grocerystore;
use grocerystore;


-- Create the 'user' table
CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    roles VARCHAR(255) NOT NULL
);

-- Create the 'user_roles' table for storing user roles
CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT,
    role VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

INSERT IGNORE INTO user (username, password, roles) VALUES
    ('admin', '	Admin123#', 'ROLE_ADMIN'),
    ('customereg', 'egCust123#', 'ROLE_CUSTOMER');
 
INSERT IGNORE INTO user_roles (user_id, role) SELECT id, 'ROLE_ADMIN' FROM user WHERE username = 'admin';
INSERT IGNORE INTO user_roles (user_id, role) SELECT id, 'ROLE_CUSTOMER' FROM user WHERE username = 'customereg';
select * from grocery;

-- Create the 'grocery' table
CREATE TABLE IF NOT EXISTS grocery (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS stores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    contact_details VARCHAR(255) NOT NULL
);



