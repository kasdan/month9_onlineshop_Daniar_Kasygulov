ALTER TABLE `month9_database`.`users`
    ADD COLUMN `enabled` BOOLEAN NOT NULL default true;
ALTER TABLE `month9_database`.`users`
    ADD COLUMN `role` VARCHAR(45) NOT NULL default 'USER';
