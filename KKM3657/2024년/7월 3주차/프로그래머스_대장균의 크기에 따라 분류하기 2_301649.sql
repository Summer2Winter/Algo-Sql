SELECT ID,
       CASE
           WHEN (RowNum * 100.0 / TotalCount) <= 25 THEN 'CRITICAL'
           WHEN (RowNum * 100.0 / TotalCount) <= 50 THEN 'HIGH'
           WHEN (RowNum * 100.0 / TotalCount) <= 75 THEN 'MEDIUM'
           ELSE 'LOW'
           END AS COLONY_NAME
FROM (
         SELECT ID,
                SIZE_OF_COLONY,
                ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC, ID ASC) AS RowNum,
                 COUNT(*) OVER () AS TotalCount
         FROM ECOLI_DATA
         ORDER BY SIZE_OF_COLONY DESC
     ) AS RankedData
ORDER BY ID;