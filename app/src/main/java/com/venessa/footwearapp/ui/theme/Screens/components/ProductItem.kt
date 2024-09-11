package com.venessa.footwearapp.ui.theme.Screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.venessa.footwearapp.R
import com.venessa.footwearapp.model.Product

@Preview(showBackground = true)
@Composable
fun ProductItem( product: Product= Product(
    id ="1",
    color= Color.Blue,
    price= "5000",
    name="Jordan 3",
    discountprice = "4500",
    rating = 4.5,
    imageRes = R.drawable.j3c,
    size = 6
   ),
      onClick:()->Unit={}
) {

    val color by remember{
        mutableStateOf(product.color)
    }
    var isFavorite by remember {
        mutableStateOf(false)
    }
    Box(modifier= Modifier
        .padding(20.dp)
        .size(168.dp, 210.dp).clickable {
            onClick.invoke()
        }){
        Box(modifier= Modifier
            .fillMaxSize()
            .alpha(2f)
            .background(color = color, shape = RoundedCornerShape(22.dp))
        )
        IconButton(onClick = {
            isFavorite=!isFavorite
        },
            modifier=Modifier.align(Alignment.TopStart)
        ) {
            Icon(imageVector =
                if (isFavorite)
                    Icons.Rounded.Favorite
                else
                    Icons.Rounded.FavoriteBorder,contentDescription= null
            )

            
        }
        Text(text = product.size.toString(),
            fontWeight = FontWeight.Bold,
            color=color.copy(alpha=.3f),
            fontSize = 120.sp,
            modifier =Modifier.align(Alignment.TopCenter)
        )
        Image(painter = painterResource(id = product.imageRes), contentDescription =null,
            modifier = Modifier
                .fillMaxSize(1f)
                .align(Alignment.Center))
//                .rotate(-30f).offset(30.dp,(-20).dp))
        Column(
            modifier=Modifier.align(Alignment.BottomEnd)
        ) {
            Text(text = "Kshs. ${product.discountprice}",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier=Modifier.padding(end =8.dp)
            )
            Text(text = "Kshs. ${product.price}",

                fontSize = 15.sp,
                modifier=Modifier.padding(end =8.dp,bottom=3.dp)
                    .align(Alignment.End),
                style= TextStyle(
                    textDecoration = TextDecoration.LineThrough
                )
            )


        }


    }

}