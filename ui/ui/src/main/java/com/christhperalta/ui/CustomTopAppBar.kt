package com.christhperalta.ui


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    title : String ,
    accionButton : Boolean,
    onClick : () -> Unit,

) {
    TopAppBar(
        modifier = modifier,
        title = {CustomText(text = title, style = MaterialTheme.typography.titleLarge)},
        navigationIcon = {
            if(!accionButton){
                IconButton(onClick = onClick) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_back),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary

                    )
                }
            }
        },
        actions = {
           if (accionButton){
               IconButton(onClick = onClick) {
                   Icon(
                       painter = painterResource(R.drawable.account),
                       contentDescription = null,

                       tint = MaterialTheme.colorScheme.secondary

                   )
               }
           }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )

}
//
//@Preview(name = "CustomTopAppBar")
//@Composable
//private fun PreviewCustomTopAppBar() {
//    CustomTopAppBar(onClick = {})
//}