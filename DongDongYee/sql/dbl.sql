DROP TABLE IF EXISTS `DD_USER`;

CREATE TABLE `DD_USER`
(
    `UserID`       VARCHAR(50) NOT NULL,
    `UserPassword` VARCHAR(100) NULL,
    `UserEmail`    VARCHAR(100) NULL,
    `UserNickname` VARCHAR(50) NULL,
    PRIMARY KEY (`UserID`)
);

DROP TABLE IF EXISTS `DD_Promotion`;

CREATE TABLE `DD_Promotion`
(
    `PromotionID`       BIGINT      NOT NULL AUTO_INCREMENT,
    `UserID`            VARCHAR(50) NOT NULL,
    `PromotionName`     VARCHAR(50) NULL,
    `PromotionContents` TEXT NULL,
    `PromotionClub`     VARCHAR(50) NULL,
    `PromotionTime`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`PromotionID`)
);

DROP TABLE IF EXISTS `DD_COMMENT`;

CREATE TABLE `DD_COMMENT`
(
    `CommentID`       BIGINT      NOT NULL AUTO_INCREMENT,
    `UserID`          VARCHAR(50) NOT NULL,
    `PromotionID`     BIGINT      NOT NULL,
    `CommentContents` TEXT NULL,
    `CommentTime`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`CommentID`)
);

DROP TABLE IF EXISTS `DD_RATING`;

CREATE TABLE `DD_RATING`
(
    `RatingID`   BIGINT      NOT NULL AUTO_INCREMENT,
    `UserID`     VARCHAR(50) NOT NULL,
    `RatingName` VARCHAR(50) NULL,
    `RatingClub` VARCHAR(50) NULL,
    `RatingPlay` TEXT NULL,
    `RatingGood` TEXT NULL,
    `RatingBad`  TEXT NULL,
    `RatingTime` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`RatingID`)
);

SHOW
TABLES;
DESC DD_USER;
DESC DD_Promotion;
DESC DD_COMMENT;
DESC DD_RATING;