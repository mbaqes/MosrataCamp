package ly.umbrella.mosratacamp.loginpage.data.entity

import ly.umbrella.mosratacamp.loginpage.data.model.UserModel

data class UserEntity (var username:String,var password:String){
    fun toModel(): UserModel {

        return UserModel(
            usename = username,
            password = password,
            isAdmin = false, token = ""
        )
    }
}