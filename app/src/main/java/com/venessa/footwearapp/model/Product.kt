package com.venessa.footwearapp.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

class Product (
    var id :String,
    var name:String,
    var color :Color,
    var price :String,
    var discountprice :String,
    var size :Int,
    var rating:Double,
   @DrawableRes val imageRes:Int,
)