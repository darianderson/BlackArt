CREATE TABLE ARTICLE (
  id BIGINT AUTO_INCREMENT NOT NULL,
  title VARCHAR(64),
  text VARCHAR(4096),
  author VARCHAR(64),
  authors_email VARCHAR(64),
  positive_feedback INT,
  negative_feedback INT
);