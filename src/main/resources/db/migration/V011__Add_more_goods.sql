INSERT INTO `month9_database`.`clothes` (`date_time_added`, `description`, `item_name`, `price`, `quantity`)
VALUES ('2022.05.05 12:00', 'Blue t-shirt short', 'Blue short t-shirt', '700', '10'),
       ('2022.05.05 12:00', 'Blue t-shirt with the dino in the middle', 'Blue t-shirt with dino', '550', '10'),
       ('2022.05.05 12:00', 'Blue t-shirt with the rainbow in the middle', 'Blue t-shirt with rainbow', '510', '10'),
       ('2022.05.05 12:00', 'Jersey t-shirt with different colors', 'Jersey t-shirt', '800', '10'),
       ('2022.05.05 12:00', 'Navy t-shirt with two main colors', 'Navy t-shirt', '770', '10'),
       ('2022.05.05 12:00', 'Blue t-shirt with image of monkey in front', 'Blue t-shirt with monkey', '420', '10');

INSERT INTO `month9_database`.`photos` (`name`, `clothes_id`) VALUES ('blueShortTshirt', '7');
INSERT INTO `month9_database`.`photos` (`name`, `clothes_id`) VALUES ('blueTshirtWithDino', '8');
INSERT INTO `month9_database`.`photos` (`name`, `clothes_id`) VALUES ('blueTshirtWithRainbow', '9'),
                                                                     ('jerseyTshirt', '10'),
                                                                     ('navyTshirt', '11'),
                                                                    ('blueTshirtWithMonkey', '12');
