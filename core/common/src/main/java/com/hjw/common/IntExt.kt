package com.hjw.common

import java.text.DecimalFormat

fun Int.decimalFormat(): String = DecimalFormat("#,###").format(this)
