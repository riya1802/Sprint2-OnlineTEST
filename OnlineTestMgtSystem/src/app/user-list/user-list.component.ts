import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../entity/User';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: any=new User(0,"",0,0,"");
  userId: number;
  message: any;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    let resp=this.userService.getAllUsers().subscribe(data=> this.users = data);
  }
  deleteUser(userId){
    alert("Are you sure you want to delete the user?")
    let del= this.userService.deleteUser(userId);
    del.subscribe((data)=>this.message=data);
  }
}
