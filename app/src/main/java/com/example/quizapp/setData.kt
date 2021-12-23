package com.example.quizapp

object setData {
    const val name:String="name"
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()
        var q1=QuestionData(
            question = "What is the Capital of India",
            id = 1,
            option_one = "Uttar Pradesh",
            option_two = "Madhya Pradesh",
            option_three = "Delhi",
            option_four = "Kolkata",
            correct_ans = 3

        )

        var q2=QuestionData(
            question = "Biggest Animal On Earth",
            id = 2,
            option_one = "Blue Whale",
            option_two = "Elephant",
            option_three = "Hippo",
            option_four = "Giraffe",
            correct_ans = 1

        )

        var q3=QuestionData(
            question = "Divide 30 by half and add ten",
            id = 3,
            option_one = "40.5",
            option_two = "50",
            option_three = "70",
            option_four = "Cant determine",
            correct_ans = 3

        )

        var q4=QuestionData(
            question = "If a leaf falls to the ground in a forest and no one hears it,does it make sound?",
            id = 5,
            option_one = "Yes",
            option_two = "No",
            option_three = "Depends on how heavy the leaf was.",
            option_four = "Depends on where it landed.",
            correct_ans = 1

        )

        var q5=QuestionData(
            question = "Where do eagles mate?",
            id = 5,
            option_one = "In a tree",
            option_two = "In their nests",
            option_three = "In the clouds",
            option_four = "In the air",
            correct_ans = 4

        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return  que

    }
}