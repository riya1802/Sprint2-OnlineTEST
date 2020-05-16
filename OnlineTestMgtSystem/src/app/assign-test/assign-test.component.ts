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

  mssg: String;
  userId: number;
  testId: number;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }
  
  assignTest(userId: number, testId: number){
      this.userService.assignTest(userId,testId).subscribe((data)=>this.mssg=data);
  }
}
