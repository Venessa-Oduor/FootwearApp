package com.venessa.footwearapp.model

class User {
    var name: String = ""
    var email: String = ""
    var password: String = ""
    var confirmpassword: String = ""
    var userid: String = ""

    constructor(name: String, email: String, password: String, confirmpassword: String, userid: String) {

        this.name = name
        this.email = email
        this.password = password
        this.confirmpassword = confirmpassword
    }

    constructor()
}