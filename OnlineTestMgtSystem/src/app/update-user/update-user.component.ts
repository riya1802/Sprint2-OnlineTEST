import { Component, OnInit } from '@angular/core';
import { User } from '../entity/User';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  constructor(private service:UserService,private router:Router) { }
  user: User= new User(0,"",0,0,"");
  message:any;
  ngOnInit(): void {
  }
  updatee(userId,user){
    let update=this.service.updateUser(userId,user);
    update.subscribe((data)=>this.message=data);
    confirm("your profile is updated ,please login again")
    this.router.navigate(['login'])
  }
}
