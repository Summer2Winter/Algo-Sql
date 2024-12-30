SELECT CATEGORY, PRICE MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) in (
    SELECT CATEGORY, MAX(PRICE)
    FROM FOOD_PRODUCT
    GROUP BY CATEGORY
    HAVING CATEGORY IN ('과자', '국', '김치', '식용유')
)
ORDER BY PRICE desc

# GROUP BY와 MAX(PRICE)를 사용하면 그룹 내에서 가장 높은 가격은 얻을 수 있지만, 그와 함께 해당 가격에 해당하는 PRODUCT_NAME을 직접 가져올 수는 없다.
-- 설명
-- SQL에서 GROUP BY는 각 그룹에 대한 하나의 결과 행만 반환하므로, 같은 카테고리에서 여러 필드(예: PRODUCT_NAME)를 가져올 때 문제가 발생할 수 있다.
-- MAX(PRICE)와 함께 해당 제품명을 직접 가져오지 못하는 이유는, SQL이 그룹화된 결과에서 PRICE가 최대인 행의 다른 컬럼 값(PRODUCT_NAME)을 자동으로 매칭하지 않기 때문입니다.