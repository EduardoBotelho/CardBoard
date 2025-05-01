--liquibase formatted sql
--changeset Eduardo:202504101140
--coment: set unblock_reason
ALTER TABLE BLOCKS MODIFY COLUMN unblock_reason VARCHAR(255)  NULL;
--roolback ALTER TABLE BLOCKS MODIFY COLUMN unblock_reason VARCHAR(255) NOT  NULL
