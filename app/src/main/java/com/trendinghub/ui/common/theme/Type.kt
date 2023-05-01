package com.trendinghub.ui.common.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    h1 = TextStyle(),
    h2 = TextStyle(),
    h3 = TextStyle(),
    h4 = TextStyle(),
    h6 = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
    subtitle1 = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
    subtitle2 = TextStyle(fontSize = 14.sp),
    button = TextStyle(),
    body1 = TextStyle(),
    body2 = TextStyle(),
)