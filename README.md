# wanted-pre-onboarding-backend

## 프로젝트 소개

---
### 프리온보드 백엔드 인턴쉽 선발과제
- 기업 채용을 위한 웹 서비스
- 회사는 채용공고를 생성, 이에 사용자는 지원
- REST API 서버 제작

## 개발환경

- Java 17 & Spring boot 3.14
- Mysql

## 진행순서


### 1. 클래스 다이어그램 설계

---

![image](https://github.com/liljoon/wanted-pre-onboarding-backend/assets/79753466/600da799-8202-49fb-89fd-90dec474ccfa)

### 2. API 설계

---

- post - /jobposting

  채용공고 등록.

성공 시 - 201 CREATED

실패 시(해당하는 회사가 없을 때) - 404 NOT FOUND

- ex)
```json
{
  "company_id":1001,
  "position":"백엔드 주니어 개발자",
  "reward":1000000,
  "description":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "usingSkill":"Python"
}
```
---
- put - /jobposting/1

  채용공고 수정

성공 시 - 201 CREATED

실패 시(해당하는 채용공고가 없을 때) - 404 NOT FOUND

ex)
```json
{
  "position":"백엔드 ",
  "reward":100,
  "description":"원티드랩에",
  "usingSkill":"Pytn"
}
```
---
- delete - /jobposting/1

  채용공고 삭제

성공 시 - 204 NO CONTENT

실패 시(해당하는 채용공고가 없을 때) - 404 NOT FOUND

---

- get - /jobposting

  채용공고 전체 조회

상시 성공 - 200 OK

ex)
```json
[
    {
        "jobPostingId": 1001,
        "companyName": "원티드랩",
        "companyNation": "한국",
        "companyRegion": "서울",
        "position": "백엔드 주니어 개발자",
        "reward": 100000,
        "usingSkill": "Python"
    },
    {
        "jobPostingId": 1002,
        "companyName": "원티드랩",
        "companyNation": "한국",
        "companyRegion": "서울",
        "position": "프론트엔드 주니어 개발자",
        "reward": 100000,
        "usingSkill": "Javascript"
    }
]

```
---
- get - /jobposting?search=원티드

  검색기능

상시 성공 - 200 OK

ex)
```json
[
    {
        "jobPostingId": 1001,
        "companyName": "원티드랩",
        "companyNation": "한국",
        "companyRegion": "서울",
        "position": "백엔드 주니어 개발자",
        "reward": 100000,
        "usingSkill": "Python"
    },
    {
        "jobPostingId": 1002,
        "companyName": "원티드랩",
        "companyNation": "한국",
        "companyRegion": "서울",
        "position": "프론트엔드 주니어 개발자",
        "reward": 100000,
        "usingSkill": "Javascript"
    }
]
```
---
- get - /jobposting/1

  채용 상세 페이지 (채용내용 포함, 해당 회사의 다른 채용공고)

성공 시 - 200 OK

실패 시(ID에 해당하는 데이터가 없을 때) - 404 NOT FOUND

ex)
```json
{
    "jobPostingId": 1001,
    "companyName": "원티드랩",
    "companyNation": "한국",
    "companyRegion": "서울",
    "position": "백엔드 주니어 개발자",
    "reward": 100000,
    "usingSkill": "Python",
    "description": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
    "sameCompanyJobPostingsId": [
        1002
    ]
}
```

---
- post - /application

  채용공고 지원

성공 시 - 201 CREATED
실패 시(해당하는 채용공고나 사용자가 없을 때) - 404 NOT FOUND

ex)
```json
{
    "jobPosting_id" : 1001,
    "user_id" : 1001
}
```