CREATE TABLE user (id INT PRIMARY KEY AUTO_INCREMENT,username VARCHAR(255),password VARCHAR(255),is_terminated BINARY DEFAULT FALSE);

CREATE TABLE employee (id INT PRIMARY KEY AUTO_INCREMENT, fullname VARCHAR(255), department VARCHAR(255), address VARCHAR(255), role VARCHAR(10), user_id INT NOT NULL,CONSTRAINT emp_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id));