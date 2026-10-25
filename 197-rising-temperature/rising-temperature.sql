# Write your MySQL query statement below
SELECT w.id  FROM Weather w JOIN Weather s ON DATEDIFF(w.recordDate , s.recordDate) = 1 WHERE w.temperature > s.temperature

