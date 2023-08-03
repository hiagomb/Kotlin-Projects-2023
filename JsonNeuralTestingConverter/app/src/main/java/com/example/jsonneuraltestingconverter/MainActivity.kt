package com.example.jsonneuraltestingconverter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.File
import java.nio.file.Paths
import java.util.Arrays

/*Tool for converting a txt file into readable ContactsTest for Neural/BMPM

HOW TO USE:

1º STEP: Put your data into Assets folder (File must be in the format):
        Arnold, Arnoud
        accept, except
        ... (Pay attention if there is a single space between terms, otherwise an exception will be throw)

2ª STEP: Change the name of SOURCE_DATA_NAME to the fileName pasted in the 1ª step

3º STEP: Change the CSV_DATA_FILE_NAME and JSON_TEST_FILE_NAME to the desired names (it can be what you want)

4º STEP: Run the app

5º STEP: You can find the resulted files in the Device File Explorer
        (data/data/com.example.jsonneuraltestingconverter/files)  */





const val SOURCE_DATA_NAME = "data_indian.txt" //must be a .txt file
const val CSV_DATA_FILE_NAME = "dataIndian.csv"  //must be a .csv file
const val JSON_TEST_FILE_NAME = "testIndian.json" // must be a .json file


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = readDataset(SOURCE_DATA_NAME)
        createCsvData(list)
        createJsonTest(list)
    }


    private fun readDataset(filePath: String): List<LineTerm>{
        val list = ArrayList<LineTerm>()
        assets.open(filePath).bufferedReader().readLines().forEach{
            val line = it.split(" ")
            if(line.size != 2){
                throw Exception("File in the wrong format: "+line.toString())
            }else{
                list.add(LineTerm(line[0].trim(), line[1].trim()))
            }
        }
        return list
    }

    private fun createCsvData(list: List<LineTerm>){
        var finalString = "_id,display_name\n"
        list.forEachIndexed{index, lineTerm ->
            finalString += "$index,${lineTerm.firstTerm.trim()}\n"
        }

        finalString = finalString.substringBeforeLast("\n")
        File(applicationContext.filesDir, CSV_DATA_FILE_NAME).printWriter().use {
            it.print(finalString)
            it.flush()
        }
    }

    private fun createJsonTest(list: List<LineTerm>){
        var finalStringTest = ""
        list.forEach{

            finalStringTest += Constants.baseStringTest.replace("@", it.firstTerm).replace("%", it.secondTerm)
        }

        finalStringTest = finalStringTest.dropLast(1)
        finalStringTest = Constants.beginningString.replace("*", CSV_DATA_FILE_NAME) + finalStringTest + Constants.endingString
        File(applicationContext.filesDir, JSON_TEST_FILE_NAME).printWriter().use {
            it.print(finalStringTest)
            it.flush()
        }
    }
}