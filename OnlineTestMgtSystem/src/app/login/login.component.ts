import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { User } from '../entity/User';
import { Router } from '@angular/router';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User= new User(0,"",0,0,"");
  flag: boolean=true;
  constructor(private service:LoginService,private router:Router) { }
  ngOnInit(): void {
  }
  loginn(user){
    this.service.login(this.user)
    .subscribe(
      data => {
        this.user=data;
        if(this.user.isAdmin==1){
          this.router.navigate(['adminHome']);
        }else if(this.user.isAdmin==0){
          this.router.navigate(['userHome']);
        }
  },error=>{
      if(error.status===401){
        alert("Incorrect Password Entered")
      }else if(error.status===404){
        alert("User Not found with this User name")
      }
  }
  )
}
  signUp(){
    this.router.navigate(['addUser']);
  }
  }


