-- liquibase formatted sql

-- changeset klejdis:create-contact-table
CREATE TABLE contact (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    mobile_num VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    subject VARCHAR(50) NOT NULL,
    message VARCHAR(50) NOT NULL,
    status VARCHAR(15) NOT NULL
);

-- changeset klejdis:load-initial-data
INSERT INTO contact (name, mobile_num, email, subject, message, status) VALUES ('Jim', '0691234567', 'test1@email.com', 'Test', 'Test', 'Pending');
INSERT INTO contact (name, mobile_num, email, subject, message, status) VALUES ('John', '0691234567', 'test2@email.com', 'Test', 'Test', 'Pending');
INSERT INTO contact (name, mobile_num, email, subject, message, status) VALUES ('Jane', '0691234567', 'test3@email.com', 'Test', 'Test', 'Pending');