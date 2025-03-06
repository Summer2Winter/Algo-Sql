SELECT year(YM) year,
       ROUND(AVG(PM_VAL1),2) as 'PM10',
       ROUND(AVG(PM_VAL2),2) as 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = "수원"
GROUP BY year
ORDER BY year

# 자리수 조심하자 => 3에서 반올림이면 2에서 해야지 밑에서 반올림해서 나타낸다.