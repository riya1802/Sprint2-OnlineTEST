import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../entity/User';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-assign-test',
  templateUrl: './assign-test.component.html',
  styleUrls: ['./assign-test.component.css']
})
export class AssignTestComponent implements OnInit {
  userId: number;
  testId: number;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }
  public assignTest(userId, testId) {
    this.userService.assignTest(userId, testId).subscribe(
      data => {
       
        if (data) {
          alert("Test assigned successfully to the user")
        }
      
      },

      error => {

        if (error.status === 400) {
          alert("Test is already assigned to this user")
        }
         else if (error.status === 404) {
          alert("Invalid Test Id or User Id")
        }
         else if (error.status === 409) {
          alert("You cannot assign test to an Admin")
        }





        else if (error.status === 200) {
          alert("Test assigned successfully to the user")
        }
      }
    )
  }
}
