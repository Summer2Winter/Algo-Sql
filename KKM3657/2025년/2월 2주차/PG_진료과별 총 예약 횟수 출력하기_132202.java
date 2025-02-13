SELECT MCDP_CD 진료과코드, count(APNT_NO) 5월예약건수
FROM APPOINTMENT
WHERE date_format(APNT_YMD, '%Y-%m') = '2022-05'
GROUP BY MCDP_CD
ORDER BY 5월예약건수, 진료과코드