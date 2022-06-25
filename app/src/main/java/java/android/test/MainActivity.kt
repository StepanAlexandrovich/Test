package java.android.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var stringList = mutableListOf("     Test")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        testClass()
        testCycle()

        stringList.forEach {
            textView.append("$it\n")
        }
    }

    private fun testClass(){
        val testClass = TestClass("name",10)
        addTextToList("имя -> ${testClass.name} число -> ${testClass.value}")

        val testClassCopy = testClass.copy()
        addTextToList("testClass === testClassCopy ${testClass === testClassCopy}")
        addTextToList("testClass == testClassCopy ${testClass == testClassCopy}")
    }

    private fun testCycle() {
        val listObjects = listOf<TestClass>(TestClass("name1",1),TestClass("name2",2),TestClass("name3",3))

        addTextToList("  forEach1 -> ")
        listObjects.forEach{
            addTextToList(it.name)
        }

        addTextToList("  forEach2 -> ")
        for(it in listObjects){
            addTextToList(it.name)
        }

        addTextToList("  repeat -> ")
        repeat(listObjects.size){
            addTextToList(listObjects[it].name)
        }

        addTextToList("  for up > ")
        for(i in listObjects.indices){
            addTextToList(listObjects[i].name)
        }

        addTextToList("  for down > ")
        for(i in listObjects.size - 1 downTo 0){
            addTextToList(listObjects[i].name)
        }
    }

    private fun addTextToList(text:String){
        stringList.add(text)
    }

}