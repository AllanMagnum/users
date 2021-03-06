CREATE SCHEMA USR;

CREATE SEQUENCE USR.SEQ_COMPANY;
CREATE TABLE USR.COMPANY (
    ID BIGINT DEFAULT USR.SEQ_COMPANY.NEXTVAL PRIMARY KEY,
    NAME VARCHAR(60) NOT NULL
);

CREATE TABLE USR.EMPLOYEE (
    UUID VARCHAR(36) PRIMARY KEY,
    CREATION_DATE TIMESTAMP NOT NULL,
    TYPE VARCHAR(20) NOT NULL,
    NAME VARCHAR(60) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    ID_COMPANY INTEGER,
    UUID_MANAGER VARCHAR(36),
    FOREIGN KEY (ID_COMPANY) REFERENCES USR.COMPANY(ID),
    FOREIGN KEY (UUID_MANAGER) REFERENCES USR.EMPLOYEE(UUID)
);