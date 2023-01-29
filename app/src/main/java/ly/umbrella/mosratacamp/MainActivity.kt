package ly.umbrella.mosratacamp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import cn.pedant.SweetAlert.SweetAlertDialog
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
                   SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                       .setTitleText("Mosrata Camp")
                       .setContentText("You Are Login IN Successfully").show()
               }
               is Recurce.Error<UserEntity>->{
                   SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                       .setTitleText("Mosrata Camp")
                       .setContentText("Something went wrong!").show()
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