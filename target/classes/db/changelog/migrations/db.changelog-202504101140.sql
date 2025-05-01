--liquibase formatted sql
--changeset Eduardo:202504101140
--coment: boards table create

CREATE TABLE BOARDS(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
  ) ENGINE=InnoDB;


--roolback DROP TABLE BOARDS
