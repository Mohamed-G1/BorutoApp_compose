package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class LessonContent(
    val key: String,
    val value: String
)


// To access the data, you can use teacherObservationData[index]
@Composable
fun MainColumn() {
    val teacherObservationData = arrayOf(
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),

        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),


        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),
        "Lesson_Content_And_Planning" to arrayOf(
            LessonContent("Clarity_Of_Lesson_Objectives", "ddd"),
            LessonContent("Alignment_With_Curriculum_Standards", "aaaa"),
            LessonContent("Appropriate_Sequencing_Of_Activities", "aaddd"),
            LessonContent("Use_Of_Varied_Instructional_Strategies", ""),
            LessonContent("Differentiation_Strategies_For_Diverse_Learners", "@@@")
        ),



        "teacher_planning" to arrayOf(
            LessonContent("test 1", "ddd"),
            LessonContent("test2", "aaaa"),
            LessonContent("test3", "aaddd"),
            LessonContent("test4", "Hello"),
            LessonContent("test5", "@@@")
        )
        // Add other fields as needed
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()

    ) {
        items(teacherObservationData.size) { index ->
            val item = teacherObservationData[index]
            val isExpandable = item.second is Array<*>
            var expanded by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .clickable { if (isExpandable) expanded = !expanded },
            ) {
                Card(
                    shape = MaterialTheme.shapes.medium,
                    backgroundColor = MaterialTheme.colors.primary,
                    elevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(text = item.first, fontWeight = FontWeight.Bold, fontSize = 22.sp)

                    }
                }
                AnimatedVisibility(visible = expanded) {
                    SubColumn(item.second as Array<LessonContent>)

                }
            }
        }
    }
}

@Composable
fun SubColumn(data: Array<LessonContent>) {
    Column(

    ) {
        data.forEach {
            Card(
                modifier = Modifier.padding(top = 4.dp),
                shape = MaterialTheme.shapes.medium,
                backgroundColor = MaterialTheme.colors.secondaryVariant,
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Text(text = "Key: ${it.key}", fontWeight = FontWeight.Normal)
                    Text(text = "Value: ${it.value}", fontWeight = FontWeight.Normal)
                }
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun NestedScrollableScreenPreview() {
    MainColumn()
}