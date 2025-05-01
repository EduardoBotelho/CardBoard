--liquibase formatted sql
--changeset Eduardo:202504101140
--coment: cards table create

CREATE TABLE CARDS(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
   kind VARCHAR(7) NOT NULL,
   board_column_id BIGINT NOT NULL,
   CONSTRAINT boards_columns_cards_fk FOREIGN KEY (board_column_id) REFERENCES BOARDS_COLUMNS(id) ON DELETE CASCADE
  ) ENGINE=InnoDB;


--roolback DROP TABLE CARDS
