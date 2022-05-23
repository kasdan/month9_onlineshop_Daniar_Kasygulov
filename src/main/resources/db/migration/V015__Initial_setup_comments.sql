DROP TABLE IF EXISTS `comments`;
CREATE TABLE `month9_database`.`comments` (
                                               `id` BIGINT NOT NULL AUTO_INCREMENT,
                                               `text` VARCHAR(255) NOT NULL,
                                               `clothes_id` BIGINT NOT NULL,
                                               `user_id` BIGINT NOT NULL,
                                               PRIMARY KEY (`id`),
                                               INDEX `clothes_idx` (`clothes_id` ASC) VISIBLE,
                                               INDEX `users_idx` (`user_id` ASC) VISIBLE,
                                               CONSTRAINT `clothes`
                                                   FOREIGN KEY (`clothes_id`)
                                                       REFERENCES `month9_database`.`clothes` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION,
                                               CONSTRAINT `users`
                                                   FOREIGN KEY (`user_id`)
                                                       REFERENCES `month9_database`.`users` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION);