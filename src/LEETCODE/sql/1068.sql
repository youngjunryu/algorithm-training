SELECT p.product_name as product_name, s.year as year, s.price as price
FROM Sales s
INNER JOIN Product p on p.product_id = s.product_id;