package ly.umbrella.mosratacamp.loginpage.data.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ly.umbrella.mosratacamp.loginpage.data.entity.UserEntity
import ly.umbrella.mosratacamp.loginpage.data.repository.LoginRepository
import ly.umbrella.mosratacamp.loginpage.data.repository.LoginRepositoryImp
import ly.umbrella.mosratacamp.loginpage.recurce.Recurce

class LoginViewModel:ViewModel() {
   var resurce = Recurce.Init<UserEntity>()
    var state = MutableLiveData<Recurce<UserEntity>>(resurce)
    val loginRepository = LoginRepositoryImp()
   fun login(user:UserEntity){
      val rer= loginRepository.login(user)
       state.value=rer
   }
}