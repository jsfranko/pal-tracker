CREATE TABLE time_entries (
    id          BIGINT NOT NULL AUTO_INCREMENT,
    project_id  BIGINT,
    user_id     BIGINT,
    date        DATE,
    hours       INT,

    PRIMARY KEY (ID)
)
ENGINE = innodb
DEFAULT CHARSET = UTF8MB4;