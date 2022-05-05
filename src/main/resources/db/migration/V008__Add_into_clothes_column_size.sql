ALTER TABLE `month9_database`.`clothes`
ADD COLUMN `size` VARCHAR(45) NULL DEFAULT NULL AFTER `quantity`;

UPDATE `month9_database`.`clothes` SET `size` = '1 year' WHERE (`id` = '1');
UPDATE `month9_database`.`clothes` SET `size` = '1 year' WHERE (`id` = '2');
UPDATE `month9_database`.`clothes` SET `size` = '1 year' WHERE (`id` = '3');
