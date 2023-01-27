package ly.umbrella.mosratacamp.loginpage.data.repository

import ly.umbrella.mosratacamp.loginpage.data.entity.UserEntity
import ly.umbrella.mosratacamp.loginpage.recurce.Recurce

interface  LoginRepository<M,E> {
    fun login(user:UserEntity): Recurce<E>
    fun logout()
}