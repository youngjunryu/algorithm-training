SELECT name
FROM Customer
WHERE IFNULL(referee_id, 0) != 2;