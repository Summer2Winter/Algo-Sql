SELECT ANIMAL_TYPE,
       (CASE
            WHEN NAME is NULL then 'No name'
            ELSE NAME
           END) NAME,
       SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;