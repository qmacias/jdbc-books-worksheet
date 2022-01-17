--relationship operations
SELECT book_author.* FROM book_author;
SELECT book_author.* FROM book_author WHERE author=4 AND book=2;
SELECT book_author.* FROM book_author WHERE book=1;
SELECT book_author.* FROM book_author WHERE author=2;
--INSERT INTO book_author(book, author) VALUES(n, n);
--UPDATE book_author SET book=n, author=n;
--DELETE FROM book_author WHERE book=n, author=n
