CREATE TABLE lifecanvas.experiences (
	id INT auto_increment NOT NULL,
	title TEXT NOT NULL,
	content TEXT NOT NULL,
	created_on DATE DEFAULT CURRENT_DATE NOT NULL,
	CONSTRAINT experiences_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

CREATE TABLE lifecanvas.emotions (
	id INT auto_increment NOT NULL,
	emotion varchar(100) NOT NULL,
	experience_id INT NOT NULL,
	CONSTRAINT emotions_pk PRIMARY KEY (id),
	CONSTRAINT emotions_experiences_FK FOREIGN KEY (id) REFERENCES lifecanvas.experiences(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

ALTER TABLE lifecanvas.emotions DROP FOREIGN KEY emotions_experiences_FK;
ALTER TABLE lifecanvas.emotions ADD CONSTRAINT emotions_experiences_FK FOREIGN KEY (experience_id) REFERENCES lifecanvas.experiences(id);
