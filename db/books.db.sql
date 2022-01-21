--PRAGMA foreign_keys = ON;
--PRAGMA foreign_keys = OFF;
DROP TABLE IF EXISTS "books";
CREATE TABLE IF NOT EXISTS "books" (
	"id"	INTEGER,
	"title"	TEXT DEFAULT NULL UNIQUE,
	"isbn"	TEXT DEFAULT NULL UNIQUE,
	PRIMARY KEY("id" AUTOINCREMENT)
);

DROP TABLE IF EXISTS "authors";
CREATE TABLE IF NOT EXISTS "authors" (
	"id"	INTEGER,
	"name"	TEXT DEFAULT NULL UNIQUE,
	PRIMARY KEY("id" AUTOINCREMENT)
);

DROP TABLE IF EXISTS "book_author";
CREATE TABLE IF NOT EXISTS "book_author" (
	"book"	INTEGER NOT NULL,
	"author"	INTEGER NOT NULL,
	FOREIGN KEY("book") REFERENCES "books"("id"),
	FOREIGN KEY("author") REFERENCES "authors"("id")
);

INSERT INTO "books" VALUES (1,'La Rosalía','413412344-5');
INSERT INTO "books" VALUES (2,'Design Patterns','293821498-7');
INSERT INTO "books" VALUES (3,'Maldad Líquida','106337074-4');
INSERT INTO "books" VALUES (4,'Mundo Consumo','977884493-6');
INSERT INTO "authors" VALUES (1,'Enrich Gamma');
INSERT INTO "authors" VALUES (2,'Zygmunt Bauman');
INSERT INTO "authors" VALUES (3,'Bruno Galindo');
INSERT INTO "authors" VALUES (4,'Richard Helm');
INSERT INTO "authors" VALUES (5,'Leonidas Donskis');
INSERT INTO "authors" VALUES (6,'Javier Blánquez');
INSERT INTO "authors" VALUES (7,'Ralph Johnson');
INSERT INTO "authors" VALUES (8,'Jorge Carrión');
INSERT INTO "authors" VALUES (9,'John Vlissides');
INSERT INTO "book_author" VALUES (1,3);
INSERT INTO "book_author" VALUES (1,6);
INSERT INTO "book_author" VALUES (1,8);
INSERT INTO "book_author" VALUES (2,1);
INSERT INTO "book_author" VALUES (2,4);
INSERT INTO "book_author" VALUES (2,7);
INSERT INTO "book_author" VALUES (2,9);
INSERT INTO "book_author" VALUES (3,2);
INSERT INTO "book_author" VALUES (3,5);
INSERT INTO "book_author" VALUES (4,2);