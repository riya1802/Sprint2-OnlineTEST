import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../entity/User';
import { error } from 'protractor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: any=new User(0,"",0,0,"");
  userId: number;
  message: any;
  constructor(private userService: UserService,private router:Router) { }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe(data=> this.users = data);
  }
  deleteUser(userId){
    let confirmation=confirm("Are you sure you want to delete the user?")
    if(confirmation){
    let del= this.userService.deleteUser(userId);
    del.subscribe((data)=>this.message=data);
  }else
   this.router.navigate['viewAllUser']
  }
}
