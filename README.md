# PipesNFilters
Pipes&amp;Filters 아키텍처 패턴: 학사 관리 시스템  
학생 정보 데이터를 읽어 다양한 목적으로 수정하여 Output 화일로 저장하는 애플리케이션


### 데이터 포맷
* 학생 정보 파일

| 학번(8자리) | 성 | 이름 | 전공 명(2자리) | 수강신청 과목1 | .. |
| :------: | :--: | :---: | :--: | :----: | :-------: |
| 20120808 | Kim | Sungsu | EE | 12345 | 23456 |

* 과목 정보 파일

| 과목번호(5자리) | 교수 성 | 과목 이름 | 선이수과목1(5자리) | 선이수과목2(5자리) | 
| :------: | :--: | :---: | :--: | :----: |
| 17655 | Lee | Architecture of Software Systems | 12345 | 23456 |


### 문제A
제공된 Pipes&Filters 프레임워크에서 다음의 3개 기능을 추가하시오. 
* 모든 CS 학생들은 모두 12345과 23456 과목을 수강해야 한다. 이 과목들을 수강 신청하지 않은 학생들을 골라 과목 ID를 추가하시오.  
* 모든 EE 학생 들은 23456 과목을 수강해야 한다.  이 과목들을 수강 신청하지 않은 학생들을 골라 과목 ID를 추가하시오.  
* 2013학번 학생들 중, CS가 아닌 사람은 17651이나 17652 과목을 들을 수 없다. CS가 아닌 학생 중에 이 과목 ID를 수강한 학생들을 골라 이 과목 ID를 삭제하시오. 
