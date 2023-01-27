package ly.umbrella.mosratacamp.loginpage.data.model

import ly.umbrella.mosratacamp.loginpage.data.entity.UserEntity

data class UserModel(var usename:String,var password:String,var token:String,var isAdmin:Boolean=false){
    fun toEntity():UserEntity{
        return UserEntity(username =usename, password = password)
    }
}
