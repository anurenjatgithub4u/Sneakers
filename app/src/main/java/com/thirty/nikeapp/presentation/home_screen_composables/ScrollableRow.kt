package com.thirty.nikeapp.presentation.home_screen_composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.thirty.nikeapp.R


@Composable
fun ThisWeekHighLight(modifier: Modifier) {


    LazyRow(modifier = modifier.padding(start = 20.dp, end = 20.dp)) {

        item {

            Column() {
                Card(modifier = modifier
                    .width(140.dp)
                    .height(140.dp), colors = CardDefaults.cardColors(containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primary)
                    ,
                ) {
                    Image(painter = painterResource(id = R.drawable.nikesix), contentDescription ="" )

                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Campus Collection", color = androidx.compose.material3.MaterialTheme.colorScheme.tertiary)
            }


            Spacer(modifier = Modifier.width(10.dp))

            Column() {
                Card(modifier = modifier
                    .width(140.dp)
                    .height(140.dp), colors = CardDefaults.cardColors(containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primary)
                    ,
                ) {
                  Image(painter = painterResource(id = R.drawable.nikefive), contentDescription ="" )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "New Arrivals", color = androidx.compose.material3.MaterialTheme.colorScheme.tertiary)
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column() {
                Card(modifier = modifier
                    .width(140.dp)
                    .height(140.dp), colors = CardDefaults.cardColors(containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primary)
                    ,
                ) {
                    Image(painter = painterResource(id = R.drawable.nijethree), contentDescription ="" )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Campus Collection", color = androidx.compose.material3.MaterialTheme.colorScheme.tertiary)
            }


            Spacer(modifier = Modifier.width(10.dp))

            Column() {
                Card(modifier = modifier
                    .width(140.dp)
                    .height(140.dp), colors = CardDefaults.cardColors(containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primary)
                    ,
                ) {
                    Image(painter = painterResource(id = R.drawable.nikesix), contentDescription ="" )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Nike By you", color = androidx.compose.material3.MaterialTheme.colorScheme.tertiary)
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column() {
                Card(modifier = modifier
                    .width(140.dp)
                    .height(140.dp), colors = CardDefaults.cardColors(containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primary)
                    ,
                ) {
                    Image(painter = painterResource(id = R.drawable.nikefour), contentDescription ="" )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Trending", color = androidx.compose.material3.MaterialTheme.colorScheme.tertiary)
            }
        }



    }

}



@Composable
fun ExpandableCard(modifier: Modifier=Modifier,painter: Painter ,textOne: String = "",textTwo: String = "",textThree: String = "",textFour:String="") {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
        shape = RoundedCornerShape(8.dp),

        elevation = 4.dp,
        backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier
                .animateContentSize()
                .padding(1.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            if (isExpanded) {
                Spacer(modifier = modifier.height(30.dp))
                Text(
                    modifier = modifier.padding(start = 20.dp) ,
                    text = textOne,
                    style = MaterialTheme.typography.body1,

                    color = androidx.compose.material3.MaterialTheme.colorScheme.tertiary
                )
                Spacer(modifier = modifier.height(10.dp))

                Divider( modifier = modifier.padding(start = 20.dp) ,)
                Spacer(modifier = modifier.height(10.dp))

                Text(
                    modifier = modifier.padding(start = 20.dp) ,
                    text = textTwo,
                    style = MaterialTheme.typography.body1,

                    color = androidx.compose.material3.MaterialTheme.colorScheme.tertiary
                )
                Spacer(modifier = modifier.height(10.dp))
                Divider( modifier = modifier.padding(start = 20.dp) ,)
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    modifier = modifier.padding(start = 20.dp) ,
                    text = textThree,
                    style = MaterialTheme.typography.body1,

                    color = androidx.compose.material3.MaterialTheme.colorScheme.tertiary
                )
                Spacer(modifier = modifier.height(10.dp))

                Divider( modifier = modifier.padding(start = 20.dp) )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    modifier = modifier.padding(start = 20.dp) ,
                    text = textFour,
                    style = MaterialTheme.typography.body1,

                    color = androidx.compose.material3.MaterialTheme.colorScheme.tertiary
                )
                Spacer(modifier = modifier.height(10.dp))
            }
        }
    }
}
