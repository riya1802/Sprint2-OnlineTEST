import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { User } from '../entity/User';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User= new User(0,"",0,0,"");
  u:any;
  constructor(private service:LoginService,private router:Router) { }
  ngOnInit(): void {
  }
  loginn(user){
    this.service.login(user).subscribe((data)=>this.u=data);
    if(this.u==1){
      this.router.navigate(['adminHome']);
    }
    if(this.u==0){
      this.router.navigate(['userHome']);
    }
  }
  signUp(){
    this.router.navigate(['addUser']);
  }
  }


