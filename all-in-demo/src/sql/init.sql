CREATE
    TABLE
        USER(
            id INT PRIMARY KEY,
            name VARCHAR(100),
            email VARCHAR(255) UNIQUE
        );

INSERT
    INTO
        USER(
            id,
            name,
            email
        )
    VALUES(
        1,
        'Alice',
        'alice@example.com'
    ),
    (
        2,
        'Bob',
        'bob@example.com'
    );

SELECT
    u.id,
    u.name
FROM
    USER u
WHERE
    u.email LIKE '%@example.com'
ORDER BY
    u.id ASC;
