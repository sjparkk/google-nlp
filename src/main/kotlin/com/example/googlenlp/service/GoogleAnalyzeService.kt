package com.example.googlenlp.service

import com.google.cloud.language.v1.*
import org.springframework.stereotype.Service

@Service
class GoogleAnalyzeService(
    val languageServiceClient: LanguageServiceClient
) {

    /**
     * Analyze entities text (항목 분석)
     * @param text
     */
    fun analyzeEntitiesText(
        text: String
    ): AnalyzeEntitiesResponse {

        languageServiceClient.use { language ->

            val doc = Document.newBuilder().setContent(text)
                    .setType(Document.Type.PLAIN_TEXT).build()

            val request = AnalyzeEntitiesRequest.newBuilder()
                    .setDocument(doc)
                    .setEncodingType(EncodingType.UTF16)
                    .build()

            return language.analyzeEntities(request)
        }
    }

    /**
     * Analyze sentiment text (감정 분석)
     * @param text
     */
    fun analyzeSentimentText(text: String): AnalyzeSentimentResponse {

        languageServiceClient.use { language ->

            val doc = Document.newBuilder().setContent(text)
                    .setType(Document.Type.PLAIN_TEXT).build()

            return language.analyzeSentiment(doc)
        }
    }

}