package ly.umbrella.mosratacamp.loginpage.data.repository

import android.util.Log
import ly.umbrella.mosratacamp.loginpage.data.entity.UserEntity
import ly.umbrella.mosratacamp.loginpage.data.model.UserModel
import ly.umbrella.mosratacamp.loginpage.recurce.Recurce

class LoginRepositoryImp:LoginRepository<UserModel,UserEntity> {
val userlist = mutableListOf<UserEntity>(UserEntity(username = "Moaz", password = "123456"))
    override fun login(user: UserEntity): Recurce<UserEntity> {
        for (userin in userlist){
            if (user.password==userin.password){
                return Recurce.Succusfuly<UserEntity>(data = user)
            }
        }
        return Recurce.Error<UserEntity>()
    }
    override fun logout() {

    }


}