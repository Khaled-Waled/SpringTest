CREATE TABLE `test`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) NULL,
  `phone` VARCHAR(14) NULL,
  `address` VARCHAR(256) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

CREATE TABLE `test`.`accounts` (
  `id` INT NOT NULL,
  `customerID` INT NULL,
  `balance` BIGINT(19) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_accounts_customer_idx` (`customerID` ASC) VISIBLE,
  CONSTRAINT `fk_accounts_customer`
    FOREIGN KEY (`customerID`)
    REFERENCES `test`.`customers` (`id`)
    ON DELETE CASCADE);


CREATE TABLE `test`.`loans` (
  `id` INT NOT NULL,
  `accountID` INT NULL,
  `amount` BIGINT(19) NULL,
  `state` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
ALTER TABLE `test`.`loans` 
ADD INDEX `fk_loans_account_idx` (`accountID` ASC) VISIBLE;
