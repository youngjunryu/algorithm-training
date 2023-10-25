SELECT em.unique_id, e.name
FROM Employees as e
LEFT JOIN EmployeeUNI as em on e.id = em.id;