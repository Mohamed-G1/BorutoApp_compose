package com.example.borutoapp.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.borutoapp.R
import com.example.borutoapp.ui.theme.StarColor


@Composable
fun RatingWidget(
    modifier: Modifier, rating: Double, scaleFactor: Float = 2f

) {
    val calculationResult = CalculateStars(rating = rating)
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBound = remember {
        starPath.getBounds()
    }

    Row(
        modifier = modifier, horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        calculationResult["filledStars"]?.let {
            repeat(it) {
                FillStar(starPath = starPath, starBounds = starPathBound, scaleFactor = scaleFactor)
            }
        }

        calculationResult["halfStars"]?.let {
            repeat(it) {
                HalfStar(starPath = starPath, starBounds = starPathBound, scaleFactor = scaleFactor)
            }
        }

        calculationResult["emptyStars"]?.let {
            repeat(it) {
                EmptyStar(
                    starPath = starPath, starBounds = starPathBound, scaleFactor = scaleFactor
                )
            }
        }
    }
}


@Composable
fun CalculateStars(rating: Double): Map<String, Int> {
    val starsCount by remember { mutableIntStateOf(5) }
    var filledStars by remember { mutableIntStateOf(0) }
    var halfStars by remember { mutableIntStateOf(0) }
    var emptyStars by remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = rating) {
        val (firstNumber, lastNumber) = rating.toString().split(".").map { it.toInt() }
        if (firstNumber in 0..5 && lastNumber in 0..9) {
            filledStars = firstNumber
            if (lastNumber in 1..5) {
                halfStars++
            }
            if (lastNumber in 6..9) {
                filledStars++
            }
            if (firstNumber == 5 && lastNumber > 0) {
                emptyStars = 5
                filledStars = 0
                halfStars = 0
            }
        }
    }
    emptyStars = starsCount - (filledStars + halfStars)
    return mapOf(
        "filledStars" to filledStars, "halfStars" to halfStars, "emptyStars" to emptyStars
    )
}


@Composable
fun FillStar(
    starPath: Path, starBounds: Rect, scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = this.size
        scale(
            scale = scaleFactor
        ) {
            val pathWidth = starBounds.width
            val pathHeight = starBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)
            translate(
                left = left, top = top

            ) {
                drawPath(
                    path = starPath, color = StarColor
                )
            }
        }
    }
}

@Composable
fun HalfStar(
    starPath: Path, starBounds: Rect, scaleFactor: Float
) {

    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = this.size
        scale(
            scale = scaleFactor
        ) {
            val pathWidth = starBounds.width
            val pathHeight = starBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)
            translate(
                left = left, top = top

            ) {
                drawPath(
                    path = starPath, color = Color.LightGray.copy(alpha = 0.5f)
                )
                clipPath(path = starPath) {
                    drawRect(
                        color = StarColor, size = Size(
                            width = starBounds.maxDimension / 1.7f,
                            height = starBounds.maxDimension * scaleFactor
                        )
                    )
                }
            }
        }
    }
}


@Composable
fun EmptyStar(
    starPath: Path, starBounds: Rect, scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = this.size
        scale(
            scale = scaleFactor
        ) {
            val pathWidth = starBounds.width
            val pathHeight = starBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)
            translate(
                left = left, top = top

            ) {
                drawPath(
                    path = starPath, color = Color.LightGray.copy(alpha = 0.5f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FillStarPreview() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBound = remember {
        starPath.getBounds()
    }
    FillStar(starPath = starPath, starBounds = starPathBound, scaleFactor = 2f)
}

@Preview(showBackground = true)
@Composable
fun HalfStarPreview() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBound = remember {
        starPath.getBounds()
    }

    HalfStar(starPath = starPath, starBounds = starPathBound, scaleFactor = 2f)
}

@Preview(showBackground = true)
@Composable
fun EmptyStar() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBound = remember {
        starPath.getBounds()
    }

    EmptyStar(starPath = starPath, starBounds = starPathBound, scaleFactor = 2f)
}

@Preview(showBackground = true)
@Composable
fun MainWidget() {
    RatingWidget(modifier =Modifier, rating = 2.1)
}

