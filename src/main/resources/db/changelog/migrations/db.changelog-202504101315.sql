--liquibase formatted sql
--changeset Eduardo:202504101140
--coment: BOARDS_COLUMNS table create

CREATE TABLE BOARDS_COLUMNS(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  `order` int NOT NULL,
   kind VARCHAR(7) NOT NULL,
   board_id BIGINT NOT NULL,
   CONSTRAINT boards__boards_columns_fk FOREIGN KEY (board_id) REFERENCES BOARDS(id) ON DELETE CASCADE,
   CONSTRAINT id_order_uk UNIQUE KEY unique_board_id_order(board_id,`order`)
  ) ENGINE=InnoDB;


--roolback DROP TABLE BOARDS_COLUMNS
