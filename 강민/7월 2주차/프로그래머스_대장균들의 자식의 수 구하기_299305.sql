SELECT A.ID, count(B.ID) CHILD_COUNT
FROM ECOLI_DATA A left join ECOLI_DATA B
ON A.ID = B.PARENT_ID
GROUP BY A.ID