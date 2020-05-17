import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../entity/User';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-assign-test',
  templateUrl: './assign-test.component.html',
  styleUrls: ['./assign-test.component.css']
})
export class AssignTestComponent implements OnInit {

  message: any;
  userId: number;
  testId: number;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }
  
  public assignTest(userId, testId){
      let assign=this.userService.assignTest(userId,testId);
      assign.subscribe((data)=>this.message=data);
      alert("Test Assigned Successfully")
  }
}
