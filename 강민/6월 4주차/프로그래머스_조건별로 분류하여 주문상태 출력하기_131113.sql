SELECT ORDER_ID, PRODUCT_ID, date_format(OUT_DATE, '%Y-%m-%d'),
       case
           when OUT_DATE <= '2022-05-01' then '출고완료'
           when OUT_DATE > '2022-05-01' then '출고대기'
           when OUT_DATE is null then '출고미정'
           end 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID