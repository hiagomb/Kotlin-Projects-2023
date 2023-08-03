package com.example.jsonneuraltestingconverter

object Constants {

    val beginningString = "{\n" +
            "  \"test-cases\": [\n" +
            "    {\n" +
            "      \"clean-indexes\": [\n" +
            "        \"PUBLICAPI\"\n" +
            "      ],\n" +
            "      \"register-schema\": [\n" +
            "        {\n" +
            "          \"name\": \"contactsneuralphoneticstest\",\n" +
            "          \"schema\": \"ContactsTest/contactsNeuralPhoneticsTest.xml\",\n" +
            "          \"default\": true\n" +
            "        }\n" +
            "      ],\n" +
            "      \"report\": {\n" +
            "        \"recall-precision\": true\n" +
            "      },\n" +
            "      \"insert-data\": [\n" +
            "        {\n" +
            "          \"index\": \"PUBLICAPI\",\n" +
            "          \"pre-insert\": {\n" +
            "            \"locale\": \"en-US\"\n" +
            "          },\n" +
            "          \"external-data\": {\n" +
            "            \"schema-name\": \"contactsneuralphoneticstest\",\n" +
            "            \"content\": \"ContactsTest/*\"\n" +
            "          }\n" +
            "        }\n" +
            "        ],\n" +
            "      \"test\": [\n" +
            "        "

    val baseStringTest = "{\n" +
            "          \"test-case-name\": \"testSearch@\",\n" +
            "          \"search\": {\n" +
            "            \"repeat\": 1,\n" +
            "            \"query-result\": [\n" +
            "              {\n" +
            "                \"term\" : \"%\",\n" +
            "               \"api\": [\n" +
            "                  {\"type\": \"PUBLICAPI\", \"query-args\": {\"string\": {\"query-json\": \"{\\\"query\\\": {\\\"match\\\": {\\\"fields\\\":[\\\"display_name_phonetic\\\"],\\\"text\\\":\\\"\$0\\\"}},\\\"args\\\": [\\\"%\\\"]}\"}}}\n" +
            "                ],\n" +
            "                \"results\": [\n" +
            "                  {\n" +
            "                    \"name\": \"display_name\",\n" +
            "                    \"values\": [\"@\"],\n" +
            "                    \"type\": \"metric\"\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        },"


    val endingString = "\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"

}