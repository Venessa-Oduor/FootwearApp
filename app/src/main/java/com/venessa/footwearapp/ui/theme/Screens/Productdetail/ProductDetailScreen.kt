package com.venessa.footwearapp.ui.theme.Screens.Productdetail

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import androidx.navigation.compose.rememberNavController
import com.venessa.footwearapp.ui.theme.Screens.Product.getProductList
import kotlinx.coroutines.delay


@SuppressLint("UseOfNonLambdaOffsetOverload")

@Composable
fun ProductDetailScreen(

    productId: String="1", navController:NavHostController
) {
    val context= LocalContext.current
    val product= getProductList().find { it.id==productId
    }!!
    var xOffset by remember {
        mutableStateOf(800.dp)

    }
    var yOffset by remember {
        mutableStateOf(800.dp)

    }
    var selectedColor by remember {

        mutableStateOf(product.color)
    }
    val animationXOffset= animateDpAsState(
        targetValue =xOffset,
        label = "",
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
    )
    val animationYOffset= animateDpAsState(
        targetValue =yOffset,
        label = "",
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
    )
    var productScale by remember{
        mutableFloatStateOf(0.6f)
    }
    val productRotate by remember {
        mutableFloatStateOf(-60f)
    }
    val animationProductScale= animateFloatAsState(targetValue = productScale,label="")
    val animationProductRotate= animateFloatAsState(targetValue = productRotate, label = "")
    var selectedSize by remember {
        mutableStateOf(product.size.toString())
    }
    var isFavorite by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(true) {
        delay(150)
        xOffset=140.dp
        yOffset= (-130).dp
        productScale=1f
//        productRotate=-30f


    }
    Box(
        modifier= Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ){
        Box(
            modifier= Modifier
                .offset(x = animationXOffset.value, y = animationYOffset.value)
                .alpha(.3f)
                .size(400.dp)
                .background(
                    color = selectedColor,
                    shape = CircleShape
                )
        )
        IconButton(onClick = { navController.popBackStack() },
            modifier= Modifier
                .padding(start = 16.dp, top = 16.dp)
                .shadow(
                    elevation = 22.dp,
                    spotColor = DefaultShadowColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(color = Color.White, shape = RoundedCornerShape(22.dp))
                .size(36.dp)
        ){
            Icon(imageVector= Icons.AutoMirrored.Rounded.KeyboardArrowLeft,contentDescription=null)
            
        }
        Column {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = null,
                        modifier = Modifier
                            .scale(animationProductScale.value)
//                .rotate(animationProductRotate.value)
                            .padding(end = 48.dp, top = 30.dp)
                            .size(320.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column{
                    Text(text="Sneaker",
                        color=Color.Black,
                        fontSize=15.sp,
                        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding=false))
                    )
                    Text(
                        text= product.name,
                        color=Color.Black,
                        fontSize=20.sp,
                        modifier=Modifier.padding(top=2.dp),
                        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                    )
                    Row(
                        modifier=Modifier.padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(imageVector = Icons.Outlined.Star,
                            modifier=Modifier.size(18.dp),
                            contentDescription = null,
                            tint=Color(0xFFFFDA45)
                        )
                        Text(
                            text= product.rating.toString(),
                            color=Color.Black,
                            fontSize=12.sp,
                            modifier=Modifier.padding(start=4.dp),
                            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                        )

                    }

                }
                Text(text = "Ksh ${product.discountprice}",
                    modifier=Modifier
                        .padding(top=4.dp),
                        color=Color.Black,
                        fontSize = 36.sp,
                        style=TextStyle(platformStyle = PlatformTextStyle(includeFontPadding=false))
                )

            }
            Text(text = "Size",modifier=Modifier
                .padding(horizontal=22.dp),
                color = Color.Black,
                fontSize = 10.sp,
                style=TextStyle(
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    fontWeight = FontWeight.Bold
               )
            )
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
                .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
        ProductSizeCard(size = "6", isSelected = selectedSize=="6" ) {
            selectedSize="6"
        } 
        ProductSizeCard(size = "7", isSelected = selectedSize=="7") {
            selectedSize="7"
        } 
        ProductSizeCard(size = "8", isSelected = selectedSize=="8") {
            selectedSize="8"
        }  
        ProductSizeCard(size = "9", isSelected = selectedSize=="9") {
            selectedSize="8"
        }
        ProductSizeCard(size = "10", isSelected = selectedSize=="10") {
            selectedSize="10"
        }
            }
                
Text(text = "Color",
    modifier= Modifier
        .padding(top = 24.dp)
        .padding(horizontal = 22.dp),
    color = Color.Black,
    fontSize = 10.sp,
    style=TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
    fontWeight = FontWeight.Bold
)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                ProductColor(color = Color.Green, isSelected=selectedColor ==Color.Green) {
                 selectedColor =Color.Green
                }
                ProductColor(color = Color.Blue, isSelected=selectedColor ==Color.Blue) {
                    selectedColor =Color.Blue
                }
                ProductColor(color = Color.Red, isSelected=selectedColor ==Color.Red) {
                    selectedColor =Color.Red
                }
                ProductColor(color = Color.Yellow, isSelected=selectedColor ==Color.Yellow) {
                    selectedColor =Color.Yellow
                }
                ProductColor(color = Color.Cyan, isSelected=selectedColor ==Color.Cyan) {
                    selectedColor =Color.Cyan
                }
            }
            Text(text = "Sneakers are like a canvas for self-expression, blending function with flair. Each pair offers a unique mix of size, shape, and color, catering to every foot and personality. From the classic whites that evoke timeless style to vibrant hues that scream individuality, sneakers come in a rainbow of possibilities. Their sizes range from dainty to robust, ensuring a snug fit for every shape and size. Whether you're looking for something sleek and understated or bold and eye-catching, sneakers are designed to be as diverse as the people who wear them.",
                modifier = Modifier
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                color=Color.Black,
                fontWeight = FontWeight.Light,
                style= TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp)) {
                IconButton(onClick = { isFavorite=!isFavorite}) {
                    Icon(imageVector =
                    if (isFavorite) Icons.Rounded.Favorite
                    else Icons.Rounded.FavoriteBorder,
                        contentDescription =null ,
                        tint=if (isFavorite)Color.Red else MaterialTheme.colorScheme.onSurface)
                    
                }
                Spacer(modifier = Modifier.width(4.dp))
                OutlinedButton(
                    onClick = {
                        val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")

                        simToolKitLaunchIntent?.let { context.startActivity(it) }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Text(text = "BUY",
                        fontSize = 20.sp)


                }

            }

        }



    }

}



@Composable
fun ProductSizeCard(
    modifier:Modifier=Modifier,
    size:String,
    isSelected:Boolean,
    onClick:()->Unit

) {
    val backGroundColor = if (isSelected) {
        Color.Red

    } else {
        Color.White
    }
    val textColor = if (isSelected) Color.White else Color.Black
    val border= if (isSelected) 0.dp else 0.8.dp
    Text(text = size,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = border,
                color = Color.Black,
                shape = RoundedCornerShape(12.dp)
            )
            .background(backGroundColor)
            .clickable { onClick() }

            .padding(12.dp),
        fontSize = 12.sp,
        color = textColor
    )
}

//@Preview(showSystemUi = true)
@Composable
fun Test() {
    ProductColor(color = Color.Yellow, isSelected = true) {
        
    }
    
}

@Composable
fun ProductColor(
    modifier:Modifier=Modifier,
    color:Color,
    isSelected: Boolean, onClick: () -> Unit
) {
val borderColor=if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent
    Box(modifier= modifier
        .border(width = 0.5.dp, shape = CircleShape, color = borderColor)
        .padding(4.dp)
        .background(color, shape = CircleShape)
        .size(24.dp)
        .clip(CircleShape)
        .clickable {
            onClick()
        }
    )
}

@Preview
@Composable
fun ProductScreen() {
    ProductDetailScreen(navController = rememberNavController())
    
}


