--liquibase formatted sql
--changeset Eduardo:202504101140
--coment: BLOCKS table create

CREATE TABLE BLOCKS(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
   blocked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   block_reason VARCHAR(255) NOT NULL,
   unblock_at TIMESTAMP NULL,
   unblock_reason VARCHAR(255) NOT NULL,
    card_id BIGINT NOT NULL,
    CONSTRAINT cards__blocks_fk FOREIGN KEY (card_id) REFERENCES CARDS(id) ON DELETE CASCADE
  ) ENGINE=InnoDB;


--roolback DROP TABLE BLOCKS
