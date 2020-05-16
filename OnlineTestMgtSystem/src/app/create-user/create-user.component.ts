import { Component, OnInit } from '@angular/core';
import { User } from '../entity/User';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  user: User= new User(0,"",0,0,"");
  message:any;
  constructor(private service:UserService) { }

  ngOnInit(): void {
  }
  public adUser(user){
    let add=this.service.addUser(user);
    add.subscribe((data)=>this.message=data);
  }

}
