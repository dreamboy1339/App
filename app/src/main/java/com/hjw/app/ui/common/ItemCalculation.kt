package com.hjw.app.ui.common

import androidx.compose.runtime.Composable

@Composable
fun calculateItemPosition(row: Int, column: Int, columns: Int) = row * columns + column

@Composable
fun isItemPositionAvailable(position: Int, maxRows: Int, columns: Int) =
    position in 0..<(maxRows * columns)

@Composable
fun calculateAvailableMaxRowCount(size: Int, columns: Int) = (size / columns) + 1

@Composable
fun isApplyItemPadding(position: Int, columns: Int) = position % columns == 1
