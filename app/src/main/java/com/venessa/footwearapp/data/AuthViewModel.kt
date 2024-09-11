package com.venessa.footwearapp.data

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User
import com.venessa.footwearapp.navigation.ROUTE_LOGIN
import com.venessa.footwearapp.navigation.ROUTE_PRODUCT
import com.venessa.footwearapp.navigation.ROUTE_REGISTER

class AuthViewModel(var navController: NavHostController, var context:Context) {

    var mAuth:FirebaseAuth
    init {
        mAuth=FirebaseAuth.getInstance()
    }
    @SuppressLint("RestrictedApi")
    fun signup(name:String, email:String, password:String, confirmpassword:String){
        if (name.isBlank() || email.isBlank() ||password.isBlank() || confirmpassword.isBlank()) {
            Toast.makeText(context, "Please input all fields", Toast.LENGTH_LONG).show()
        } else if (password !=confirmpassword){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful){
                    val userdata= com.venessa.footwearapp.model.User(
                        name,
                        email,
                        password,
                        confirmpassword,
                        mAuth.currentUser!!.uid
                    )
                    val regRef= FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {

                        if (it.isSuccessful){
                            Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)
                        }
                    }
                }else{
                    navController.navigate(ROUTE_REGISTER)
                }

            } }

    }



    fun login(email: String,pass: String){

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {

            if (it.isSuccessful){
                Toast.makeText(context,"Succeffully Logged in",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_PRODUCT)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }}
