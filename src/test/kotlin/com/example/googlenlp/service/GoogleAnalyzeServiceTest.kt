package com.example.googlenlp.service

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class GoogleAnalyzeServiceTest(
    val googleAnalyzeService: GoogleAnalyzeService
) {

    val textKo = """
        한국인터넷기업협회가 14일 서울 서초구 사무실에서 '챗GPT 열풍, 인공지능에 관한 새로운 챕터의 시작'을 주제로 
        연 토론회에서 윤영진 네이버클라우드 글로벌 AI 비즈니스 리더는 챗GPT를 비롯한 생성형 인공지능(AI) 시대 교육의 바람직한 방향에 대해 이렇게 말했다.
        최영준 연세대 행정학과 교수는 "이번 학기 첫 수업에 들어가기 전 챗GPT에게 '생성형 AI 시대에 학생들에게 무엇을 가르쳐야 하는지, 
        어떤 역량이 제일 중요한지' 묻자 창의성, 혁신, 토론과 윤리적 결정, 데이터를 읽고 판별할 수 있는 능력인 '데이터 리터러시', 협력 등의 답을 내놨다"고 했다.
    """.trimIndent()

    @Test
    fun `항목 분석`() {
        val result = googleAnalyzeService.analyzeEntitiesText(textKo)

        for (entity in result.entitiesList) {
            println("Entity: %s".format(entity.name))
            println("Salience: %.3f".format(entity.salience))
            println("Metadata {")
            for ((key, value) in entity.metadataMap) {
                println("%s : %s".format(key, value))
            }
            println("}")
            for (mention in entity.mentionsList) {
                println("Begin offset: %d".format(mention.text.beginOffset))
                println("Content: %s".format(mention.text.content))
                println("Type: %s".format(mention.type))
            }
        }
    }
}