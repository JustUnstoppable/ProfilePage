package com.example.dogprofilepage


import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage(){
    Card(elevation=6.dp,modifier = Modifier
        .fillMaxWidth()
        .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        //.border(width = 2.dp,color= Color.Black, shape = RoundedCornerShape(30.dp))
    ) {
        //vertical scroll fo orientation changes to display all content on scrolling
        Column( modifier= Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.dog),
                contentDescription = "cute",
                Modifier
                    .size(180.dp)
                    .border(2.dp, Color.Red, CircleShape)
                    .clip(CircleShape))
            Text(text ="Cute Dog")
            Text(text="India")
            Row(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                profileStats(count = "150", title ="Followers" )
                profileStats(count = "100", title ="Following" )
                profileStats(count = "30", title ="Posts" )

            }
            Row(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Follow User")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Direct Message")
                }
            }
        }
    }

}

@Composable
fun profileStats(count:String, title:String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text= count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}
@Preview(showBackground = true)
@Composable
fun ProfilePagePreview(){
    ProfilePage()
}