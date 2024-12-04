CREATE TABLE Patients
(
    patient_id          INT PRIMARY KEY AUTO_INCREMENT,
    first_name          VARCHAR(50) NOT NULL,
    last_name           VARCHAR(50) NOT NULL,
    date_of_birth       DATE,
    gender              CHAR(1),
    admission_date      DATE,
    discharge_date      DATE,
    room_number         INT         NOT NULL,
    attending_physician VARCHAR(50),
    diagnosis           VARCHAR(100)

);

CREATE TABLE Physicians
(
    physician_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    specialty    VARCHAR(50)
);

