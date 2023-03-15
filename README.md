# Google Natural Language API

##

## Description
*** 
- 해당 프로젝트는 Google Cloud 에서 제공하는 Natural Language API 에 대한 내용을 정리한 프로젝트입니다.

## Natural Language API
***
- Natural Language API는 감정 분석, 항목 분석, 콘텐츠 분류 및 구문 분석 등의 기능을 통해 개발자가 애플리케이션에 자연어 이해(NLU)를 쉽게 적용할 수 있도록 지원

### 항목 분석
    주어진 텍스트에서 알려진 항목 (유명인사, 명소 등의 고유 명사)을 검사하고 항목의 정보를 반환
    
    Response
    1. type - 항목 유형
    2. metadata - 항목의 지식 저장소에 대한 소스 정보
    3. salience - 전체 문서 텍스트에서 이 항목의 종요성이나 관련성 (0.0에 가까울수록 중요도 낮음)
    4. mentions - 텍스트 내에서 항목이 언급된 오프셋 위치를 나타냄



