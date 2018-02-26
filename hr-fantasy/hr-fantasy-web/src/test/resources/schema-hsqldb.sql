
DROP SCHEMA PUBLIC CASCADE;
SET SCHEMA PUBLIC;

-- Simple OXIREP Schema for Test Purposes

CREATE TABLE TEV
(   EV_ID NUMERIC (20) NOT NULL,
    EV_TYPE_ID NUMERIC(20) NOT NULL,
    DESCR CHARACTER (120) NOT NULL,
    START_TIME DATE NOT NULL,
    PRIMARY KEY (EV_ID)
);

CREATE TABLE TEVTYPE
(
    EV_TYPE_ID NUMERIC(20) NOT NULL,
    PRIMARY KEY (EV_TYPE_ID)
);

CREATE TABLE TEVMKT
(
    EV_MKT_ID NUMERIC(20) NOT NULL,
    EV_ID NUMERIC(20) NOT NULL,
    NAME CHARACTER(120) NOT NULL,
    PRIMARY KEY (EV_MKT_ID)
);

CREATE TABLE TEVOC
(
    EV_OC_ID NUMERIC(20) NOT NULL,
    EV_ID NUMERIC(20) NOT NULL,
    EV_MKT_ID NUMERIC(20) NOT NULL,
    RUNNER_NUM NUMERIC(20) NOT NULL,
    DESCR CHARACTER(120) NOT NULL,
    PRIMARY KEY (EV_OC_ID)
);