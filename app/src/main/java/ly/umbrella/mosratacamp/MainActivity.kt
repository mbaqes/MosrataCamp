package ly.umbrella.mosratacamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import ly.umbrella.mosratacamp.loginpage.data.entity.UserEntity
import ly.umbrella.mosratacamp.loginpage.data.viewmodel.LoginViewModel
import ly.umbrella.mosratacamp.loginpage.recurce.Recurce

class MainActivity : AppCompatActivity() {
  val vmLogin:LoginViewModel by viewModels()
    private lateinit var txtUserName: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnLogin:Button
    private lateinit var isok:TextView

    private lateinit var alairtDialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }
    fun initUI(){

        var observer =Observer<Recurce<UserEntity>>{
           when(it){
               is Recurce.Succusfuly<UserEntity>->{
                   isok.text ="Okkkkk"
               }
               is Recurce.Error<UserEntity>->{
                   isok.text = "Error !!!!!"
               }
           }
        }
        vmLogin.state.observe(this,observer)
          txtPassword =findViewById(R.id.passwordtxt)
        txtUserName=findViewById(R.id.usernametext)
        btnLogin=findViewById(R.id.loginbtn)
        isok=findViewById(R.id.isok)
        btnLogin.setOnClickListener {
            vmLogin.login(
                UserEntity(
                    username =txtPassword.text.toString() ,
                    password = txtUserName.text.toString()
                )
            )
        }
    }

}