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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage(){
    Card(elevation=6.dp,modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        //.border(width = 2.dp,color= Color.Black, shape = RoundedCornerShape(30.dp))
    ) {
        //vertical scroll fo orientation changes to display all content on scrolling
        ConstraintLayout {
            val (image, nameText, countryText, rowStats,buttonFollow,buttonMessage) = createRefs()

            val guideline= createGuidelineFromTop(0.1f)
            Image(
                painter = painterResource(id = R.drawable.dog),
                contentDescription = "cute",
                Modifier
                    .size(100.dp)
                    .border(2.dp, Color.Red, CircleShape)
                    .clip(CircleShape)
                    .constrainAs(image) {
                        top.linkTo(guideline)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )
            Text(text = "Cute Dog",
                modifier = Modifier.constrainAs(nameText) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Text(text = "India",
                modifier = Modifier.constrainAs(countryText) {
                    top.linkTo(nameText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Row(modifier = Modifier
                .padding(16.dp)
                .constrainAs(rowStats) {
                    top.linkTo(countryText.bottom)

                }
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                profileStats(count = "150", title = "Followers")
                profileStats(count = "100", title = "Following")
                profileStats(count = "30", title = "Posts")

            }

            Button(onClick = { /*TODO*/ },
            modifier= Modifier.constrainAs(buttonFollow){
               top.linkTo(rowStats.bottom,margin= 16.dp)
                start.linkTo(parent.start)
                end.linkTo(buttonMessage.start)
                width= Dimension.wrapContent
            }) {
                Text(text = "Follow User")
            }
            Button(onClick = { /*TODO*/ },
                modifier= Modifier.constrainAs(buttonMessage){
                    top.linkTo(rowStats.bottom,margin= 16.dp)
                    start.linkTo(buttonFollow.end)
                    end.linkTo(parent.end)
                    width= Dimension.wrapContent
                }) {
                Text(text = "Direct Message")
            }
            Text(text="",modifier = Modifier.padding(bottom = 16.dp))
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