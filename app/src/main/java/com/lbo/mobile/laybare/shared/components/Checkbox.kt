package com.lbo.mobile.laybare.shared.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CheckboxComponent(
    modifier: Modifier = Modifier,isChecked:Boolean = false,onCheckedChange:(Boolean)->Unit = {},
    ){
    Checkbox(modifier = modifier,checked = isChecked, onCheckedChange = {onCheckedChange(it)},
    colors = CheckboxDefaults.colors())




}