package com.example.quizapp

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity() {

    private var Name:String?=null
    private var score:Int=0


    private var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData>?=null
    private var selected_option:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name=intent.getStringExtra(setData.name)

        questionList=setData.getQuestion()

        setQueston()

        opt1.setOnClickListener {
            selectedOptionStyle(opt1,1)
        }
        opt2.setOnClickListener {
            selectedOptionStyle(opt2,2)
        }
        opt3.setOnClickListener {
            selectedOptionStyle(opt3,3)
        }
        opt4.setOnClickListener {
            selectedOptionStyle(opt4,4)
        }

        submit.setOnClickListener {
            if(selected_option!=0)
            {
                val question=questionList!![currentPosition-1]
                if(selected_option!=question.correct_ans){
                    setcolor(selected_option,R.drawable.wrong_question_option)
                }
                else{
                    score++;
                }
                setcolor(question.correct_ans,R.drawable.correct_question_option)
                if(currentPosition==questionList!!.size)
                    submit.text="Finish"
                else
                    submit.text="Go to Next"
            }
            else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQueston()
                    }
                    else->{
                        var intent=Intent(this,Result::class.java)
                        intent.putExtra(setData.name,Name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selected_option=0
        }


    }

    fun setcolor(opt:Int,color:Int){
        when(opt){
            1->{
                opt1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }

    fun setQueston(){
        val question = questionList!![currentPosition-1]
        setOptionStyle()


        progress_bar.progress=currentPosition
        progress_bar.max=questionList!!.size
        progress_text.text="${currentPosition}"+"/${questionList!!.size}"
        questio_text.text=question.question
        opt1.text=question.option_one
        opt2.text=question.option_two
        opt3.text=question.option_three
        opt4.text=question.option_four
    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt1)
        optionList.add(0,opt2)
        optionList.add(0,opt3)
        optionList.add(0,opt4)

        for (op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }
    }

    @SuppressLint("Range")
    fun selectedOptionStyle(view:TextView, opt:Int){
        setOptionStyle()
        selected_option=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }
}