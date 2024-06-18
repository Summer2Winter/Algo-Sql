#MEMBER_PROFILE 테이블에서 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요. 
#이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, 결과는 회원ID를 기준으로 오름차순 정렬해주세요.

# SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
# FROM MEMBER_PROFILE
# WHERE GENDER = 'W'
#   AND DATE_OF_BIRTH LIKE '____-03-__'
#   AND TLNO IS NOT NULL
# ORDER BY MEMBER_ID;

SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
# 출력할 날짜 포맷(YYYY-MM-DD)에 맞춰 설정
FROM MEMBER_PROFILE
WHERE GENDER = 'W'
# 검색 조건 1 => 여성 회원
  AND TLNO IS NOT NULL
# 검색 조건 2 => 전화번호가 NULL인 경우는 출력대상에서 제외
  AND MONTH(DATE_OF_BIRTH) = 3
# 검색 조건 3 => 생일이 3월
ORDER BY MEMBER_ID;
# 회원ID를 기준으로 오름차순 정렬 => ORDER BY 기본값 오름차순