insert into company(company_id, name, nation, region)
values (1001,'원티드랩', '한국', '서울');

insert into company(company_id, name, nation, region)
values (1002,'릴준랩', '미국', '시카고');

insert into job_posting(company_company_id, job_posting_id, reward, description, position, using_skill)
values (1001, 1001, 100000, '원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..', '백엔드 주니어 개발자', 'Python');

insert into COMPANY_JOB_POSTINGS(COMPANY_COMPANY_ID, JOB_POSTINGS_JOB_POSTING_ID)
values (1001, 1001);

insert into job_posting(company_company_id, job_posting_id, reward, description, position, using_skill)
values (1001, 1002, 100000, '원티드랩에서 프론트엔드 주니어 개발자를 채용합니다. 자격요건은..', '프론트엔드 주니어 개발자', 'Javascript');

insert into COMPANY_JOB_POSTINGS(COMPANY_COMPANY_ID, JOB_POSTINGS_JOB_POSTING_ID)
values (1001, 1002);

insert into job_posting(company_company_id, job_posting_id, reward, description, position, using_skill)
values (1002, 1003, 500000, '릴준랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..', '백엔드 주니어 개발자', 'Python');

insert into COMPANY_JOB_POSTINGS(COMPANY_COMPANY_ID, JOB_POSTINGS_JOB_POSTING_ID)
values (1002, 1003);

insert into job_posting(company_company_id, job_posting_id, reward, description, position, using_skill)
values (1002, 1004, 500000, '릴준랩에서 프론트엔드 주니어 개발자를 채용합니다. 자격요건은..', '프론트엔드 주니어 개발자', 'Javascript');

insert into COMPANY_JOB_POSTINGS(COMPANY_COMPANY_ID, JOB_POSTINGS_JOB_POSTING_ID)
values (1002, 1004);

insert into JOB_USER(USER_ID, ID, NAME, PASSWORD)
values (1001, 'testid', 'testname', 'testpw')