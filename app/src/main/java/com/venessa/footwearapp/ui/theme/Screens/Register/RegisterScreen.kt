package com.venessa.footwearapp.ui.theme.Screens.Register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.venessa.footwearapp.R
import com.venessa.footwearapp.data.AuthViewModel
import com.venessa.footwearapp.navigation.ROUTE_LOGIN

@Composable
fun RegisterScreen(navController: NavHostController) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by  remember { mutableStateOf(TextFieldValue("")) }
    var confirmpassword by  remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Scaffold (modifier = Modifier.fillMaxSize()){
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            Image(painter= painterResource(id = R.drawable.shoelogo), contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.White)
            )
            OutlinedTextField(value =name,
                onValueChange ={name=it},
                label = { Text(text = "Name:") },
                modifier=Modifier
                    .fillMaxWidth()
                    .padding(8.dp))


            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value =email,
                onValueChange ={email=it},
                label = { Text(text = "Email:") },
                modifier=Modifier
                    .fillMaxWidth()
                    .padding(8.dp))

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(value =password ,
                onValueChange ={password=it} ,
                label = { Text(text = "Password:") },
                visualTransformation = PasswordVisualTransformation(),
                modifier=Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(value =confirmpassword ,
                onValueChange ={confirmpassword=it} ,
                label = { Text(text = " Confirm Password:") },
                visualTransformation = PasswordVisualTransformation(),
                modifier=Modifier
                    .fillMaxWidth()
                    .padding(8.dp))

            Spacer(modifier = Modifier.height(15.dp))

            Button(onClick = {
                val myregister= AuthViewModel(navController,context)
                myregister.signup(name.text.trim(),email.text.trim(),password.text.trim(),confirmpassword.text.trim())
            },
                modifier = Modifier
                    .fillMaxWidth()) {
                Text(text ="REGISTER", color = Color.White)

            }
            Spacer(modifier = Modifier.height(15.dp))

            TextButton(onClick = { navController.navigate(ROUTE_LOGIN) }, modifier = Modifier.fillMaxWidth()) {
                Text(text ="Already have an account? Click to Login")

            }

        }



    }




}



@Preview
@Composable
fun Registerpage() {
    RegisterScreen(navController = rememberNavController())

}