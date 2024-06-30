SELECT ANIMAL_TYPE,
       (
           CASE
               WHEN NAME is NULL THEN 'No name'
               ELSE NAME
               END
           ) NAME,
       SEX_UPON_INTAKE
FROM ANIMAL_INS