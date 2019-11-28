DROP TABLE  ARTICLE if exists;

CREATE TABLE ARTICLE (
  id IDENTITY NOT NULL,
  title VARCHAR(64),
  text VARCHAR(4096),
  author VARCHAR(64),
  authors_email VARCHAR(64),
  positive_feedback INT,
  negative_feedback INT,
  PRIMARY KEY(id)
);
CREATE TABLE TAG (
  idTag IDENTITY NOT NULL,
  nameTag VARCHAR (32),
  PRIMARY KEY(idTag)
);

 CREATE TABLE ARTICLE_TAG(
   id BIGINT NOT NULL,
   idTag BIGINT NOT NULL,
--    PRIMARY KEY(id,idTag)
   CONSTRAINT article_tag_ibfk_1 FOREIGN KEY (id) REFERENCES ARTICLE (id),
  CONSTRAINT article_tag_ibfk_2 FOREIGN KEY (idTag) REFERENCES TAG (idTag)
);


-- SELECT s.id
--     , s.title
--     , s.text
--     , h.nameTag
-- FROM ARTICLE s
-- INNER JOIN ARTICLE_TAG hp
--     on s.id = hp.id
-- INNER JOIN TAG h
--     on hp.idTag= h.idTag
